package com.xiesu.securityserver.domain;


import com.xiesu.commonbase.domain.AbstractEntity;
import javax.persistence.Column;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter

@Entity
@Table(name = "sys_user")
@EqualsAndHashCode
public class SysUser extends AbstractEntity {

    @Column(name = "uid")
    private String userId;
    @Column(name = "pwd")
    private String pwd;


}
