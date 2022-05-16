package com.xiesu.securityserver.domain;

import com.xiesu.commonbase.domain.AbstractEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


/**
 * @author xiesu
 */
@Table(name = "sys_user_role")
@Getter
@Setter
@Entity
@EqualsAndHashCode
public class SysUserRole extends AbstractEntity {

    @Column(name = "uid")
    private String uid;
    @Column(name = "role_name")
    private String roleName;

}
