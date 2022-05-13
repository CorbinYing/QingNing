package com.xiesu.commonbase.except;

import com.xiesu.commonbase.response.ResponseResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler
    public ResponseResult handleServiceException(ExposedException e) {
        return null;
    }

}
