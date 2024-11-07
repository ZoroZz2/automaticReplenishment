package com.yh.ar.business.controller;

import com.yh.ar.business.pojo.ResultData;
import com.yh.ar.business.service.SalesForecastService;
import com.yh.ar.util.ParamUtils;
import com.yh.ar.util.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: SalesForecastController
 * @Description: 销量预测
 * @Author: system
 * @Date: 2024-10-25 17:22
 * @Version: 1.0
 **/
@RestController
@RequestMapping("/api/salesForecast")
public class SalesForecastController {

    @Autowired
    private SalesForecastService salesForecastService;

    /**
     * @Author: system
     * @Description: 2次以上反单
     * @Date: 2024-10-28 23:51:46
     * @Param: params
     * @return: ResultData<List < Map>>
     **/
    @GetMapping("/queryMultipleReturnOrdersList")
    public ResultData<PageResult> queryMultipleReturnOrdersList(@RequestParam Map<String, Object> params) {
        return salesForecastService.queryMultipleReturnOrdersList(params);
    }

    /**
     * @Author: system
     * @Description: 修改2次以上反单
     * @Date: 2024-11-03 22:00:30
     * @Param: params
     * @return: ResultData<PageResult>
     **/
    @RequestMapping(value = "/updMultipleReturnOrders", method = RequestMethod.POST)
    public ResultData<String> updMultipleReturnOrders(@RequestParam Map<String, Object> params) {
        return salesForecastService.updMultipleReturnOrders(params);
    }

    /**
     * @Author: system
     * @Description: 首次反单
     * @Date: 2024-10-28 23:37:13
     * @Param: params
     * @return: ResultData<List < Map>>
     **/
    @GetMapping("/queryFirstReturnOrderList")
    public ResultData<PageResult> queryFirstReturnOrderList(@RequestParam Map<String, Object> params) {
        return salesForecastService.queryFirstReturnOrderList(params);
    }

    /**
     * @Author: system
     * @Description: 修改首次反单
     * @Date: 2024-11-03 22:00:30
     * @Param: params
     * @return: ResultData<PageResult>
     **/
    @RequestMapping(value = "/updFirstReturnOrder", method = RequestMethod.POST)
    public ResultData<String> updFirstReturnOrder(@RequestParam Map<String, Object> params) {
        return salesForecastService.updFirstReturnOrder(params);
    }

}
