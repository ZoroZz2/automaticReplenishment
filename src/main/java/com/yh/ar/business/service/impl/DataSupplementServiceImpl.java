package com.yh.ar.business.service.impl;

import com.yh.ar.business.mapper.UpdateDataMapper;
import com.yh.ar.business.pojo.ResultData;
import com.yh.ar.business.service.DataSupplementService;
import com.yh.ar.export.annotation.ExportAnnotation;
import com.yh.ar.util.ParamUtils;
import com.yh.ar.util.ResultDataUtils;
import com.yh.ar.util.page.PageResult;
import com.yh.ar.util.page.SelectDataAtom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;

import java.util.Map;

/**
 * @ClassName: DataSupplementServiceImpl
 * @Description: 数据补充实现类
 * @Author: system
 * @Date: 2024-10-31 18:32
 * @Version: 1.0
 **/
@Service("dataSupplementService")
public class DataSupplementServiceImpl implements DataSupplementService {

    @Autowired
    UpdateDataMapper updateDataMapper;

    /**
     * @Author: system
     * @Description: 产品标签数据
     * @Date: 2024-10-31 18:35:37
     * @Param: params
     * @return: ResultData<PageResult>
     **/
    @Override
    @ExportAnnotation(menuId = "dataSupplementProduct")
    public ResultData<PageResult> queryDataSupplementProductList(Map<String, Object> params) {
        // 查询采购下单数据
        PageResult pageResult = SelectDataAtom.selectDataList("queryDataSupplementProductList", params);
        return ResultDataUtils.success(pageResult);
    }

    /**
     * @Author: system
     * @Description: 新增产品标签数据
     * @Date: 2024-11-04 00:25:27
     * @Param: params
     * @return: ResultData<String>
     **/
    @Override
    public ResultData<String> addDataSupplementProduct(Map<String, Object> params) {
        String product = (String) params.get("product");
        if (!ParamUtils.isNullOrEmpty(product)) {
            return ResultDataUtils.fail("新增失败:请求参数[product]不能为空!");
        }

        try {
            updateDataMapper.addDataSupplementProduct(params);
        } catch (Exception e) {
            return ResultDataUtils.fail("新增失败:请联系工作人员!");
        }

        return ResultDataUtils.success("新增成功");
    }

    /**
     * @Author: system
     * @Description: 修改产品标签数据
     * @Date: 2024-11-04 00:25:27
     * @Param: params
     * @return: ResultData<String>
     **/
    @Override
    public ResultData<String> updDataSupplementProduct(Map<String, Object> params) {
        String id = (String) params.get("id");
        if (!ParamUtils.isNullOrEmpty(id)) {
            return ResultDataUtils.fail("修改失败:请求参数[id]不能为空!");
        }

        try {
            updateDataMapper.updDataSupplementProduct(params);
        } catch (Exception e) {
            return ResultDataUtils.fail("修改失败:请联系工作人员!");
        }

        return ResultDataUtils.success("修改成功");
    }

    /**
     * @Author: system
     * @Description: 工厂数据
     * @Date: 2024-10-31 18:36:11
     * @Param: params
     * @return: ResultData<PageResult>
     **/
    @Override
    @ExportAnnotation(menuId = "dataSupplementFactory")
    public ResultData<PageResult> queryDataSupplementFactoryList(Map<String, Object> params) {
        // 查询采购下单数据
        PageResult pageResult = SelectDataAtom.selectDataList("queryDataSupplementFactoryList", params);
        return ResultDataUtils.success(pageResult);
    }

    /**
     * @Author: system
     * @Description: 新增工厂数据
     * @Date: 2024-11-04 00:25:27
     * @Param: params
     * @return: ResultData<String>
     **/
    @Override
    public ResultData<String> addDataSupplementFactory(Map<String, Object> params) {
        String product = (String) params.get("product");
        if (!ParamUtils.isNullOrEmpty(product)) {
            return ResultDataUtils.fail("新增失败:请求参数[product]不能为空!");
        }

        try {
            updateDataMapper.addDataSupplementFactory(params);
        } catch (Exception e) {
            return ResultDataUtils.fail("新增失败:请联系工作人员!");
        }

        return ResultDataUtils.success("新增成功");
    }

    /**
     * @Author: system
     * @Description: 修改工厂数据
     * @Date: 2024-11-04 00:25:44
     * @Param: params
     * @return: ResultData<String>
     **/
    @Override
    public ResultData<String> updDataSupplementFactory(Map<String, Object> params) {
        String id = (String) params.get("id");
        if (!ParamUtils.isNullOrEmpty(id)) {
            return ResultDataUtils.fail("修改失败:请求参数[id]不能为空!");
        }

        try {
            updateDataMapper.updDataSupplementFactory(params);
        } catch (Exception e) {
            return ResultDataUtils.fail("修改失败:请联系工作人员!");
        }

        return ResultDataUtils.success("修改成功");
    }

    /**
     * @Author: system
     * @Description: CG发货占比数据
     * @Date: 2024-10-31 18:36:26
     * @Param: params
     * @return: ResultData<PageResult>
     **/
    @Override
    @ExportAnnotation(menuId = "dataSupplementDelivery")
    public ResultData<PageResult> queryDataSupplementDeliveryList(Map<String, Object> params) {
        // 查询采购下单数据
        PageResult pageResult = SelectDataAtom.selectDataList("queryDataSupplementDeliveryList", params);
        return ResultDataUtils.success(pageResult);
    }

    /**
     * @Author: system
     * @Description: 新增CG发货占比数据
     * @Date: 2024-11-04 00:25:27
     * @Param: params
     * @return: ResultData<String>
     **/
    @Override
    public ResultData<String> addDataSupplementDelivery(Map<String, Object> params) {
        String product = (String) params.get("product");
        if (!ParamUtils.isNullOrEmpty(product)) {
            return ResultDataUtils.fail("新增失败:请求参数[product]不能为空!");
        }

        try {
            updateDataMapper.addDataSupplementDelivery(params);
        } catch (Exception e) {
            return ResultDataUtils.fail("新增失败:请联系工作人员!");
        }

        return ResultDataUtils.success("新增成功");
    }

    /**
     * @Author: system
     * @Description: 修改CG发货占比数据
     * @Date: 2024-11-04 00:25:55
     * @Param: params
     * @return: ResultData<String>
     **/
    @Override
    public ResultData<String> updDataSupplementDelivery(Map<String, Object> params) {
        String id = (String) params.get("id");
        if (!ParamUtils.isNullOrEmpty(id)) {
            return ResultDataUtils.fail("修改失败:请求参数[id]不能为空!");
        }

        try {
            updateDataMapper.updDataSupplementDelivery(params);
        } catch (Exception e) {
            return ResultDataUtils.fail("修改失败:请联系工作人员!");
        }

        return ResultDataUtils.success("修改成功");
    }
}