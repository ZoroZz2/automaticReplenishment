package com.yh.ar.business.controller.procurementCenter;

import com.yh.ar.business.pojo.ResultData;
import com.yh.ar.business.service.PurchaseOrderService;
import com.yh.ar.business.service.UrgentDeliveryBatchService;
import com.yh.ar.util.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @ClassName: UrgentDeliveryBatchController
 * @Description: 催货批次
 * @Author: system
 * @Date: 2024-10-25 17:32
 * @Version: 1.0
 **/
@RestController
@RequestMapping("/api/procurementCenter")
public class UrgentDeliveryBatchController {

    @Autowired
    UrgentDeliveryBatchService urgentDeliveryBatchService;

    /**
     * @Author: system
     * @Description: 催货批次列表查询
     * @Date: 2024-10-29 19:22:38
     * @Param: params
     * @return: ResultData<List < Map>>
     **/
    @GetMapping("/queryUrgentDeliveryBatchList")
    public ResultData<PageResult> queryUrgentDeliveryBatchList(@RequestParam Map<String, Object> params) {
        return urgentDeliveryBatchService.queryUrgentDeliveryBatchList(params);
    }

    /**
     * @Author: system
     * @Description: 新增催货批次状态
     * @Date: 2024-10-29 19:22:38
     * @Param: params
     * @return: ResultData<List < Map>>
     **/
    @RequestMapping(value = "/addUrgentDeliveryBatch", method = RequestMethod.POST)
    public ResultData<String> addUrgentDeliveryBatch(@RequestParam Map<String, Object> params) {
        return urgentDeliveryBatchService.addUrgentDeliveryBatch(params);
    }

    /**
     * @Author: system
     * @Description: 修改催货批次状态
     * @Date: 2024-10-29 19:22:38
     * @Param: params
     * @return: ResultData<List < Map>>
     **/
    @RequestMapping(value = "/updUrgentDeliveryBatch", method = RequestMethod.POST)
    public ResultData<String> updUrgentDeliveryBatch(@RequestParam Map<String, Object> params) {
        return urgentDeliveryBatchService.updUrgentDeliveryBatch(params);
    }

    /**
     * @Author: system
     * @Description: 催生产列表查询
     * @Date: 2024-11-02 17:34:05
     * @Param: params
     * @return: ResultData<PageResult>
     **/
    @GetMapping("/queryUrgeProductionDetailsList")
    public ResultData<PageResult> queryUrgeProductionDetailsList(@RequestParam Map<String, Object> params) {
        return urgentDeliveryBatchService.queryUrgeProductionDetailsList(params);
    }

    /**
     * @Author: system
     * @Description: 催发货列表查询
     * @Date: 2024-11-02 17:34:05
     * @Param: params
     * @return: ResultData<PageResult>
     **/
    @GetMapping("/queryUrgeShipmentDetailsList")
    public ResultData<PageResult> queryUrgeShipmentDetailsList(@RequestParam Map<String, Object> params) {
        return urgentDeliveryBatchService.queryUrgeShipmentDetailsList(params);
    }


}
