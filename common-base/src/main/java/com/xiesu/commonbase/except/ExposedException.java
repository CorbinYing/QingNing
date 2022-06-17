package com.xiesu.commonbase.except;

import java.text.MessageFormat;
import java.util.Objects;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 可向调用者公开的异常，对于不可向外部暴露的异常（例如：IOEXception_RunTimeException），则应该被拦截，打印日常信息，但对外部隐藏异常内容，显示系统内部错误即可。
 * 具体拦截
 *
 * @author xiesu
 */
@Getter
@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR,reason = "系统内部异常")
public class ExposedException extends RuntimeException {

    private final Integer code;
    private String msg;

    private Object[] params;

    /**
     * Constructs a new runtime exception with the specified detail message. The cause is not
     * initialized, and may subsequently be initialized by a call to {@link #initCause}.
     */
    public ExposedException(Integer code) {
        this.code = code;
    }

    /**
     * Constructs a new runtime exception with the specified detail message. The cause is not
     * initialized, and may subsequently be initialized by a call to {@link #initCause}.
     */
    public ExposedException(Integer code, String msg) {
        this.code = Objects.requireNonNull(code);
        this.msg = msg;
    }


    public ExposedException(Integer code, Object... params) {
        this.code = Objects.requireNonNull(code);
        this.params = params;
    }

    /**
     * 根据传入的参数进行msg 进行格式化
     *
     * @param code   code
     * @param msg    not null
     * @param params 参数
     */
    public ExposedException(Integer code, String msg, String... params) {
        Objects.requireNonNull(msg);
        this.code = Objects.requireNonNull(code);
        this.msg = MessageFormat.format(msg, (Object) params);
    }
}
