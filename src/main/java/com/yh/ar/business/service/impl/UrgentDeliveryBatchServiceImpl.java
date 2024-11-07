package com.yh.ar.business.service.impl;

import com.yh.ar.business.mapper.UpdateDataMapper;
import com.yh.ar.business.pojo.ResultData;
import com.yh.ar.business.service.UrgentDeliveryBatchService;
import com.yh.ar.export.annotation.ExportAnnotation;
import com.yh.ar.util.BusinessUtils;
import com.yh.ar.util.ParamUtils;
import com.yh.ar.util.ResultDataUtils;
import com.yh.ar.util.page.PageResult;
import com.yh.ar.util.page.SelectDataAtom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;

/**
 * @ClassName: UrgentDeliveryBatchServiceImpl
 * @Description: 催货批次业务逻辑实现
 * @Author: system
 * @Date: 2024-11-02 15:47
 * @Version: 1.0
 **/
@Service("urgentDeliveryBatchService")
public class UrgentDeliveryBatchServiceImpl implements UrgentDeliveryBatchService {

    @Autowired
    UpdateDataMapper updateDataMapper;

    /**
     * @Author: system
     * @Description: 催货批次列表查询
     * @Date: 2024-11-02 16:07:41
     * @Param: params
     * @return: ResultData<PageResult>
     **/
    @Override
    public ResultData<PageResult> queryUrgentDeliveryBatchList(Map<String, Object> params) {
        PageResult pageResult = SelectDataAtom.selectDataList("queryUrgentDeliveryBatchList", params);
        return ResultDataUtils.success(pageResult);
    }

    /**
     * @Author: system
     * @Description: 新增催货批次
     * @Date: 2024-11-03 23:14:23
     * @Param: params
     * @return: ResultData<String>
     **/
    @Override
    public ResultData<String> addUrgentDeliveryBatch(Map<String, Object> params) {
        // 设置催货批次号
        params.put("urgentDeliveryBatch", BusinessUtils.getBatchNumber());
        try {
            updateDataMapper.addUrgentDeliveryBatch(params);
        } catch (Exception e) {
            return ResultDataUtils.fail("新增失败:请联系工作人员!");
        }
        return ResultDataUtils.success("新增成功");
    }

    /**
     * @Author: system
     * @Description: 修改催货批次状态
     * @Date: 2024-11-03 23:08:48
     * @Param: params
     * @return: ResultData<String>
     **/
    @Override
    public ResultData<String> updUrgentDeliveryBatch(Map<String, Object> params) {
        String id = (String) params.get("id");
        if (!ParamUtils.isNullOrEmpty(id)) {
            return ResultDataUtils.fail("修改失败:请求参数[id]不能为空!");
        }

        try {
            updateDataMapper.updUrgentDeliveryBatch(params);
        } catch (Exception e) {
            return ResultDataUtils.fail("修改失败:请联系工作人员!");
        }

        return ResultDataUtils.success("修改成功");
    }

    /**
     * @Author: system
     * @Description: 催生产列表查询
     * @Date: 2024-11-02 17:35:23
     * @Param: params
     * @return: ResultData<PageResult>
     **/
    @Override
    @ExportAnnotation(menuId = "urgeProductionDetails")
    public ResultData<PageResult> queryUrgeProductionDetailsList(Map<String, Object> params) {
        PageResult pageResult = SelectDataAtom.selectDataList("queryUrgeProductionDetailsList", params);
        return ResultDataUtils.success(pageResult);
    }

    /**
     * @Author: system
     * @Description: 催发货列表查询
     * @Date: 2024-11-02 17:35:36
     * @Param: params
     * @return: ResultData<PageResult>
     **/
    @Override
    @ExportAnnotation(menuId = "urgeShipmentDetails")
    public ResultData<PageResult> queryUrgeShipmentDetailsList(Map<String, Object> params) {
        PageResult pageResult = SelectDataAtom.selectDataList("queryUrgeShipmentDetailsList", params);
        return ResultDataUtils.success(pageResult);
    }
}