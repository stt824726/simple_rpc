package config.configuration;

import config.configuration.AbstractConfig;

import java.lang.annotation.*;

/**
 * @description: 开启参数绑定
 * @author: shaott
 * @create: 2024-10-15 10:27
 * @Version 1.0
 **/
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EnableConfigBinds {

    /**
     * 参数开始头
     * @return
     */
    String prefix();

    Class<? extends AbstractConfig> type();

}
