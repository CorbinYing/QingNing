package com.xiesu.commonbase.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xiesu.commonbase.response.ResponseResult;
import java.util.Map;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice
public class ResponseHandlerAdvice implements ResponseBodyAdvice<Object> {

    /**
     * Whether this component supports the given controller method return type and the selected
     * {@code HttpMessageConverter} type.
     *
     * @param returnType    the return type
     * @param converterType the selected converter type
     * @return {@code true} if {@link #beforeBodyWrite} should be invoked; {@code false} otherwise
     */
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    /**
     * 如果 请求头 包含Accept-Language 参数，则根据该参数进行国际化处理；<p> 参数格式  Accept-Language ：zh-CN
     *
     *
     * <p>
     * Invoked after an {@code HttpMessageConverter} is selected and just before its write method is
     * invoked.
     *
     * @param body                  the body to be written
     * @param returnType            the return type of the controller method
     * @param selectedContentType   the content type selected through content negotiation
     * @param selectedConverterType the converter type selected to write to the response
     * @param request               the current request
     * @param response              the current response
     * @return the body that was passed in or a modified (possibly new) instance
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType,
            MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request,
            ServerHttpResponse response) {

        if (body instanceof ResponseResult) {
            return ((ResponseResult) body).getResult();
        } else if (body instanceof Map) {
            return ResponseResult.success()
                    .item((Map<Object, Object>) body)
                    .build()
                    .getResult();
        } else if (body instanceof String) {
            //String 是直接返回，需要手动转json，不然会报错
            try {
                return new ObjectMapper().writeValueAsString(ResponseResult.success()
                        .item("result", body)
                        .build()
                        .getResult());
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }

        return ResponseResult
                .success()
                .item("result", body)
                .build()
                .getResult();
    }
}
