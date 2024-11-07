package com.yh.ar.business.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @ClassName: urgeShipmentDetails
 * @Description: 催发货详情
 * @Author: system
 * @Date: 2024-11-02 17:41
 * @Version: 1.0
 **/
@Table(name = "催发货详情")
@Data
public class UrgeShipmentDetails extends UrgeProductionDetails {

    @Column(name = "'CG_美国催发货'")
    public String urgesShipmentUs;
    @Column(name = "'CG_加拿大催发货'")
    public String urgesShipmentCanada;
    @Column(name = "'自建仓催发货'")
    public String urgesShipmentCustom;
}