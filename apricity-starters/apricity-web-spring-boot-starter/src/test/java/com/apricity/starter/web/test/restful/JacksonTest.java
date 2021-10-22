package com.apricity.starter.web.test.restful;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

public class JacksonTest {
    @Test
    void jacksonFieldOrderTest() throws JsonProcessingException {
        String origin = "{\n" +
                "    \"1\": 1,\n" +
                "    \"2\": 2,\n" +
                "    \"3\":3,\n" +
                "    \"c\": 1,\n" +
                "    \"b\": 3\n" +
                "}";
        ObjectMapper objectMapper = new ObjectMapper();
        final JavaType javaType = objectMapper.getTypeFactory().constructParametricType(LinkedHashMap.class, String.class, String.class);
        final LinkedHashMap<String, String> o = objectMapper.readValue(origin, javaType);
        System.out.println("finish");
    }
}
