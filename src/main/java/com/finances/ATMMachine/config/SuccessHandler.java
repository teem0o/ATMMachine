package com.finances.ATMMachine.config;

import com.alibaba.fastjson.JSON;
import com.finances.ATMMachine.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
@Slf4j
public class SuccessHandler implements AuthenticationSuccessHandler {

    @SuppressWarnings("deprecation")
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        log.info("login half way done:{}", authentication.getPrincipal());
        PrintWriter writer = response.getWriter();
        writer.print(JSON.toJSONString(Result.success(authentication.getPrincipal().toString())));
        writer.flush();
        writer.close();
    }
}