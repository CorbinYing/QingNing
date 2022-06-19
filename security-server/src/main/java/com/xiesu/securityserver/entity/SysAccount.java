package com.xiesu.securityserver.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.xiesu.common.domain.AbstractEntity;
import java.util.Set;
import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode(callSuper = true)
@TableName("sys_account")
public class SysAccount extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 账户唯一标识,允许数字字母下划线
     */
    @TableField("account_id")
    private String accountId;

    /**
     * 密码
     */
    @TableField("pwd")
    private String pwd;

    /**
     * 邮箱,逻辑上保持唯一
     */
    @TableField("mail")
    private String mail;

    /**
     * 电话,逻辑上保持唯一
     */
    @TableField("tel")
    private String tel;

    /**
     * 级联的角色信息
     */
    @TableField(exist = false)
    private Set<SysRole> roleSet;


}
