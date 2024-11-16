package com.yh.ar.cache;

import com.yh.ar.account.mapper.AccountMapper;
import com.yh.ar.util.RedisUtils;
import com.yh.ar.util.enums.MenuMethodEnum;
import jakarta.annotation.PostConstruct;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @ClassName: PermissionCache
 * @Description: 权限缓存
 * @Author: system
 * @Date: 2024-11-08 00:19
 * @Version: 1.0
 **/
@Component
public class PermissionCache {

    @Value("${redis.key}")
    private String key;

    @Value("${redis.permissionKey}")
    private String permissionKey;

    @Value("${redis.value}")
    private String permissionVal;

    @Value("${redis.expirationTime}")
    private Long expirationTime;

    @Value("${redis.permissionCache}")
    private String permissionCache;

    @Autowired
    RedisUtils redisUtils;

    @Autowired
    AccountMapper accountMapper;

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
        boolean existence = redisUtils.existence(permissionKey, permissionVal, expirationTime);
        if (existence) {
            try {
                // 缓存信息
                Map cacheMap = new HashMap<>();
                String salesForecast = MenuMethodEnum.SALES_FORECAST.getMenuId();
                String proportionOfShipments = MenuMethodEnum.PROPORTION_OF_SHIPMENTS.getMenuId();
                String orderBatch = MenuMethodEnum.ORDER_BATCH.getMenuId();
                String orderApproval = MenuMethodEnum.ORDER_APPROVAL.getMenuId();
                String purchaseOrder = MenuMethodEnum.PURCHASE_ORDER.getMenuId();
                String urgentDeliveryBatch = MenuMethodEnum.URGENT_DELIVERY_BATCH.getMenuId();
                String paramManagement = MenuMethodEnum.PARAM_MANAGEMENT.getMenuId();
                String dataSupplement = MenuMethodEnum.DATA_SUPPLEMENT.getMenuId();
                String dataReport = MenuMethodEnum.DATA_REPORT.getMenuId();
                String roleManagement = MenuMethodEnum.ROLE_MANAGEMENT.getMenuId();
                String accountManagement = MenuMethodEnum.ACCOUNT_MANAGEMENT.getMenuId();
                // 权限信息
                List<Map> permissionList = accountMapper.queryPermissionInfoList(new HashMap<>());
                permissionList.stream().forEach(m -> {
                    // 账户名
                    String account = String.valueOf(m.get("account"));
                    // 权限信息
                    Map permissionMap = new LinkedHashMap();
                    // 角色id
                    permissionMap.put("roleId", m.get("roleId"));
                    // 角色名称
                    permissionMap.put("roleName", m.get("roleName"));
                    // 产品分类
                    permissionMap.put("productType", m.get("productType"));

                    // 销量预测
                    permissionMap.put(salesForecast, Arrays.asList(String.valueOf(m.get(salesForecast)).split(",")));
                    // CG发货占比
                    permissionMap.put(proportionOfShipments,
                            Arrays.asList(String.valueOf(m.get(proportionOfShipments)).split(",")));
                    // 下单批次
                    permissionMap.put(orderBatch, Arrays.asList(String.valueOf(m.get(orderBatch)).split(",")));
                    // 下单审批
                    permissionMap.put(orderApproval, Arrays.asList(String.valueOf(m.get(orderApproval)).split(",")));
                    // 采购下单
                    permissionMap.put(purchaseOrder, Arrays.asList(String.valueOf(m.get(purchaseOrder)).split(",")));
                    // 催货批次
                    permissionMap.put(urgentDeliveryBatch,
                            Arrays.asList(String.valueOf(m.get(urgentDeliveryBatch)).split(",")));
                    // 参数管理
                    permissionMap.put(paramManagement,
                            Arrays.asList(String.valueOf(m.get(paramManagement)).split(",")));
                    // 数据补充
                    permissionMap.put(dataSupplement, Arrays.asList(String.valueOf(m.get(dataSupplement)).split(",")));
                    // 数据报表
                    permissionMap.put(dataReport, Arrays.asList(String.valueOf(m.get(dataReport)).split(",")));
                    // 角色管理
                    permissionMap.put(roleManagement, Arrays.asList(String.valueOf(m.get(roleManagement)).split(",")));
                    // 账户管理
                    permissionMap.put(accountManagement, Arrays.asList(String.valueOf(m.get(accountManagement)).split(
                            ",")));
                    // 加入缓存
                    cacheMap.put(account, permissionMap);
                });
                // 预先清除原有的缓存值
                redisUtils.del(permissionCache);
                // 新增缓存
                redisUtils.hmset(permissionCache, cacheMap);
            } catch (Exception e) {
                logger.error("权限缓存加载失败! {}", permissionCache);
            } finally {
                // 清除redis锁
                redisUtils.del(permissionKey);
            }
        } else {
            logger.error("获取redis锁失败! {}", permissionKey);
        }
    }

    /**
     * @Author: system
     * @Description: 获取指定用户权限缓存
     * @Date: 2024-11-09 11:29:44
     * @Param: key
     * @return: List<Object>
     **/
    public Map<String, Object> getAccountPermissionInfo(String key) {
        // 获取全部权限缓存
        Map<Object, Object> permissionMap = redisUtils.hmget(permissionCache);
        // 获取账户对应权限缓存
        return (Map) permissionMap.get(key);
    }

}