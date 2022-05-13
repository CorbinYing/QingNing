package com.xiesu.commonbase.response;

import lombok.extern.slf4j.Slf4j;

import java.text.MessageFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class ResponseDefaultMsg {
    private static final String resourceBundleName = "i18n/codeMessage";

    private static volatile Map<Locale, ResourceBundle> resourceBundleMap;


    /**
     * 获取默认信息
     *
     * @param code
     * @return
     */
//    public static String getDefaultMsg(Integer code) {
//        if (properties == null) {
//            loadProperties(msgCodeFileName);
//        }
//        if (properties != null) {
//            return properties.getProperty(code.toString());
//        } else {
//            return null;
//        }
//    }
    public static String getDefaultMsg(Integer code) {
        return getDefaultMsg(code, null);
    }

    public static String getDefaultMsg(Integer code, String... params) {
        return getDefaultMsg(code, Locale.getDefault(), params);
    }

    public static String getDefaultMsg(Integer code, Locale locale, String... params) {
        assert code != null;
        if (locale == null) locale = Locale.getDefault();

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
        assert locale != null;
        if (resourceBundleMap == null) {
            synchronized (ResponseDefaultMsg.class) {//此处this指的是调用者的线程对象
                if (resourceBundleMap == null) {
                    resourceBundleMap = new ConcurrentHashMap<Locale, ResourceBundle>();
                }
            }
        }

        if (!resourceBundleMap.containsKey(locale)) {
            resourceBundleMap.put(locale, ResourceBundle.getBundle(resourceBundleName, locale));
        }

    }

}
