package com.xiesu.securityserver.security;

import java.util.Collection;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author xiesu
 */
@Setter
public class JwtUser implements UserDetails {

    private String username;
    private String password;

    private Collection<? extends GrantedAuthority> authorities;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
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

    public JwtUser(SysUser user, Collection<GrantedAuthority> authorities) {
        this.username = user.getUid();
        this.password = user.getPwd();
        this.authorities = authorities;

    }
}
