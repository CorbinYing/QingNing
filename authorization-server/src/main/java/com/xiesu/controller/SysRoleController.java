package com.xiesu.controller;

import com.xiesu.common.handler.ResponseHandlerAdvice;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.xiesu.common.controller.BaseController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xiesu
 * @since 2022-06-03
 */
@RestController
@RequestMapping("/security-server/sys-role")
public class SysRoleController extends BaseController {

    @Autowired
    private ApplicationContext applicationContext;
    @GetMapping("/1")
    public int test1(){
    Object o=    applicationContext.getBean(ResponseHandlerAdvice.class);
        System.out.println(o);
        return 1;
    }


    @GetMapping("/2")
    public Map<String,Object> test2(){
        Map<String,Object> map=new HashMap<>();
        map.put("1","2");
        return map;
    }
}
