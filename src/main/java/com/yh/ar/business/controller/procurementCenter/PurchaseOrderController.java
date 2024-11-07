package com.yh.ar.business.controller.procurementCenter;

import com.yh.ar.business.pojo.ResultData;
import com.yh.ar.business.service.PurchaseOrderService;
import com.yh.ar.util.ParamUtils;
import com.yh.ar.util.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: PurchaseOrderController
 * @Description: 采购下单
 * @Author: system
 * @Date: 2024-10-25 17:32
 * @Version: 1.0
 **/
@RestController
@RequestMapping("/api/procurementCenter")
public class PurchaseOrderController {

    @Autowired
    PurchaseOrderService purchaseOrderService;

    /**
     * @Author: system
     * @Description: 采购下单列表查询
     * @Date: 2024-10-29 19:22:38
     * @Param: params
     * @return: ResultData<List < Map>>
     **/
    @GetMapping("/queryPurchaseOrderList")
    public ResultData<PageResult> queryPurchaseOrderList(@RequestParam Map<String, Object> params) {
        return purchaseOrderService.queryPurchaseOrderList(params);
    }

    /**
     * @Author: system
     * @Description: 需下单数量查询
     * @Date: 2024-11-04 00:10:02
     * @Param: params
     * @return: ResultData<PageResult>
     **/
    @GetMapping("/queryQuantityToBeOrderedList")
    public ResultData<PageResult> queryQuantityToBeOrderedList(@RequestParam Map<String, Object> params) {
        return purchaseOrderService.queryQuantityToBeOrderedList(params);
    }

}
