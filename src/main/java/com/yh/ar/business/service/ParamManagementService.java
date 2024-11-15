package com.yh.ar.business.service;

import com.yh.ar.business.pojo.ResultData;
import com.yh.ar.util.page.PageResult;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: ParamManagementService
 * @Description: 参数管理
 * @Author: system
 * @Date: 2024-11-02 15:39
 * @Version: 1.0
 **/
public interface ParamManagementService {

    ResultData<PageResult> queryRemindStandardizationList(Map<String, Object> params);

    ResultData<String> addRemindStandardization(Map<String, Object> params);

    ResultData<String> updRemindStandardization(Map<String, Object> params);

    ResultData<String> delRemindStandardization(Map<String, Object> params);

    ResultData<PageResult> queryRestockingRulesList(Map<String, Object> params);

    ResultData<String> addRestockingRules(Map<String, Object> params);

    ResultData<String> updRestockingRules(Map<String, Object> params);

    ResultData<String> delRestockingRules(Map<String, Object> params);

    ResultData<PageResult> queryLinkCoefficientList(Map<String, Object> params);

    ResultData<String> updLinkCoefficient(Map<String, Object> params);

    ResultData<List<Map>> queryWarehouseCoefficientList(Map<String, Object> params);

    ResultData<String> updWarehouseCoefficient(Map<String, Object> params);

    ResultData<List<Map>> querySalesLevelList(Map<String, Object> params);

    ResultData<String> updSalesLevel(Map<String, Object> params);

    ResultData<PageResult> queryShippingGradeList(Map<String, Object> params);

    ResultData<String> addShippingGrade(Map<String, Object> params);

    ResultData<String> updShippingGrade(Map<String, Object> params);

    ResultData<String> delShippingGrade(Map<String, Object> params);

    ResultData<List<Map>> queryOrderSafetyFactorList(Map<String, Object> params);

    ResultData<String> updOrderSafetyFactor(Map<String, Object> params);

}