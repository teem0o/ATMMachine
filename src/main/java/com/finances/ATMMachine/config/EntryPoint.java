package com.finances.ATMMachine.config;

import com.alibaba.fastjson.JSON;
import com.finances.ATMMachine.entity.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class EntryPoint implements AuthenticationEntryPoint {

    @SuppressWarnings("deprecation")
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        String error = "request url:" + request.getRequestURI() + " authentication failed:" + authException.getMessage();
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        PrintWriter writer = response.getWriter();
        writer.print(JSON.toJSONString(Result.result(HttpStatus.UNAUTHORIZED.value(), error)));
        writer.flush();
        writer.close();
    }
}
