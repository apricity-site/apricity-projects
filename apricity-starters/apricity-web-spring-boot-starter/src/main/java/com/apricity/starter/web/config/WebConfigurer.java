package com.apricity.starter.web.config;

import com.apricity.starter.web.restful.resolver.ToRestJsonResolver;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Import({ WebConfigurer.class })
public class WebConfigurer implements WebMvcConfigurer {

    private final ObjectMapper objectMapper;

    @Autowired
    public WebConfigurer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new ToRestJsonResolver(objectMapper));
    }
}
