package com.yh.ar.business.controller.placeAnOrder;

import com.yh.ar.business.pojo.ResultData;
import com.yh.ar.business.service.OrderBatchService;
import com.yh.ar.util.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @ClassName: OrderBatchController
 * @Description: 下单批次
 * @Author: system
 * @Date: 2024-10-25 17:30
 * @Version: 1.0
 **/
@RestController
@RequestMapping("/api/placeAnOrder")
public class OrderBatchController {

    @Autowired
    OrderBatchService orderBatchService;

    /**
     * @Author: system
     * @Description: 下单批次列表查询
     * @Date: 2024-10-29 19:22:38
     * @Param: params
     * @return: ResultData<List < Map>>
     **/
    @GetMapping("/queryOrderBatchList")
    public ResultData<PageResult> queryOrderBatchList(@RequestParam Map<String, Object> params) {
        return orderBatchService.queryOrderBatchList(params);
    }

    /**
     * @Author: system
     * @Description: 修改下单批次状态
     * @Date: 2024-10-29 19:22:38
     * @Param: params
     * @return: ResultData<List < Map>>
     **/
    @RequestMapping(value = "/updOrderBatch", method = RequestMethod.POST)
    public ResultData<String> updOrderBatch(@RequestParam Map<String, Object> params) {
        return orderBatchService.updOrderBatch(params);
    }

    /**
     * @Author: system
     * @Description: 2次以上反单
     * @Date: 2024-11-07 00:48:52
     * @Param: params
     * @return: ResultData<PageResult>
     **/
    @GetMapping("/queryBatchMultipleReturnOrdersList")
    public ResultData<PageResult> queryBatchMultipleReturnOrdersList(@RequestParam Map<String, Object> params) {
        return orderBatchService.queryBatchMultipleReturnOrdersList(params);
    }

    /**
     * @Author: system
     * @Description: 修改2次以上反单
     * @Date: 2024-11-07 08:47:23
     * @Param: params
     * @return: ResultData<String>
     **/
    @RequestMapping(value = "/updBatchMultipleReturnOrders", method = RequestMethod.POST)
    public ResultData<String> updBatchMultipleReturnOrders(@RequestParam Map<String, Object> params) {
        return orderBatchService.updBatchMultipleReturnOrders(params);
    }

    /**
     * @Author: system
     * @Description: 首次反单
     * @Date: 2024-11-07 00:49:09
     * @Param: params
     * @return: ResultData<PageResult>
     **/
    @GetMapping("/queryBatchFirstReturnOrderList")
    public ResultData<PageResult> queryBatchFirstReturnOrderList(@RequestParam Map<String, Object> params) {
        return orderBatchService.queryBatchFirstReturnOrderList(params);
    }

    /**
     * @Author: system
     * @Description: 修改首次返单
     * @Date: 2024-11-07 08:47:58
     * @Param: params
     * @return: ResultData<String>
     **/
    @RequestMapping(value = "/updBatchFirstReturnOrder", method = RequestMethod.POST)
    public ResultData<String> updBatchFirstReturnOrder(@RequestParam Map<String, Object> params) {
        return orderBatchService.updBatchFirstReturnOrder(params);
    }

}
