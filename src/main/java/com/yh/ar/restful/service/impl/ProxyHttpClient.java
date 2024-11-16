package com.yh.ar.restful.service.impl;

import com.yh.ar.restful.service.HttpClientService;
import com.yh.ar.util.Constants;
import com.yh.ar.util.Md5Utils;
import com.yh.ar.util.ParamUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

/**
 * @ClassName: ProxyHttpClient
 * @Description: 代理请求
 * @Author: system
 * @Date: 2024-11-13 16:02
 * @Version: 1.0
 **/
@Service("proxyHttpClient")
public class ProxyHttpClient implements HttpClientService {

    @Autowired
    HttpClient httpClient;

    // 应用key
    private static final String APP_KEY = "ef5e556512774576";
    // 秘钥
    private static final String SECRET_KEY = "addeecf7c5f00f7c";
    // 签名类型
    private static final String SIGN_TYPE = "MD5";
    // 版本号
    private static final String VERSION = "v1.0.0";
    // 编码格式
    private static final String CHARSET = "UTF-8";
    // 服务id
    private static final String SERVICE_ID = "EHUU5M";

    /**
     * @Author: system
     * @Description: 初始化参数信息
     * @Date: 2024-11-13 16:39:06
     * @Param: params
     * @return: void
     **/
    private Map<String, Object> intRequestMap(String interfaceMethod, Map<String, Object> params) {
        Map<String, Object> requestMap = new LinkedHashMap();
        requestMap.put("app_key", APP_KEY);
        requestMap.put("biz_content", params.toString());
        requestMap.put("charset", CHARSET);
        requestMap.put("interface_method", interfaceMethod);
        requestMap.put("nonce_str", ParamUtils.generateByShuffle());
        requestMap.put("service_id", SERVICE_ID);
        requestMap.put("sign_type", SIGN_TYPE);
        requestMap.put("timestamp", String.valueOf(System.currentTimeMillis()));
        requestMap.put("version", VERSION);
        return requestMap;
    }

    @Override
    public List<Map> sendPost(String url, String interfaceMethod, Map<String, Object> params) throws IOException {
        // 初始化请求参数信息
        Map<String, Object> requestMap = intRequestMap(interfaceMethod, params);

        // 更改参数加密规则
        String mapAsString = requestMap.entrySet().stream()
                .map(entry -> entry.getKey() + "=" + entry.getValue())
                .reduce((s1, s2) -> s1 + "&" + s2)
                .orElse("");

        String encryption = Md5Utils.encryption(mapAsString, SECRET_KEY);
        requestMap.put("sign", encryption);
        return httpClient.sendPost(Constants.YC_URL, interfaceMethod, requestMap);
    }

    @Override
    public String sendGet(String url, String interfaceMethod) throws IOException {
        return null;
    }
}