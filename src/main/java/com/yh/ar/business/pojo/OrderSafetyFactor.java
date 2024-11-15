package com.yh.ar.business.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @ClassName: orderSafetyFactor
 * @Description: 高风险产品下单安全系数
 * @Author: system
 * @Date: 2024-11-01 00:19
 * @Version: 1.0
 **/
@Table(name = "风险系数")
@Data
public class OrderSafetyFactor {

    @Column(name = "id")
    public String id;
    @Column(name = "系数")
    public String coefficient;
    @Column(name = "内部高风险")
    public String internalHighRisk;
    @Column(name = "邮件高风险")
    public String emailHighRisk;
    @Column(name = "已停售")
    public String soldOut;
    @Column(name = "风险未完全解除")
    public String riskNotResolved;
    @Column(name = "更新时间")
    public String updateTime;

}