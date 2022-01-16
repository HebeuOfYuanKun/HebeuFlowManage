package com.yuankun.security;

import cn.hutool.json.JSONUtil;
import com.alibaba.druid.support.json.JSONUtils;
import com.sun.javaws.IconUtil;
import com.yuankun.response.Result;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import springfox.documentation.spring.web.json.Json;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
@Component
public class LoginFailureHandler implements AuthenticationFailureHandler {//登录失败处理器

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=UTF-8");//登录失败处理器
        ServletOutputStream servletOutputStream=httpServletResponse.getOutputStream();
        //System.out.println(e.getClass().getName());
        Result result=new Result(402,"",null);//判断登录出现的错误类型：1.验证码错误 2.用户名或密码错误
        if(e.getClass().getName().equals("org.springframework.security.authentication.BadCredentialsException")){
            result.setMsg("用户名密码错误");
        }else{
            result.setMsg("验证码错误");
        }
        httpServletResponse.setStatus(402);
        //new Result(402,e.getMessage(),null);


        servletOutputStream.write(JSONUtil.toJsonStr(result).getBytes(StandardCharsets.UTF_8));

        servletOutputStream.flush();
        servletOutputStream.close();
    }
}
