package com.xiesu.common.response;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import org.springframework.http.HttpStatus;


/**
 * Action: 正常情况下构建统一返回结果
 *
 * @author xiesu
 */
public class OkResponseResult extends AbstractResponse {

    private OkResponseResult(Map<Object, Object> data) {
        super(HttpStatus.OK);
        result.put(ERR_CODE_KEY, ResponseCode.SUCC_0);
        result.put(ERR_MSG_KEY, ResponseDefaultMsg.getDefaultMsg(ResponseCode.SUCC_0, LOCALE));
        result.putAll(Objects.requireNonNull(data));
    }


    public static SucResponseBuilder success() {
        return new SucResponseBuilder();
    }

    public static class SucResponseBuilder {

        private final Map<Object, Object> data = new LinkedHashMap<>();

        /**
         * 具体的结果值
         *
         * @param key   notnull
         * @param value nullable
         */
        public SucResponseBuilder item(String key, Object value) {
            data.put(Objects.requireNonNull(key), value);
            return this;
        }

        /**
         * 具体的结果值
         *
         * @param map notnull
         */
        public SucResponseBuilder item(Map<Object, Object> map) {
            Objects.requireNonNull(map, "map不能为null");
            data.putAll(map);
            return this;
        }

        /**
         * 构建外部结果类
         */
        public OkResponseResult build() {
            return new OkResponseResult(data);
        }
    }
}
