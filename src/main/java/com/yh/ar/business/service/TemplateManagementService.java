package com.yh.ar.business.service;

import com.yh.ar.business.pojo.ResultData;
import com.yh.ar.business.pojo.TemplateManagement;
import com.yh.ar.util.page.PageResult;

import java.util.Map;

/**
 * @InterfaceName: TemplateManagementService
 * @Description: 模板管理
 * @Author: system
 * @Date: 2024-10-31 20:40
 * @Version: 1.0
 **/
public interface TemplateManagementService {

    ResultData<PageResult> queryTemplateManagementList(Map<String, Object> params);
    ResultData<PageResult> queryTemplateDetailsList(Map<String, Object> params);
    ResultData<String> delTemplateManagement(TemplateManagement template);

}