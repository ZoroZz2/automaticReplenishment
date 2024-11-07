package com.yh.ar.business.service.impl;

import com.yh.ar.business.mapper.UpdateDataMapper;
import com.yh.ar.business.pojo.ResultData;
import com.yh.ar.business.service.OrderBatchService;
import com.yh.ar.export.annotation.ExportAnnotation;
import com.yh.ar.util.ParamUtils;
import com.yh.ar.util.ResultDataUtils;
import com.yh.ar.util.page.PageResult;
import com.yh.ar.util.page.SelectDataAtom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @ClassName: OrderBatchServiceImpl
 * @Description: 下单批次业务逻辑实现
 * @Author: system
 * @Date: 2024-11-02 15:44
 * @Version: 1.0
 **/
@Service("orderBatchService")
public class OrderBatchServiceImpl implements OrderBatchService {

    @Autowired
    UpdateDataMapper updateDataMapper;

    /**
     * @Author: system
     * @Description: 下单批次列表查询
     * @Date: 2024-11-02 15:50:11
     * @Param: params
     * @return: ResultData<PageResult>
     **/
    @Override
    public ResultData<PageResult> queryOrderBatchList(Map<String, Object> params) {
        PageResult pageResult = SelectDataAtom.selectDataList("queryOrderBatchList", params);
        return ResultDataUtils.success(pageResult);
    }

    /**
     * @Author: system
     * @Description: 2次以上反单
     * @Date: 2024-11-07 00:51:41
     * @Param: params
     * @return: ResultData<PageResult>
     **/
    @Override
    @ExportAnnotation(menuId = "batchMultipleReturnOrders")
    public ResultData<PageResult> queryBatchMultipleReturnOrdersList(Map<String, Object> params) {
        PageResult pageResult = SelectDataAtom.selectDataList("queryBatchMultipleReturnOrdersList", params);
        return ResultDataUtils.success(pageResult);
    }

    /**
     * @Author: system
     * @Description: 首次反单
     * @Date: 2024-11-07 00:51:49
     * @Param: params
     * @return: ResultData<PageResult>
     **/
    @Override
    @ExportAnnotation(menuId = "batchFirstReturnOrder")
    public ResultData<PageResult> queryBatchFirstReturnOrderList(Map<String, Object> params) {
        PageResult pageResult = SelectDataAtom.selectDataList("queryBatchFirstReturnOrderList", params);
        return ResultDataUtils.success(pageResult);
    }

    /**
     * @Author: system
     * @Description: 修改批次信息
     * @Date: 2024-11-07 08:48:39
     * @Param: params
     * @return: ResultData<String>
     **/
    @Override
    public ResultData<String> updOrderBatch(Map<String, Object> params) {
        String id = (String) params.get("id");
        if (!ParamUtils.isNullOrEmpty(id)) {
            return ResultDataUtils.fail("修改失败:请求参数[id]不能为空!");
        }

        try {
            updateDataMapper.updOrderBatch(params);
        } catch (Exception e) {
            return ResultDataUtils.fail("修改失败:请联系工作人员!");
        }

        return ResultDataUtils.success("修改成功");
    }

    /**
     * @Author: system
     * @Description: 修改2次以上反单
     * @Date: 2024-11-07 08:48:55
     * @Param: params
     * @return: ResultData<String>
     **/
    @Override
    public ResultData<String> updBatchMultipleReturnOrders(Map<String, Object> params) {
        String id = (String) params.get("id");
        if (!ParamUtils.isNullOrEmpty(id)) {
            return ResultDataUtils.fail("修改失败:请求参数[id]不能为空!");
        }

        try {
            updateDataMapper.updBatchMultipleReturnOrders(params);
        } catch (Exception e) {
            return ResultDataUtils.fail("修改失败:请联系工作人员!");
        }

        return ResultDataUtils.success("修改成功");
    }

    /**
     * @Author: system
     * @Description: 修改首次返单
     * @Date: 2024-11-07 08:49:02
     * @Param: params
     * @return: ResultData<String>
     **/
    @Override
    public ResultData<String> updBatchFirstReturnOrder(Map<String, Object> params) {
        String id = (String) params.get("id");
        if (!ParamUtils.isNullOrEmpty(id)) {
            return ResultDataUtils.fail("修改失败:请求参数[id]不能为空!");
        }

        try {
            updateDataMapper.updBatchFirstReturnOrder(params);
        } catch (Exception e) {
            return ResultDataUtils.fail("修改失败:请联系工作人员!");
        }

        return ResultDataUtils.success("修改成功");
    }
}