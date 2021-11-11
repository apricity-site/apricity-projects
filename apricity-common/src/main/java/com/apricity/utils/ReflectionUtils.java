package com.apricity.utils;

import org.springframework.util.Assert;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

public class ReflectionUtils extends org.springframework.util.ReflectionUtils {


    /**
     * 查找getter方法
     * @param obj bean
     * @param fieldName 字段名
     * @return Method
     */
    public static Method getReadMethod(Object obj, String fieldName) {
        Assert.notNull(fieldName, "field name must be not null");
        Field field = findField(obj.getClass(), fieldName);
        return getReadMethod(obj, field);
    }



    /**
     * 查找getter方法
     * @param obj bean
     * @param field 字段
     * @return Method
     */
    public static Method getReadMethod(Object obj, Field field) {
        Assert.notNull(field, "field ["+ field.getName() +"] must be not null");
        Class<?> clz = obj.getClass();
        Class<?> type = field.getType();
        Method method = findMethod(clz, "get" + StringUtils.capitalize(field.getName()));
        if (Objects.isNull(method) && (Boolean.TYPE == type || Boolean.class.isAssignableFrom(type))) {
            method = findMethod(clz, "is" + StringUtils.capitalize(field.getName()));
        }
        return method;
    }
}
