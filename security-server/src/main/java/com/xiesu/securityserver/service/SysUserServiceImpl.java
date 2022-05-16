package com.xiesu.securityserver.service;

import com.xiesu.securityserver.domain.SysUser;
import com.xiesu.securityserver.repository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserRepository sysUserRepository;

    public Optional<SysUser> findByUserId(String uid) {
        return sysUserRepository.findByUserId(uid);
    }


    public SysUser save(SysUser sysUser){
        return sysUserRepository.save(sysUser);
    }
    public SysUser saveAndFlush(SysUser sysUser){
        return sysUserRepository.saveAndFlush(sysUser);
    }


}
