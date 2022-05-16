package com.xiesu.securityserver.domain.dto;

import com.xiesu.securityserver.domain.SysRole;
import com.xiesu.securityserver.domain.SysUser;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class UserRoleDto extends SysUser {

    private Set<SysRole> roleSet = new HashSet<>();
}
