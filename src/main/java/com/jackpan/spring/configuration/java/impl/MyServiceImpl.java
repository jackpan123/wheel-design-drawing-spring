package com.jackpan.spring.configuration.java.impl;

import com.jackpan.spring.configuration.java.MyService;

public class MyServiceImpl implements MyService {
    @Override
    public void introduce() {
        System.out.println("It's a wheel design drawing for spring");
    }
}
