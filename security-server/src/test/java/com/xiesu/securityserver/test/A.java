package com.xiesu.securityserver.test;

import java.util.concurrent.ThreadLocalRandom;

public class A {
    public static void main(String[] args) {
       int s= ThreadLocalRandom.current().nextInt();
        System.out.println(s);
        System.out.println(ThreadLocalRandom.current().nextInt(2,6));
    }
}
