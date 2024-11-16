package com.yh.ar.util;

/**
 * @ClassName: Constants
 * @Description: 常量类
 * @Author: system
 * @Date: 2024-10-26 11:52
 * @Version: 1.0
 **/
public class Constants {

    // 失败码
    public static final int FAIL_CODE = 0;
    // 成功码
    public static final int SUCCESS_CODE = 200;

    // 是
    public static final String YES_CODE = "1";
    // 否
    public static final String NO_CODE = "0";

    // 用户会话信息
    public static final String SYSTEM_ACCOUNT_COOKIE = "cookie_username";
    public static final String SYSTEM_ACCOUNT_SESSION = "session_username";

    // 无权限默认值
    public static final String NO_PERMISSION_DEFAULT = "0";

    // 多选字段标识
    public static final String MULTI_FIELD_MARK = "_multi";

    // 阶梯价权限
    public static final String LADDER_PRICE_PERMISSION = "110";

    // 参数缓存key值
    // 提醒列表
    public static final String REMIND_STANDARDIZATION_LIST = "remindStandardizationList";
    // 补货规则
    public static final String RESTOCKING_RULES_LIST = "restockingRulesList";
    // 各链路系数
    public static final String LINK_COEFFICIENT_LIST = "linkCoefficientList";
    // 库内系数
    public static final String WAREHOUSE_COEFFICIENT_LIST = "warehouseCoefficientList";
    // 销售等级
    public static final String SALES_LEVEL_LIST = "salesLevelList";
    // 发货等级
    public static final String SHIPPING_GRADE_LIST = "shippingGradeList";
    // 高风险产品下单安全系数
    public static final String ORDER_SAFETY_FACTOR_LIST = "orderSafetyFactorList";

    // restful请求静态参数
    // 请求地址
    public static final String YC_URL = "http://openapi-web.eccang.com/openApi/api/unity";

}
