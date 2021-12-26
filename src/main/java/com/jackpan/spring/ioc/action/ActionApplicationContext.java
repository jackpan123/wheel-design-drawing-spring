package com.jackpan.spring.ioc.action;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ActionApplicationContext implements ActionBeanFactory {

    private final Map<String, ActionBeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>(256);
    private final Map<String, Object> beanObjectMap = new ConcurrentHashMap<>(256);

    public ActionApplicationContext(Class<?> clazz) {
        try {
            registerBeanDefinition(clazz);
            preInstantiateSingletonBean();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Application init failed");
        }

    }

    private void preInstantiateSingletonBean() throws Exception {
        for (Map.Entry<String, ActionBeanDefinition> entry : beanDefinitionMap.entrySet()) {
            ActionBeanDefinition value = entry.getValue();
            if (value.getSingletonFlag() && !value.getConfigurationFlag()) {
                Class<?> clazz = value.getClazz();
                Object instance = clazz.newInstance();
                synchronized (this.beanObjectMap) {
                    beanObjectMap.put(value.getBeanName(), instance);
                }
            }
        }
    }

    private void registerBeanMethodBeanDefinition(Class<?> clazz) throws Exception {
        Object o = clazz.newInstance();
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (int i = 0; i < declaredMethods.length; i++) {
            Method declaredMethod = declaredMethods[i];
            Annotation[] annotations = declaredMethod.getAnnotations();
            Set<Class<? extends Annotation>> annotationSet = new HashSet<>();
            for (Annotation annotation : annotations) {
                annotationSet.add(annotation.annotationType());
            }

            if (annotationSet.contains(Bean.class)) {
                String beanName = declaredMethod.getName();
                Class<?> returnType = declaredMethod.getReturnType();
                ActionBeanDefinition actionBeanDefinition = new ActionBeanDefinition(beanName, returnType);
                actionBeanDefinition.setInstantiateComplete(true);
                if (annotationSet.contains(Scope.class)) {
                    Scope scope = declaredMethod.getAnnotation(Scope.class);
                    String value = scope.value();
                    if ("singleton".equals(value)) {
                        actionBeanDefinition.setSingletonFlag(true);
                        Bean annotation = declaredMethod.getAnnotation(Bean.class);
                        String[] nameArr = annotation.name();
                        Object invoke = declaredMethod.invoke(o);
                        if (nameArr.length > 0) {
                            for (int i1 = 0; i1 < nameArr.length; i1++) {
                                beanName = nameArr[i1];
                                beanObjectMap.put(beanName, invoke);
                            }
                        } else {
                            beanObjectMap.put(beanName, invoke);
                        }
                    }
                }

                beanDefinitionMap.put(beanName, actionBeanDefinition);
            }
        }
    }

    private void registerBeanDefinition(Class<?> clazz) throws Exception {
        String beanName = clazz.getName();
        ActionBeanDefinition beanDefinition = new ActionBeanDefinition(beanName, clazz);
        beanDefinition.setConfigurationFlag(true);
        synchronized (this.beanDefinitionMap) {
            beanDefinitionMap.put(beanName, beanDefinition);
        }
        registerBeanMethodBeanDefinition(clazz);

    }


    @Override
    public Object getBean(String name) {
        ActionBeanDefinition beanDefinition = beanDefinitionMap.get(name);
        if (beanDefinition == null) {
            return null;
        } else {
            if (beanDefinition.getSingletonFlag()) {
                return beanObjectMap.get(name);
            } else {
                try {
                    return beanDefinition.getClazz().newInstance();
                } catch (Exception e) {
                    throw new RuntimeException("Bean creation fail");
                }
            }
        }
    }
}
