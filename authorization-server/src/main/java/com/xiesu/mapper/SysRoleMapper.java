package com.xiesu.mapper;

import com.xiesu.entity.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.Set;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xiesu
 * @since 2022-06-03
 */
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {

   Set<SysRole> findByAccountId(@Param("accountId") String accountId);

}
