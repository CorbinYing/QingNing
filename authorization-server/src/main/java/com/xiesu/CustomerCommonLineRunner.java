package com.xiesu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
//定义多个CommandLineRunner时搭配@order 实现顺序启动，value越大，优先级越低

@Order(1)
@Component
public class CustomerCommonLineRunner implements CommandLineRunner {
  private final static   Logger logger = LoggerFactory.getLogger(CustomerCommonLineRunner.class);
    public void run(String... args) throws Exception {
        logger.info("程序启动》》》》开始自动执行CommandLineRunner自定义初始化操作》》》》》");
    }
}
