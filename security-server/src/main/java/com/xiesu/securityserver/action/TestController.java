package com.xiesu.securityserver.action;

import com.xiesu.commonbase.controller.BaseController;
import com.xiesu.securityserver.domain.SysUser;
import com.xiesu.securityserver.service.SysUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController extends BaseController {
    @Autowired
    private SysUserServiceImpl sysUserService;

    @GetMapping(value = "/get-user")
    public SysUser getUser(@RequestParam String userName){
        return sysUserService.findByUserId(userName).orElse(null);
    }




}
