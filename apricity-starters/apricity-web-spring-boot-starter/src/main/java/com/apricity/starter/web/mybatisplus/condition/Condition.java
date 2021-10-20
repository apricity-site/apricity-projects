package com.apricity.starter.web.mybatisplus.condition;

import com.apricity.starter.web.mybatisplus.condition.parser.LocalDateConditionParser;
import com.apricity.starter.web.mybatisplus.condition.parser.LocalDateTimeConditionParser;
import com.apricity.starter.web.mybatisplus.condition.parser.NumberConditionParser;
import com.apricity.starter.web.mybatisplus.condition.parser.StringConditionParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class Condition {

    private static final Map<String, BiFunction<String, String, String>> conditionMap = new HashMap<>();
    private static final List<ConditionInterceptor> interceptors = new ArrayList<>();

    static {
        conditionMap.put("S_LL",     (c, v) -> new StringConditionParser("S_LL").parse(c, v));
        conditionMap.put("S_L",      (c, v) -> new StringConditionParser("S_L").parse(c, v));
        conditionMap.put("S_LR",     (c, v) -> new StringConditionParser("S_LR").parse(c, v));
        conditionMap.put("S_EQ",     (c, v) -> new StringConditionParser("S_EQ").parse(c, v));

        conditionMap.put("S_LL_CI",   (c, v) -> new StringConditionParser("S_LL_CI").parse(c, v));
        conditionMap.put("S_L_CI",    (c, v) -> new StringConditionParser("S_L_CI").parse(c, v));
        conditionMap.put("S_LR_CI",    (c, v) -> new StringConditionParser("S_LR_CI").parse(c, v));
        conditionMap.put("S_EQ_CI",   (c, v) -> new StringConditionParser("S_EQ_CI").parse(c, v));

        conditionMap.put("D_GT",      (c, v) -> new LocalDateConditionParser("D_GT").parse(c, v));
        conditionMap.put("D_GE",    (c, v) -> new LocalDateConditionParser("D_GE").parse(c, v));
        conditionMap.put("D_LT",      (c, v) -> new LocalDateConditionParser("D_LT").parse(c, v));
        conditionMap.put("D_LE",    (c, v) -> new LocalDateConditionParser("D_LE").parse(c, v));
        conditionMap.put("D_EQ",     (c, v) -> new LocalDateConditionParser("D_EQ").parse(c, v));
        conditionMap.put("D_R",      (c, v) -> new LocalDateConditionParser("D_R").parse(c, v));
        conditionMap.put("T_GT",      (c, v) -> new LocalDateTimeConditionParser("T_GT").parse(c, v));
        conditionMap.put("T_GE",    (c, v) -> new LocalDateTimeConditionParser("T_GE").parse(c, v));
        conditionMap.put("T_LT",      (c, v) -> new LocalDateTimeConditionParser("T_LT").parse(c, v));
        conditionMap.put("T_EQ",     (c, v) -> new LocalDateTimeConditionParser("T_EQ").parse(c, v));
        conditionMap.put("T_LE",    (c, v) -> new LocalDateTimeConditionParser("T_LE").parse(c, v));
        conditionMap.put("T_R",      (c, v) -> new LocalDateTimeConditionParser("T_R").parse(c, v));

        conditionMap.put("N_GT",    (c, v) -> new NumberConditionParser("N_GT").parse(c, v));
        conditionMap.put("N_GE",    (c, v) -> new NumberConditionParser("N_GE").parse(c, v));
        conditionMap.put("N_LT",    (c, v) -> new NumberConditionParser("N_LT").parse(c, v));
        conditionMap.put("N_LE",    (c, v) -> new NumberConditionParser("N_LE").parse(c, v));
        conditionMap.put("N_EQ",    (c, v) -> new NumberConditionParser("N_EQ").parse(c, v));
        conditionMap.put("N_R",     (c, v) -> new NumberConditionParser("N_R").parse(c, v));

        conditionMap.put("NE",  (c, v) -> new StringConditionParser("CISEQ").parse(c, v));

        conditionMap.put("NIN",     (c, v) -> new StringConditionParser("CISEQ").parse(c, v));
        conditionMap.put("DIN",     (c, v) -> new StringConditionParser("CISEQ").parse(c, v));
        conditionMap.put("TIN",     (c, v) -> new StringConditionParser("CISEQ").parse(c, v));
        conditionMap.put("IN",      (c, v) -> new StringConditionParser("CISEQ").parse(c, v));
    }

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
