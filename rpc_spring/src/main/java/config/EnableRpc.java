package config;

import java.lang.annotation.*;

/**
 * @description: enables rpc components
 * @author: shaott
 * @create: 2024-10-14 17:43
 * @Version 1.0
 **/
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface EnableRpc {

    /**
     * 扫描路径
     * @return
     */
    String[] scanBasePackages() default {};

}
