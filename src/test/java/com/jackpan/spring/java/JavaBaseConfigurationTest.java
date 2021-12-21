package com.jackpan.spring.java;

import com.jackpan.spring.configuration.java.AppConfig;
import com.jackpan.spring.configuration.java.MyService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaBaseConfigurationTest {

    @Test
    public void simpleConstruction() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        MyService myService = ctx.getBean("myService", MyService.class);
        myService.introduce();
    }
}
