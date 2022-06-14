package com.xiesu.bookkeeping.controller;

import com.xiesu.bookkeeping.service.Teacher;
import com.xiesu.commonbase.except.ExposedException;
import com.xiesu.commonbase.handler.ResponseHandlerAdvice;
import com.xiesu.commonbase.response.ResponseCode;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    ApplicationContext applicationContext;
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


    @GetMapping("/3")
    public Teacher testw2(){
        Teacher teacher=new Teacher();
        teacher.id=1;
        return teacher;
    }

    @GetMapping("/4")
    public Map<Teacher,Teacher> te2stw2(){
        final Teacher teacher=new Teacher();
        teacher.id=1;
        return new HashMap<Teacher,Teacher>(){{put(teacher,teacher);}};
    }


    @GetMapping("/5")
    public String testww2(){
        return "1";
    }



    @GetMapping("/6")
    public String teswwtww2(){
        throw new ExposedException(ResponseCode.SUCC_0, new Object[]{"zhangsan，lisi，王武"});
    }
}
