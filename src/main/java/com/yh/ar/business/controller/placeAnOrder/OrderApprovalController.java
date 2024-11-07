package com.yh.ar.business.controller.placeAnOrder;

import com.yh.ar.business.pojo.ResultData;
import com.yh.ar.business.service.OrderApprovalService;
import com.yh.ar.util.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @ClassName: OrderApprovalController
 * @Description: 下单审批
 * @Author: system
 * @Date: 2024-10-25 17:24
 * @Version: 1.0
 **/
@RestController
@RequestMapping("/api/placeAnOrder")
public class OrderApprovalController {

    @Autowired
    OrderApprovalService orderApprovalService;

    /**
     * @Author: system
     * @Description: 下单审批列表查询
     * @Date: 2024-11-02 15:51:25
     * @Param: params
     * @return: ResultData<PageResult>
     **/
    @GetMapping("/queryOrderApprovalList")
    public ResultData<PageResult> queryOrderApprovalList(@RequestParam Map<String, Object> params) {
        return orderApprovalService.queryOrderApprovalList(params);
    }

    /**
     * @Author: system
     * @Description: 2次以上反单
     * @Date: 2024-10-28 23:51:46
     * @Param: params
     * @return: ResultData<List < Map>>
     **/
    @GetMapping("/queryApprovalMultipleReturnOrdersList")
    public ResultData<PageResult> queryApprovalMultipleReturnOrdersList(@RequestParam Map<String, Object> params) {
        return orderApprovalService.queryApprovalMultipleReturnOrdersList(params);
    }

    /**
     * @Author: system
     * @Description: 修改2次以上反单审批状态
     * @Date: 2024-11-07 09:02:30
     * @Param: params
     * @return: ResultData<String>
     **/
    @RequestMapping(value = "/updMultipleApprovalSstatus", method = RequestMethod.POST)
    public ResultData<String> updMultipleApprovalSstatus(@RequestParam Map<String, Object> params) {
        return orderApprovalService.updMultipleApprovalSstatus(params);
    }

    /**
     * @Author: system
     * @Description: 首次反单
     * @Date: 2024-10-28 23:37:13
     * @Param: params
     * @return: ResultData<List < Map>>
     **/
    @GetMapping("/queryApprovalFirstReturnOrderList")
    public ResultData<PageResult> queryApprovalFirstReturnOrderList(@RequestParam Map<String, Object> params) {
        return orderApprovalService.queryApprovalFirstReturnOrderList(params);
    }

    /**
     * @Author: system
     * @Description: 修改首次反单审批状态
     * @Date: 2024-11-07 09:04:10
     * @Param: params
     * @return: ResultData<String>
     **/
    @RequestMapping(value = "/updFirstApprovalSstatus", method = RequestMethod.POST)
    public ResultData<String> updFirstApprovalSstatus(@RequestParam Map<String, Object> params) {
        return orderApprovalService.updFirstApprovalSstatus(params);
    }

}
