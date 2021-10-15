package com.apricity.starter.web.restful.data;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Parameter {
    private int page;
    private int size;
    /**
     * {
     *    id_EQ : 1
     * }
     */
    private final Map<String, Object> conditions = new HashMap<>();
    private final Map<String, String> orders = new LinkedHashMap<>();
    @JsonAnyGetter
    @JsonAnySetter
    private final Map<String, Object> ext$ = new LinkedHashMap<>();

    public void putExtItem(String paramName, Object paramValue) {
        ext$.put(paramName, paramValue);
    }

    public Object getExtItem(String paramName) {
        return ext$.get(paramName);
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Map<String, Object> getConditions() {
        return conditions;
    }

    public Map<String, String> getOrders() {
        return orders;
    }

    public Map<String, Object> getExt$() {
        return ext$;
    }
}
