package com.yh.ar.business.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @ClassName: ApprovalFirstReturnOrder
 * @Description: 下单审批-首次返单
 * @Author: system
 * @Date: 2024-11-07 01:09
 * @Version: 1.0
 **/
@Table(name = "下单审批-首次返单")
@Data
public class ApprovalFirstReturnOrder {

    @Column(name = "序号")
    public String id;
    @Column(name = "下单批次")
    public String orderBatch;
    @Column(name = "产品分类")
    public String productType;
    @Column(name = "产品SPU")
    public String product;
    @Column(name = "工厂ID")
    public String factoryId;
    @Column(name = "工厂名称")
    public String factoryName;
    @Column(name = "新品标签")
    public String newProductLabel;
    @Column(name = "总库存")
    public String totalInventory;
    @Column(name = "上个月销量")
    public String lastMonthSalesVolume;
    @Column(name = "近14天销量")
    public String recentSalesFourteenDays;
    @Column(name = "近7天销量")
    public String recentSalesSevenDays;
    @Column(name = "全平台利润等级")
    public String profitLevel;
    @Column(name = "全平台销量等级")
    public String salesLevel;
    @Column(name = "起订量")
    public String minimumOrderQuantity;
    @Column(name = "阶梯价")
    public String ladderPrice;
    @Column(name = "WF建议下单量")
    public String wfSuggestedOrderQuantity;
    @Column(name = "HD建议下单量")
    public String hdSuggestedOrderQuantity;
    @Column(name = "AMZ建议下单量")
    public String amzSuggestedOrderQuantit;
    @Column(name = "OS建议下单量")
    public String osSuggestedOrderQuantity;
    @Column(name = "全平台建议下单量")
    public String suggestPlacingAnOrder;
    @Column(name = "跟单建议下单量")
    public String singleOrderQuantity;
    @Column(name = "下单数量")
    public String orderQuantity;

}