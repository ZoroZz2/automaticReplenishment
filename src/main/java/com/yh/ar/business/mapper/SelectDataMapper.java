package com.yh.ar.business.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: SelectDataMapper
 * @Description: 数据查询映射
 * @Author: system
 * @Date: 2024-10-29 19:31
 * @Version: 1.0
 **/
@Mapper
public interface SelectDataMapper {

    // 查询专用方法，通过反射调用，请不要删除！！！begin
    // 2次及以上返单
    List<Map> queryMultipleReturnOrdersList(Map<String, Object> params);

    // 查询预估月销
    List<Map> queryEstimatedMonthlySalesVolumeList(Map<String, Object> params);

    // 首次返单
    List<Map> queryFirstReturnOrderList(Map<String, Object> params);

    // CG发货占比数据
    List<Map> queryProportionOfShipmentsList(Map<String, Object> params);

    // 下单批次
    List<Map> queryOrderBatchList(Map<String, Object> params);

    // 下单批次-2次及以上反单
    List<Map> queryBatchMultipleReturnOrdersList(Map<String, Object> params);

    // 下单批次-首次返单
    List<Map> queryBatchFirstReturnOrderList(Map<String, Object> params);

    // 下单审批
    List<Map> queryOrderApprovalList(Map<String, Object> params);

    // 下单审批-2次及以上反单
    List<Map> queryApprovalMultipleReturnOrdersList(Map<String, Object> params);

    // 下单审批-首次返单
    List<Map> queryApprovalFirstReturnOrderList(Map<String, Object> params);

    // 查询采购下单数据
    List<Map> queryPurchaseOrderList(Map<String, Object> params);

    // 查询需下单数量
    List<Map> queryQuantityToBeOrderedList(Map<String, Object> params);

    // 查询催货批次数据
    List<Map> queryUrgentDeliveryBatchList(Map<String, Object> params);

    // 查询催生产数据
    List<Map> queryUrgeProductionDetailsList(Map<String, Object> params);

    // 查询催发货数据
    List<Map> queryUrgeShipmentDetailsList(Map<String, Object> params);

    // 提醒设置列表查询
    List<Map> queryRemindStandardizationList(Map<String, Object> params);

    // 补货规则列表查询
    List<Map> queryRestockingRulesList(Map<String, Object> params);

    // 各链路系数列表查询
    List<Map> queryLinkCoefficientList(Map<String, Object> params);

    // 库内系数列表查询
    List<Map> queryWarehouseCoefficientList(Map<String, Object> params);

    // 销售等级列表查询
    List<Map> querySalesLevelList(Map<String, Object> params);

    // 发货等级列表查询
    List<Map> queryShippingGradeList(Map<String, Object> params);

    // 高风险产品下单安全系数
    List<Map> queryOrderSafetyFactorList(Map<String, Object> params);

    // 查询数据补充-产品标签数据
    List<Map> queryDataSupplementProductList(Map<String, Object> params);

    // 查询数据补充-工厂数据
    List<Map> queryDataSupplementFactoryList(Map<String, Object> params);

    // 查询数据补充-CG发货占比数据
    List<Map> queryDataSupplementDeliveryList(Map<String, Object> params);

    // 查询模板管理数据
    List<Map> queryTemplateManagementList(Map<String, Object> params);

    // 查询模板详情数据
    List<Map> queryTemplateDetailsList(Map<String, Object> params);
    // 查询专用方法，通过反射调用，请不要删除！！！end

}