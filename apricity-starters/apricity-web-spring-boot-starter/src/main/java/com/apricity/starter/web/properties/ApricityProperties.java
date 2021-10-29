package com.apricity.starter.web.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@Getter
@Setter
@ConfigurationProperties(prefix = "apricity")
public class ApricityProperties {
    @NestedConfigurationProperty
    private MybatisProperties mybatis;
}
