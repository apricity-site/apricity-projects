package com.apricity.starter.web.restful.resolver;

import com.apricity.exception.UnexpectedException;
import com.apricity.starter.web.restful.data.RestJson;
import com.apricity.utils.AStringUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapType;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Objects;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public class ToRestJsonResolver implements HandlerMethodArgumentResolver {

    private final ObjectMapper objectMapper;

    public ToRestJsonResolver(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }


    /**
     * 只处理 参数为 {@link RestJson}的接口
     */
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(RestJson.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        final HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
        if (Objects.isNull(request) ||
                (HttpMethod.GET.name().equals(request.getMethod()) &&
                        StringUtils.contains(request.getContentType(), APPLICATION_JSON_VALUE))) {
            return null;
        }

        String requestJson = getRequestJson(webRequest);
        LinkedHashMap<String, String> requestMap = RestJsonResolverHelper.jsonStrToMap(requestJson, objectMapper);

        return null;
    }

    private String getRequestJson(NativeWebRequest webRequest) {
        HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
        if (Objects.isNull(request)) return null;
        try (InputStream is = request.getInputStream()) {
            return AStringUtils.read(is);
        } catch (IOException ioe) {
            throw new UnexpectedException(ioe);
        }
    }
}
