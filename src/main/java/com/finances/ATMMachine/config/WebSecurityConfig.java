package com.finances.ATMMachine.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.util.List;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String[] EXCLUDE_URLS = { "/**/*.js", "/**/*.css", "/**/*.jpg", "/**/*.png", "/**/*.gif",
            "/v2/**", "/errors", "/error", "/favicon.ico", "/swagger-ui.html/**", "/swagger-ui/**", "/webjars/**",
            "/swagger-resources/**", "/auth/login","/h2/**","/h2**","/h2" };
    @Autowired
    private AuthenticationSuccessHandler successHandler;
    @Autowired
    private AuthenticationFailureHandler failureHandler;
    @Autowired
    AccessDeniedHandler deniedHandler;
    @Autowired
    AuthenticationEntryPoint entryPoint;
    @Autowired
    private List<AuthenticationProvider> authenticationProviderList;

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        for (AuthenticationProvider authenticationProvider : authenticationProviderList) {
            http.authenticationProvider(authenticationProvider);
        }

        http.exceptionHandling().accessDeniedHandler(deniedHandler).authenticationEntryPoint(entryPoint);
        http.authorizeRequests().antMatchers(EXCLUDE_URLS).permitAll()
                .anyRequest().authenticated();

        FormLoginConfigurer<HttpSecurity> formLogin = http.formLogin();

        formLogin.successHandler(successHandler).failureHandler(failureHandler);

        formLogin.loginProcessingUrl("/auth/login");
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }
}