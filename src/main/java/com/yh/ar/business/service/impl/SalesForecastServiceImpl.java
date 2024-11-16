package com.yh.ar.business.service.impl;

import com.alibaba.fastjson.JSON;
import com.yh.ar.business.mapper.SelectDataMapper;
import com.yh.ar.business.mapper.UpdateDataMapper;
import com.yh.ar.business.pojo.FirstReturnOrder;
import com.yh.ar.business.pojo.MultipleReturnOrders;
import com.yh.ar.business.pojo.ResultData;
import com.yh.ar.business.service.SalesForecastService;
import com.yh.ar.export.annotation.ExportAnnotation;
import com.yh.ar.export.annotation.ImportAnnotation;
import com.yh.ar.util.ParamUtils;
import com.yh.ar.util.ResultDataUtils;
import com.yh.ar.util.page.PageResult;
import com.yh.ar.util.page.SelectDataAtom;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

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

    @Autowired
    SelectDataMapper selectDataMapper;

    @Autowired
    TransactionTemplate transactionTemplate;

    private final Logger logger = LogManager.getLogger(getClass());

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
     * @Description: 新增2次及以上返单
     * @Date: 2024-11-15 15:33:00
     * @Param: params
     * @return: ResultData<String>
     **/
    @ImportAnnotation(menuId = "multipleReturnOrders")
    public ResultData<String> addMultipleReturnOrdersParent(Map<String, Object> params) {
        List<MultipleReturnOrders> dataList = (List<MultipleReturnOrders>) params.get("operateList");

        if (null != dataList && dataList.isEmpty()) {
            return ResultDataUtils.fail("新增失败:请求参数[operateList]不能为空!");
        }
        try {
            for (MultipleReturnOrders multipleReturnOrders : dataList) {
                String product = String.valueOf(multipleReturnOrders.getProduct());
                if (!ParamUtils.isNullOrEmpty(product)) {
                    logger.error("新增失败:请求参数[product]不能为空!", multipleReturnOrders.toString());
                    continue;
                }
                // 对象转Map
                Map<String, Object> insertMap = JSON.parseObject(JSON.toJSONString(multipleReturnOrders), Map.class);
                // 编程式事务sql管理
                transactionTemplate.execute(new TransactionCallbackWithoutResult() {
                    @Override
                    protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                        try {
                            updateDataMapper.addMultipleReturnOrdersParent(insertMap);
                            updateDataMapper.addMultipleReturnOrders(insertMap);
                        } catch (Exception e) {
                            //回滚
                            transactionStatus.setRollbackOnly();
                        }
                    }
                });
            }
        } catch (Exception e) {
            return ResultDataUtils.fail("新增失败:请联系工作人员!");
        }

        return ResultDataUtils.success("新增成功");
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
            // 预估月销数据
            List<Map> dataList = selectDataMapper.queryEstimatedMonthlySalesVolumeList(params);
            if (dataList.size() == 0) { // 新增数据
                updateDataMapper.addMultipleReturnOrders(params);
            } else {
                updateDataMapper.updMultipleReturnOrders(params);
            }
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
     * @Description: 新增首次返单
     * @Date: 2024-11-15 15:33:23
     * @Param: params
     * @return: ResultData<String>
     **/
    @ImportAnnotation(menuId = "firstReturnOrder")
    public ResultData<String> addFirstReturnOrder(Map<String, Object> params) {
        List<FirstReturnOrder> dataList = (List<FirstReturnOrder>) params.get("operateList");

        if (null != dataList && dataList.isEmpty()) {
            return ResultDataUtils.fail("新增失败:请求参数[operateList]不能为空!");
        }
        try {
            for (FirstReturnOrder firstReturnOrder : dataList) {
                String product = String.valueOf(firstReturnOrder.getProduct());
                if (!ParamUtils.isNullOrEmpty(product)) {
                    logger.error("新增失败:请求参数[product]不能为空!", firstReturnOrder.toString());
                    continue;
                }
                // 执行插入
                updateDataMapper.addFirstReturnOrder(firstReturnOrder);
            }
        } catch (Exception e) {
            return ResultDataUtils.fail("新增失败:请联系工作人员!");
        }

        return ResultDataUtils.success("新增成功");
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
