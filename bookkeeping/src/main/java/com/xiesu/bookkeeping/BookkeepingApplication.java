package com.xiesu.bookkeeping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//需要指明扫描路径，否则不会扫描被引入模块的bean（）
@SpringBootApplication(scanBasePackages = "com.xiesu.**")
public class BookkeepingApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookkeepingApplication.class, args);
    }

}
