package com.xiesu.securityserver.mapper;

import com.xiesu.securityserver.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xiesu
 * @since 2022-05-25
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    SysUser selectByUid(String uid);

}
