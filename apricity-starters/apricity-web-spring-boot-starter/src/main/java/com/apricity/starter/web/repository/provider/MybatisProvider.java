package com.apricity.starter.web.repository.provider;

import com.apricity.starter.web.repository.annotation.Table;
import com.apricity.utils.StringUtils;
import org.apache.ibatis.builder.annotation.ProviderContext;
import org.apache.ibatis.jdbc.SQL;

import java.beans.Introspector;
import java.lang.reflect.ParameterizedType;

public class MybatisProvider {

    public String listAll(ProviderContext ctx) {
        Class<?> mapperType = ctx.getMapperType();
        Class<?> entityClass = resolveEntityClass(mapperType);
        String tableName = resolveTableName(entityClass);
        SQL sql = new SQL();
        sql.SELECT("*").FROM(tableName);
        return sql.toString();
    }

    protected Class<?> resolveEntityClass(Class<?> mapperClass){
        ParameterizedType type = (ParameterizedType)mapperClass.getGenericInterfaces()[0];
        return (Class<?>) type.getActualTypeArguments()[0];
    }

    protected String resolveTableName(Class<?> entityClass) {
        Table annotation = entityClass.getAnnotation(Table.class);
        if (annotation != null) return annotation.value();
        return StringUtils.camelCaseToUnderscore(Introspector.decapitalize(entityClass.getName()));
    }


}
