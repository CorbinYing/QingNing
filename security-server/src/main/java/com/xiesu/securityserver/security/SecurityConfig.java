package com.xiesu.securityserver.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * description: Security配置 <br> date: 2021/7/31 18:15 <br> author: ztz <br> version: 1.0 <br>
 */
@Configuration





@EnableWebSecurity
//开启方法权限注解支持
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailServiceImpl userDetailsService;

    /**
     * @param auth
     * @Description 认证
     * @author Tansty
     * @date 2021/8/3 14:14
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //auth.userDetailsService(userDetailsService).passwordEncoder(new MyPasswordEncoder());
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    /**
     * @param web
     * @Description 配置静态资源的过滤
     * @author Tansty
     * @date 2021/8/3 14:14
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        // 配置静态文件不需要认证
        web.ignoring().antMatchers(
                "/swagger-ui.html",
                // swagger api json
                "/v2/api-docs",
                // 用来获取支持的动作
                "/swagger-resources/configuration/ui",
                // 用来获取api-docs的URI
                "/swagger-resources",
                // 安全选项
                "/swagger-resources/configuration/security",
                "/swagger-resources/**",
                "/webjars/**",
                "/druid/**"
        );
    }
//
//    /**
//     * @param http
//     * @Description 授权
//     * @author Tansty
//     * @date 2021/8/3 14:14
//     */
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.cors().and().csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/auth/login").permitAll()
//                .antMatchers("/test/**").permitAll()
//                .antMatchers("/user/**").permitAll()
//                //.antMatchers("/pet/**").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
//                .addFilter(new JWTAuthorizationFilter(authenticationManager()))
//                // 不需要session
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .exceptionHandling().authenticationEntryPoint(new JWTAuthenticationEntryPoint())
//                // 添加无权限时的处理
//                .accessDeniedHandler(new JWTAccessDeniedHandler());
//
//    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(new SecurityPasswordEncoder());
        daoAuthenticationProvider.setHideUserNotFoundExceptions(false);
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        return daoAuthenticationProvider;
    }


}

