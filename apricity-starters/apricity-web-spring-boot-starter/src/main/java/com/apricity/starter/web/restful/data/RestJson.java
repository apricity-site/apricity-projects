package com.apricity.starter.web.restful.data;


import com.apricity.starter.web.restful.RestJsonHelper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import java.util.List;

public class RestJson {
    private Parameter param;
    private List<String> data;
    private String repository;

    // 解析data
    public <T> List<T> parse(Class<T> clazz){
        return RestJsonHelper.parse(this, clazz);
    }

    // 解析排序
    public void buildOrders() {
        RestJsonHelper.parseOrders(this);
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

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    public String getRepository() {
        return repository;
    }

    public void setRepository(String repository) {
        this.repository = repository;
    }
}
