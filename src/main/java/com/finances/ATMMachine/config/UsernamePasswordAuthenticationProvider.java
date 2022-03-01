package com.finances.ATMMachine.config;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Slf4j
public class UsernamePasswordAuthenticationProvider implements AuthenticationProvider {
    @Getter
    @Setter
    private UserDetailsService userDetailsService;
//    @Autowired
//    private PasswordEncoder passwordEncoder;

    public UsernamePasswordAuthenticationProvider(UserDetailsService userDetailsService) {
        super();
        this.userDetailsService = userDetailsService;
    }
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();
        UserDetails userDetails;
        try {
            userDetails = userDetailsService.loadUserByUsername(username);
        } catch (Exception e) {
            throw new AuthenticationServiceException(e.getMessage());
        }
        if (!passwordEncoder().matches(password, userDetails.getPassword())) {
            log.info("Current login person: {}, current login password: {}", username, password);
            throw new BadCredentialsException("User password is incorrect");
        }
        return new UsernamePasswordAuthenticationToken(username, null, userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}