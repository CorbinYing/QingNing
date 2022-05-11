package com.xiesu.commonbase.domain;


import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author xiesu
 */
public  abstract class AbstractEntity implements Serializable,Cloneable {


    private Integer id;

    private LocalDate createTime;

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
