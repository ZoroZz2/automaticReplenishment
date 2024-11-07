package com.yh.ar.business.service;

import com.yh.ar.business.pojo.ResultData;
import com.yh.ar.util.page.PageResult;

import java.util.Map;

/**
 * @InterfaceName: ProportionOfShipmentsService
 * @Description: CG发货占比
 * @Author: system
 * @Date: 2024-11-02 15:25
 * @Version: 1.0
 **/
public interface ProportionOfShipmentsService {

    ResultData<PageResult> queryProportionOfShipmentsList(Map<String, Object> params);

    ResultData<String> updProportionOfShipments(Map<String, Object> params);

}