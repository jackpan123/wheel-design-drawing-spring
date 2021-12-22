package com.jackpan.spring.bean.dependency;

import org.springframework.beans.factory.annotation.Autowired;

public class ExampleBean {

    // Number of years to calculate the Ultimate Answer
    private int years;

    private AnotherBean anotherBean;

    private YetAnthoerBean yetAnthoerBean;

    private int i;

    // The Answer to Life, the Universe, and Everything
    private String ultimateAnswer;

    public ExampleBean() {

    }

    public ExampleBean(AnotherBean anotherBean, YetAnthoerBean yetAnthoerBean, int i) {
        this.anotherBean = anotherBean;
        this.yetAnthoerBean = yetAnthoerBean;
        this.i = i;
    }

    public ExampleBean(int years, String ultimateAnswer) {
        this.years = years;
        this.ultimateAnswer = ultimateAnswer;
    }


    public void setAnotherBean(AnotherBean anotherBean) {
        this.anotherBean = anotherBean;
    }

    public void setYetAnthoerBean(YetAnthoerBean yetAnthoerBean) {
        this.yetAnthoerBean = yetAnthoerBean;
    }

    public void setIntegerProperty(int i) {
        this.i = i;
    }

    public static ExampleBean createInstance(AnotherBean anotherBean, YetAnthoerBean yetAnthoerBean, int i) {
        ExampleBean exampleBean = new ExampleBean(anotherBean, yetAnthoerBean, i);
        return exampleBean;
    }
}
