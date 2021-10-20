package com.apricity.starter.web.restful;

import com.apricity.exception.UnexpectedException;
import com.apricity.starter.web.restful.data.RestJson;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static com.apricity.starter.web.mybatisplus.condition.ConditionEnums.SB;

public class RestJsonHelper {

    private static final ThreadLocal<List<OrderItem>> ORDER_ITEM_LIST_CONTAINER = new ThreadLocal<>();


    public static <T> List<T> parse(RestJson restJson, Class<T> clazz){
        ObjectMapper objectMapper = new ObjectMapper();
        List<T> resultList = new ArrayList<>();
        try {
            if (CollectionUtils.isNotEmpty(restJson.getData())) {
                for (int i = 0; i < restJson.getData().size(); i++) {
                    resultList.add(objectMapper.readValue(restJson.getData().get(i), clazz));
                }
            }
        }catch (JsonProcessingException e){
            throw new UnexpectedException(e);
        }
        return resultList;
    }

    /**
     * {<br>
     *     column_asc: 正序,<br>
     *     column: 正序,<br>
     *     column_desc: 倒序,<br>
     * }<br>
     */
    public static void parseOrders(RestJson restJson) {
        List<OrderItem> orderList = new ArrayList<>();
        if (restJson.getParam() != null && CollectionUtils.isNotEmpty(restJson.getParam().getOrders())) {
            restJson.getParam().getOrders().forEach((k, v) -> {
                if (!StringUtils.contains(k, StringPool.UNDERSCORE)) {
                    orderList.add(new OrderItem(k, true));
                } else {
                    final String[] split = StringUtils.split(k, StringPool.UNDERSCORE);
                    orderList.add(new OrderItem(split[0], "asc".equalsIgnoreCase(v)));
                }
            });
        }
        ORDER_ITEM_LIST_CONTAINER.set(orderList);
    }

    public static void parseCondition(RestJson restJson) {
        if (restJson.getParam() != null && CollectionUtils.isNotEmpty(restJson.getParam().getConditions())) {
            restJson.getParam().getConditions().forEach((k, v) -> {
                if (StringUtils.contains(k, StringPool.UNDERSCORE)) {
                    String conditionName = k.substring(0, k.indexOf(StringPool.UNDERSCORE));
                    String originValue = k.substring(k.indexOf(StringPool.UNDERSCORE) + 1);
                    if (SB.name().equals(conditionName)){

                    }
                }
            });
        }
    }
}
