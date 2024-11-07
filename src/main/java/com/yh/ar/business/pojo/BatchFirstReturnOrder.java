package com.yh.ar.business.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @ClassName: BatchFirstReturnOrder
 * @Description: 下单批次-首次返单
 * @Author: system
 * @Date: 2024-11-07 01:08
 * @Version: 1.0
 **/
@Table(name = "下单批次-首次返单")
@Data
public class BatchFirstReturnOrder {

    @Column(name = "序号")
    public String id;
    @Column(name = "下单批次")
    public String orderBatch;
    @Column(name = "产品分类")
    public String productType;
    @Column(name = "产品SPU")
    public String product;
    @Column(name = "是否KD")
    public String isKD;
    @Column(name = "新品标签")
    public String newProductLabel;
    @Column(name = "最近第一月销量")
    public String recentSalesOneMonth;
    @Column(name = "最近第二月销量")
    public String recentSalesTwoMonth;
    @Column(name = "最近第三月销量")
    public String recentSalesThreeMonth;
    @Column(name = "最近第四月销量")
    public String recentSalesFourMonth;
    @Column(name = "最近14天销量")
    public String recentSalesFourteenDays;
    @Column(name = "最近7天销量")
    public String recentSalesSevenDays;
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