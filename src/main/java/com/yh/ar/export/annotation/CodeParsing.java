package com.yh.ar.export.annotation;

import com.yh.ar.business.pojo.ResultData;
import com.yh.ar.business.service.impl.PurchaseOrderServiceImpl;
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
        List<Class<?>> clazzList = getClazzList("com.yh.ar.business.service.impl");
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
     * @Description: 获取指定包下的对象实例
     * @Date: 2024-10-30 22:27:24
     * @Param: packageName
     * @return: List<Class < ?>>
     **/
    private static List<Class<?>> getClazzList(String packageName) {
        List<Class<?>> clazzes = new ArrayList<>();
        // 获取包名对应的路径
        String path = packageName.replace('.', '/');
        // 获取包的URL
        URL resource = Thread.currentThread().getContextClassLoader().getResource(path);

        if (resource != null) {
            // 获取文件目录
            File directory = new File(resource.getFile());

            if (directory.exists()) {
                // 获取该目录下的所有文件
                File[] files = directory.listFiles();
                for (File file : files) {
                    // 检查文件是不是以.class结尾
                    if (file.isFile() && file.getName().endsWith(".class")) {
                        String className = packageName + '.' + file.getName().replace(".class", "");
                        try {
                            // 通过类名获取Class对象
                            Class<?> clazz = Class.forName(className);
                            // 将Class对象添加到列表
                            clazzes.add(clazz);
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return clazzes;
    }

}