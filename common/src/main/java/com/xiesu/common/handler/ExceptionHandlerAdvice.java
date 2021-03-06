package com.xiesu.common.handler;

import com.xiesu.common.except.AbstractCustomerException;
import com.xiesu.common.except.ExposedException;
import com.xiesu.common.except.UnExposedException;
import com.xiesu.common.response.ErrResponseResult;
import com.xiesu.common.response.ResponseCode;
import com.xiesu.common.response.OkResponseResult;
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

    /**
     * 全局处理手动定义的异常 并进行封装
     */
    @ExceptionHandler(value = {ExposedException.class, UnExposedException.class})
    public ErrResponseResult handleCustomException(AbstractCustomerException e) {
        log.error(e.getClass().getName(), e);
        return ErrResponseResult.faild(e);
    }


    /**
     * 处理其他非自定义运行时异常
     */
    @ExceptionHandler(value = RuntimeException.class)
    public ErrResponseResult handleRuntimeException(RuntimeException e) {
        log.error(e.getClass().getName(), e);
        return ErrResponseResult.faild(new UnExposedException());
    }


}
