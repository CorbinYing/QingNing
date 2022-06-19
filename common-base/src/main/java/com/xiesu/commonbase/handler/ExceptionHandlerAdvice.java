package com.xiesu.commonbase.handler;

import com.xiesu.commonbase.except.AbstractCustomerException;
import com.xiesu.commonbase.except.ExposedException;
import com.xiesu.commonbase.except.UnExposedException;
import com.xiesu.commonbase.response.ResponseCode;
import com.xiesu.commonbase.response.ResponseDefaultMsg;
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

    /**
     * 全局处理手动定义的异常 并进行封装
     */
    @ExceptionHandler(value = {ExposedException.class, UnExposedException.class})
    public ResponseResult handleCustomException(AbstractCustomerException e) {
        log.error(e.getClass().getName(), e);
        return ResponseResult
                .faild()
                .params(e.getParams())
                .errCode(e.getCode())
                .errMsg(e.getMsg())
                .build();
    }


    /**
     * 处理其他非自定义运行时异常
     */
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseResult handleRuntimeException(RuntimeException e) {
        log.error(e.getClass().getName(), e);
        return ResponseResult
                .faild()
                .errCode(ResponseCode.ERR_SYSTEM)
                .build();
    }


}
