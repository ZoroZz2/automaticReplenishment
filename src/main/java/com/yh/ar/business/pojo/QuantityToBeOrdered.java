package com.yh.ar.business.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @ClassName: QuantityToBeOrdered
 * @Description: 需下单数量
 * @Author: system
 * @Date: 2024-11-04 00:11
 * @Version: 1.0
 **/
@Table(name = "需下单数量")
@Data
public class QuantityToBeOrdered {

    @Column(name = "工厂下单批次")
    public String factoryOrderBatch;
    @Column(name = "工厂ID")
    public String factoryId;
    @Column(name = "产品SPU")
    public String product;
    @Column(name = "是否KD")
    public String isKD;
    @Column(name = "需下单数量")
    public String orderRequired;
    @Column(name = "已下单数量")
    public String orderedQuantity;

}