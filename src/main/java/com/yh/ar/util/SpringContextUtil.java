package com.yh.ar.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Author: system
 * @Description: 获取对象实例
 * @Date: 2024-11-16 23:59:00
 * @Param: null
 * @return: null
 **/
@Component
public class SpringContextUtil implements ApplicationContextAware {

    private SpringContextUtil(){}

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtil.applicationContext = applicationContext;
    }

    public static <T> T getBean(Class<T> clazz) {
        // 先判断是否存在上下文对象
        if (applicationContext == null) {
            return null;
        }
        return applicationContext.getBean(clazz);
    }

    public static <T> T getBean(String beanName, Class<T> clazz) {
        // 先判断是否存在上下文对象
        if (applicationContext == null) {
            return null;
        }
        return applicationContext.getBean(beanName, clazz);
    }

}
