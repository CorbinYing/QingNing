package com.xiesu.commonbase.response;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.i18n.LocaleContextHolder;
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


    public static ResponseBuilder success() {
        return new ResponseBuilder().errCode(ResponseCode.SUCC_0);
    }

    public static ResponseBuilder faild() {
        return new ResponseBuilder();
    }


    /**
     * 返回构建的LinkedHashMap
     */
    public Map<Object, Object> getResult() {
        return result;
    }

    public static class ResponseBuilder {

        //根据请求头 包含Accept-Language获取Locale，获取不到使用defaultLocale
        private final Locale locale = LocaleContextHolder.getLocale();

        //使用有序map
        private final Map<Object, Object> response = new LinkedHashMap<>();

        private ResponseBuilder() {
        }


        public ResponseBuilder errCode(int code) {
            response.put(ERR_CODE_KEY, code);
            return this;
        }

        public ResponseBuilder errMsg(String msg) {
            response.put(ERR_MSG_KEY, msg);
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
            Assert.isTrue(response.containsKey(ERR_CODE_KEY), "返回值必须包含err_code");
            boolean flag = !response.containsKey(ERR_MSG_KEY) || StringUtils.isBlank(
                    (String) response.get(ERR_MSG_KEY));
            if (flag) {
                //默认消息msg则进行国际化处理
                response.put(ERR_MSG_KEY,
                        ResponseDefaultMsg.getDefaultMsg((Integer) response.get(ERR_CODE_KEY),
                                locale));
            }
            return new ResponseResult(response);
        }

    }


    private ResponseResult(Map<Object, Object> response) {
        this.result = response;
    }


}
