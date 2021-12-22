package com.jackpan.spring.java;

import com.jackpan.spring.configuration.java.AppConfig;
import com.jackpan.spring.configuration.java.MyService;
import com.jackpan.spring.configuration.java.OtherConfig;
import com.jackpan.spring.configuration.java.StuffService;
import com.jackpan.spring.configuration.java.declarebean.TransferServiceImpl;
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

    @Test
    public void buildContainerByRegister() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class, OtherConfig.class);
        ctx.refresh();
        StuffService stuffService = ctx.getBean("stuffService", StuffService.class);
        stuffService.doStuff();
    }

    @Test
    public void componentScan() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.scan("com.jackpan");
        ctx.refresh();
        MyService myService = ctx.getBean("myService", MyService.class);
        myService.introduce();
    }

    @Test
    public void multipleDeclareBean() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        // normal way
        MyService myService = ctx.getBean("myService", MyService.class);
        myService.introduce();

        // within interface declare bean
        TransferServiceImpl transferServiceImpl = ctx.getBean("transferService", TransferServiceImpl.class);
        transferServiceImpl.doTransfer();
    }

    @Test
    public void beanDependencies() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        // Get MyService bean dependency.
        TransferServiceImpl transferServiceImpl1 = ctx.getBean("transferService1", TransferServiceImpl.class);
        transferServiceImpl1.doMyServiceMethod();


    }
}
