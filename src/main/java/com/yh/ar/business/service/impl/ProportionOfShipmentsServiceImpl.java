package com.yh.ar.business.service.impl;

import com.yh.ar.business.mapper.UpdateDataMapper;
import com.yh.ar.business.pojo.ResultData;
import com.yh.ar.business.service.ProportionOfShipmentsService;
import com.yh.ar.export.annotation.ExportAnnotation;
import com.yh.ar.util.ParamUtils;
import com.yh.ar.util.ResultDataUtils;
import com.yh.ar.util.page.PageResult;
import com.yh.ar.util.page.SelectDataAtom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @ClassName: ProportionOfShipmentsServiceImpl
 * @Description: CG发货占比逻辑实现
 * @Author: system
 * @Date: 2024-11-02 15:26
 * @Version: 1.0
 **/
@Service("proportionOfShipmentsService")
public class ProportionOfShipmentsServiceImpl implements ProportionOfShipmentsService {

    @Autowired
    UpdateDataMapper updateDataMapper;

    /**
     * @Author: system
     * @Description: CG发货占比数据列表查询
     * @Date: 2024-11-02 15:28:56
     * @Param: params
     * @return: ResultData<PageResult>
     **/
    @Override
    @ExportAnnotation(menuId = "proportionOfShipments")
    public ResultData<PageResult> queryProportionOfShipmentsList(Map<String, Object> params) {
        PageResult pageResult = SelectDataAtom.selectDataList("queryProportionOfShipmentsList", params);
        return ResultDataUtils.success(pageResult);
    }

    /**
     * @Author: system
     * @Description: 修改CG发货占比
     * @Date: 2024-11-03 22:26:03
     * @Param: params
     * @return: ResultData<String>
     **/
    @Override
    public ResultData<String> updProportionOfShipments(Map<String, Object> params) {
        String id = (String) params.get("id");
        if (!ParamUtils.isNullOrEmpty(id)) {
            return ResultDataUtils.fail("修改失败:请求参数[id]不能为空!");
        }

        try {
            updateDataMapper.updProportionOfShipments(params);
        } catch (Exception e) {
            return ResultDataUtils.fail("修改失败:请联系工作人员!");
        }

        return ResultDataUtils.success("修改成功");
    }

}