package com.yh.ar.business.service;

import com.yh.ar.business.pojo.ResultData;
import com.yh.ar.util.page.PageResult;

import java.util.Map;

/**
 * @ClassName: UrgentDeliveryBatchService
 * @Description: 催货批次
 * @Author: system
 * @Date: 2024-11-02 15:39
 * @Version: 1.0
 **/
public interface UrgentDeliveryBatchService {

    ResultData<PageResult> queryUrgentDeliveryBatchList(Map<String, Object> params);

    ResultData<String> addUrgentDeliveryBatch(Map<String, Object> params);

    ResultData<String> updUrgentDeliveryBatch(Map<String, Object> params);

    ResultData<PageResult> queryUrgeProductionDetailsList(Map<String, Object> params);

    ResultData<PageResult> queryUrgeShipmentDetailsList(Map<String, Object> params);

}