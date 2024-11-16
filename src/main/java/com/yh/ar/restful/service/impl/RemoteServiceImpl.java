package com.yh.ar.restful.service.impl;

import com.yh.ar.business.pojo.ResultData;
import com.yh.ar.business.service.RemoteService;
import com.yh.ar.cache.ProductCache;
import com.yh.ar.export.annotation.ExportAnnotation;
import com.yh.ar.restful.service.HttpClientService;
import com.yh.ar.util.Constants;
import com.yh.ar.util.ResultDataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @ClassName: RemoteServiceImpl
 * @Description: 远程服务调用实现
 * @Author: system
 * @Date: 2024-11-14 23:40
 * @Version: 1.0
 **/
@Service("remoteService")
public class RemoteServiceImpl implements RemoteService {

    @Autowired
    HttpClientService proxyHttpClient;

    @Autowired
    ProductCache productCache;

    /**
     * @Author: system
     * @Description: 查询产品分类
     * @Date: 2024-11-14 23:51:18
     * @Param: params
     * @return: ResultData<List < String>>
     **/
    @Override
    public ResultData<Map<String, Set>> queryProductDictList(Map<String, Object> params) {
        // 产品数据
        List<Map<String, Object>> dataList = productCache.getProductCacheList();
        // 产品分类数据 - erp-接口获取对应二级品类
        Set<String> productTypeSet = new HashSet<>();
        // 产品SPU数据 - erp-接口获取对应产品名称
        Set<String> productSet = new HashSet<>();
        dataList.stream().filter(m -> !Constants.NO_CODE.equals(m.get("product_status"))) // 过滤不可用产品
                .forEach(m -> {
                    productSet.add((String) m.get("product_title"));
                    productTypeSet.add((String) m.get("procut_category_code2"));
                });
        Map<String, Set> dictionary = new HashMap();
        dictionary.put("productSet", productSet);
        dictionary.put("productTypeSet", productTypeSet);
        return ResultDataUtils.success(dictionary);
    }
}