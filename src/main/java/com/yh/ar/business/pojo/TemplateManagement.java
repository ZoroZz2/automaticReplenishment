package com.yh.ar.business.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @ClassName: Template
 * @Description: 模板管理
 * @Author: system
 * @Date: 2024-10-31 20:46
 * @Version: 1.0
 **/
@Table(name = "数据报表-模板管理")
@Data
public class TemplateManagement {

    @Column(name = "模板序号")
    public String templateId;
    @Column(name = "模板名称")
    public String templateName;
    @Column(name = "创建日期")
    public String createdTime;

}