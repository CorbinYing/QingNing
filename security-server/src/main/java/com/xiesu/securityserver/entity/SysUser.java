package com.xiesu.securityserver.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.xiesu.commonbase.domain.AbstractEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author xiesu
 * @since 2022-05-25
 */
@Getter
@Setter
@TableName("sys_user")
@ApiModel(value = "SysUser对象", description = "")
public class SysUser extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户唯一id")
    @TableField("uid")
    private String uid;

    @ApiModelProperty("密码")
    @TableField("pwd")
    private String pwd;


    @ApiModelProperty("用户关联的角色")
    @TableField(exist = false)
    private Set<SysRole> roleSet = new HashSet<>();



}
