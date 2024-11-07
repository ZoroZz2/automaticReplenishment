package com.yh.ar.export.controller;

import com.yh.ar.business.pojo.ResultData;
import com.yh.ar.export.service.ExportService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

/**
 * @ClassName: ExportController
 * @Description: 导出公共处理
 * @Author: system
 * @Date: 2024-10-29 16:00
 * @Version: 1.0
 **/
@RestController
@RequestMapping("/api/export")
public class ExportController {

    @Autowired
    ExportService exportService;

    /**
     * @Author: system
     * @Description: 模板导出
     * @Date: 2024-10-29 16:24:39
     * @Param: menuId
     * @Param: response
     * @return: void
     **/
    @GetMapping("/template")
    public ResultData<String> downloadTemplate(String menuId, HttpServletResponse response) throws IOException {
        return exportService.downloadTemplate(menuId, response);
    }

    /**
     * @Author: system
     * @Description: 数据导出
     * @Date: 2024-10-29 16:15:00
     * @Param: response
     * @return: void
     **/
    @GetMapping("/data")
    public ResultData<String> exportData(@RequestParam Map<String, Object> params, HttpServletResponse response) throws IOException {
        return exportService.exportData(params, response);
    }

}