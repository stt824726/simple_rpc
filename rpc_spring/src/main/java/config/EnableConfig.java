package config;


import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 初始化配置
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Import(ConfigurationRegistrar.class)
public @interface EnableConfig {

}
