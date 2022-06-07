package com.xiesu.securityserver.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.google.common.base.Objects;
import com.xiesu.commonbase.domain.AbstractEntity;
import java.io.Serializable;
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
@TableName("sys_role")
public class SysRole extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色名
     */
    @TableField("role_name")
    private String roleName;

    /**
     * 角色描述
     */
    @TableField("role_desc")
    private String roleDesc;



}
