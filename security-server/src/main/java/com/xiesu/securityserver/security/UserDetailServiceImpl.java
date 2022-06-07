package com.xiesu.securityserver.security;

import com.xiesu.securityserver.dto.AccountUKDto;
import com.xiesu.securityserver.entity.SysAccount;
import com.xiesu.securityserver.entity.SysRole;
import com.xiesu.securityserver.mapper.SysAccountMapper;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


/**
 * 用户认证类
 *
 * @author xiesu
 */
@Component
public class UserDetailServiceImpl implements UserDetailsService {

    @Resource
    private SysAccountMapper accountMapper;

    /**
     * Locates the user based on the username. In the actual implementation, the search may possibly
     * be case sensitive, or case insensitive depending on how the implementation instance is
     * configured. In this case, the <code>UserDetails</code> object that comes back may have a
     * username that is of a different case than what was actually requested..
     *
     * @param accountId the username identifying the user whose data is required.
     * @return a fully populated user record (never <code>null</code>)
     * @throws UsernameNotFoundException if the user could not be found or the user has no
     *                                   GrantedAuthority
     */
    @Override
    public UserDetails loadUserByUsername(String accountId) throws UsernameNotFoundException {

        SysAccount account = accountMapper.findByUK(
                AccountUKDto.builder().accountId(accountId).build());
        //TODO:跑出异常，捕获，并通知web
        Objects.requireNonNull(account);

        //取出所有的角色，并赋予
        Collection<GrantedAuthority> authorities =
                account.getRoleSet().stream().map(SysRole::getRoleName)
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toSet());
        //使用默认的UserDetails实现类即可
        //return new User(accountId, account.getPwd(), authorities);
        return User.builder().username(accountId).password(account.getPwd())
                .authorities(authorities).build();
    }


}
