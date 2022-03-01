package com.finances.ATMMachine.config;

import com.finances.ATMMachine.entity.User;
import com.finances.ATMMachine.entity.SystemUserDetails;
import com.finances.ATMMachine.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
public class SecurityConfig {

    @Autowired
    private UserService userService;

    @Bean
    public UserDetailsService usernamePasswordUserDetails() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                User user = userService.getUserByUserName(username);

                if (user != null) {
                    return new SystemUserDetails(user.getUserName(), user.getPassword(), user, null);
                }
                throw new UsernameNotFoundException("error 404");
            }
        };
    }

    @Bean
    public AuthenticationProvider usernamePasswordAuthenticationProvider() {
        return new UsernamePasswordAuthenticationProvider(usernamePasswordUserDetails());
    }
}

