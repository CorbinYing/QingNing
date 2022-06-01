package com.xiesu.securityserver.action;

import com.xiesu.commonbase.controller.BaseController;
import com.xiesu.securityserver.entity.SysRole;
import com.xiesu.securityserver.entity.SysUser;
import com.xiesu.securityserver.service.SysUserService;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController extends BaseController {
    @Autowired
    private SysUserService sysUserService;

    @GetMapping(value = "/get-user")
    public SysUser getUser(@RequestParam String userName){

        SysUser user  =sysUserService.selectByUid(userName).get();
        Set<SysRole> roleSet=user.getRoleSet();
        System.out.println(user);
        System.out.println(roleSet);
                return user;
    }
}
