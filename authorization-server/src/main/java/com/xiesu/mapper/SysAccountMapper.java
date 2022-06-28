package com.xiesu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiesu.dto.AccountUKDto;
import com.xiesu.entity.SysAccount;
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
public interface SysAccountMapper extends BaseMapper<SysAccount> {

    /**
     * 默认delete_flag=0
     * 根据账户唯一属性查询账户信息，并级联查询角色信息，
     * 唯一属性包含id，accountId，mail，tel，后续添加微信，qq等，
     * 以上属性只需一个、多个均可
     *
     * @param account 账户id
     * @return SysAccount with SysRole
     */
   SysAccount findByUK(@Param("account") AccountUKDto account);

}
