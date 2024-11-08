package com.yh.ar.permission;

import com.yh.ar.util.Constants;
import com.yh.ar.util.RedisUtils;
import com.yh.ar.util.enums.MenuMethodEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: DataPermission
 * @Description: 数据权限控制
 * @Author: system
 * @Date: 2024-11-08 17:24
 * @Version: 1.0
 **/
@Component
public class DataPermission {

    @Autowired
    RedisUtils redisUtils;

    @Value("${redis.permissionCache}")
    private String permissionCache;

    /**
     * @Author: system
     * @Description: 阶梯价权限控制
     * @Date: 2024-11-08 17:34:38
     * @Param: account
     * @Param: dataList
     * @return: void
     **/
    public void ladderPriceFilter(String account, String menuId, List<Map<String, Object>> dataList) {
        // 获取全部权限缓存
        Map<Object, Object> permissionMap = redisUtils.hmget(permissionCache);
        // 获取账户对应权限缓存
        Map<String, Object> accountMap = (Map) permissionMap.get(account);
        // 获取菜单权限缓存
        List<String> menuPermissionList = (List) accountMap.get(menuId);
        boolean containsLadderPrice =
                menuPermissionList.stream().anyMatch(element -> element.equals(Constants.LADDER_PRICE_PERMISSION));
        if (!containsLadderPrice) { // 不包含阶梯价权限
            dataList.forEach(map -> map.put("ladderPrice", "********"));
        }
    }

}