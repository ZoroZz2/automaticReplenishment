package com.yh.ar.account.service;

import com.yh.ar.account.pojo.RoleInfo;
import com.yh.ar.business.pojo.ResultData;
import com.yh.ar.util.page.PageResult;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: RoleService
 * @Description: 角色信息操作
 * @Author: system
 * @Date: 2024-10-27 20:33
 * @Version: 1.0
 **/
public interface RoleService {

    ResultData<PageResult> queryRoleInfoList(RoleInfo roleVo);

    ResultData<String> addRoleInfo(RoleInfo roleVo);

    ResultData<String> updRoleInfo(RoleInfo roleVo);

    ResultData<String> delRoleInfo(RoleInfo roleVo);
}
