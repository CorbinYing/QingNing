package com.xiesu.securityserver.domain;


import com.xiesu.commonbase.domain.AbstractEntity;
import com.xiesu.securityserver.domain.SysRole;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Getter
@Setter

@Entity
@Table(name = "sys_user")
public class SysUser extends AbstractEntity {


    private String accountId;
    private String pwd;

    @OneToMany
    private Set<SysRole> roleSet;

}
