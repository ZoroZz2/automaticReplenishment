package com.yh.ar.account.service;

import com.yh.ar.account.pojo.Account;
import com.yh.ar.business.pojo.ResultData;
import com.yh.ar.util.page.PageResult;

import java.util.List;

/**
 * @ClassName: AccountService
 * @Description: 用户信息操作
 * @Author: system
 * @Date: 2024-10-26 12:12
 * @Version: 1.0
 **/
public interface AccountService {

    Account getAccountInfoByAccount(String account);

    ResultData<PageResult> queryAccountInfoList(Account accountVo);

    ResultData<String> addAccountInfo(Account accountVo);

    ResultData<String> updAccountInfoByAccount(Account accountVo);

    ResultData<String> delAccountInfoByAccount(Account accountVo);

}
