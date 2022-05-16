package com.xiesu.securityserver.domain;


import com.xiesu.commonbase.domain.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter

@Entity
@Table(name = "sys_user")
public class SysUser extends AbstractEntity {

    private String accountId;
    private String pwd;


}
