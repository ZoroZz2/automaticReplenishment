package com.yh.ar.export.service.impl;

import com.yh.ar.business.pojo.PurchaseOrder;
import com.yh.ar.business.pojo.ResultData;
import com.yh.ar.export.service.ImportService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.yh.ar.util.ImportUtils;

import java.util.List;

/**
 * @ClassName: ImportServiceImpl
 * @Description: 导入逻辑处理
 * @Author: system
 * @Date: 2024-10-29 16:04
 * @Version: 1.0
 **/
@Service("importService")
public class ImportServiceImpl implements ImportService {
    /**
     * @Author: system
     * @Description: 数据导入
     * @Date: 2024-10-30 22:32:07
     * @Param: menuId
     * @Param: file
     * @return: ResultData<String>
     **/
    // TODO:导入功能待商议
    @Override
    public ResultData<String> importData(String menuId, MultipartFile file) throws Exception {
        // 调用ImportUtil工具类来获取实体对象列表
        List<PurchaseOrder> entities = ImportUtils.importData(file, PurchaseOrder.class);
        // 在这里处理导入数据的逻辑
        for (PurchaseOrder entity : entities) {
            break;
        }
        return null;
    }
}