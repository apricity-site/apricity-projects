package com.apricity.starter.web.repository;

import com.apricity.exception.UnexpectedException;

import java.lang.reflect.ParameterizedType;

public class RepositoryHelper {

    public static Class<?> getEntityClass(Class<?> mapperClass) {
        if (!mapperClass.isAssignableFrom(Repository.class)) throw new UnexpectedException("Unsupported");
        ParameterizedType type = (ParameterizedType)mapperClass.getGenericInterfaces()[0];
        return (Class<?>) type.getActualTypeArguments()[0];
    }

}
