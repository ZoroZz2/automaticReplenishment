package com.yh.ar.export.service;

import com.yh.ar.business.pojo.ResultData;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * @InterfaceName: ImportService
 * @Description: 导入
 * @Author: system
 * @Date: 2024-10-29 16:03
 * @Version: 1.0
 **/
public interface ImportService {

    ResultData<String> importData(String menuId, MultipartFile file) throws Exception;

}