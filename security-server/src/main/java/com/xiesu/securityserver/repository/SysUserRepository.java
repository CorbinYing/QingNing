package com.xiesu.securityserver.repository;

import com.xiesu.securityserver.domain.SysUser;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface SysUserRepository extends JpaRepository<SysUser,Integer> {

   Optional<SysUser> findByUserId(@Param("uid") String uid);

}
