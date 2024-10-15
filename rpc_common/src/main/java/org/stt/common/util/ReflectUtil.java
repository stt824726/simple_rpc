package org.stt.common.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.lang.reflect.Method;

/**
 * @description: 反射工具类
 * @author: shaott
 * @create: 2024-10-15 11:00
 * @Version 1.0
 **/
public class ReflectUtil {

    private static Log log = LogFactory.getLog(ReflectUtil.class);

    public static <T> void appendProperties(String prefix,T t) {
        if (t == null) {
            return;
        }
        Method[] methods = t.getClass().getMethods();
        for(Method method : methods){
            try{

            }catch (Exception e){
                log.error(e.getMessage(), e);
            }
        }
    }


    public static Object convertPrimitive(Class<?> type, String value) {
        if (type == char.class || type == Character.class) {
            return value.length() > 0 ? value.charAt(0) : '\0';
        } else if (type == boolean.class || type == Boolean.class) {
            return Boolean.valueOf(value);
        } else if (type == byte.class || type == Byte.class) {
            return Byte.valueOf(value);
        } else if (type == short.class || type == Short.class) {
            return Short.valueOf(value);
        } else if (type == int.class || type == Integer.class) {
            return Integer.valueOf(value);
        } else if (type == long.class || type == Long.class) {
            return Long.valueOf(value);
        } else if (type == float.class || type == Float.class) {
            return Float.valueOf(value);
        } else if (type == double.class || type == Double.class) {
            return Double.valueOf(value);
        }
        return value;
    }
}
