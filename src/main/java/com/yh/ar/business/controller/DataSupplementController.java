package com.yh.ar.business.controller;

import com.yh.ar.business.pojo.ResultData;
import com.yh.ar.business.service.DataSupplementService;
import com.yh.ar.business.service.PurchaseOrderService;
import com.yh.ar.util.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @ClassName: DataSupplementController
 * @Description: 数据补充
 * @Author: system
 * @Date: 2024-10-25 17:35
 * @Version: 1.0
 **/
@RestController
@RequestMapping("/api/dataSupplement")
public class DataSupplementController {


    @Autowired
    DataSupplementService dataSupplementService;

    /**
     * @Author: system
     * @Description: 产品标签
     * @Date: 2024-10-29 19:22:38
     * @Param: params
     * @return: ResultData<List < Map>>
     **/
    @GetMapping("/queryDataSupplementProductList")
    public ResultData<PageResult> queryDataSupplementProductList(@RequestParam Map<String, Object> params) {
        return dataSupplementService.queryDataSupplementProductList(params);
    }

    /**
     * @Author: system
     * @Description: 修边产品标签
     * @Date: 2024-11-04 00:23:00
     * @Param: params
     * @return: ResultData<PageResult>
     **/
    @RequestMapping(value = "/updDataSupplementProduct", method = RequestMethod.POST)
    public ResultData<String> updDataSupplementProduct(@RequestParam Map<String, Object> params) {
        return dataSupplementService.updDataSupplementProduct(params);
    }

    /**
     * @Author: system
     * @Description: 工厂数据
     * @Date: 2024-10-29 19:22:38
     * @Param: params
     * @return: ResultData<List < Map>>
     **/
    @GetMapping("/queryDataSupplementFactoryList")
    public ResultData<PageResult> queryDataSupplementFactoryList(@RequestParam Map<String, Object> params) {
        return dataSupplementService.queryDataSupplementFactoryList(params);
    }

    /**
     * @Author: system
     * @Description: 修边工厂数据
     * @Date: 2024-11-04 00:23:00
     * @Param: params
     * @return: ResultData<PageResult>
     **/
    @RequestMapping(value = "/updDataSupplementFactory", method = RequestMethod.POST)
    public ResultData<String> updDataSupplementFactory(@RequestParam Map<String, Object> params) {
        return dataSupplementService.updDataSupplementFactory(params);
    }

    /**
     * @Author: system
     * @Description: CG发货占比数据
     * @Date: 2024-10-29 19:22:38
     * @Param: params
     * @return: ResultData<List < Map>>
     **/
    @GetMapping("/queryDataSupplementDeliveryList")
    public ResultData<PageResult> queryDataSupplementDeliveryList(@RequestParam Map<String, Object> params) {
        return dataSupplementService.queryDataSupplementDeliveryList(params);
    }

    /**
     * @Author: system
     * @Description: 修边CG发货占比数据
     * @Date: 2024-11-04 00:23:00
     * @Param: params
     * @return: ResultData<PageResult>
     **/
    @RequestMapping(value = "/updDataSupplementDelivery", method = RequestMethod.POST)
    public ResultData<String> updDataSupplementDelivery(@RequestParam Map<String, Object> params) {
        return dataSupplementService.updDataSupplementDelivery(params);
    }

}
