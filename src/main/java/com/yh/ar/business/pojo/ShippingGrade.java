package com.yh.ar.business.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @ClassName: shippingGrade
 * @Description: 发货等级
 * @Author: system
 * @Date: 2024-11-01 00:11
 * @Version: 1.0
 **/
@Table(name = "发货等级")
@Data
public class ShippingGrade {

    @Column(name = "全平台利润&全平台销量&其他平台销量等级")
    public String ratingResults;
    @Column(name = "发货等级")
    public String shippingGrade;
    @Column(name = "更新时间")
    public String updateTime;

}