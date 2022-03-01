package com.finances.ATMMachine.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class SystemUserDetails implements UserDetails {

    private static final long serialVersionUID = -7127141675788677116L;

    @Setter
    private String username;
    @Setter
    private String password;
    @Setter
    private Collection<? extends GrantedAuthority> authorities;
    @Getter
    @Setter
    private User user;

    public SystemUserDetails() {
        super();
    }

    public SystemUserDetails(String username, String password, User user,
                             Collection<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}