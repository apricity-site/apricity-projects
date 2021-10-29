package com.apricity.starter.web.properties;

import lombok.Data;

@Data
public class MybatisProperties {
    private boolean updateIfNull = true;
    private boolean camelToUnderline = true;
    private String tablePrefix = "";
}
