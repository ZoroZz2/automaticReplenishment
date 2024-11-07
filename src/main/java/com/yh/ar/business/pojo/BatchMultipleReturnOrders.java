package com.yh.ar.business.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @ClassName: BatchMultipleReturnOrders
 * @Description: 下单批次-2次以上返单
 * @Author: system
 * @Date: 2024-11-07 01:08
 * @Version: 1.0
 **/
@Table(name = "下单批次-2次以上返单")
@Data
public class BatchMultipleReturnOrders {

    @Column(name = "序号")
    public String id;
    @Column(name = "下单批次")
    public String orderBatch;
    @Column(name = "产品分类")
    public String productType;
    @Column(name = "产品SPU")
    public String product;
    @Column(name = "砍线标签")
    public String isCut;
    @Column(name = "新品标签")
    public String newProductLabel;
    @Column(name = "总库存")
    public String totalInventory;
    @Column(name = "近3个月月均销量")
    public String monthlyAverageSalesVolume;
    @Column(name = "预估月销")
    public String estimatedMonthlySales;
    @Column(name = "预估风险")
    public String estimateRisk;
    @Column(name = "建议预估范围")
    public String suggestedEstimatedRange;
    @Column(name = "下单安全库存")
    public String orderSafetyStock;
    @Column(name = "下单安全系数")
    public String orderSafetyFactor;
    @Column(name = "实际总库存系数")
    public String totalInventoryCoefficient;
    @Column(name = "还需下单数量")
    public String furtherOrderQuantityRequired;
    @Column(name = "起订量")
    public String minimumOrderQuantity;
    @Column(name = "阶梯价")
    public String ladderPrice;
    @Column(name = "WF建议下单量")
    public String wfSuggestedOrderQuantity;
    @Column(name = "HD建议下单量")
    public String hdSuggestedOrderQuantity;
    @Column(name = "AMZ建议下单量")
    public String amzSuggestedOrderQuantity;
    @Column(name = "OS建议下单量")
    public String osSuggestedOrderQuantity;
    @Column(name = "全平台建议下单")
    public String suggestPlacingAnOrder;
    @Column(name = "跟单建议下单量")
    public String singleOrderQuantity;
    @Column(name = "审批结果")
    public String approvalResult;
    @Column(name = "下单数量")
    public String orderQuantity;

}