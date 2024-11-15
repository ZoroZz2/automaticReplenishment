package com.yh.ar.business.service;

import com.yh.ar.business.pojo.ResultData;
import com.yh.ar.util.page.PageResult;

import java.util.Map;

/**
 * @ClassName: DataSupplementService
 * @Description: 数据补充
 * @Author: system
 * @Date: 2024-10-31 18:31
 * @Version: 1.0
 **/
public interface DataSupplementService {

    // 查询数据补充-产品标签数据
    ResultData<PageResult> queryDataSupplementProductList(Map<String, Object> params);

    ResultData<String> addDataSupplementProduct(Map<String, Object> params);

    ResultData<String> updDataSupplementProduct(Map<String, Object> params);

    // 查询数据补充-工厂数据
    ResultData<PageResult> queryDataSupplementFactoryList(Map<String, Object> params);

    ResultData<String> addDataSupplementFactory(Map<String, Object> params);

    ResultData<String> updDataSupplementFactory(Map<String, Object> params);

    // 查询数据补充-CG发货占比数据
    ResultData<PageResult> queryDataSupplementDeliveryList(Map<String, Object> params);

    ResultData<String> addDataSupplementDelivery(Map<String, Object> params);

    ResultData<String> updDataSupplementDelivery(Map<String, Object> params);

}