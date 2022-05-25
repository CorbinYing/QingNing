package com.xiesu.commonbase.domain;


import com.baomidou.mybatisplus.annotation.*;
import lombok.Getter;
import lombok.Setter;


import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author xiesu
 */
@Getter
@Setter
public abstract class AbstractEntity implements Serializable, Cloneable {


    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;


    /**
     * 字段注解只有使用mybaties plus的操作逻辑才有，使用xml定义的sql不生效
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDate createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDate updateTime;

    /**
     * 乐观锁
     */
    @Version
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
