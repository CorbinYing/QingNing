package com.xiesu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xiesu
 */ //@EnableEurekaClient
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@SpringBootApplication(scanBasePackages = "com.xiesu")
//@Import(ResponseHandlerAdvice.class)
//@EnableTransactionManagement
public class AuthorizationApplication {

    //@Bean
    //public Object printPlatformTransactionManagerBeanName(PlatformTransactionManager platformTransactionManager) {
    //    System.out.println(">>>>>>>>>>>" + platformTransactionManager.getClass().getName());
    //    return new Object();
    //}

    /**
     * 配置事务管理器，搭配@EnableTransactionManager使用，不过spring boot 已经默认开启了事务，只有项目大时才需要这么做
     */
//    @Bean
//    public PlatformTransactionManager txManager(EntityManagerFactory factory) {
//        return new JpaTransactionManager(factory);
//    }
    public static void main(String[] args) {
        SpringApplication.run(AuthorizationApplication.class, args);


    }

}
