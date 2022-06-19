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

    /**
     * {@link #success()}或{@link #faild()}builder的构建结果，包含code，msg
     */
    private final Map<Object, Object> result;

    /**
     * 返回结果的http状态
     */
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


        /**
         * 设置错误吗
         *
         * @param code notnull
         */
        public ResponseBuilder errCode(int code) {
            this.code = code;
            return this;
        }

        /**
         * 设置错误消息，没有错误消息则使用code获取默认消息
         *
         * @param msg errMsg，nullable
         */
        public ResponseBuilder errMsg(String msg) {
            this.msg = msg;
            return this;
        }

        /**
         * 设置格式化消息的参数，{@link #msg}不为 空，则进行格式化；否则获取默认消息并进行格式化
         *
         * @param params nullable
         */
        public ResponseBuilder params(Object... params) {
            this.params = params;
            return this;
        }


        /**
         * 具体的结果值
         *
         * @param key   notnull
         * @param value nullable
         */
        public ResponseBuilder item(String key, Object value) {
            response.put(Objects.requireNonNull(key), value);
            return this;
        }

        /**
         * 具体的结果值
         *
         * @param map notnull
         */
        public ResponseBuilder item(Map<Object, Object> map) {
            Objects.requireNonNull(map, "map不能为null");
            response.putAll(map);
            return this;
        }

        /**
         * 构建外部结果类
         */
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
