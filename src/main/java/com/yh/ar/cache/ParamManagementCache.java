package com.yh.ar.cache;

import com.yh.ar.business.mapper.SelectDataMapper;
import com.yh.ar.util.Constants;
import com.yh.ar.util.ParamUtils;
import com.yh.ar.util.RedisUtils;
import com.yh.ar.util.page.SelectDataAtom;
import jakarta.annotation.PostConstruct;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: ParamManagementCache
 * @Description: 参数管理缓存
 * @Author: system
 * @Date: 2024-11-08 00:20
 * @Version: 1.0
 **/
@Component
public class ParamManagementCache {

    @Value("${redis.paramKey}")
    private String paramKey;

    @Value("${redis.value}")
    private String paramVal;

    @Value("${redis.expirationTime}")
    private Long expirationTime;

    @Value("${redis.paramCache}")
    private String paramCache;

    @Autowired
    RedisUtils redisUtils;

    @Autowired
    SelectDataMapper selectDataMapper;

    private final Logger logger = LogManager.getLogger(getClass());

    /**
     * @Author: system
     * @Description: 参数缓存
     * @Date: 2024-11-08 16:02:53
     * @Param:
     * @return: void
     **/
    @PostConstruct
    public void loadParamCache() {
        // 使用redis锁防止重复加载
        boolean existence = redisUtils.existence(paramKey, paramVal, expirationTime);
        if (existence) {
            try {
                // 提醒列表
                List<Map> remindStandardizationList =
                        selectDataMapper.queryRemindStandardizationList(new HashMap<>());
                redisUtils.del(Constants.REMIND_STANDARDIZATION_LIST);
                redisUtils.lSet(Constants.REMIND_STANDARDIZATION_LIST, remindStandardizationList);
                // 补货规则
                List<Map> restockingRulesList = selectDataMapper.queryRestockingRulesList(new HashMap<>());
                redisUtils.del(Constants.RESTOCKING_RULES_LIST);
                redisUtils.lSet(Constants.RESTOCKING_RULES_LIST, restockingRulesList);
                // 各链路系数
                List<Map> linkCoefficientList = selectDataMapper.queryLinkCoefficientList(new HashMap<>());
                redisUtils.del(Constants.LINK_COEFFICIENT_LIST);
                redisUtils.lSet(Constants.LINK_COEFFICIENT_LIST, linkCoefficientList);
                // 库内系数
                List<Map> warehouseCoefficientList =
                        selectDataMapper.queryWarehouseCoefficientList(new HashMap<>());
                redisUtils.del(Constants.WAREHOUSE_COEFFICIENT_LIST);
                redisUtils.lSet(Constants.WAREHOUSE_COEFFICIENT_LIST, warehouseCoefficientList);
                // 销售等级
                List<Map> salesLevelList = selectDataMapper.querySalesLevelList(new HashMap<>());
                redisUtils.del(Constants.SALES_LEVEL_LIST);
                redisUtils.lSet(Constants.SALES_LEVEL_LIST, salesLevelList);
                // 发货等级
                List<Map> shippingGradeList = selectDataMapper.queryShippingGradeList(new HashMap<>());
                redisUtils.del(Constants.SHIPPING_GRADE_LIST);
                redisUtils.lSet(Constants.SHIPPING_GRADE_LIST, shippingGradeList);
                // 高风险产品下单安全系数
                List<Map> orderSafetyFactorList = selectDataMapper.queryOrderSafetyFactorList(new HashMap<>());
                redisUtils.del(Constants.ORDER_SAFETY_FACTOR_LIST);
                redisUtils.lSet(Constants.ORDER_SAFETY_FACTOR_LIST, orderSafetyFactorList);
            } catch (Exception e) {
                logger.error("权限缓存加载失败! {}", paramCache);
            } finally {
                // 清除redis锁
                redisUtils.del(paramKey);
            }
        } else {
            logger.error("获取redis锁失败! {}", paramCache);
        }
    }

    /**
     * @Author: system
     * @Description: 指定key值初始化缓存
     * @Date: 2024-11-08 23:55:09
     * @Param: key
     * @return: void
     **/
    public void loadParamCache(String key) {
        redisUtils.del(key);
        // 首字母变成大写
        String newKey = ParamUtils.capitalizeFirstLetter(key);
        String methodName = "query" + newKey;
        // 反射调用对应方法
        List<Map> dataList = (List) SelectDataAtom.invoke(methodName, new HashMap<>());
        redisUtils.lSet(key, dataList);
    }

    /**
     * @Author: system
     * @Description: 获取指定key缓存数据
     * @Date: 2024-11-08 23:55:09
     * @Param: key
     * @return: void
     **/
    public List<Object> getParamCacheList(String key) {
        return redisUtils.lGet(key, 0, -1);
    }


}