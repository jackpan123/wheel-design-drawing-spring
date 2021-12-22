package com.jackpan.spring.ioc.configuration.methodinjectionn;

public interface Command {

    void setState(Object commandState);

    Object execute();
}
