package com.yh.ar.account.mapper;

import com.yh.ar.account.pojo.RoleInfo;
import com.yh.ar.business.mapper.CommonMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: RoleMapper
 * @Description: 角色数据映射
 * @Author: system
 * @Date: 2024-10-29 19:32
 * @Version: 1.0
 **/
@Mapper
public interface RoleMapper {

    // 查询专用方法，通过反射调用，请不要删除！！！
    List<Map> queryRoleInfoList(Map<String, Object> params);

    Integer addRoleInfo(RoleInfo roleVo);

    int addRoleInfoDetails(RoleInfo roleVo);

    int updRoleInfo(RoleInfo roleVo);

    int delRoleInfo(RoleInfo roleVo);

}