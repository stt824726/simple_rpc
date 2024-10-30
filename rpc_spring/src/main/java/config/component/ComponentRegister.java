package config.component;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @description:
 * @author: shaott
 * @create: 2024-10-30 16:54
 * @Version 1.0
 **/
public class ComponentRegister implements ImportBeanDefinitionRegistrar {


    /**
     * 注册客户端和服务端rpc生成类
     * @param importingClassMetadata
     * @param registry
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        //省略定制扫描路径获取


    }


    /**
     * 注册server端
     * @param registry
     */
    public void registerServiceBeanPostProcessor(BeanDefinitionRegistry registry){

    }


    /**
     * 注册Reference端
     * @param registry
     */
    public void registerReferenceBeanPostProcessor(BeanDefinitionRegistry registry){

    }


    /**
     * 注册bean
     * @param beanDefinitionRegistry
     * @param beanName
     * @param beanType
     */
    private void registerInfrastructureBean(BeanDefinitionRegistry beanDefinitionRegistry,
                                            String beanName,
                                            Class<?> beanType){
        if(!beanDefinitionRegistry.containsBeanDefinition(beanName)){
            RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
            beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
            beanDefinitionRegistry.registerBeanDefinition(beanName, beanDefinition);
        }
    }

}
