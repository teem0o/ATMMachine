package com.finances.ATMMachine.config;

import com.alibaba.fastjson.JSON;
import com.finances.ATMMachine.entity.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class FailureHandler implements AuthenticationFailureHandler {

    private Logger log = LoggerFactory.getLogger(getClass());

    @SuppressWarnings("deprecation")
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        log.info("Login failed,{}", exception.getMessage());
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        PrintWriter writer = response.getWriter();
        writer.print(JSON.toJSONString(Result.result(400, exception.getMessage())));
        writer.flush();
        writer.close();
    }
}
