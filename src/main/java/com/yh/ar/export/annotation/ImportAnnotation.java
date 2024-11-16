package com.yh.ar.export.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @InterfaceName: ImportAnnotation
 * @Description: 导入数据，根据注解找到对应的sql执行类
 * @Author: system
 * @Date: 2024-11-16 19:49
 * @Version: 1.0
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ImportAnnotation {

    String menuId() default "";

}