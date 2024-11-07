package com.yh.ar.security;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * @ClassName: SecurityUserDetails
 * @Description:
 * @Author: system
 * @Date: 2024-11-06 01:32
 * @Version: 1.0
 **/
public class SecurityUserDetails implements UserDetails {

    private String id;
    private String username;
    @JsonIgnore
    private String password;
    private Set<GrantedAuthority> authorities;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    public SecurityUserDetails(String id, String username, String password,
                               Collection<? extends GrantedAuthority> authorities,
                               boolean accountNonExpired, boolean accountNonLocked,
                               boolean credentialsNonExpired, boolean enabled) {
        this.username = username;
        this.id = id;
        this.password = password;
        this.authorities = Collections.unmodifiableSet(
                authorities.stream().map(authority ->
                        new SimpleGrantedAuthority(authority.getAuthority())
                ).collect(Collectors.toSet()));
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
        this.enabled = enabled;
    }

    public String getId() {
        return id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SecurityUserDetails.class.getSimpleName() + "[", "]")
                .add("nickname='" + id + "'")
                .add("username='" + username + "'")
                .add("password=[PROJECT]")
                .add("authorities=" + authorities)
                .add("accountNonExpired=" + accountNonExpired)
                .add("accountNonLocked=" + accountNonLocked)
                .add("credentialsNonExpired=" + credentialsNonExpired)
                .add("enabled=" + enabled)
                .toString();
    }

}