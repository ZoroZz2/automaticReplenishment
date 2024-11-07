package com.yh.ar.account.service;

import com.yh.ar.business.pojo.ResultData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.util.Map;

/**
 * @ClassName: LoginService
 * @Description: 登录逻辑处理
 * @Author: system
 * @Date: 2024-10-26 11:02
 * @Version: 1.0
 **/
public interface LoginService {

    ResultData<Map<String, Object>> doLogin(String account, String password, HttpSession session, HttpServletRequest request,
                                            HttpServletResponse response);

    ResultData<Map<String, Object>> refreshToken(HttpServletRequest request);

    ResultData<String> logout(HttpSession session, HttpServletRequest request, HttpServletResponse response);

}
