package com.xiesu.securityserver.security;

import com.xiesu.commonbase.except.ExposedException;

import com.xiesu.securityserver.entity.SysRole;
import com.xiesu.securityserver.entity.SysUser;
import com.xiesu.securityserver.mapper.SysUserMapper;
import java.util.Collection;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/**
 * 用户认证类
 * @author xiesu
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Resource
    private SysUserMapper sysUserRepository;

    @Override
    public UserDetails loadUserByUsername(String uid) throws UsernameNotFoundException {
        SysUser sysUser = sysUserRepository.selectByUid(uid);
        if (sysUser == null) {
            throw new ExposedException();
        }

//        取出所有的角色，并赋予
        Collection<GrantedAuthority> authorities =
                sysUser.getRoleSet().stream().map(SysRole::getRoleName)
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toSet());

        return new JwtUser(sysUser, authorities);
    }
}
