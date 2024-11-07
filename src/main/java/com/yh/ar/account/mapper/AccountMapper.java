package com.yh.ar.account.mapper;

import com.yh.ar.account.pojo.Account;
import com.yh.ar.business.mapper.CommonMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: AccountMapper
 * @Description: 用户信息数据映射
 * @Author: system
 * @Date: 2024-10-26 16:01
 * @Version: 1.0
 **/
@Mapper
public interface AccountMapper {

    Account getAccountInfoByAccount(String account);

    // 查询专用方法，通过反射调用，请不要删除！！！
    List<Map> queryAccountInfoList(Map<String, Object> params);

    int addAccountInfo(Account accountVo);

    int updAccountInfoByAccount(Account accountVo);

    int delAccountInfoByAccount(Account accountVo);

}
