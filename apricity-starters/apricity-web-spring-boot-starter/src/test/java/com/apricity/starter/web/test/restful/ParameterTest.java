package com.apricity.starter.web.test.restful;

import com.apricity.starter.web.restful.data.Parameter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParameterTest {
    @Test
    void testExtParamToJSONString() throws JsonProcessingException {
        Parameter param = new Parameter();
        param.putExtItem("hello", "world");
        String result = new ObjectMapper().writeValueAsString(param);
        System.out.println(result);
        Assertions.assertEquals(result, "{\"page\":0,\"size\":0,\"conditions\":{},\"orders\":{},\"ext$\":{\"hello\":\"world\"},\"hello\":\"world\"}");
    }
    @Test
    void testJsonStringToExtParam() throws JsonProcessingException {
        String origin = "{\"page\":0,\"size\":0,\"conditions\":{},\"orders\":{},\"hello\":\"world\"}";
        final Parameter param = new ObjectMapper().readValue(origin, Parameter.class);
        Assertions.assertNotNull(param.getExt$().get("hello"));
    }
}
