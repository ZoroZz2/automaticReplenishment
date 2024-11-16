package com.yh.ar.cache;

import com.yh.ar.business.pojo.ResultData;
import com.yh.ar.util.ResultDataUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ClassName: CacheController
 * @Description: 缓存控制器
 * @Author: system
 * @Date: 2024-11-15 18:30
 * @Version: 1.0
 **/
@RestController
@RequestMapping("/api/cache")
public class CacheController {

    @Value("${redis.paramCache}")
    private String paramCacheKey;

    @Value("${redis.permissionCache}")
    private String permissionCacheKey;

    @Value("${redis.productCache}")
    private String productCacheKey;

    // 产品管理缓存
    @Autowired
    ParamManagementCache paramManagementCache;
    // 账户权限缓存
    @Autowired
    PermissionCache permissionCache;
    // 产品信息缓存
    @Autowired
    ProductCache productCache;

    @GetMapping("/refreshCache")
    public ResultData<String> refreshCache(@RequestParam Map<String, Object> params) {
        String cacheKey = (String) params.get("cacheKey");
        if (StringUtils.isEmpty(cacheKey)) { // 为空则刷新所有缓存
            new Thread(new Runnable() {
                @Override
                public void run() {
                    permissionCache.loadCache();
                    paramManagementCache.loadCache();
                    productCache.loadCache();
                }
            }).start();
        } else {
            if (permissionCacheKey.equals(cacheKey)) {
                permissionCache.loadCache();
            } else if (paramCacheKey.equals(cacheKey)) {
                paramManagementCache.loadCache();
            } else if (productCacheKey.equals(cacheKey)) {
                productCache.loadCache();
            } else {
                return ResultDataUtils.success("刷新缓存数据失败！cacheKey值错误: " + cacheKey);
            }
        }
        return ResultDataUtils.success("刷新缓存数据成功");
    }

}