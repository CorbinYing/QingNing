package com.xiesu.bookkeeping.service;

import org.springframework.transaction.annotation.Transactional;

public class TestService {



    @Transactional()
    public String get(String o){
        return o;
    }
}
