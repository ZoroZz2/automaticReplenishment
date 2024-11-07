package com.yh.ar.business.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @ClassName: DataSupplementDelivery
 * @Description: 数据补充-CG发货占比
 * @Author: system
 * @Date: 2024-10-31 18:09
 * @Version: 1.0
 **/
@Table(name = "数据补充-CG发货占比")
@Data
public class DataSupplementDelivery {

    @Column(name = "序号")
    public String id;
    @Column(name = "CG近6个月发货占比")
    public String cgDeliveryRatioSix;
    @Column(name = "CG近3个月发货占比")
    public String cgDeliveryRatioThree;
    @Column(name = "CG近3个月最大发货占比")
    public String cgDeliveryRatioMaxThree;
    @Column(name = "近3个月加拿大占CG总量比例")
    public String cgDeliveryRatioCanadaThree;
    @Column(name = "WF风险标记")
    public String wfRiskMarker;
    @Column(name = "系统建议CG发货占比")
    public String proposalCgDeliveryRatio;
    @Column(name = "更新日期")
    public String updateTime;

}