package com.xiesu.securityserver.repository;

import com.xiesu.securityserver.domain.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysUserRepository extends JpaRepository<SysUser,Integer> {

    SysUser findByAccountId(String accountId);

}
