package com.xiesu.commonbase.handler;

import com.xiesu.commonbase.except.ExposedException;
import com.xiesu.commonbase.response.ResponseResult;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Action: 全局处理异常
 *
 * @author xiesu
 */
@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler
    @NonNull
    @Validated

//TODo IllegalArgumentException
    public ResponseResult handleServiceException(ExposedException e) {
        return null;
    }

}
