package com.xiesu.securityserver.domain;

import com.xiesu.commonbase.domain.AbstractEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@RestControllerAdvice
@Table(name = "sys_role")
public class SysRole extends AbstractEntity {


    private String roleName;
    private String roleDesc;
}
