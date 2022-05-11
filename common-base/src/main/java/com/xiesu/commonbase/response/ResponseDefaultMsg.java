package com.xiesu.commonbase.response;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;

@Slf4j
public class ResponseDefaultMsg {
    private static final String resourceBundleName = "i18n/codeMessage";

    private static volatile Set<ResourceBundle> resourceBundleSet;


    /**
     * 获取默认信息
     *
     * @param code
     * @return
     */
    public static String getDefaultMsg(Integer code) {
        if (properties == null) {
            loadProperties(msgCodeFileName);
        }
        if (properties != null) {
            return properties.getProperty(code.toString());
        } else {
            return null;
        }
    }


    public static String getDefaultMsg(Integer code, Locale locale) {
        assert code != null;

        if (resourceBundleList == null) {

        }


    }

    public final List<ResourceBundle> getResourceBundleList(Locale locale) {
        if (resourceBundleSet == null) {
            synchronized (this) {//此处this指的是调用者的线程对象
                if (resourceBundleSet == null) {
                    if (locale == null) locale = Locale.getDefault();
                    resourceBundleSet=new ConcurrentSkipListSet<ResourceBundle>()
                }
            }
        }


    }

}
