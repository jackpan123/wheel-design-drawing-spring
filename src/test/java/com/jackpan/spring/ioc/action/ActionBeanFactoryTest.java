package com.jackpan.spring.ioc.action;

import com.jackpan.spring.ioc.configuration.AppConfig;
import com.jackpan.spring.ioc.configuration.impl.MyServiceImpl;
import org.junit.Test;

public class ActionBeanFactoryTest {

    @Test
    public void beanFactoryTest() {
        ActionBeanFactory beanFactory = new ActionApplicationContext(AppConfig.class);
        MyServiceImpl myService = (MyServiceImpl) beanFactory.getBean("myService");
        myService.introduce();
    }
}
