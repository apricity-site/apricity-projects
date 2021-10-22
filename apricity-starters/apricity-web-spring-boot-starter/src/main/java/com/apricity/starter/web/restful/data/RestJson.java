package com.apricity.starter.web.restful.data;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

public class RestJson {
    private Parameter param;
    private String dataJsonStr;
    private String repository;
    private final String requestJson;

    public RestJson(String requestJson) {
        this.requestJson = requestJson;
    }


    public static void main(String[] args) {

        final QueryWrapper<RestJson> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("hello", 12);
        final String sqlSegment = queryWrapper.getSqlSegment();
        System.out.println(sqlSegment);
    }

    public Parameter getParam() {
        return param;
    }

    public void setParam(Parameter param) {
        this.param = param;
    }

    public String getDataJsonStr() {
        return dataJsonStr;
    }

    public void setDataJsonStr(String dataJsonStr) {
        this.dataJsonStr = dataJsonStr;
    }

    public String getRequestJson() {
        return requestJson;
    }

    public String getRepository() {
        return repository;
    }

    public void setRepository(String repository) {
        this.repository = repository;
    }
}
