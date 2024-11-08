package com.yh.ar.util.page;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yh.ar.business.mapper.CommonMapper;
import com.yh.ar.business.mapper.SelectDataMapper;
import com.yh.ar.util.ParamUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: PageUtils
 * @Description: 分页工具类
 * @Author: system
 * @Date: 2024-10-29 23:07
 * @Version: 1.0
 **/
@Component
public class SelectDataAtom {

    /**
     * @Author: system
     * @Description: 查询分页数据入口
     * @Date: 2024-10-30 02:58:27
     * @Param: pageRequest
     * @Param: selectDataMapper
     * @Param: queryMethodName
     * @Param: args
     * @return: PageResult
     **/
    public static PageResult selectDataList(String queryMethodName, Map<String, Object> params) {

        // 重新设值多选字段类型
        ParamUtils.multiFieldToList(params);
        // 设置分页参数
        // 获取请求中页数
        String reqPageNum = (String) params.get("pageNum");
        // 设置默认值
        int pageNum = Integer.valueOf(StringUtils.defaultString(reqPageNum, "1"));

        //获取请求中页码
        String reqPageSize = (String) params.get("pageSize");
        // 设置默认值
        int pageSize = Integer.valueOf(StringUtils.defaultString(reqPageSize, "10"));

        // 先初始换分页对象PageHelper类,调用startPage方法,需传入页数和页码
        PageHelper.startPage(pageNum, pageSize);
        // 调用mapper接口中分页方法,传入mapper接口,和方法名及参数
        Object result = invoke(queryMethodName, params);
        // 将查询结果result传入PageInfo对象进行分页,并将分页结果封装到自己的PageResult对象中
        return getPageResult(new PageInfo((List) result));
    }

    /**
     * @Author: system
     * @Description: 反射调用mapper方法
     * @Date: 2024-10-30 23:12:45
     * @Param: clazz
     * @Param: queryMethodName
     * @Param: params
     * @return: Object
     **/
    public static Object invoke(String queryMethodName, Map<String, Object> params) {
        List<Map> dataList = new ArrayList<>();

        // 获取查询实例化对象值
        HttpServletRequest request =
                ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
        Object obj = context.getBean("commonMapper");

        try {
            // 创建类的实例
            Class<CommonMapper> clazzz = (Class<CommonMapper>) obj.getClass();
            // 通过方法名和参数类型获取Method对象
            Method method = clazzz.getMethod(queryMethodName, Map.class);
            // 执行最终方法
            dataList = (List<Map>) method.invoke(obj, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataList;

    }

    /**
     * @Author: system
     * @Description: 分页信息归总
     * @Date: 2024-10-29 23:50:42
     * @Param: pageRequest
     * @Param: pageInfo
     * @return: PageResult
     **/
    private static PageResult getPageResult(PageInfo pageInfo) {
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPagesize(pageInfo.getPageSize());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setDataList(pageInfo.getList());
        return pageResult;
    }

}