package com.apricity.starter.web.restful.resolver;

import com.apricity.exception.UnexpectedException;
import com.apricity.starter.web.restful.RestJsonWrapper;
import com.apricity.utils.AStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpMethod;
import org.springframework.web.context.request.NativeWebRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


public class ToRestJsonResolveArgumentHandler {
    private final MethodParameter parameter;
    private final NativeWebRequest webRequest;

    public ToRestJsonResolveArgumentHandler(MethodParameter parameter,
                                            NativeWebRequest webRequest) {
        this.parameter = parameter;
        this.webRequest = webRequest;
    }

    public MethodParameter getParameter() {
        return parameter;
    }

    public NativeWebRequest getWebRequest() {
        return webRequest;
    }

    public RestJsonWrapper resolveArgument() {
        String requestJson = getRequestJson();
        if (StringUtils.isEmpty(requestJson)) {
            return new RestJsonWrapper();
        }

        return null;
    }

    public boolean supports(){
        final HttpServletRequest request = getWebRequest().getNativeRequest(HttpServletRequest.class);
        if (Objects.nonNull(request)) {
            return !HttpMethod.GET.name().equals(request.getMethod()) && StringUtils.contains(request.getContentType(), APPLICATION_JSON_VALUE);
        }
        return false;
    }

    protected String getRequestJson() {
        if (!supports()) {
            return null;
        }
        HttpServletRequest request = getWebRequest().getNativeRequest(HttpServletRequest.class);
        if (Objects.isNull(request)) return null;
        try (InputStream is = request.getInputStream()) {
            return AStringUtils.read(is);
        } catch (IOException ioe) {
            throw new UnexpectedException(ioe);
        }
    }

}
