package com.xiesu.securityserver.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.xiesu.commonbase.domain.AbstractEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


/**
 * @author xiesu
 */
@TableName(value = "sys_user_role")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class SysUserRole extends AbstractEntity {
    private String uid;
    private String roleName;

}
