package com.yh.ar.business.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @ClassName: PurchaseOrder
 * @Description: 采购下单实体类
 * @Author: system
 * @Date: 2024-10-29 15:38
 * @Version: 1.0
 **/


@Table(name = "采购下单")
@Data
public class PurchaseOrder {

    @Column(name = "序号")
    public String id;
    @Column(name = "下单批次")
    public String orderBatch;
    @Column(name = "工厂下单批次")
    public String factoryOrderBatch;
    @Column(name = "工厂ID")
    public String factoryId;
    @Column(name = "需下单数量")
    public String orderRequired;
    @Column(name = "已下单数量")
    public String orderedQuantity;
    @Column(name = "下单状态")
    public String orderStatus;

}