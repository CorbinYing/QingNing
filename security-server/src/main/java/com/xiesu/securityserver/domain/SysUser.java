package com.xiesu.securityserver.domain;


import com.xiesu.commonbase.domain.AbstractEntity;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author xiesu
 */
@Getter
@Setter

@Entity
@Table(name = "sys_user")
@EqualsAndHashCode(callSuper = true)
public class SysUser extends AbstractEntity {

    @Column(name = "uid")
    private String userId;
    @Column(name = "pwd")
    private String pwd;

    @ManyToMany
    @JoinTable(name = "sys_user_role", joinColumns = {
            @JoinColumn(name = "uid", referencedColumnName = "uid",table = "sys_user"),
    }
            , inverseJoinColumns = {
            @JoinColumn(name = "role_name", referencedColumnName = "role_name",table = "sys_role")
    })
    private Set<SysRole> roleSet = new HashSet<>();


}
