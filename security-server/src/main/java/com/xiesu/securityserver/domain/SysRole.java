package com.xiesu.securityserver.domain;

import com.baomidou.mybatisplus.annotation.TableField;
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


    @TableField(value = "role_name")
    private String roleName;

    @Column(name = "role_desc")
    private String roleDesc;

}
