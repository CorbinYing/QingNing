package com.xiesu.securityserver.service.impl;

import com.xiesu.securityserver.entity.SysUser;
import com.xiesu.securityserver.mapper.SysUserMapper;
import com.xiesu.securityserver.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.Optional;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xiesu
 * @since 2022-05-25
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;
    @Override
    public Optional<SysUser> selectByUid(String uid) {
        return Optional.ofNullable(sysUserMapper.selectByUid(uid));
    }
}
