package com.xiesu.securityserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


//定义多个ApplicationRunner时搭配@order 实现顺序启动，value越大，优先级越低

@Order(2)
@Component
public class CustomerApplicationRunner implements ApplicationRunner {
    private final static Logger logger = LoggerFactory.getLogger(CustomerCommonLineRunner.class);

    public void run(ApplicationArguments args) throws Exception {
        logger.info("程序启动》》》》开始自动执行ApplicationRunner自定义初始化操作》》》》》");
    }
}
