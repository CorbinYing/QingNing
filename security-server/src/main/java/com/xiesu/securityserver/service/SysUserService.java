package com.xiesu.securityserver.service;

import com.xiesu.securityserver.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.Optional;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xiesu
 * @since 2022-05-25
 */
public interface SysUserService extends IService<SysUser> {

   Optional<SysUser>  selectByUid(String uid);

}
