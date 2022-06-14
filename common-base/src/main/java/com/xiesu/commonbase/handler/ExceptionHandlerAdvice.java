package com.xiesu.commonbase.handler;

import com.xiesu.commonbase.except.ExposedException;
import com.xiesu.commonbase.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Action: 全局处理异常
 * 该类处理之后依旧会被{@link ResponseHandlerAdvice#beforeBodyWrite(Object, MethodParameter, MediaType, Class,
 * ServerHttpRequest, ServerHttpResponse)} 拦截处理
 *
 * @author xiesu
 */
@Slf4j
@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(value = ExposedException.class)
    public ResponseResult handleServiceException(ExposedException e) {
        log.error(e.getClass().getName(), e);
        return ResponseResult.faild()
                .params(e.getParams())
                .errCode(e.getCode())
                .errMsg(e.getMsg())
                .build();
    }

}
