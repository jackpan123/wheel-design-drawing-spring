package com.jackpan.spring.ioc.configuration.methodinjectionn;

public class AsyncCommand implements Command {

    int executeNum = 0;
    @Override
    public void setState(Object commandState) {

    }

    @Override
    public Object execute() {
        System.out.println(++executeNum);
        return null;
    }
}
