package com.apricity.starter.web.test.restful;

import com.apricity.starter.web.restful.RestJsonHelper;
import com.apricity.starter.web.restful.data.Parameter;
import com.apricity.starter.web.restful.data.RestJson;
import com.apricity.starter.web.test.restful.bean.TestDataBean;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RestJsonTest {
    @Test
    void testRestJsonToJsonString() throws JsonProcessingException {
        final RestJson restJson = new RestJson();

        final Parameter parameter = new Parameter();
        parameter.putExtItem("hello", "world");
        restJson.setParam(parameter);

        TestDataBean dataBean = new TestDataBean();
        dataBean.setName("name");
        restJson.setData(new ArrayList<>());

        final String result = new ObjectMapper().writeValueAsString(restJson);
        assertEquals(result, "{\"param\":{\"page\":0,\"size\":0,\"conditions\":{},\"orders\":{},\"ext$\":{\"hello\":\"world\"},\"hello\":\"world\"},\"data\":[{\"name\":\"name\"}],\"repository\":null}");
    }

    @Test
    void testJsonStringToExtParam() throws JsonProcessingException {
        final RestJson restJson = new ObjectMapper().readValue("", RestJson.class);
    }

    @Test
    void testParseCondition() {
        final RestJson restJson = new RestJson();
        Parameter param = new Parameter();
        param.getConditions().put("column_NEQ", 1);
        restJson.setParam(param);
        RestJsonHelper.parseCondition(restJson);
    }
}
