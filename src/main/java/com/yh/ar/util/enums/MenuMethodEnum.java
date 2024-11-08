package com.yh.ar.util.enums;

import com.yh.ar.business.pojo.*;

/**
 * @EnumName: MenuMethodEnum
 * @Description: 菜单id对应方法名
 * @Author: systm
 * @Date: 2024-10-30 15:42
 * @Version: 1.0
 **/
public enum MenuMethodEnum {

    SALES_FORECAST("salesForecast", "销量预测", null),
    MULTIPLE_RETURN_ORDERS("multipleReturnOrders", "销量预测-2次以上返单", MultipleReturnOrders.class),
    FIRST_RETURN_ORDER("firstReturnOrder", "销量预测-首次返单", FirstReturnOrder.class),
    PROPORTION_OF_SHIPMENTS("proportionOfShipments", "CG发货占比", ProportionOfShipments.class),
    ORDER_BATCH("orderBatch", "下单批次", null),
    BATCH_MULTIPLE_RETURN_ORDERS("batchMultipleReturnOrders", "下单批次-2次以上返单", BatchMultipleReturnOrders.class),
    BATCH_FIRST_RETURN_ORDER("batchFirstReturnOrder", "下单批次-首次返单", BatchFirstReturnOrder.class),
    ORDER_APPROVAL("orderApproval", "下单审批", null),
    APPROVAL_MULTIPLE_RETURN_ORDERS("approvalMultipleReturnOrders", "下单审批-2次以上返单", ApprovalMultipleReturnOrders.class),
    APPROVAL_FIRST_RETURN_ORDER("approvalFirstReturnOrder", "下单审批-首次返单", ApprovalFirstReturnOrder.class),
    PURCHASE_ORDER("purchaseOrder", "采购下单", PurchaseOrder.class),
    QUANTITY_TO_BE_ORDERED("quantityToBeOrdered", "需下单数量", QuantityToBeOrdered.class),
    URGENT_DELIVERY_BATCH("urgentDeliveryBatch", "催货批次", null),
    URGE_PRODUCTION_DETAILS("urgeProductionDetails", "催生产详情", UrgeProductionDetails.class),
    URGE_SHIPMENT_DETAILS("urgeShipmentDetails", "催发货详情", UrgeShipmentDetails.class),
    PARAM_MANAGEMENT("paramManagement", "参数管理", null),
    SHIPPING_GRADE("shippingGrade", "参数管理-发货等级", ShippingGrade.class),
    ORDER_SAFETY_FACTOR("orderSafetyFactor", "参数管理-高风险产品下单安全系数", OrderSafetyFactor.class),
    DATA_SUPPLEMENT("dataSupplement", "数据补充", null),
    DATA_SUPPLEMENT_PRODUCT("dataSupplementProduct", "数据补充-产品标签", DataSupplementProduct.class),
    DATA_SUPPLEMENT_FACTORY("dataSupplementFactory", "数据补充-工厂数据", DataSupplementFactory.class),
    DATA_SUPPLEMENT_DELIVERY("dataSupplementDelivery", "数据补充-CG发货占比", DataSupplementDelivery.class),
    DATA_REPORT("dataReport", "数据报表", null),
    TEMPLATE_DETAILS("templateDetails", "数据报表-模板详情", TemplateDetails.class),
    DATA_BOARD("dataBoard", "数据看板", null),
    TEMPLATE_MANAGEMENT("templateManagement", "模板管理", null),
    ROLE_MANAGEMENT("roleManagement", "角色管理", null),
    ACCOUNT_MANAGEMENT("accountManagement", "账户管理", null);


    /**
     * @Author: system
     * @Description: 菜单id
     **/
    private String menuId;
    /**
     * @Author: system
     * @Description: 菜单名称
     **/
    private String menuName;
    /**
     * @Author: system
     * @Description: 对象实例化
     **/
    private Class<?> clazz;

    MenuMethodEnum(String menuId, String menuName, Class<?> clazz) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.clazz = clazz;
    }

    // 定义私有属性的get和set方法
    public String getMenuId() {
        return menuId;
    }

    private void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    private String getMenuName() {
        return menuName;
    }

    private void setMenuName(String methodName) {
        this.menuName = methodName;
    }

    private Class<?> getClazz() {
        return clazz;
    }

    private void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }

    /**
     * @Author: system
     * @Description: 根据菜单id获取菜单名称
     * @Date: 2024-10-30 15:53:34
     * @Param: menuId
     * @return: String
     **/
    public static boolean isMenuIdExist(String menuId) {
        for (MenuMethodEnum methodEnum : MenuMethodEnum.values()) {
            // 去除下划线“_”字符,保持和数据库字段名称一致
            String enumMenuId = String.valueOf(methodEnum).replace("_", "");
            if (enumMenuId.equals(menuId)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @Author: system
     * @Description: 根据菜单id获取类对象实例化
     * @Date: 2024-10-30 15:53:34
     * @Param: menuId
     * @return: String
     **/
    public static Class<?> getClazzByMenuId(String menuId) {
        for (MenuMethodEnum methodEnum : MenuMethodEnum.values()) {
            if (methodEnum.menuId.equals(menuId)) {
                return methodEnum.getClazz();
            }
        }
        throw new IllegalArgumentException("Invalid key: " + menuId);
    }

    /**
     * @Author: system
     * @Description: 根据菜单id获取菜单名称
     * @Date: 2024-10-30 15:53:34
     * @Param: menuId
     * @return: String
     **/
    public static String getMenuNameByMenuId(String menuId) {
        for (MenuMethodEnum methodEnum : MenuMethodEnum.values()) {
            if (methodEnum.equals(menuId)) {
                return methodEnum.menuName;
            }
        }
        throw new IllegalArgumentException("Invalid key: " + menuId);
    }

}