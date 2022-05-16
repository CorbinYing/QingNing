package com.xiesu.securityserver.repository;

import com.xiesu.securityserver.domain.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SysUserRepository extends JpaRepository<SysUser,Integer> {

   Optional<SysUser> findByAccountId(String accountId);

}
