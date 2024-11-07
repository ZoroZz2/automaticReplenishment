package com.yh.ar.account.service.impl;

import ch.qos.logback.core.util.StringUtil;
import com.yh.ar.account.pojo.Account;
import com.yh.ar.account.service.AccountService;
import com.yh.ar.account.service.LoginService;
import com.yh.ar.business.pojo.ResultData;
import com.yh.ar.security.SecurityUserDetails;
import com.yh.ar.security.jwt.JwtTokenProvider;
import com.yh.ar.util.Constants;
import com.yh.ar.util.ResultDataUtils;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: LoginServiceImpl
 * @Description: 登录处理实现类
 * @Author: system
 * @Date: 2024-10-26 11:11
 * @Version: 1.0
 **/
@Service("loginService")
public class LoginServiceImpl implements LoginService {
    final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private AccountService accountService;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    AuthenticationManager authenticationManager;

    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * @Author: system
     * @Description: 登录验证
     * @Date: 2024-10-28 23:55:29
     * @Param: account
     * @Param: password
     * @Param: session
     * @Param: request
     * @Param: response
     * @return: ResultData<String>
     **/
    @Override
    public ResultData<Map<String, Object>> doLogin(String account, String password, HttpSession session,
                                                   HttpServletRequest request, HttpServletResponse response) {
        if (StringUtil.isNullOrEmpty(account) || StringUtil.isNullOrEmpty(password)) {
            return ResultDataUtils.fail("请输入账号或密码");
        }
        // 查询用户信息
        Account accountInfo = accountService.getAccountInfoByAccount(account);
        if (null == accountInfo) {
            return ResultDataUtils.fail("该账号不存在或账号无法登录，请检查后重试");
        }

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        // 验证密码是否正确
        if (!passwordEncoder.matches(password, accountInfo.getPassword())) {
            return ResultDataUtils.fail("账号/密码错误，请重新输入！");
        }

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(account, password));

            SecurityUserDetails securityUserDetails = (SecurityUserDetails) authentication.getPrincipal();

            String token = jwtTokenProvider.createToken(securityUserDetails);
            Map<String, Object> model = new HashMap<>();
            model.put("account", account);
            model.put("token", token);
            model.put("token_expiration", dateTimeFormatter.format(
                    jwtTokenProvider.getTokenExpiration(token)
                            .toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()));
            return ResultDataUtils.success(model);
        } catch (BadCredentialsException e) {
            e.printStackTrace();
            return ResultDataUtils.fail("登录失败");
        }
    }

    /**
     * @Author: system
     * @Description: 刷新token
     * @Date: 2024-11-06 12:01:14
     * @Param: request
     * @return: ResultData<String>
     **/
    @Override
    public ResultData<Map<String, Object>> refreshToken(HttpServletRequest request) {
        String currToken = jwtTokenProvider.resolveToken(request);
        String newToken = jwtTokenProvider.refreshToken(currToken);
        Map<String, Object> model = new HashMap<>();
        model.put("account", jwtTokenProvider.getUsername(newToken));
        model.put("token", newToken);
        model.put("token_expiration", dateTimeFormatter.format(
                jwtTokenProvider.getTokenExpiration(newToken)
                        .toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()));
        return ResultDataUtils.success(model);
    }

    /**
     * @Author: system
     * @Description: 退出登录
     * @Date: 2024-10-28 23:55:36
     * @Param: session
     * @Param: request
     * @Param: response
     * @return: ResultData<String>
     **/
    @Override
    public ResultData<String> logout(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        try {
            // 删除session里面的用户信息
            session.removeAttribute(Constants.SYSTEM_ACCOUNT_SESSION);
            // 保存cookie，实现自动登录
            Cookie cookieAccount = new Cookie(Constants.SYSTEM_ACCOUNT_COOKIE, "");
            // 设置cookie的持久化时间，0
            cookieAccount.setMaxAge(0);
            // 设置为当前项目下都携带这个cookie
            cookieAccount.setPath(request.getContextPath());
            // 向客户端发送cookie
            response.addCookie(cookieAccount);
        } catch (Exception e) {

        }
        return ResultDataUtils.success("登出成功");
    }

}
