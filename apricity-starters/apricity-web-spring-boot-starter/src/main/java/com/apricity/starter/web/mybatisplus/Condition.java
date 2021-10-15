package com.apricity.starter.web.mybatisplus;

public class Condition {
    private final String column;
    private final Object value;
    private final String condition;

    public Condition(String column, Object value, String condition) {
        this.column = column;
        this.value = value;
        this.condition = condition;
    }

    public String getColumn() {
        return column;
    }

    public Object getValue() {
        return value;
    }

    public String getCondition() {
        return condition;
    }
}
