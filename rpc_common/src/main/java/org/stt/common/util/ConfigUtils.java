package org.stt.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @description: 配置工具类
 * @author: shaott
 * @create: 2024-10-15 13:43
 * @Version 1.0
 **/
public class ConfigUtils {

    private static Log log = LogFactory.getLog(ConfigUtils.class);

    private static volatile Properties PROPERTIES;

    public static final String DEFAULT_DUBBO_PROPERTIES = "dubbo.properties";

    public static String getProperty(String key) {
        return getProperty(key, null);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public static String getProperty(String key, String defaultValue) {
        String value = System.getProperty(key);
        if (value != null && value.length() > 0) {
            return value;
        }
        Properties properties = getProperties();
        return properties.getProperty(key, defaultValue);
    }

    public static Properties getProperties() {
        if (PROPERTIES == null) {
            synchronized (ConfigUtils.class) {
                if (PROPERTIES == null) {
                    PROPERTIES = ConfigUtils.loadProperties(DEFAULT_DUBBO_PROPERTIES);
                }
            }
        }
        return PROPERTIES;
    }


    public static Properties loadProperties(String fileName) {
        Properties properties = new Properties();
        if (!checkFileNameExist(fileName)) {
            return null;
        }
        try {
            FileInputStream input = new FileInputStream(fileName);
            try {
                properties.load(input);
            } finally {
                input.close();
            }
        } catch (Throwable e) {
            log.warn("Failed to load " + fileName + " file from " + fileName + "(ignore this file): " + e.getMessage(), e);
        }
        return properties;
    }


    private static boolean checkFileNameExist(String fileName) {
        File file = new File(fileName);
        return file != null && file.exists() ? true : false;
    }
}
