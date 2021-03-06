package com.jackpan.spring.ioc.dependency;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanDependencyInjectionConstructorBaseTest {

    @Test
    public void noExplicitlyDependencyInjection() {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("com/jackpan/spring/ioc/dependency/constructor-base.xml");
        ThingOne beanOne = ctx.getBean("beanOne", ThingOne.class);
        ThingTwo beanTwo = ctx.getBean("beanTwo", ThingTwo.class);
        ThingThree beanThree = ctx.getBean("beanThree", ThingThree.class);
    }

    @Test
    public void argumentTypeMatching() {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("com/jackpan/spring/ioc/dependency/constructor-base.xml");
        ExampleBean exampleBean = ctx.getBean("exampleBean", ExampleBean.class);
    }

    @Test
    public void argumentIndexMatching() {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("com/jackpan/spring/ioc/dependency/constructor-base.xml");
        ExampleBean exampleBean = ctx.getBean("exampleBean1", ExampleBean.class);
    }

    @Test
    public void argumentNameMatching() {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("com/jackpan/spring/ioc/dependency/constructor-base.xml");
        ExampleBean exampleBean = ctx.getBean("exampleBean2", ExampleBean.class);
    }

    @Test
    public void setterMethodDependency() {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("com/jackpan/spring/ioc/dependency/constructor-base.xml");
        ExampleBean exampleBean = ctx.getBean("exampleBean2", ExampleBean.class);
    }

    @Test
    public void factoryMethodDependency() {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("com/jackpan/spring/ioc/dependency/constructor-base.xml");
        ExampleBean exampleBean = ctx.getBean("exampleBean3", ExampleBean.class);

    }
}
