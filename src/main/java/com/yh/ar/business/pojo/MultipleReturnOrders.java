package com.yh.ar.business.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @ClassName: MultipleReturnOrders
 * @Description: 2次以上返单
 * @Author: system
 * @Date: 2024-11-01 23:35
 * @Version: 1.0
 **/
@Table(name = "2次以上返单")
@Data
public class MultipleReturnOrders {

    @Column(name = "序号")
    public String id;
    @Column(name = "平台id")
    public String platformId;
    @Column(name = "平台名称")
    public String platformName;
    @Column(name = "产品分类")
    public String productType;
    @Column(name = "产品SPU")
    public String product;
    @Column(name = "是否砍线")
    public String isCut;
    @Column(name = "总库存")
    public String totalInventory;
    @Column(name = "最近第一月销量")
    public String recentSalesOneMonth;
    @Column(name = "最近第二月销量")
    public String recentSalesTwoMonth;
    @Column(name = "最近第三月销量")
    public String recentSalesThreeMonth;
    @Column(name = "最近第四月销量")
    public String recentSalesFourMonth;
    @Column(name = "最近14天销量")
    public String recentSalesFourteenDays;
    @Column(name = "最近7天销量")
    public String recentSalesSevenDays;
    @Column(name = "销量走势")
    public String salesTrend;
    @Column(name = "建议预估范围")
    public String estimatedScope;
    @Column(name = "未来第一月销量")
    public String futureSalesOneMonth;
    @Column(name = "未来第二月销量")
    public String futureSalesTwoMonth;
    @Column(name = "未来第三月销量")
    public String futureSalesThreeMonth;
    @Column(name = "未来第四月销量")
    public String futureSalesFourMonth;
    @Column(name = "未来第五月销量")
    public String futureSalesFiveMonth;
    @Column(name = "未来第六月销量")
    public String futureSalesSixMonth;
    @Column(name = "未来第七月销量")
    public String futureSalesSevenMonth;
    @Column(name = "未来第八月销量")
    public String futureSalesEightMonth;
    @Column(name = "更新时间")
    public String updateTime;

}