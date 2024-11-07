package com.yh.ar.business.service;

import com.yh.ar.business.pojo.ResultData;
import com.yh.ar.util.page.PageResult;

import java.util.Map;

/**
 * @ClassName: OrderApprovalService
 * @Description: 下单审批
 * @Author: system
 * @Date: 2024-11-02 15:37
 * @Version: 1.0
 **/
public interface OrderApprovalService {

    ResultData<PageResult> queryOrderApprovalList(Map<String, Object> params);

    ResultData<PageResult> queryApprovalMultipleReturnOrdersList(Map<String, Object> params);

    ResultData<PageResult> queryApprovalFirstReturnOrderList(Map<String, Object> params);

    ResultData<String> updMultipleApprovalSstatus(Map<String, Object> params);

    ResultData<String> updFirstApprovalSstatus(Map<String, Object> params);
}