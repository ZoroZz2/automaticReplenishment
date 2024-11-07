package com.yh.ar.business.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @ClassName: TemplateDetails
 * @Description: 模板详情
 * @Author: system
 * @Date: 2024-11-03 17:58
 * @Version: 1.0
 **/
@Table(name = "数据报表-模板管理")
@Data
public class TemplateDetails {

    @Column(name = "模板序号")
    public String templateId;

    @Column(name = "产品分类")
    public String productType;
    @Column(name = "WF分类")
    public String wfType;
    @Column(name = "产品SPU")
    public String product;

    @Column(name = "AMZ近7天销售")
    public String sevenDaySalesAmz;
    @Column(name = "AMZ近14天销售")
    public String fourteenDaySalesAmz;
    @Column(name = "AMZ3月销售")
    public String marchSalesAmz;

    @Column(name = "AMZ预估月销")
    public String monthlySalesAmz;
    @Column(name = "WF预估月销")
    public String monthlySalesWf;
    @Column(name = "全平台预估月销")
    public String monthlySalesPlatforms;

    @Column(name = "工厂库存")
    public String factoryInventory;
    @Column(name = "FBA库存")
    public String inventoryFba;

}