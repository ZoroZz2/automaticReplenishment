package com.yh.ar.security;

import com.yh.ar.account.pojo.Account;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @ClassName: SecurityUserDetailsService
 * @Description:
 * @Author: system
 * @Date: 2024-11-06 01:15
 * @Version: 1.0
 **/
@Component
public class SecurityUserDetailsService implements UserDetailsService {
    final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private SqlSession sqlSession;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            Account accountInfo = sqlSession.selectOne("getAccountInfoByAccount", username);
            SecurityUserDetails securityUserDetails = new SecurityUserDetails(accountInfo.getId(),
                    username, accountInfo.getPassword(), new ArrayList<>(),
                    true, true, true, true);
            return securityUserDetails;
        } catch (Exception e) {
            String msg = "Username: " + username + " not found";
            logger.error(msg, e);
            throw new UsernameNotFoundException(msg);
        }
    }
}