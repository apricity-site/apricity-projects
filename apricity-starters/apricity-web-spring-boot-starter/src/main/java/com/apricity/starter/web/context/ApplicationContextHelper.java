package com.apricity.starter.web.context;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.Environment;

public class ApplicationContextHelper implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextHelper.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext(){
        return ApplicationContextHelper.applicationContext;
    }

    public static SqlSessionTemplate getMybatisSqlSessionTemplate() {
        return getApplicationContext().getBean(SqlSessionTemplate.class);
    }

    public static <T> T getBean(Class<T> clazz){
        return getApplicationContext().getBean(clazz);
    }

    @SuppressWarnings("unchecked")
    public static <T> T getBean(String beanName){
        return (T)getApplicationContext().getBean(beanName);
    }

    public static Environment getEnvironment() {
        return getApplicationContext().getEnvironment();
    }

    public static String getProperty(String name){
        return getApplicationContext().getEnvironment().getProperty(name);
    }

}
