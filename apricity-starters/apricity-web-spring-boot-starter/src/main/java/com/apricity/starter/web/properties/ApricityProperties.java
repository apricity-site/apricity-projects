package com.apricity.starter.web.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@ConfigurationProperties(prefix = "apricity")
public class ApricityProperties {
    @NestedConfigurationProperty
    private MybatisProperties mybatis;
}
