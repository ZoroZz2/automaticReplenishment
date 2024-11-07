package com.yh.ar.business.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @ClassName: DataSupplementFactory
 * @Description: 数据补充-工厂数据
 * @Author: system
 * @Date: 2024-10-31 18:08
 * @Version: 1.0
 **/
@Table(name = "数据补充-工厂数据")
@Data
public class DataSupplementFactory {

    @Column(name = "序号")
    public String id;
    @Column(name = "产品SPU")
    public String product;
    @Column(name = "是否KD")
    public String isKD;
    @Column(name = "工厂ID")
    public String factoryId;
    @Column(name = "工厂名称")
    public String factoryName;
    @Column(name = "生产时长")
    public String productionDuration;
    @Column(name = "起订量")
    public String minimumOrderQuantity;
    @Column(name = "阶梯价")
    public String ladderPrice;
    @Column(name = "更新日期")
    public String updateTime;

}