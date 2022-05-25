package com.xiesu.securityserver.repository;

import com.xiesu.securityserver.domain.SysUser;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface SysUserRepository {

   Optional<SysUser> findByUserId(String uid);

}
