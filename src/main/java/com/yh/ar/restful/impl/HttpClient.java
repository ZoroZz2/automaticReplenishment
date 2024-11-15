package com.yh.ar.restful.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.TypeReference;
import com.yh.ar.restful.HttpClientService;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.SocketConfig;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: HttpClient
 * @Description: 请求
 * @Author: system
 * @Date: 2024-11-12 21:29
 * @Version: 1.0
 **/
@Service("httpClient")
public class HttpClient implements HttpClientService {

    private static final Logger logger = LogManager.getLogger(HttpClient.class);

    /**
     * @Author: system
     * @Description: post请求
     * @Date: 2024-11-14 17:37:21
     * @Param: url
     * @Param: interfaceMethod
     * @Param: map
     * @return: String
     **/
    @Override
    public List<Map> sendPost(String url, String interfaceMethod, Map<String, Object> params) throws IOException {
        String result = "";
        // 创建连接管理器
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        // 设置总连接数
        cm.setMaxTotal(200);
        // 设置每个主机的最大连接数
        cm.setDefaultMaxPerRoute(20);

        // 为特定路由设置最大连接数，以防止连接泄露
        // cm.setMaxPerRoute(new HttpRoute(new HttpHost("localhost", 80)), 20);

        // 配置请求信息
        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(1000) // 连接超时时间
                .setSocketTimeout(2000)  // 请求超时时间
                .setConnectionRequestTimeout(500) // 获取连接超时时间
                .build();

        // 创建CloseableHttpClient实例，使用自定义配置
        CloseableHttpClient httpClient = HttpClients.custom()
                .setConnectionManager(cm)
                .setDefaultRequestConfig(config)
                .build();
        // CloseableHttpClient httpClient = HttpClients.createDefault();
        // 创建post方式请求对象
        HttpPost httpPost = new HttpPost(url);
        // 装填参数
        StringEntity entity = new StringEntity(JSON.toJSONString(params));
        httpPost.setEntity(entity);
        httpPost.setHeader("Content-Type", "application/json");

        // 执行请求操作，并拿到结果（同步阻塞）
        CloseableHttpResponse response = null;
        try {
            // 执行请求
            response = httpClient.execute(httpPost);
            // 获取结果实体
            // 判断网络连接状态码是否正常(0--200都数正常)
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                result = EntityUtils.toString(response.getEntity(), "utf-8");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 释放链接
            response.close();
        }

        List<Map> dataList = new ArrayList<>();
        try {
            // 接口公共返回数据
            Map<String, Object> resultMap = JSON.parseObject(result, new TypeReference<>() {
            });
            // 业务数据信息
            String bizContent = (String) resultMap.get("biz_content");
            Map<String, Object> bizContentMap = JSON.parseObject(bizContent, new TypeReference<>() {
            });
            // 业务数据
            JSONArray dataArray = (JSONArray) bizContentMap.get("data");
            dataList = dataArray.toJavaList(Map.class);
        } catch (Exception e) {
            logger.error("{}接口返回数据转换失败！", interfaceMethod);
            e.printStackTrace();
        }

        return dataList;
    }

    /**
     * get请求传输数据
     *
     * @param url
     * @param interfaceMethod
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     */
    @Override
    public String sendGet(String url, String interfaceMethod) throws ClientProtocolException, IOException {
        String result = "";

        // 创建httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        // 创建get方式请求对象
        HttpGet httpGet = new HttpGet(url);
        httpGet.addHeader("Content-type", "application/json");
        // 通过请求对象获取响应对象
        CloseableHttpResponse response = httpClient.execute(httpGet);

        // 获取结果实体
        // 判断网络连接状态码是否正常(0--200都数正常)
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            result = EntityUtils.toString(response.getEntity(), "utf-8");
        }
        // 释放链接
        response.close();

        return result;
    }

}