package com.yh.ar.account.service.impl;

import com.alibaba.fastjson.JSON;
import com.yh.ar.account.mapper.RoleMapper;
import com.yh.ar.account.pojo.RoleInfo;
import com.yh.ar.account.service.RoleService;
import com.yh.ar.business.pojo.ResultData;
import com.yh.ar.cache.PermissionCache;
import com.yh.ar.util.Constants;
import com.yh.ar.util.ParamUtils;
import com.yh.ar.util.ResultDataUtils;
import com.yh.ar.util.enums.MenuMethodEnum;
import com.yh.ar.util.page.PageResult;
import com.yh.ar.util.page.SelectDataAtom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: RoleServiceImpl
 * @Description: 角色信息操作实现
 * @Author: system
 * @Date: 2024-10-27 20:34
 * @Version: 1.0
 **/
@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    TransactionTemplate transactionTemplate;

    @Autowired
    PermissionCache permissionCache;

    /**
     * @Author: system
     * @Description: 查询角色信息
     * @Date: 2024-10-28 23:56:04
     * @Param: roleVo
     * @return: ResultData<List < Map>>
     **/
    @Override
    public ResultData<PageResult> queryRoleInfoList(RoleInfo roleVo) {
        List<Map<String, Object>> resultList = new LinkedList<>();

        // JavaBean转Map
        Map<String, Object> params = JSON.parseObject(JSON.toJSONString(roleVo), Map.class);
        // 分页查询
        PageResult pageResult = SelectDataAtom.selectDataList("queryRoleInfoList", params);
        List<Map<String, Object>> roleInfoList = pageResult.getDataList();
        roleInfoList.forEach(roleMap -> {
            Map resultMap = new HashMap();
            // 授权列表
            List<String> authorizedList = new LinkedList<>();

            roleMap.forEach((key, value) -> {
                String copyKey = key.toUpperCase();
                if (MenuMethodEnum.isMenuIdExist(copyKey)) { // 包含权限设置
                    List<String> permissionList = ParamUtils.stringToList((String) value);
                    if (!permissionList.isEmpty() && !Constants.NO_PERMISSION_DEFAULT.equals(permissionList.get(0))) { // 有设置权限
                        authorizedList.add(key);
                    }
                    resultMap.put(key, permissionList);
                } else {
                    resultMap.put(key, value);
                }
            });
            resultMap.put("authorizedList", authorizedList);

            resultList.add(resultMap);
        });

        pageResult.setDataList(resultList);
        return ResultDataUtils.success(pageResult);
    }

    /**
     * @Author: system
     * @Description: 新增角色
     * @Date: 2024-10-28 23:56:10
     * @Param: roleVo
     * @return: ResultData<String>
     **/
    @Override
    public ResultData<String> addRoleInfo(RoleInfo roleVo) {
        String roleName = roleVo.getRoleName(), productType = roleVo.getProductType();
        if (!ParamUtils.isNullOrEmpty(roleName, productType)) {
            return ResultDataUtils.fail("新增失败:请求参数[roleName, productType]不能为空!");
        }

        // 编程式事务sql管理
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    roleMapper.addRoleInfo(roleVo);
                    roleMapper.addRoleInfoDetails(roleVo);
                } catch (Exception e) {
                    //回滚
                    transactionStatus.setRollbackOnly();
                }
            }
        });

        return ResultDataUtils.success("新增成功");
    }

    /**
     * @Author: system
     * @Description: 修改角色
     * @Date: 2024-10-28 23:56:16
     * @Param: roleVo
     * @return: ResultData<String>
     **/
    @Override
    public ResultData<String> updRoleInfo(RoleInfo roleVo) {
        String roleId = roleVo.getRoleId();
        if (!ParamUtils.isNullOrEmpty(roleId)) {
            return ResultDataUtils.fail("修改失败:请求参数[roleId]不能为空!");
        }

        try {
            roleMapper.updRoleInfo(roleVo);
        } catch (Exception e) {
            // e.printStackTrace();
            return ResultDataUtils.fail("修改失败:请联系工作人员!");
        } finally {
            // 重新加载缓存
            permissionCache.loadCache();
        }

        return ResultDataUtils.success("修改成功");
    }

    /**
     * @Author: system
     * @Description: 删除角色
     * @Date: 2024-10-28 23:56:23
     * @Param: roleVo
     * @return: ResultData<String>
     **/
    @Override
    public ResultData<String> delRoleInfo(RoleInfo roleVo) {
        String roleId = roleVo.getRoleId();
        if (!ParamUtils.isNullOrEmpty(roleId)) {
            return ResultDataUtils.fail("删除失败:请求参数[roleId]不能为空!");
        }

        try {
            roleMapper.delRoleInfo(roleVo);
        } catch (Exception e) {
            return ResultDataUtils.fail("删除失败:请联系工作人员!");
        } finally {
            // 重新加载缓存
            permissionCache.loadCache();
        }

        return ResultDataUtils.success("删除成功");
    }

}
