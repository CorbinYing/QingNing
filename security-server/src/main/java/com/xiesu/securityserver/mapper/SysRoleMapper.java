package com.xiesu.securityserver.mapper;

import com.xiesu.securityserver.entity.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.Set;
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
public interface SysRoleMapper extends BaseMapper<SysRole> {

    /**
     * 查询用户的角色
     * @param uid
     * @return
     */
    Set<SysRole> selectByUserUid(String uid);


}
