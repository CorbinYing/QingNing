package com.xiesu.commonbase.response;

import lombok.extern.slf4j.Slf4j;

import java.text.MessageFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.util.Assert;

/**
 * 自定义读取国际化配置文件
 */
@Slf4j
public class ResponseDefaultMsg {

    private static final String RESOURCE_BUNDLE_NAME = "i18n/codeMessage";

    private static volatile Map<Locale, ResourceBundle> resourceBundleMap;


    public static String getDefaultMsg(Integer code) {
        return getDefaultMsg(code, null);
    }

    public static String getDefaultMsg(Integer code, Locale locale, String... params) {
        assert code != null;
        if (locale == null) {
            locale = Locale.getDefault();
        }

        getResourceBundleMap(locale);
        ResourceBundle resourceBundle = resourceBundleMap.get(locale);
        String msg = resourceBundle.getString(String.valueOf(code));
        MessageFormat messageFormat = new MessageFormat(msg);

        return messageFormat.format(params);
    }

//    public MessageFormat

    /**
     * 获取指定local的ResourceBundle
     *
     * @param locale
     */
    private static void getResourceBundleMap(Locale locale) {
        Objects.requireNonNull(locale);
        if (resourceBundleMap == null) {
            //此处this指的是调用者的线程对象
            synchronized (ResponseDefaultMsg.class) {
                if (resourceBundleMap == null) {
                    resourceBundleMap = new ConcurrentHashMap<Locale, ResourceBundle>();
                }
            }
        }

        if (!resourceBundleMap.containsKey(locale)) {
            resourceBundleMap.put(locale, ResourceBundle.getBundle(RESOURCE_BUNDLE_NAME, locale));
        }

    }

}
