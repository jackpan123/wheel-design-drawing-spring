package com.jackpan.spring.configuration.java.declarebean;

import com.jackpan.spring.configuration.java.MyService;

public class TransferServiceImpl {

    private MyService myService;

    public void doTransfer() {
        System.out.println("I will transfer");
    }

    public void doMyServiceMethod() {
        myService.introduce();
    }

    public void setMyService(MyService myService) {
        this.myService = myService;
    }
}
