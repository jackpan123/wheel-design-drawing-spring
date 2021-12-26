package com.jackpan.spring.ioc.action;

public interface ActionBeanFactory {


    /**
     * 根据名称获取Bean
     * Get Bean according to name
     * @param name Bean名称
     * @return
     */
    Object getBean(String name);

}
