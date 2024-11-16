package com.yh.ar.export.service.impl;

import com.yh.ar.business.pojo.ResultData;
import com.yh.ar.export.annotation.CodeParsing;
import com.yh.ar.export.service.ImportService;
import com.yh.ar.util.ImportUtils;
import com.yh.ar.util.ResultDataUtils;
import com.yh.ar.util.enums.MenuMethodEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: ImportServiceImpl
 * @Description: 导入逻辑处理
 * @Author: system
 * @Date: 2024-10-29 16:04
 * @Version: 1.0
 **/
@Service("importService")
public class ImportServiceImpl implements ImportService {

    @Autowired
    CodeParsing codeParsing;

    /**
     * @Author: system
     * @Description: 数据导入
     * @Date: 2024-10-30 22:32:07
     * @Param: menuId
     * @Param: file
     * @return: ResultData<String>
     **/
    @Override
    public ResultData<String> importData(String menuId, MultipartFile file) throws Exception {
        // 获取导入数据实体类
        Class<?> exportEntity = MenuMethodEnum.getClazzByMenuId(menuId);
        // 调用ImportUtil工具类来获取导入数据列表
        List<?> objectList = ImportUtils.importData(file, exportEntity);
        // 组装新增数据格式
        Map<String, Object> insertMap = new HashMap<>();
        insertMap.put("operateList", objectList);
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 异步执行数据导入
                codeParsing.insertData(menuId, insertMap);
            }
        }).start();
        return ResultDataUtils.success("数据导入成功");
    }
}