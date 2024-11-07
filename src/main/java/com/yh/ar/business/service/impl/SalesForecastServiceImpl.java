package com.yh.ar.business.service.impl;

import com.yh.ar.business.mapper.UpdateDataMapper;
import com.yh.ar.business.pojo.ResultData;
import com.yh.ar.business.service.SalesForecastService;
import com.yh.ar.export.annotation.ExportAnnotation;
import com.yh.ar.util.ParamUtils;
import com.yh.ar.util.ResultDataUtils;
import com.yh.ar.util.page.PageResult;
import com.yh.ar.util.page.SelectDataAtom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: SalesForecastServiceImpl
 * @Description: 销售预测逻辑实现
 * @Author: system
 * @Date: 2024-10-27 12:17
 * @Version: 1.0
 **/
@Service("salesForecastService")
public class SalesForecastServiceImpl implements SalesForecastService {

    @Autowired
    UpdateDataMapper updateDataMapper;

    /**
     * @Author: system
     * @Description: 2次及以上返单
     * @Date: 2024-11-02 15:24:00
     * @Param: params
     * @return: ResultData<PageResult>
     **/
    @Override
    @ExportAnnotation(menuId = "multipleReturnOrders")
    public ResultData<PageResult> queryMultipleReturnOrdersList(Map<String, Object> params) {
        PageResult pageResult = SelectDataAtom.selectDataList("queryMultipleReturnOrdersList", params);
        return ResultDataUtils.success(pageResult);
    }

    /**
     * @Author: system
     * @Description: 修改2次及以上返单
     * @Date: 2024-11-03 22:02:28
     * @Param: params
     * @return: ResultData<String>
     **/
    @Override
    public ResultData<String> updMultipleReturnOrders(Map<String, Object> params) {
        String id = (String) params.get("id");
        if (!ParamUtils.isNullOrEmpty(id)) {
            return ResultDataUtils.fail("修改失败:请求参数[id]不能为空!");
        }

        try {
            updateDataMapper.updMultipleReturnOrders(params);
        } catch (Exception e) {
            return ResultDataUtils.fail("修改失败:请联系工作人员!");
        }

        return ResultDataUtils.success("修改成功");
    }

    /**
     * @Author: system
     * @Description: 首次返单
     * @Date: 2024-11-02 15:24:12
     * @Param: params
     * @return: ResultData<PageResult>
     **/
    @Override
    @ExportAnnotation(menuId = "firstReturnOrder")
    public ResultData<PageResult> queryFirstReturnOrderList(Map<String, Object> params) {
        PageResult pageResult = SelectDataAtom.selectDataList("queryFirstReturnOrderList", params);
        return ResultDataUtils.success(pageResult);
    }

    /**
     * @Author: system
     * @Description: 修改首次返单
     * @Date: 2024-11-03 22:02:45
     * @Param: params
     * @return: ResultData<String>
     **/
    @Override
    public ResultData<String> updFirstReturnOrder(Map<String, Object> params) {
        String id = (String) params.get("id");
        if (!ParamUtils.isNullOrEmpty(id)) {
            return ResultDataUtils.fail("修改失败:请求参数[id]不能为空!");
        }

        try {
            updateDataMapper.updFirstReturnOrder(params);
        } catch (Exception e) {
            return ResultDataUtils.fail("修改失败:请联系工作人员!");
        }

        return ResultDataUtils.success("修改成功");
    }
}
