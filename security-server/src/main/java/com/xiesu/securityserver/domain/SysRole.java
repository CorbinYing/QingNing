package com.xiesu.securityserver.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.xiesu.commonbase.domain.AbstractEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@TableName(value = "sys_role")
public class SysRole extends AbstractEntity {

    private String roleName;

    private String roleDesc;

}
