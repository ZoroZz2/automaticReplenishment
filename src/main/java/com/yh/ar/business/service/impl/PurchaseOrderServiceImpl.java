package com.yh.ar.business.service.impl;

import com.yh.ar.business.pojo.ResultData;
import com.yh.ar.business.service.PurchaseOrderService;
import com.yh.ar.export.annotation.ExportAnnotation;
import com.yh.ar.util.ResultDataUtils;
import com.yh.ar.util.page.PageResult;
import com.yh.ar.util.page.SelectDataAtom;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @ClassName: PurchaseOrderServiceImpl
 * @Description: 采购下单逻辑实现
 * @Author: system
 * @Date: 2024-10-29 19:25
 * @Version: 1.0
 **/
@Service("purchaseOrderService")
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    /**
     * @Author: system
     * @Description: 采购下单数据查询
     * @Date: 2024-10-30 12:02:27
     * @Param: params
     * @return: ResultData<PageResult>
     **/
    @Override
    @ExportAnnotation(menuId = "purchaseOrder")
    public ResultData<PageResult> queryPurchaseOrderList(Map<String, Object> params) {
        PageResult pageResult = SelectDataAtom.selectDataList("queryPurchaseOrderList", params);
        return ResultDataUtils.success(pageResult);
    }

    /**
     * @Author: system
     * @Description: 需下单数量
     * @Date: 2024-11-04 00:09:06
     * @Param: params
     * @return: ResultData<PageResult>
     **/
    @Override
    @ExportAnnotation(menuId = "quantityToBeOrdered")
    public ResultData<PageResult> queryQuantityToBeOrderedList(Map<String, Object> params) {
        PageResult pageResult = SelectDataAtom.selectDataList("queryQuantityToBeOrderedList", params);
        return ResultDataUtils.success(pageResult);
    }
}