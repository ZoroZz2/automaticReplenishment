package com.yh.ar.cache;

import com.alibaba.fastjson.JSONObject;
import com.yh.ar.restful.service.HttpClientService;
import com.yh.ar.util.Constants;
import com.yh.ar.util.RedisUtils;
import com.yh.ar.util.enums.InterfaceMethodEnum;
import jakarta.annotation.PostConstruct;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName: ProductCache
 * @Description: 产品信息缓存
 * @Author: system
 * @Date: 2024-11-15 16:15
 * @Version: 1.0
 **/
@Component
public class ProductCache {

    @Value("${redis.key}")
    private String key;

    @Value("${redis.productKey}")
    private String productKey;

    @Value("${redis.value}")
    private String productVal;

    @Value("${redis.expirationTime}")
    private Long expirationTime;

    @Value("${redis.productCache}")
    private String productCache;

    @Autowired
    RedisUtils redisUtils;

    @Autowired
    HttpClientService proxyHttpClient;

    private final Logger logger = LogManager.getLogger(getClass());

    /**
     * @Author: system
     * @Description: 初始化时加载权限缓存
     * @Date: 2024-11-08 00:39:06
     * @Param:
     * @return: void
     **/
    @PostConstruct
    public void loadCache() {
        // 使用redis锁防止重复加载
        boolean existence = redisUtils.existence(productKey, productVal, expirationTime);
        if (existence) {
            try {
                // 缓存信息
                Map cacheMap = new HashMap<>();
                // 接口名称
                String interfaceMethod = InterfaceMethodEnum.GET_WMS_PRODUCT_LIST.getInterfaceMethod();
                // 产品数据-全量数据
                List<Map> dataList = proxyHttpClient.sendPost(Constants.YC_URL, interfaceMethod, new HashMap<>());
                // 预先清除原有的缓存值
                redisUtils.del(productCache);
                // 新增缓存
                redisUtils.lSet(productCache, dataList);
            } catch (Exception e) {
                logger.error("权限缓存加载失败! {}", productCache);
            } finally {
                // 清除redis锁
                redisUtils.del(productKey);
            }
        } else {
            logger.error("获取redis锁失败! {}", productCache);
        }
    }

    /**
     * @Author: system
     * @Description: 获取指定key缓存数据
     * @Date: 2024-11-08 23:55:09
     * @Param: key
     * @return: void
     **/
    public List<Map<String, Object>> getProductCacheList() {
        List<Object> objectList = redisUtils.lGet(productCache, 0, -1);
        if (objectList.size() != 0) {
            List<JSONObject> jsonObjectLIst = (List<JSONObject>) objectList.get(0);
            List<Map<String, Object>> mapList = jsonObjectLIst.stream()
                    .map(obj -> {
                        Map<String, Object> map = new HashMap<>();
                        map.putAll(obj.getInnerMap());
                        return map;
                    })
                    .collect(Collectors.toList());
            return mapList;
        }
        return new ArrayList<>();
    }

}