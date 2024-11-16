package com.yh.ar.business.service.impl;

import com.yh.ar.business.mapper.UpdateDataMapper;
import com.yh.ar.business.pojo.ApprovalFirstReturnOrder;
import com.yh.ar.business.pojo.ApprovalMultipleReturnOrders;
import com.yh.ar.business.pojo.BatchMultipleReturnOrders;
import com.yh.ar.business.pojo.ResultData;
import com.yh.ar.business.service.OrderApprovalService;
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
 * @ClassName: OrderApprovalServiceImpl
 * @Description: 下单审批业务逻辑实现
 * @Author: system
 * @Date: 2024-11-02 15:43
 * @Version: 1.0
 **/
@Service("orderApprovalService")
public class OrderApprovalServiceImpl implements OrderApprovalService {

    @Autowired
    UpdateDataMapper updateDataMapper;

    @Autowired
    DataPermission dataPermission;

    private final Logger logger = LogManager.getLogger(getClass());

    /**
     * @Author: system
     * @Description: 下单审批
     * @Date: 2024-11-02 15:52:03
     * @Param: params
     * @return: ResultData<PageResult>
     **/
    @Override
    public ResultData<PageResult> queryOrderApprovalList(Map<String, Object> params) {
        PageResult pageResult = SelectDataAtom.selectDataList("queryOrderApprovalList", params);
        return ResultDataUtils.success(pageResult);
    }

    /**
     * @Author: system
     * @Description: 2次及以上反单
     * @Date: 2024-11-07 00:37:58
     * @Param: params
     * @return: ResultData<PageResult>
     **/
    @Override
    @ExportAnnotation(menuId = "approvalMultipleReturnOrders")
    public ResultData<PageResult> queryApprovalMultipleReturnOrdersList(Map<String, Object> params) {
        PageResult pageResult = SelectDataAtom.selectDataList("queryApprovalMultipleReturnOrdersList", params);
        List<Map<String, Object>> dataList = pageResult.getDataList();
        // 菜单名称-下单批次
        String menuId = MenuMethodEnum.ORDER_APPROVAL.getMenuId();
        // 账户
        String account = (String) params.get("account");
        // 阶梯价权限控制
        dataPermission.ladderPriceFilter(account, menuId, dataList);
        return ResultDataUtils.success(pageResult);
    }

    /**
     * @Author: system
     * @Description: 首次返单
     * @Date: 2024-11-07 00:38:08
     * @Param: params
     * @return: ResultData<PageResult>
     **/
    @Override
    @ExportAnnotation(menuId = "approvalFirstReturnOrder")
    public ResultData<PageResult> queryApprovalFirstReturnOrderList(Map<String, Object> params) {
        PageResult pageResult = SelectDataAtom.selectDataList("queryApprovalFirstReturnOrderList", params);
        List<Map<String, Object>> dataList = pageResult.getDataList();
        // 菜单名称-下单批次
        String menuId = MenuMethodEnum.ORDER_APPROVAL.getMenuId();
        // 账户
        String account = (String) params.get("account");
        // 阶梯价权限控制
        dataPermission.ladderPriceFilter(account, menuId, dataList);
        return ResultDataUtils.success(pageResult);
    }

    /**
     * @Author: system
     * @Description: 新增2次以上反单审批
     * @Date: 2024-11-07 09:04:34
     * @Param: params
     * @return: ResultData<String>
     **/
    @ImportAnnotation(menuId = "approvalMultipleReturnOrders")
    public ResultData<String> addMultipleApproval(Map<String, Object> params) {
        List<ApprovalMultipleReturnOrders> dataList = (List<ApprovalMultipleReturnOrders>) params.get("operateList");

        if (null != dataList && dataList.isEmpty()) {
            return ResultDataUtils.fail("新增失败:请求参数[operateList]不能为空!");
        }
        try {
            for (ApprovalMultipleReturnOrders approvalMultipleReturnOrders : dataList) {
                String product = String.valueOf(approvalMultipleReturnOrders.getProduct());
                if (!ParamUtils.isNullOrEmpty(product)) {
                    logger.error("新增失败:请求参数[product]不能为空!", approvalMultipleReturnOrders.toString());
                    continue;
                }
                // 下单批次号
                approvalMultipleReturnOrders.setOrderBatch(BusinessUtils.getBatchNumber());
                // 执行插入
                updateDataMapper.addMultipleApproval(approvalMultipleReturnOrders);
            }
        } catch (Exception e) {
            return ResultDataUtils.fail("新增失败:请联系工作人员!");
        }

        return ResultDataUtils.success("新增成功");
    }

    /**
     * @Author: system
     * @Description: 修改2次以上反单审批状态
     * @Date: 2024-11-07 09:04:34
     * @Param: params
     * @return: ResultData<String>
     **/
    @Override
    public ResultData<String> updMultipleApprovalSstatus(Map<String, Object> params) {
        List<Map> dataList = BusinessUtils.getOperateList(params);

        if (null != dataList && dataList.isEmpty()) {
            return ResultDataUtils.fail("修改失败:请求参数[operateList]不能为空!");
        }
        dataList.stream().forEach(map -> {
            String id = (String) map.get("id");
            if (!ParamUtils.isNullOrEmpty(id)) {
                logger.error("修改库内系数失败，参数id为空！{}", map);
            }
            updateDataMapper.updMultipleApprovalSstatus(map);
        });

        return ResultDataUtils.success("修改成功");
    }

    /**
     * @Author: system
     * @Description: 新增首次反单审批
     * @Date: 2024-11-07 09:04:34
     * @Param: params
     * @return: ResultData<String>
     **/
    @ImportAnnotation(menuId = "approvalFirstReturnOrder")
    public ResultData<String> addFirstApproval(Map<String, Object> params) {
        List<ApprovalFirstReturnOrder> dataList = (List<ApprovalFirstReturnOrder>) params.get("operateList");

        if (null != dataList && dataList.isEmpty()) {
            return ResultDataUtils.fail("新增失败:请求参数[operateList]不能为空!");
        }
        try {
            for (ApprovalFirstReturnOrder approvalFirstReturnOrder : dataList) {
                String product = String.valueOf(approvalFirstReturnOrder.getProduct());
                if (!ParamUtils.isNullOrEmpty(product)) {
                    logger.error("新增失败:请求参数[product]不能为空!", approvalFirstReturnOrder.toString());
                    continue;
                }
                // 下单批次号
                approvalFirstReturnOrder.setOrderBatch(BusinessUtils.getBatchNumber());
                // 执行插入
                updateDataMapper.addFirstApproval(approvalFirstReturnOrder);
            }
        } catch (Exception e) {
            return ResultDataUtils.fail("新增失败:请联系工作人员!");
        }

        return ResultDataUtils.success("新增成功");
    }

    /**
     * @Author: system
     * @Description: 修改首次反单审批状态
     * @Date: 2024-11-07 09:04:37
     * @Param: params
     * @return: ResultData<String>
     **/
    @Override
    public ResultData<String> updFirstApprovalSstatus(Map<String, Object> params) {
        List<Map> dataList = BusinessUtils.getOperateList(params);

        if (null != dataList && dataList.isEmpty()) {
            return ResultDataUtils.fail("修改失败:请求参数[operateList]不能为空!");
        }
        dataList.stream().forEach(map -> {
            String id = (String) map.get("id");
            if (!ParamUtils.isNullOrEmpty(id)) {
                logger.error("修改库内系数失败，参数id为空！{}", map);
            }
            updateDataMapper.updFirstApprovalSstatus(map);
        });

        return ResultDataUtils.success("修改成功");
    }

}