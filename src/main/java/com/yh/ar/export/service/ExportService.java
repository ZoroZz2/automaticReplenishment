package com.yh.ar.export.service;

import com.yh.ar.business.pojo.ResultData;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

/**
 * @InterfaceName: ExportService
 * @Description: 导出
 * @Author: system
 * @Date: 2024-10-29 16:02
 * @Version: 1.0
 **/
public interface ExportService {

    ResultData<String> downloadTemplate(String menuId, HttpServletResponse response) throws IOException;

    ResultData<String> exportData(Map<String, Object> params, HttpServletResponse response) throws IOException;

}