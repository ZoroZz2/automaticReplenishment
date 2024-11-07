package com.yh.ar.export.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: system
 * @Description: 导出数据，根据注解找到对应的sql执行类
 * @Date: 2024-10-29 19:13:15
 * @Param: null
 * @return: null
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExportAnnotation {
    // 菜单id
    String menuId() default "";

}
