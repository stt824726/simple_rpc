package config.component;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 扫描注册rpc专用类
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(ComponentRegister.class)
public @interface RpcComponentScan {


}
