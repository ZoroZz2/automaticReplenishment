package com.yh.ar.account.pojo;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

/**
 * @ClassName: Account
 * @Description: 用户登录信息
 * @Author: system
 * @Date: 2024-10-26 10:53
 * @Version: 1.0
 **/
@Component
@Data
public class Account implements UserDetails {

    // id
    private String id;
    // 账户名
    private String account;
    // 账户密码
    private String password;
    // 邮箱地址
    private String email;
    // 电话号码
    private String phone;
    // 账户角色
    private String roleId;
    // 账户状态
    private String status;
    // 创建时间
    private String createdTime;
    // 修改时间
    private String updateTime;

    // 认证列表
    private List<GrantedAuthority> authorities;

    public void Account(String account, String password) {
        this.account = account;
        this.password = password;
    }

    /**
     * @Author: system
     * @Description: 返回的值不能为null, 否则返回的永远是null, 就会一直没有权限，
     * 由此定义了一个authorities 属性并提供get方法，因为自定义了UserDetails，
     * 就没有在UserService中，使用到框架提供的User对象
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getUsername() {
        return this.account;
    }
}
