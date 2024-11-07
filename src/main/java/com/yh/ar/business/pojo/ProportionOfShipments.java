package com.yh.ar.business.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @ClassName: proportionOfShipments
 * @Description: CG发货占比
 * @Author: system
 * @Date: 2024-11-01 23:57
 * @Version: 1.0
 **/
@Table(name = "CG发货占比")
@Data
public class ProportionOfShipments {

    @Column(name = "序号")
    public String id;
    @Column(name = "产品分类")
    public String productType;
    @Column(name = "产品SPU")
    public String product;
    @Column(name = "是否首次返单")
    public String isFirstOrder;
    @Column(name = "是否砍线")
    public String isCut;
    @Column(name = "新品标签")
    public String newProductLabel;
    @Column(name = "是否有下架风险")
    public String isRiskOfDelisting;
    @Column(name = "WF预估月销")
    public String wfEstimatedMonthlySales;
    @Column(name = "CG近6个月发货占比")
    public String cgDeliveryRatioSix;
    @Column(name = "CG近3个月最大发货占比")
    public String cgDeliveryRatioMaxThree;
    @Column(name = "系统建议CG发货占比")
    public String proposalCgDeliveryRatio;
    @Column(name = "运营建议CG发货占比")
    public String operateDeliveryRatio;
    @Column(name = "系统建议加拿大CG发货占比")
    public String sysCanadaDeliveryRatio;
    @Column(name = "最终CG发货占比")
    public String finalDeliveryRatio;
    @Column(name = "近3个月加拿大占CG总量比例")
    public String cgDeliveryRatioCanadaThree;
    @Column(name = "运营建议加拿大CG发货占比")
    public String operateCanadaDeliveryRatio;
    @Column(name = "更新时间")
    public String updateTime;

}