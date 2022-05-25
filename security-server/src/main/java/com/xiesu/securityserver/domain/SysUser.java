package com.xiesu.securityserver.domain;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.xiesu.commonbase.domain.AbstractEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xiesu
 */
@Getter
@Setter

@TableName(value = "sys_user")
@EqualsAndHashCode(callSuper = true)
public class SysUser extends AbstractEntity {

    private String userId;
    private String pwd;


    @TableField(exist = false)
    private Set<SysRole> roleSet = new HashSet<>();


}
