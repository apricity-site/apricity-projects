package com.apricity.starter.web.config;

import com.apricity.starter.web.context.ApplicationContextHelper;
import com.apricity.starter.web.properties.ApricityProperties;
import com.apricity.starter.web.repository.RepositoryInitializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Import({RepositoryInitializer.class, ApplicationContextHelper.class})
@EnableConfigurationProperties(ApricityProperties.class)
public class ApricityWebAutoConfig implements InitializingBean {

    @Bean
    @Primary
    @ConditionalOnMissingBean(ObjectMapper.class)
    public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder builder){
        // 通过该方法对mapper对象进行设置，所有序列化的对象都将按改规则进行系列化
        // Include.Include.ALWAYS 默认
        // Include.NON_DEFAULT 属性为默认值不序列化
        // Include.NON_EMPTY 属性为 空（""） 或者为 NULL 都不序列化，则返回的json是没有这个字段的。这样对移动端会更省流量
        // Include.NON_NULL 属性为NULL 不序列化
        return builder.createXmlMapper(false).build();
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
