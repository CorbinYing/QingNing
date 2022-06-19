package com.xiesu.securityserver.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.xiesu.common.domain.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author xiesu
 * @since 2022-06-03
 */
@Getter
@Setter
@TableName("sys_account_role")
public class SysAccountRole extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 账户id
     */
    @TableField("account_id")
    private String accountId;

    /**
     * 角色
     */
    @TableField("role_name")
    private String roleName;


}
