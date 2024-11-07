package com.yh.ar.export.controller;

import com.yh.ar.business.pojo.ResultData;
import com.yh.ar.export.service.ExportService;
import com.yh.ar.export.service.ImportService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @ClassName: ImportController
 * @Description: 导入公共处理
 * @Author: system
 * @Date: 2024-10-29 16:02
 * @Version: 1.0
 **/
@RestController
@RequestMapping("/api/import")
public class ImportController {

    @Autowired
    ImportService importService;

    /**
     * @Author: system
     * @Description: 模板导出
     * @Date: 2024-10-29 16:24:39
     * @Param: menuId
     * @Param: response
     * @return: void
     **/
    @GetMapping("/data")
    public ResultData<String> importData(String menuId, @RequestParam("file") MultipartFile file) throws Exception {
        return importService.importData(menuId, file);
    }

}