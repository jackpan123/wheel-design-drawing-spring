package com.jackpan.spring.bean.dependency;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanDependencyInjectionConstructorBaseTest {

    @Test
    public void noExplicitlyDependencyInjection() {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("com/jackpan/spring/bean/dependency/constructor-base.xml");
        ThingOne beanOne = ctx.getBean("beanOne", ThingOne.class);
        ThingTwo beanTwo = ctx.getBean("beanTwo", ThingTwo.class);
        ThingThree beanThree = ctx.getBean("beanThree", ThingThree.class);
    }
}
