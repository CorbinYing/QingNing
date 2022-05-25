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
@TableName("sys_user_role")
@ApiModel(value = "SysUserRole对象", description = "")
public class SysUserRole extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("账户id")
    @TableField("uid")
    private String uid;

    @TableField("role_name")
    private String roleName;


}
