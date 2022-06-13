package com.xiesu.bookkeeping.service;

import java.io.Serializable;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Teacher extends Persion implements Serializable {

    public int id;


    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Teacher)) {
            return false;
        }

        Teacher teacher = (Teacher) o;

        return new EqualsBuilder().append(id, teacher.id).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(id).toHashCode();
    }
}
