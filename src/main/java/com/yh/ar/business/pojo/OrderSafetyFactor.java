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
@Table(name = "高风险产品下单安全系数")
@Data
public class OrderSafetyFactor {

    @Column(name = "高风险产品下单安全系数")
    public String orderSafetyFactor;
    @Column(name = "更新时间")
    public String updateTime;

}