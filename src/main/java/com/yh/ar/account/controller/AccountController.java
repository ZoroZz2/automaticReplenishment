package com.yh.ar.account.controller;

import com.yh.ar.account.pojo.Account;
import com.yh.ar.account.service.AccountService;
import com.yh.ar.business.pojo.ResultData;
import com.yh.ar.cache.PermissionCache;
import com.yh.ar.util.ResultDataUtils;
import com.yh.ar.util.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ClassName: AccountController
 * @Description: 用户信息操作
 * @Author: system
 * @Date: 2024-10-26 21:39
 * @Version: 1.0
 **/
@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    PermissionCache permissionCache;

    /**
     * @Author: system
     * @Description: 获取指定账户权限缓存值
     * @Date: 2024-11-09 11:15:12
     * @Param: paramKey
     * @return: List<Object>
     **/
    @GetMapping("/getAccountPermissionInfo")
    public ResultData<Map<String, Object>> getAccountPermissionInfo(String cacheKey) {
        Map<String, Object> accountPermissionInfo = permissionCache.getAccountPermissionInfo(cacheKey);
        return ResultDataUtils.success(accountPermissionInfo);
    }

    @GetMapping("/queryAccountInfoList")
    public ResultData<PageResult> queryAccountInfoList(Account accountVo) {
        return accountService.queryAccountInfoList(accountVo);
    }

    @RequestMapping(value = "/addAccountInfo", method = RequestMethod.POST)
    public ResultData<String> addAccountInfo(Account accountVo) {
        return accountService.addAccountInfo(accountVo);
    }

    /**
     * @Author: system
     * @Description: 校验账户密码
     * @Date: 2024-11-08 22:12:28
     * @Param: accountVo
     * @return: ResultData<String>
     **/
    @RequestMapping(value = "/verifyPassword", method = RequestMethod.POST)
    public ResultData<String> verifyPassword(Account accountVo) {
        return accountService.verifyPassword(accountVo);
    }

    @RequestMapping(value = "/updAccountInfoByAccount", method = RequestMethod.POST)
    public ResultData<String> updAccountInfoByAccount(Account accountVo) {
        return accountService.updAccountInfoByAccount(accountVo);
    }

    @RequestMapping(value = "/delAccountInfoByAccount", method = RequestMethod.POST)
    public ResultData<String> delAccountInfoByAccount(Account accountVo) {
        return accountService.delAccountInfoByAccount(accountVo);
    }

}
