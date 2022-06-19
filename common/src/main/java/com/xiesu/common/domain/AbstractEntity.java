package com.xiesu.common.domain;


import com.baomidou.mybatisplus.annotation.*;
import com.xiesu.common.constant.ColumnConstant;
import java.util.Objects;
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


    /**
     * 主键
     */
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
     * 乐观锁字段
     */
    @Version
    @TableField(value = "version")
    private Integer version;

    /**
     * 删除标志，默认为0
     */
    @TableField(value = "delete_flag")
    private Long deleteFlag;

    /**
     * 该条记录是否是可用的
     * @return boolean
     */
    public boolean isUsable() {
        Objects.requireNonNull(deleteFlag);
        return ColumnConstant.INIT_DELETE_FLAG == deleteFlag;
    }

    @Override
    public AbstractEntity clone() {
        try {
            return (AbstractEntity) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AbstractEntity)) {
            return false;
        }
        AbstractEntity that = (AbstractEntity) o;
        return com.google.common.base.Objects.equal(id, that.id)
                && com.google.common.base.Objects.equal(createTime, that.createTime)
                && com.google.common.base.Objects.equal(updateTime, that.updateTime)
                && com.google.common.base.Objects.equal(version, that.version)
                && com.google.common.base.Objects.equal(deleteFlag, that.deleteFlag);
    }

    @Override
    public int hashCode() {
        return com.google.common.base.Objects.hashCode(id, createTime, updateTime, version,
                deleteFlag);
    }

}
