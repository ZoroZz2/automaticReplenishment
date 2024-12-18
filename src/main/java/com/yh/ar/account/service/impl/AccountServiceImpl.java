package com.yh.ar.account.service.impl;

import ch.qos.logback.core.util.StringUtil;
import com.alibaba.fastjson.JSON;
import com.yh.ar.account.mapper.AccountMapper;
import com.yh.ar.account.pojo.Account;
import com.yh.ar.account.service.AccountService;
import com.yh.ar.business.pojo.ResultData;
import com.yh.ar.cache.PermissionCache;
import com.yh.ar.util.ParamUtils;
import com.yh.ar.util.ResultDataUtils;
import com.yh.ar.util.page.PageResult;
import com.yh.ar.util.page.SelectDataAtom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @ClassName: accountServiceImpl
 * @Description: 用户信息操作实现
 * @Author: system
 * @Date: 2024-10-26 12:16
 * @Version: 1.0
 **/
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    PermissionCache permissionCache;

    /**
     * @Author: system
     * @Description: 查询用户信息
     * @Date: 2024-10-28 23:54:51
     * @Param: account
     * @return: Account
     **/
    @Override
    public Account getAccountInfoByAccount(String account) {
        return accountMapper.getAccountInfoByAccount(account);
    }

    /**
     * @Author: system
     * @Description: 查询用户信息列表
     * @Date: 2024-10-28 23:54:59
     * @Param: accountVo
     * @return: ResultData<List < Account>>
     **/
    @Override
    public ResultData<PageResult> queryAccountInfoList(Account accountVo) {
        // JavaBean转Map
        Map<String, Object> params = JSON.parseObject(JSON.toJSONString(accountVo), Map.class);
        // 分页查询
        PageResult pageResult = SelectDataAtom.selectDataList("queryAccountInfoList", params);
        return ResultDataUtils.success(pageResult);
    }

    /**
     * @Author: system
     * @Description: 校验用户密码
     * @Date: 2024-11-08 22:13:51
     * @Param: accountVo
     * @return: ResultData<String>
     **/
    @Override
    public ResultData<String> verifyPassword(Account accountVo) {
        String account = accountVo.getAccount();
        String password = accountVo.getPassword();
        // 查询用户信息
        Account accountInfo = getAccountInfoByAccount(account);
        if (null == accountInfo) {
            return ResultDataUtils.fail("该账号不存在或账号无法登录，请检查后重试");
        }

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        // 验证密码是否正确
        if (!passwordEncoder.matches(password, accountInfo.getPassword())) {
            return ResultDataUtils.fail("账号/密码错误，请重新输入！");
        }
        return ResultDataUtils.success("密码正确");
    }

    /**
     * @Author: system
     * @Description: 新增用户信息
     * @Date: 2024-10-28 23:55:04
     * @Param: accountVo
     * @return: ResultData<String>
     **/
    @Override
    public ResultData<String> addAccountInfo(Account accountVo) {
        String account = accountVo.getAccount(), password = accountVo.getPassword(), role = accountVo.getRoleId();
        if (!ParamUtils.isNullOrEmpty(account, password, role)) {
            return ResultDataUtils.fail("新增失败:请求参数[account，password，role]不能为空!");
        }
        // 加密密码
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodePassword = passwordEncoder.encode(password);
        accountVo.setPassword(encodePassword);
        try {
            accountMapper.addAccountInfo(accountVo);
        } catch (Exception e) {
            return ResultDataUtils.fail("新增失败:请联系工作人员!");
        } finally {
            // 重新加载缓存
            permissionCache.loadCache();
        }

        return ResultDataUtils.success("新增成功");
    }

    /**
     * @Author: system
     * @Description: 修改用户信息
     * @Date: 2024-10-28 23:55:10
     * @Param: accountVo
     * @return: ResultData<String>
     **/
    @Override
    public ResultData<String> updAccountInfoByAccount(Account accountVo) {
        if (StringUtil.isNullOrEmpty(accountVo.getAccount())) {
            return ResultDataUtils.fail("修改失败:请求参数[account]不能为空!");
        }

        String password = accountVo.getPassword();
        if (!StringUtil.isNullOrEmpty(password)) { // 修改了密码
            // 加密密码
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodePassword = passwordEncoder.encode(password);
            accountVo.setPassword(encodePassword);
        }

        try {
            accountMapper.updAccountInfoByAccount(accountVo);
        } catch (Exception e) {
            return ResultDataUtils.fail("修改失败:请联系工作人员!");
        } finally {
            String roleId = accountVo.getRoleId();
            if (!StringUtil.isNullOrEmpty(roleId)) { // 修改了角色值
                // 重新加载缓存
                permissionCache.loadCache();
            }
        }

        return ResultDataUtils.success("修改成功");
    }

    /**
     * @Author: system
     * @Description: 删除用户信息
     * @Date: 2024-10-28 23:55:15
     * @Param: accountVo
     * @return: ResultData<String>
     **/
    @Override
    public ResultData<String> delAccountInfoByAccount(Account accountVo) {
        if (StringUtil.isNullOrEmpty(accountVo.getAccount())) {
            return ResultDataUtils.fail("删除失败:请求参数[account]不能为空!");
        }

        try {
            accountMapper.delAccountInfoByAccount(accountVo);
        } catch (Exception e) {
            return ResultDataUtils.fail("删除失败:请联系工作人员!");
        } finally {
            // 重新加载缓存
            permissionCache.loadCache();
        }

        return ResultDataUtils.success("删除成功");
    }
}
