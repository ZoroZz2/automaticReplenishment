package com.yh.ar.business.mapper;

import com.yh.ar.business.pojo.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * @ClassName: UpdateDataMapper
 * @Description: 数据修改映射
 * @Author: system
 * @Date: 2024-10-29 19:49
 * @Version: 1.0
 **/
@Mapper
public interface UpdateDataMapper extends CommonMapper {

    int addMultipleReturnOrdersParent(Map<String, Object> params);

    int addMultipleReturnOrders(Map<String, Object> params);

    int updMultipleReturnOrders(Map<String, Object> params);

    int addFirstReturnOrder(FirstReturnOrder firstReturnOrder);

    int updFirstReturnOrder(Map<String, Object> params);

    int addProportionOfShipments(ProportionOfShipments proportionOfShipments);

    int updProportionOfShipments(Map<String, Object> params);

    int updOrderBatch(Map<String, Object> params);

    int addBatchMultipleReturnOrders(BatchMultipleReturnOrders batchMultipleReturnOrders);

    int updBatchMultipleReturnOrders(Map<String, Object> params);

    int addBatchFirstReturnOrder(BatchFirstReturnOrder batchFirstReturnOrder);

    int updBatchFirstReturnOrder(Map<String, Object> params);

    int addMultipleApproval(ApprovalMultipleReturnOrders approvalMultipleReturnOrders);

    int updMultipleApprovalSstatus(Map<String, Object> params);

    int addFirstApproval(ApprovalFirstReturnOrder approvalFirstReturnOrder);

    int updFirstApprovalSstatus(Map<String, Object> params);

    int addUrgentDeliveryBatch(Map<String, Object> params);

    int updUrgentDeliveryBatch(Map<String, Object> params);

    int addDataSupplementProduct(DataSupplementProduct dataSupplementProduct);

    int updDataSupplementProduct(Map<String, Object> params);

    int addDataSupplementFactory(DataSupplementFactory dataSupplementFactory);

    int updDataSupplementFactory(Map<String, Object> params);

    int addDataSupplementDelivery(DataSupplementDelivery dataSupplementDelivery);

    int updDataSupplementDelivery(Map<String, Object> params);

    int addRemindStandardization(Map<String, Object> params);

    int updRemindStandardization(Map<String, Object> params);

    int delRemindStandardization(Map<String, Object> params);

    int addRestockingRules(Map<String, Object> params);

    int updRestockingRules(Map<String, Object> params);

    int delRestockingRules(Map<String, Object> params);

    int updLinkCoefficient(Map<String, Object> params);

    int updWarehouseCoefficient(Map<String, Object> params);

    int updSalesLevel(Map<String, Object> params);

    int addShippingGrade(Map<String, Object> params);

    int updShippingGrade(Map<String, Object> params);

    int delShippingGrade(Map<String, Object> params);

    int updOrderSafetyFactor(Map<String, Object> params);

    int delTemplateManagement(TemplateManagement template);
}