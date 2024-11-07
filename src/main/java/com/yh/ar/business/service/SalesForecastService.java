package com.yh.ar.business.service;

import com.yh.ar.business.pojo.ResultData;
import com.yh.ar.util.page.PageResult;

import java.util.Map;

/**
 * @ClassName: SalesForecastService
 * @Description: 销量预测业务逻辑处理
 * @Author: system
 * @Date: 2024-10-25 18:05
 * @Version: 1.0
 **/
public interface SalesForecastService {

    ResultData<PageResult> queryMultipleReturnOrdersList(Map<String, Object> params);

    ResultData<String> updMultipleReturnOrders(Map<String, Object> params);

    ResultData<PageResult> queryFirstReturnOrderList(Map<String, Object> params);

    ResultData<String> updFirstReturnOrder(Map<String, Object> params);
}
