package com.yh.ar.account.controller;

import com.yh.ar.account.pojo.RoleInfo;
import com.yh.ar.account.service.RoleService;
import com.yh.ar.business.pojo.ResultData;
import com.yh.ar.util.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: RoleController
 * @Description: 账户角色
 * @Author: system
 * @Date: 2024-10-27 20:31
 * @Version: 1.0
 **/
@RestController
@RequestMapping("/api/account/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @GetMapping("/queryRoleInfoList")
    public ResultData<PageResult> queryRoleInfoList(RoleInfo roleVo) {
        return roleService.queryRoleInfoList(roleVo);
    }

    @RequestMapping(value = "/addRoleInfo", method = RequestMethod.POST)
    public ResultData<String> addRoleInfo(RoleInfo roleVo) {
        return roleService.addRoleInfo(roleVo);
    }

    @RequestMapping(value = "/updRoleInfo", method = RequestMethod.POST)
    public ResultData<String> updRoleInfo(RoleInfo roleVo) {
        return roleService.updRoleInfo(roleVo);
    }

    @RequestMapping(value = "/delRoleInfo", method = RequestMethod.POST)
    public ResultData<String> delRoleInfo(RoleInfo roleVo) {
        return roleService.delRoleInfo(roleVo);
    }

}
