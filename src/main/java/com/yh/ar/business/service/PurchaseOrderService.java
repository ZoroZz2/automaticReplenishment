package com.yh.ar.business.service;

import com.yh.ar.business.pojo.ResultData;
import com.yh.ar.util.page.PageResult;

import java.util.Map;

/**
 * @InterfaceName: PurchaseOrderService
 * @Description: 采购下单接口
 * @Author: system
 * @Date: 2024-10-29 19:23
 * @Version: 1.0
 **/
public interface PurchaseOrderService {

    ResultData<PageResult> queryPurchaseOrderList(Map<String, Object> params);

    ResultData<PageResult> queryQuantityToBeOrderedList(Map<String, Object> params);

}