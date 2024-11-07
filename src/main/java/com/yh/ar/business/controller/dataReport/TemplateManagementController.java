package com.yh.ar.business.controller.dataReport;

import com.yh.ar.business.pojo.ResultData;
import com.yh.ar.business.pojo.TemplateManagement;
import com.yh.ar.business.service.TemplateManagementService;
import com.yh.ar.util.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ClassName: TemplateManagementController
 * @Description: 模板管理
 * @Author: system
 * @Date: 2024-10-25 17:38
 * @Version: 1.0
 **/
@RestController
@RequestMapping("/api/dataReport")
public class TemplateManagementController {

    @Autowired
    TemplateManagementService templateManagementService;

    /**
     * @Author: system
     * @Description: 查询模板管理
     * @Date: 2024-10-29 19:22:38
     * @Param: params
     * @return: ResultData<List < Map>>
     **/
    @RequestMapping(value = "/queryTemplateManagementList", method = RequestMethod.POST)
    public ResultData<PageResult> queryTemplateManagementList(@RequestParam Map<String, Object> params) {
        return templateManagementService.queryTemplateManagementList(params);
    }

    /**
     * @Author: system
     * @Description: 查询模板详情数据
     * @Date: 2024-11-03 17:55:14
     * @Param: params
     * @return: ResultData<PageResult>
     **/
    @RequestMapping(value = "/queryTemplateDetailsList", method = RequestMethod.POST)
    public ResultData<PageResult> queryTemplateDetailsList(@RequestParam Map<String, Object> params) {
        return templateManagementService.queryTemplateDetailsList(params);
    }

    /**
     * @Author: system
     * @Description: 删除模板
     * @Date: 2024-10-29 19:22:38
     * @Param: params
     * @return: ResultData<List < Map>>
     **/
    @RequestMapping(value = "/delTemplateManagement", method = RequestMethod.POST)
    public ResultData<String> delTemplateManagement(TemplateManagement template) {
        return templateManagementService.delTemplateManagement(template);
    }

}
