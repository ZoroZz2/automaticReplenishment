package com.yh.ar.business.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @ClassName: DataSupplementProduct
 * @Description: 数据补充-产品标签
 * @Author: system
 * @Date: 2024-10-31 18:07
 * @Version: 1.0
 **/
@Table(name = "数据补充-产品标签")
@Data
public class DataSupplementProduct {

    @Column(name = "序号")
    public String id;
    @Column(name = "产品SPU")
    public String product;
    @Column(name = "WF分类")
    public String wfType;
    @Column(name = "WF_SKU")
    public String wfSku;
    @Column(name = "亚马逊ASIN")
    public String amazonAsin;
    @Column(name = "全平台利润等级")
    public String profitLevel;
    @Column(name = "WF上架日期")
    public String wfListingDate;
    @Column(name = "HD上架日期")
    public String hdListingDate;
    @Column(name = "AMZ上架日期")
    public String amzListingDate;
    @Column(name = "OS上架日期")
    public String osListingDate;
    @Column(name = "更新日期")
    public String updateTime;

}