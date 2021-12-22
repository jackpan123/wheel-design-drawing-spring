package com.jackpan.spring.bean.configuration.impl;

import com.jackpan.spring.bean.configuration.MyService;

public class MyServiceImpl implements MyService {
    @Override
    public void introduce() {
        System.out.println("It's a wheel design drawing for spring");
    }
}
