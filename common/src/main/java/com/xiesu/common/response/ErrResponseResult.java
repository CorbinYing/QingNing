package com.xiesu.common.response;

import com.xiesu.common.except.AbstractCustomerException;
import java.text.MessageFormat;
import java.util.Objects;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;

/**
 * Action：程序异常统一返回结果
 *
 * @author xiesu
 */
@Getter
public class ErrResponseResult extends AbstractResponse {

    private ErrResponseResult(AbstractCustomerException e) {
        super(HttpStatus.INTERNAL_SERVER_ERROR);

        Assert.isTrue(Objects.nonNull(e.getCode()), "返回值必须包含err_code");

        Integer code = e.getCode();
        String msg = e.getMsg();
        Object[] params = e.getParams();

        //消息msg则进行国际化处理
        if (StringUtils.isNoneBlank(msg)) {
            msg = params == null ? msg : MessageFormat.format(msg, params);
        } else {
            msg = ResponseDefaultMsg.getDefaultMsg(code, LOCALE, params);
        }

        result.put(ERR_CODE_KEY, code);
        result.put(ERR_MSG_KEY, msg);
    }

    /**
     * 构造异常返回结果
     *
     * @param e e
     */
    public static ErrResponseResult faild(AbstractCustomerException e) {
        return new ErrResponseResult(e);
    }


}
