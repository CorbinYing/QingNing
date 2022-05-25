package com.xiesu.securityserver.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.xiesu.commonbase.domain.AbstractEntity;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@TableName("sys_role")
@ApiModel(value = "SysRole对象", description = "")
public class SysRole extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("角色")
    @TableField("role_name")
    private String roleName;

    @ApiModelProperty("描述")
    @TableField("role_desc")
    private String roleDesc;


}
