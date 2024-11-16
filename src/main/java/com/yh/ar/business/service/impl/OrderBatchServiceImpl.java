package com.yh.ar.business.service.impl;

import com.yh.ar.business.mapper.UpdateDataMapper;
import com.yh.ar.business.pojo.BatchFirstReturnOrder;
import com.yh.ar.business.pojo.BatchMultipleReturnOrders;
import com.yh.ar.business.pojo.FirstReturnOrder;
import com.yh.ar.business.pojo.ResultData;
import com.yh.ar.business.service.OrderBatchService;
import com.yh.ar.export.annotation.ExportAnnotation;
import com.yh.ar.export.annotation.ImportAnnotation;
import com.yh.ar.permission.DataPermission;
import com.yh.ar.util.BusinessUtils;
import com.yh.ar.util.ParamUtils;
import com.yh.ar.util.ResultDataUtils;
import com.yh.ar.util.enums.MenuMethodEnum;
import com.yh.ar.util.page.PageResult;
import com.yh.ar.util.page.SelectDataAtom;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    @Autowired
    DataPermission dataPermission;

    private final Logger logger = LogManager.getLogger(getClass());

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
        List<Map<String, Object>> dataList = pageResult.getDataList();
        // 菜单名称-下单批次
        String menuId = MenuMethodEnum.ORDER_BATCH.getMenuId();
        // 账户
        String account = (String) params.get("account");
        // 阶梯价权限控制
        dataPermission.ladderPriceFilter(account, menuId, dataList);
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
        List<Map<String, Object>> dataList = pageResult.getDataList();
        // 菜单名称-下单批次
        String menuId = MenuMethodEnum.ORDER_BATCH.getMenuId();
        // 账户
        String account = (String) params.get("account");
        // 阶梯价权限控制
        dataPermission.ladderPriceFilter(account, menuId, dataList);
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
     * @Description: 新增2次以上反单
     * @Date: 2024-11-07 08:48:55
     * @Param: params
     * @return: ResultData<String>
     **/
    @ImportAnnotation(menuId = "batchMultipleReturnOrders")
    public ResultData<String> addBatchMultipleReturnOrders(Map<String, Object> params) {
        List<BatchMultipleReturnOrders> dataList = (List<BatchMultipleReturnOrders>) params.get("operateList");

        if (null != dataList && dataList.isEmpty()) {
            return ResultDataUtils.fail("新增失败:请求参数[operateList]不能为空!");
        }
        try {
            for (BatchMultipleReturnOrders batchMultipleReturnOrders : dataList) {
                String product = String.valueOf(batchMultipleReturnOrders.getProduct());
                if (!ParamUtils.isNullOrEmpty(product)) {
                    logger.error("新增失败:请求参数[product]不能为空!", batchMultipleReturnOrders.toString());
                    continue;
                }
                // 下单批次号
                batchMultipleReturnOrders.setOrderBatch(BusinessUtils.getBatchNumber());
                // 执行插入
                updateDataMapper.addBatchMultipleReturnOrders(batchMultipleReturnOrders);
            }
        } catch (Exception e) {
            return ResultDataUtils.fail("新增失败:请联系工作人员!");
        }

        return ResultDataUtils.success("新增成功");
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
     * @Description: 新增首次返单
     * @Date: 2024-11-07 08:49:02
     * @Param: params
     * @return: ResultData<String>
     **/
    @ImportAnnotation(menuId = "batchFirstReturnOrder")
    public ResultData<String> addBatchFirstReturnOrder(Map<String, Object> params) {
        List<BatchFirstReturnOrder> dataList = (List<BatchFirstReturnOrder>) params.get("operateList");

        if (null != dataList && dataList.isEmpty()) {
            return ResultDataUtils.fail("新增失败:请求参数[operateList]不能为空!");
        }
        try {
            for (BatchFirstReturnOrder batchFirstReturnOrder : dataList) {
                String product = String.valueOf(batchFirstReturnOrder.getProduct());
                if (!ParamUtils.isNullOrEmpty(product)) {
                    logger.error("新增失败:请求参数[product]不能为空!", batchFirstReturnOrder.toString());
                    continue;
                }
                // 下单批次号
                batchFirstReturnOrder.setOrderBatch(BusinessUtils.getBatchNumber());
                // 执行插入
                updateDataMapper.addBatchFirstReturnOrder(batchFirstReturnOrder);
            }
        } catch (Exception e) {
            return ResultDataUtils.fail("新增失败:请联系工作人员!");
        }

        return ResultDataUtils.success("新增成功");
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