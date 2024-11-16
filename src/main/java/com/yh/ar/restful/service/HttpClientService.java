package com.yh.ar.restful.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: HttpClientService
 * @Description: 请求服务
 * @Author: system
 * @Date: 2024-11-13 15:55
 * @Version: 1.0
 **/
public interface HttpClientService {

    List<Map> sendPost(String url, String interfaceMethod, Map<String, Object> map) throws IOException;

    String sendGet(String url, String interfaceMethod) throws IOException;
}