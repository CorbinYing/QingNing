package com.xiesu.commonbase.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author xiesu
 */
@Getter
@Setter
@MappedSuperclass()
public  abstract class AbstractEntity implements Serializable,Cloneable {


    @Id
    private Integer id;

    @Transient
    private LocalDate createTime;

    @Transient
    private LocalDate updateTime;








    @Override
    public AbstractEntity clone() {
        try {
            return (AbstractEntity) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
