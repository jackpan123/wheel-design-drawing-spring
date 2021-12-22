package com.jackpan.spring.bean.configuration.methodinjectionn;

public interface Command {

    void setState(Object commandState);

    Object execute();
}
