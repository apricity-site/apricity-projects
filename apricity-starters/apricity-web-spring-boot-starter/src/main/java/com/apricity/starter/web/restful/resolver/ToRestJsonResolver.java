package com.apricity.starter.web.restful.resolver;

import com.apricity.starter.web.restful.data.RestJson;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class ToRestJsonResolver implements HandlerMethodArgumentResolver {


    /**
     * 只处理 参数为 {@link RestJson}的接口
     */
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(RestJson.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        ToRestJsonResolveArgumentHandler resolveArgumentHandler = new ToRestJsonResolveArgumentHandler(parameter, webRequest);
        if (resolveArgumentHandler.supports()) {
            return resolveArgumentHandler.resolveArgument();
        }
        return null;
    }
}
