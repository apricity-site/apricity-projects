package com.apricity.starter.web.restful.resolver;

import com.apricity.starter.web.restful.RestJsonHelper;
import com.apricity.starter.web.restful.data.Parameter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;

import java.util.LinkedHashMap;
import java.util.Objects;

public class QueryParamParser {

    private final static String PAGE = "page";
    private final static String SIZE = "size";
    private final static String ORDER = "order_by";
    private final static String WHERE = "where";

    private final Parameter parameter = new Parameter();
    private final String paramStr;
    private final ObjectMapper objectMapper;
    private final LinkedHashMap<String, String> paramMap = new LinkedHashMap<>();



    QueryParamParser(String paramStr,
                     ObjectMapper objectMapper) throws JsonProcessingException {
        this.paramStr = paramStr;
        this.objectMapper = objectMapper;
        if (StringUtils.isNotBlank(paramStr)) {
            paramMap.putAll(RestJsonHelper.jsonStrToMap(paramStr, objectMapper));
        }
    }

    public Parameter parse() throws JsonProcessingException {
        if (StringUtils.isNotBlank(paramStr)) {
            parsePagination();
            parseConditions();
            parseOrders();
            parseExtParam();
        }
        return parameter;
    }

    private void parseExtParam() {
        if (paramMap.size() > 0) {
            parameter.getExt$().putAll(paramMap);
        }
    }

    private void parseOrders() throws JsonProcessingException {
        if (Objects.nonNull(paramMap.get(ORDER))) {
            parameter.getOrders().putAll(
                    RestJsonHelper.jsonStrToMap(paramMap.get(ORDER), objectMapper)
            );
        }
        paramMap.remove(ORDER);
    }

    private void parseConditions() {
        if (Objects.nonNull(paramMap.get(WHERE))) {
            // TODO parse condition
        }
        paramMap.remove(WHERE);
    }

    private void parsePagination() {
        parameter.setPage(1);
        parameter.setSize(-1);
        if (Objects.nonNull(paramMap.get(PAGE))) parameter.setPage(Integer.parseInt(paramMap.get(PAGE)));
        if (Objects.nonNull(paramMap.get(SIZE))) parameter.setPage(Integer.parseInt(paramMap.get(SIZE)));
        paramMap.remove(PAGE);
        paramMap.remove(SIZE);
    }

}
