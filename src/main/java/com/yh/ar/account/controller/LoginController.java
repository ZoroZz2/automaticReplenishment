package com.yh.ar.account.controller;

import com.yh.ar.business.pojo.ResultData;
import com.yh.ar.account.service.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ClassName: LoginController
 * @Description: 用户登录入口
 * @Author: system
 * @Date: 2024-10-26 11:13
 * @Version: 1.0
 **/
@RestController
@RequestMapping("/api/account")
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * @Author: system
     * @Description: 登录
     * @Date: 2024-10-28 23:53:31
     * @Param: account
     * @Param: password
     * @Param: session
     * @Param: request
     * @Param: response
     * @return: ResultData<String>
     **/
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultData<Map<String, Object>> login(String account, String password, HttpSession session,
                                                 HttpServletRequest request,
                                                 HttpServletResponse response) {
        return loginService.doLogin(account.trim(), password.trim(), session, request, response);
    }

    /**
     * @Author: system
     * @Description: 刷新token
     * @Date: 2024-11-06 12:00:15
     * @Param: request
     * @return: ResultData<String>
     **/
    @GetMapping("/refreshToken")
    public ResultData<Map<String, Object>> refreshToken(HttpServletRequest request) {
        return loginService.refreshToken(request);
    }

    /**
     * @Author: system
     * @Description: 退出登录
     * @Date: 2024-10-28 23:53:43
     * @Param: session
     * @Param: request
     * @Param: response
     * @return: ResultData<String>
     **/
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ResultData<String> logout(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        return loginService.logout(session, request, response);
    }

}
