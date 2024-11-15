package com.yh.ar.business.service.impl;

import com.yh.ar.business.pojo.ResultData;
import com.yh.ar.business.service.RemoteService;
import com.yh.ar.restful.HttpClientService;
import com.yh.ar.util.Constants;
import com.yh.ar.util.enums.InterfaceMethodEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    /**
     * @Author: system
     * @Description: 查询产品分类
     * @Date: 2024-11-14 23:51:18
     * @Param: params
     * @return: ResultData<List < String>>
     **/
    @Override
    public ResultData<List<String>> queryProductTypeList(Map<String, Object> params) throws IOException {
        // 接口名称
        String interfaceMethod = InterfaceMethodEnum.GET_WMS_PRODUCT_LIST.getInterfaceMethod();
        // 产品数据
        List<Map> dataList = proxyHttpClient.sendPost(Constants.YC_URL, interfaceMethod, params);
        // 产品分类数据 - erp-接口获取对应二级品类
        Set<String> productTypeSet = new HashSet<>();
        // 产品SPU数据 - erp-接口获取对应产品名称

        return null;
    }
}