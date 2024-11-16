package com.yh.ar.export.annotation;

import com.yh.ar.business.pojo.ResultData;
import com.yh.ar.business.service.impl.PurchaseOrderServiceImpl;
import com.yh.ar.util.BusinessUtils;
import com.yh.ar.util.SpringContextUtil;
import com.yh.ar.util.page.PageResult;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @ClassName: CodeParsing
 * @Description: 代码解析
 * @Author: system
 * @Date: 2024-10-30 11:47
 * @Version: 1.0
 **/
@Component
public class CodeParsing {

    /**
     * @Author: system
     * @Description: 获取导出查询数据
     * @Date: 2024-10-30 16:56:35
     * @Param: menuId
     * @Param: obj
     * @return: List<Map>
     **/
    public ResultData<PageResult> queryDataList(String menuId, Object... obj) {
        // 最终返回结果
        AtomicReference<ResultData<PageResult>> resultData = new AtomicReference<>(new ResultData<>());
        // 获取指定包下所有类实例
        List<Class<?>> clazzList = BusinessUtils.getClazzList("com.yh.ar.business.service.impl");
        clazzList.stream().forEach(clazz -> {
            // 获取对象所有方法
            Method[] methods = clazz.getDeclaredMethods();
            Arrays.stream(methods)
                    .filter(method -> method.isAnnotationPresent(ExportAnnotation.class))
                    .forEach(method -> {
                        ExportAnnotation annotation = method.getAnnotation(ExportAnnotation.class);
                        if (menuId.equals(annotation.menuId())) {
                            try {
                                Object instance = clazz.newInstance();
                                resultData.set((ResultData<PageResult>) method.invoke(instance, obj));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                    });
        });

        return resultData.get();
    }

    /**
     * @Author: system
     * @Description: 获取数据导入insert执行类
     * @Date: 2024-10-30 16:56:35
     * @Param: menuId
     * @Param: obj
     * @return: List<Map>
     **/
    public void insertData(String menuId, Object... obj) {
        // 获取指定包下所有类实例
        List<Class<?>> clazzList = BusinessUtils.getClazzList("com.yh.ar.business.service.impl");
        clazzList.stream().forEach(clazz -> {
            // 获取对象所有方法
            Method[] methods = clazz.getDeclaredMethods();
            Arrays.stream(methods)
                    .filter(method -> method.isAnnotationPresent(ImportAnnotation.class))
                    .forEach(method -> {
                        ImportAnnotation annotation = method.getAnnotation(ImportAnnotation.class);
                        if (menuId.equals(annotation.menuId())) {
                            try {
                                Object bean = SpringContextUtil.getBean(clazz);
                                // Object instance = clazz.newInstance();
                                method.invoke(bean, obj);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                    });
        });
    }

}