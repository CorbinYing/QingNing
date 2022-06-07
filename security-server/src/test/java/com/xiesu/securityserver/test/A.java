package com.xiesu.securityserver.test;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class A {
    public static void main(String[] args) {
       int s= ThreadLocalRandom.current().nextInt();
        System.out.println(s);
        System.out.println(ThreadLocalRandom.current().nextInt(2,6));

        Function<String, String> passwordEncoder = (password) -> password;
        String ss=null;
        String a=passwordEncoder.apply(ss);
        System.out.println(a);

        System.out.println(new BCryptPasswordEncoder().encode("123456"));
    }
}
