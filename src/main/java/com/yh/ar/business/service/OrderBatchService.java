package com.yh.ar.business.service;

import com.yh.ar.business.pojo.ResultData;
import com.yh.ar.util.page.PageResult;

import java.util.Map;

/**
 * @ClassName: OrderBatchService
 * @Description: 下单批次
 * @Author: system
 * @Date: 2024-11-02 15:37
 * @Version: 1.0
 **/
public interface OrderBatchService {

    ResultData<PageResult> queryOrderBatchList(Map<String, Object> params);

    ResultData<PageResult> queryBatchMultipleReturnOrdersList(Map<String, Object> params);

    ResultData<PageResult> queryBatchFirstReturnOrderList(Map<String, Object> params);

    ResultData<String> updOrderBatch(Map<String, Object> params);

    ResultData<String> updBatchMultipleReturnOrders(Map<String, Object> params);

    ResultData<String> updBatchFirstReturnOrder(Map<String, Object> params);
}