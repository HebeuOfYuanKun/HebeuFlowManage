package com.yuankun.security;

import cn.hutool.core.util.StrUtil;
import cn.hutool.jwt.JWTException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.yuankun.conf.MyUserDetailsService;
import com.yuankun.mapper.UserMapper;
import com.yuankun.pojo.User;
import com.yuankun.util.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JWTAuthenticationFilter extends BasicAuthenticationFilter {
    @Autowired
    private JWTUtils jwtUtils;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MyUserDetailsService myUserDetailsService;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String Token=request.getHeader("Token");//从请求头中拿取token
        if(StrUtil.isBlankOrUndefined(Token)){//token不存在
            chain.doFilter(request,response);//放行拦截
            return;
        }
        DecodedJWT decodedJWT=jwtUtils.verifyToken(Token);//用jwt验证token
        if(decodedJWT==null){
            throw new JWTException("Token异常");
        }else{
            if(StrUtil.isBlankOrUndefined(decodedJWT.getClaim("username").asString())){//token是伪造的
                throw new JWTException("Token没有信息");
            }
            if(jwtUtils.IsTokenExpired(decodedJWT)){
                throw new JWTException("Token过期");
            }
        }
        String username=decodedJWT.getClaim("username").asString();//从token中获取username
        //Integer id=decodedJWT.getClaim("id").asInt();
        User user=userMapper.QueryByUserName(username);
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=
                new UsernamePasswordAuthenticationToken(username,null,myUserDetailsService.ProdeceAuthority(user.getId()));
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);//在security框架中设置授权用户

        chain.doFilter(request, response);//放行拦截
    }
}
