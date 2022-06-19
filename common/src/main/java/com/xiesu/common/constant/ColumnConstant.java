package com.xiesu.common.constant;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * 数据库字段默认常量值
 */
public abstract class ColumnConstant implements Serializable {

    /**
     * 版本号默认值
     */
    public final static int INIT_VERSION = 0;
    /**
     * 删除标志默认值
     */
    public final static int INIT_DELETE_FLAG = 0;

    /**
     * 当前时间,用于update_time,create_time
     *
     * @return LocalDate
     */
    public static LocalDate presentTime() {
        return LocalDate.now();
    }

    /**
     * 更新删除标志时，返回时间戳
     *
     * @return 时间戳
     */
    public static Long updateDeleteFlag() {
        return System.currentTimeMillis();
    }

    /**
     * 更新版本时，版本+1
     * @param version int型
     * @return version+1
     */
    public static int updateVersion(int version) {
        return ++version;
    }

}
