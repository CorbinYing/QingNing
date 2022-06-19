package com.xiesu.common.response;

import com.xiesu.common.except.AbstractCustomerException;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;

/**
 * @author xiesu
 */
public abstract class AbstractResponse implements Serializable {

    protected static String ERR_CODE_KEY = "err_code";
    protected static String ERR_MSG_KEY = "err_msg";
    /**
     * 根据请求头 包含Accept-Language获取Locale，获取不到使用defaultLocale
     */
    protected static Locale LOCALE = LocaleContextHolder.getLocale();


    /**
     * {@link OkResponseResult#success()}或{@link ErrResponseResult#faild(AbstractCustomerException)}
     * ()}builder的构建结果，包含code，msg
     */
    protected final Map<Object, Object> result = new LinkedHashMap<>();

    /**
     * 返回结果的http状态
     */
    private final HttpStatus httpStatus;

    protected AbstractResponse(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }


    public Map<Object, Object> getResult() {
        return result;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
