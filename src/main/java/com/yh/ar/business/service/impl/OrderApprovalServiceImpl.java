package com.yh.ar.business.service.impl;

import com.yh.ar.business.mapper.UpdateDataMapper;
import com.yh.ar.business.pojo.ResultData;
import com.yh.ar.business.service.OrderApprovalService;
import com.yh.ar.export.annotation.ExportAnnotation;
import com.yh.ar.permission.DataPermission;
import com.yh.ar.util.ParamUtils;
import com.yh.ar.util.ResultDataUtils;
import com.yh.ar.util.enums.MenuMethodEnum;
import com.yh.ar.util.page.PageResult;
import com.yh.ar.util.page.SelectDataAtom;
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
     * @Description: 修改2次以上反单审批状态
     * @Date: 2024-11-07 09:04:34
     * @Param: params
     * @return: ResultData<String>
     **/
    @Override
    public ResultData<String> updMultipleApprovalSstatus(Map<String, Object> params) {
        List<Map> dataList = (List) params.get("updList");
        if (null != dataList && dataList.isEmpty()) {
            return ResultDataUtils.fail("修改失败:请求参数[updList]不能为空!");
        }
        dataList.stream().forEach(map -> {
            String id = (String) map.get("id");
            if (!ParamUtils.isNullOrEmpty(id)) {
                // TODO:待日志打印
            }
            try {
                updateDataMapper.updMultipleApprovalSstatus(map);
            } catch (Exception e) {
                // TODO:待日志打印
                //return ResultDataUtils.fail("修改失败:请联系工作人员!");
            }
        });

        return ResultDataUtils.success("修改成功");
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
        List<Map> dataList = (List) params.get("updList");
        if (null != dataList && dataList.isEmpty()) {
            return ResultDataUtils.fail("修改失败:请求参数[updList]不能为空!");
        }
        dataList.stream().forEach(map -> {
            String id = (String) map.get("id");
            if (!ParamUtils.isNullOrEmpty(id)) {
                // TODO:待日志打印
            }
            try {
                updateDataMapper.updFirstApprovalSstatus(map);
            } catch (Exception e) {
                // TODO:待日志打印
                //return ResultDataUtils.fail("修改失败:请联系工作人员!");
            }
        });

        return ResultDataUtils.success("修改成功");
    }

}