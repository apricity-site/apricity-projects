package com.apricity.starter.web.repository;

import com.apricity.exception.UnexpectedException;
import com.apricity.starter.web.properties.MybatisProperties;

import java.lang.reflect.ParameterizedType;

public class RepositoryHelper {

    private static MybatisProperties config;

    public static Class<?> getEntityClass(Class<?> mapperClass) {
        if (!mapperClass.isAssignableFrom(Repository.class)) throw new UnexpectedException("Unsupported");
        ParameterizedType type = (ParameterizedType)mapperClass.getGenericInterfaces()[0];
        return (Class<?>) type.getActualTypeArguments()[0];
    }

    public static void setGlobalConfig(MybatisProperties globalConfig) {
        config = globalConfig;
    }

    public static MybatisProperties getGlobalConfig() {
        return config;
    }

}
