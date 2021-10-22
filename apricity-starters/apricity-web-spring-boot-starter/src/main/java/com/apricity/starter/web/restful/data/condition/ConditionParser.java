package com.apricity.starter.web.restful.data.condition;

public abstract class ConditionParser {
    public abstract String parse(String columnAndPattern, String value);
}
