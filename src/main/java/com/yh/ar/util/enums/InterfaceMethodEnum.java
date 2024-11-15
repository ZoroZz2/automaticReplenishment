package com.yh.ar.util.enums;

/**
 * @ClassName: InterfaceMethodEnum
 * @Description: 易仓接口映射
 * @Author: system
 * @Date: 2024-11-14 17:50
 * @Version: 1.0
 **/
public enum InterfaceMethodEnum {

    GET_WMS_PRODUCT_LIST("getWmsProductList", "获取产品列表");

    /**
     * @Author: system
     * @Description: 接口名
     **/
    private String interfaceMethod;
    /**
     * @Author: system
     * @Description: 接口中文名称
     **/
    private String interfaceMethodName;

    InterfaceMethodEnum(String interfaceMethod, String interfaceMethodName) {
        this.interfaceMethod = interfaceMethod;
        this.interfaceMethodName = interfaceMethodName;
    }

    public String getInterfaceMethod() {
        return interfaceMethod;
    }

    private void setInterfaceMethod(String interfaceMethod) {
        this.interfaceMethod = interfaceMethod;
    }

    private String getInterfaceMethodName() {
        return interfaceMethodName;
    }

    private void setInterfaceMethodName(String interfaceMethodName) {
        this.interfaceMethodName = interfaceMethodName;
    }
}