package com.yh.ar.business.controller;

import com.yh.ar.business.pojo.ResultData;
import com.yh.ar.business.service.ProportionOfShipmentsService;
import com.yh.ar.util.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @ClassName: ProportionOfShipmentsController
 * @Description: CG发货占比
 * @Author: system
 * @Date: 2024-10-25 17
 * @Version: 1.0
 **/
@RestController
@RequestMapping("/api/proportionOfShipments")
public class ProportionOfShipmentsController {

    @Autowired
    private ProportionOfShipmentsService proportionOfShipmentsService;

    /**
     * @Author: system
     * @Description: CG发货占比列表查询
     * @Date: 2024-10-28 23:51:46
     * @Param: params
     * @return: ResultData<List < Map>>
     **/
    @GetMapping("/queryProportionOfShipmentsList")
    public ResultData<PageResult> queryProportionOfShipmentsList(@RequestParam Map<String, Object> params) {
        return proportionOfShipmentsService.queryProportionOfShipmentsList(params);
    }

    /**
     * @Author: system
     * @Description: 修改CG发货占比
     * @Date: 2024-11-03 22:25:27
     * @Param: params
     * @return: ResultData<PageResult>
     **/
    @RequestMapping(value = "/updProportionOfShipments", method = RequestMethod.POST)
    public ResultData<String> updProportionOfShipments(@RequestParam Map<String, Object> params) {
        return proportionOfShipmentsService.updProportionOfShipments(params);
    }

}
