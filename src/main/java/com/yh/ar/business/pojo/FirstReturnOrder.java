package com.yh.ar.business.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @ClassName: firstReturnOrder
 * @Description: 首次返单
 * @Author: system
 * @Date: 2024-11-01 23:53
 * @Version: 1.0
 **/
@Table(name = "首次返单")
@Data
public class FirstReturnOrder {

    @Column(name = "序号")
    public String id;
    @Column(name = "平台id")
    public String platformId;
    @Column(name = "平台名称")
    public String platformName;
    @Column(name = "产品SPU")
    public String product;
    @Column(name = "产品分类")
    public String productType;
    @Column(name = "最近第一月销量")
    public String recentSalesOneMonth;
    @Column(name = "最近第二月销量")
    public String recentSalesTwoMonth;
    @Column(name = "最近第三月销量")
    public String recentSalesThreeMonth;
    @Column(name = "最近第四月销量")
    public String recentSalesFourMonth;
    @Column(name = "总库存")
    public String totalInventory;
    @Column(name = "预估下单")
    public String estimatedOrderPlacement;
    @Column(name = "备注")
    public String remark;

}