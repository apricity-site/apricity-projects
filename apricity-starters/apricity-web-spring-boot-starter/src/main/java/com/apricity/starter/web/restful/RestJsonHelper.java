package com.apricity.starter.web.restful;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapType;

import java.util.LinkedHashMap;

public class RestJsonHelper {

    /**
     *
     * convert json string to {@link LinkedHashMap }
     */
    public static LinkedHashMap<String, String> jsonStrToMap(String str, ObjectMapper objectMapper) throws JsonProcessingException {
        MapType javaType = objectMapper.getTypeFactory().constructMapType(LinkedHashMap.class, String.class, String.class);
        return objectMapper.readValue(str, javaType);
    }

}
