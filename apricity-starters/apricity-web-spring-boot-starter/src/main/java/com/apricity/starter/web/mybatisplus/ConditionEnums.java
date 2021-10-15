package com.apricity.starter.web.mybatisplus;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public enum ConditionEnums {
    SB(String.class, null), // 字符串左对齐
    SC(String.class, null), // 字符串居中对齐
    SE(String.class, null), // 字符串右对齐
    SEQ(String.class, null), // 字符串相等

    CISB(String.class, null), // 字符串不区分大小写左对齐
    CISC(String.class, null), // 字符串不区分大小写居中对齐
    CISE(String.class, null), // 字符串不区分大小写右对齐
    CISEQ(String.class, null), // 字符串不区分大小写相等

    DG(LocalDate.class, null), // 日期大于
    DGOE(LocalDate.class, null), // 日期大于等于
    DL(LocalDate.class, null), // 日期小于
    DLOE(LocalDate.class, null), // 日期小于等于
    DEQ(LocalDate.class, null), // 日期相等
    DR(LocalDate.class, null), // 日期区间查询（(d1,d2]-不含左、含右 [d1,d2)-含左、不含右等等）
    TG(LocalDateTime.class, null), // 时间大于
    TGOE(LocalDateTime.class, null), // 时间大于等于
    TL(LocalDateTime.class, null), // 时间小于
    TLOE(LocalDateTime.class, null), // 时间小于等于
    TEQ(LocalDateTime.class, null), // 时间相等
    TR(LocalDateTime.class, null), // 时间区间查询（(d1,d2]-不含左、含右 [d1,d2)-含左、不含右等等）

    NG(Double.class, null), // 数字大于
    NGOE(Double.class, null), // 数字大于等于
    NL(Double.class, null), // 数字小于
    NLOE(Double.class, null), // 数字小于等于
    NEQ(Double.class, null), // 数字相等
    NR(Double.class, null), // 数字区间查询（(n1,n2]-不含左、含右 [n1,n2)-含左、不含右等等）

    DIFFER(Void.class, null), // 不相等

    NIN(Double.class, null), // 数字
    DIN(LocalDate.class, null), // 日期
    TIN(LocalDateTime.class, null), // 日期时间
    IN(String.class, null); // IN语句

    private final Class<?> type;
    private final Function<String, List<Condition>> conditionParser;

    private ConditionEnums(Class<?> type,Function<String, List<Condition>> conditionParser) {
        this.type = type;
        this.conditionParser = conditionParser;
    }

    public ConditionEnums getCondition(String conditionName) {
        if (StringUtils.isBlank(conditionName)) return null;
        return Arrays.stream(values()).filter(c -> c.name().equals(conditionName)).findFirst().orElse(null);
    }
}
