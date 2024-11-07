package com.yh.ar.export.service.impl;

import ch.qos.logback.core.util.StringUtil;
import com.alibaba.fastjson.JSON;
import com.yh.ar.business.pojo.PurchaseOrder;
import com.yh.ar.business.pojo.ResultData;
import com.yh.ar.export.annotation.CodeParsing;
import com.yh.ar.export.service.ExportService;
import com.yh.ar.util.ExportUtils;
import com.yh.ar.util.ResultDataUtils;
import com.yh.ar.util.enums.MenuMethodEnum;
import com.yh.ar.util.page.PageResult;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName: ExportServiceImpl
 * @Description: 导出逻辑处理
 * @Author: system
 * @Date: 2024-10-29 16:06
 * @Version: 1.0
 **/
@Service("exportService")
public class ExportServiceImpl implements ExportService {

    @Autowired
    CodeParsing codeParsing;

    /**
     * @Author: system
     * @Description: 下载模版
     * @Date: 2024-10-29 16:29:51
     * @Param: menuId
     * @Param: response
     * @return: ResultData<String>
     **/
    @Override
    public ResultData<String> downloadTemplate(String menuId, HttpServletResponse response) throws IOException {
        if (StringUtil.isNullOrEmpty(menuId)) {
            return ResultDataUtils.fail("模板下载失败:请求参数[menuId]不能为空!");
        }
        // 获取实体模板下载菜单类
        Class<?> exportEntity = MenuMethodEnum.getClazzByMenuId(menuId);
        // 调用接口，并传入空数据，在导出已经做出判断
        ExportUtils.exportData(response, null, exportEntity);
        return ResultDataUtils.success("模板导出成功");
    }

    /**
     * @Author: system
     * @Description: 导出数据
     * @Date: 2024-10-29 16:30:07
     * @Param: params
     * @Param: response
     * @return: ResultData<String>
     **/
    @Override
    public ResultData<String> exportData(Map<String, Object> params, HttpServletResponse response) throws IOException {
        // 菜单id
        String menuId = (String) params.get("menuId");
        if (StringUtil.isNullOrEmpty(menuId)) {
            return ResultDataUtils.fail("数据导出失败:请求参数[menuId]不能为空!");
        }
        // 数据库获取数据
        ResultData<PageResult> resultData = codeParsing.queryDataList(menuId, params);
        List<Map<String, Object>> dataList = resultData.getData().getDataList();
        // 获取实体模板下载菜单类
        Class<?> exportEntity = MenuMethodEnum.getClazzByMenuId(menuId);
        // 数据导出
        ExportUtils.exportData(response, dataList, exportEntity);

        return ResultDataUtils.success("数据导出成功");
    }
}