package com.jackpan.spring.ioc.action;

public class ActionBeanDefinition {

    private boolean singletonFlag = true;

    private String beanName;

    private Class<?> clazz;

    private boolean configurationFlag = false;

    private boolean instantiateComplete = false;
    public ActionBeanDefinition(String beanName, Class<?> clazz) {
        this.beanName = beanName;
        this.clazz = clazz;
    }

    public boolean isSingleton() {
        return singletonFlag;
    }

    public boolean getSingletonFlag() {
        return singletonFlag;
    }

    public void setSingletonFlag(boolean singletonFlag) {
        this.singletonFlag = singletonFlag;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }

    public boolean getConfigurationFlag() {
        return configurationFlag;
    }

    public void setConfigurationFlag(boolean configurationFlag) {
        this.configurationFlag = configurationFlag;
    }

    public boolean getInstantiateComplete() {
        return instantiateComplete;
    }

    public void setInstantiateComplete(boolean instantiateComplete) {
        this.instantiateComplete = instantiateComplete;
    }
}
