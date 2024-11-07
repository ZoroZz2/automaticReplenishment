package com.yh.ar.account.pojo;

import lombok.Data;

/**
 * @ClassName: RoleInfo
 * @Description: 角色信息基础类
 * @Author: system
 * @Date: 2024-10-27 22:24
 * @Version: 1.0
 **/
@Data
public class RoleInfo {

    // 角色id
    private String roleId;
    // 角色名
    private String roleName;
    // 产品分类
    private String productType;

    // 权限:销量预测
    private String salesForecast;
    // 权限:CG发货占比
    private String proportionOfShipments;
    // 权限:下单审批-下单批次
    private String orderBatch;
    // 权限:下单审批-下单审批
    private String orderApproval;
    // 权限:采购中心-采购下单
    private String purchaseOrder;
    // 权限:采购中心-催货批次
    private String urgentDeliveryBatch;
    // 权限:产品管理
    private String paramManagement;
    // 权限:数据补充
    private String dataSupplement;
    // 权限:数据报表
    private String dataReport;
    // 权限:权限管理-角色管理
    private String roleManagement;
    // 权限:权限管理-账户管理
    private String accountManagement;

    // 账户状态
    private String status;
    // 创建时间
    private String createdTime;
    // 修改时间
    private String updateTime;

}
