package com.xiesu.securityserver.domain;

import com.xiesu.commonbase.domain.AbstractEntity;
import javax.persistence.Column;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@EqualsAndHashCode
@RestControllerAdvice
@Table(name = "sys_role")
public class SysRole extends AbstractEntity {


    @Column(name = "role_name")
    private String roleName;

    @Column(name = "role_desc")
    private String roleDesc;
}
