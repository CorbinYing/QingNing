package com.xiesu.commonbase.domain;


import lombok.Getter;
import lombok.Setter;


import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author xiesu
 */
@Getter
@Setter
public  abstract class AbstractEntity implements Serializable,Cloneable {


    private Integer id;

    private LocalDate createTime;

    private LocalDate updateTime;

    private Integer version;








    @Override
    public AbstractEntity clone() {
        try {
            return (AbstractEntity) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
