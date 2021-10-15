package com.apricity.starter.web.restful.resolver;

import com.apricity.starter.web.restful.RestJsonWrapper;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class ToRestJsonWrapperResolver implements HandlerMethodArgumentResolver {


    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        // 只处理 参数为 RestJsonWrapper的接口
        return parameter.getParameterType().equals(RestJsonWrapper.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        ToRestJsonWrapperResolveArgumentHandler resolveArgumentHandler = new ToRestJsonWrapperResolveArgumentHandler(parameter, webRequest);
        if (resolveArgumentHandler.supports()) {
            return resolveArgumentHandler.resolveArgument();
        }
        return null;
    }
}
