package com.yh.ar.business.service.impl;

import com.yh.ar.business.mapper.UpdateDataMapper;
import com.yh.ar.business.pojo.ResultData;
import com.yh.ar.business.pojo.TemplateManagement;
import com.yh.ar.business.service.TemplateManagementService;
import com.yh.ar.export.annotation.ExportAnnotation;
import com.yh.ar.util.ParamUtils;
import com.yh.ar.util.ResultDataUtils;
import com.yh.ar.util.page.PageResult;
import com.yh.ar.util.page.SelectDataAtom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @ClassName: TemplateManagementServiceImpl
 * @Description: 模板管理逻辑处理
 * @Author: system
 * @Date: 2024-10-31 20:41
 * @Version: 1.0
 **/
@Service("templateManagementService")
public class TemplateManagementServiceImpl implements TemplateManagementService {

    @Autowired
    UpdateDataMapper updateDataMapper;

    /**
     * @Author: system
     * @Description: 查询模板管理数据
     * @Date: 2024-10-31 20:42:27
     * @Param: params
     * @return: ResultData<PageResult>
     **/
    @Override
    public ResultData<PageResult> queryTemplateManagementList(Map<String, Object> params) {
        PageResult pageResult = SelectDataAtom.selectDataList("queryTemplateManagementList", params);
        return ResultDataUtils.success(pageResult);
    }

    /**
     * @Author: system
     * @Description: 查询模板详情数据
     * @Date: 2024-11-03 17:54:28
     * @Param: params
     * @return: ResultData<PageResult>
     **/
    @Override
    @ExportAnnotation(menuId = "templateDetails")
    public ResultData<PageResult> queryTemplateDetailsList(Map<String, Object> params) {
        PageResult pageResult = SelectDataAtom.selectDataList("queryTemplateDetailsList", params);
        return ResultDataUtils.success(pageResult);
    }

    /**
     * @Author: system
     * @Description: 删除模板
     * @Date: 2024-10-31 21:59:10
     * @Param: template
     * @return: ResultData<String>
     **/
    @Override
    public ResultData<String> delTemplateManagement(TemplateManagement template) {
        String roleId = template.getTemplateId();
        if (!ParamUtils.isNullOrEmpty(roleId)) {
            return ResultDataUtils.fail("删除失败:请求参数[template]不能为空!");
        }

        try {
            updateDataMapper.delTemplateManagement(template);
        } catch (Exception e) {
            return ResultDataUtils.fail("删除失败:请联系工作人员!");
        }

        return ResultDataUtils.success("删除成功");
    }
}