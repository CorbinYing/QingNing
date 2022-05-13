package com.xiesu.securityserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@EnableEurekaClient
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@SpringBootApplication
@EnableTransactionManagement
public class SecurityServerApplication {




    public static void main(String[] args) {
        SpringApplication.run(SecurityServerApplication.class, args);
    }







    @Bean
    public Object testBean(PlatformTransactionManager platformTransactionManager) {
        System.out.println(">>>>>>>>>>>" + platformTransactionManager.getClass().getName());
        return new Object();
    }

    /**
     * 配置事务管理器，搭配@EnableTransactionManager使用，不过spring boot 已经默认开启了事务，只有项目大时才需要这么做
     *
     * @param factory
     * @return
     */
    @Bean
    public PlatformTransactionManager txManager(EntityManagerFactory factory) {
        return new JpaTransactionManager(factory);
    }

}
