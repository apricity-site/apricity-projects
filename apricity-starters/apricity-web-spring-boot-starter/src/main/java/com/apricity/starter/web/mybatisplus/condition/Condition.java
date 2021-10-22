package com.apricity.starter.web.mybatisplus.condition;

import java.util.ArrayList;
import java.util.List;

public class Condition {

    /**
     * column name / _and _or
     */
    private final String key;
    private final List<Condition> childConditionList = new ArrayList<>();
    private final Class<?> javaType;
    private final String operator;
    private final Object value;
    private final boolean isCol;

    public Condition(String key,
                     List<Condition> childConditionList,
                     Class<?> javaType,
                     String operator,
                     Object value,
                     boolean isCol) {
        this.key = key;
        this.childConditionList.addAll(childConditionList);
        this.javaType = javaType;
        this.operator = operator;
        this.value = value;
        this.isCol = isCol;
    }

    public String toSqlSegment() {
        return null;
    }

    public String getKey() {
        return key;
    }

    public List<Condition> getChildConditionList() {
        return childConditionList;
    }

    public Class<?> getJavaType() {
        return javaType;
    }

    public String getOperator() {
        return operator;
    }

    public Object getValue() {
        return value;
    }

    public boolean isCol() {
        return isCol;
    }
}
