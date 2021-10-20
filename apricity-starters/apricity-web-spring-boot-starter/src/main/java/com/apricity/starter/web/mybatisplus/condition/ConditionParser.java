package com.apricity.starter.web.mybatisplus.condition;

public abstract class ConditionParser {
    public abstract String parse(String columnAndPattern, String value);
}
