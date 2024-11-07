package com.yh.ar.business.mapper;

import com.yh.ar.account.mapper.AccountMapper;
import com.yh.ar.account.mapper.RoleMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @InterfaceName: dataMapper
 * @Description: 公共映像类
 * 实现查询分页数据的Mapper文件
 * @Author: system
 * @Date: 2024-10-30 01:55
 * @Version: 1.0
 **/
@Mapper
public interface CommonMapper extends AccountMapper, RoleMapper, SelectDataMapper {
}