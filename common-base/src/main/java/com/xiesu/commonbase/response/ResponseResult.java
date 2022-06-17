package com.xiesu.commonbase.response;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;


/**
 * Action: 构建统一返回结果
 *
 * @author xiesu
 */
public class ResponseResult implements Serializable {

    private final static String ERR_CODE_KEY = "err_code";
    private final static String ERR_MSG_KEY = "err_msg";
    private final Map<Object, Object> result;

    private final HttpStatus httpStatus;


    public static ResponseBuilder success() {
        return new ResponseBuilder(HttpStatus.OK).errCode(ResponseCode.SUCC_0);
    }

    public static ResponseBuilder faild() {
        return new ResponseBuilder(HttpStatus.INTERNAL_SERVER_ERROR);
    }


    /**
     * 返回构建的LinkedHashMap
     */
    public Map<Object, Object> getResult() {
        return result;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public static class ResponseBuilder {

        private Integer code;

        private String msg;

        /**
         * msg 格式化参数
         */
        private Object[] params;

        //根据请求头 包含Accept-Language获取Locale，获取不到使用defaultLocale
        private final Locale locale = LocaleContextHolder.getLocale();

        //使用有序map
        private final Map<Object, Object> response = new LinkedHashMap<>();

        private final HttpStatus httpStatus;

        private ResponseBuilder(HttpStatus httpStatus) {
            this.httpStatus = httpStatus;
        }


        public ResponseBuilder errCode(int code) {
            this.code = code;
            return this;
        }

        public ResponseBuilder errMsg(String msg) {
            this.msg = msg;
            return this;
        }

        public ResponseBuilder params(Object... params) {
            this.params = params;
            return this;
        }


        public ResponseBuilder item(String key, Object value) {
            response.put(Objects.requireNonNull(key), value);
            return this;
        }

        public ResponseBuilder item(Map<Object, Object> map) {
            response.putAll(map);
            return this;
        }

        public ResponseResult build() {
            Assert.isTrue(Objects.nonNull(code), "返回值必须包含err_code");

            //消息msg则进行国际化处理
            if (StringUtils.isNoneBlank(msg)) {
                this.msg = MessageFormat.format(msg, params);
            } else {
                this.msg = ResponseDefaultMsg.getDefaultMsg(code, locale, params);
            }

            Map<Object, Object> map = new LinkedHashMap<>();
            map.put(ERR_CODE_KEY, this.code);
            map.put(ERR_MSG_KEY, this.msg);
            map.putAll(this.response);

            return new ResponseResult(httpStatus, map);
        }

    }


    private ResponseResult(HttpStatus httpStatus, Map<Object, Object> response) {
        this.result = response;
        this.httpStatus = httpStatus;
    }


}
