package com.yh.ar.business.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @ClassName: UrgeProductionDetails
 * @Description: 催生产详情
 * @Author: system
 * @Date: 2024-11-02 17:36
 * @Version: 1.0
 **/
@Table(name = "催生产详情")
@Data
public class UrgeProductionDetails {

    @Column(name = "序号")
    public String id;
    @Column(name = "催货批次")
    public String urgentDeliveryBatch;
    @Column(name = "是否二次返单")
    public String isSecondReturnOrder;
    @Column(name = "产品分类")
    public String productType;
    @Column(name = "产品SPU")
    public String product;
    @Column(name = "工厂ID")
    public String factoryId;
    @Column(name = "长(cm)")
    public String longCm;
    @Column(name = "宽(cm)")
    public String wideCm;
    @Column(name = "高(cm)")
    public String highCm;
    @Column(name = "长(inch)")
    public String longInch;
    @Column(name = "宽(inch)")
    public String wideInch;
    @Column(name = "高(inch)")
    public String highInch;
    @Column(name = "工厂总库存")
    public String totalFactoryInventory;
    @Column(name = "全平台销量等级")
    public String salesLevel;
    @Column(name = "全平台利润等级")
    public String profitLevel;
    @Column(name = "CG+海上实际系数")
    public String actualCoefficient;
    @Column(name = "自建仓+海上实际系数")
    public String multipleActualCoefficient;
    @Column(name = "催生产")
    public String urgeProduction;

}