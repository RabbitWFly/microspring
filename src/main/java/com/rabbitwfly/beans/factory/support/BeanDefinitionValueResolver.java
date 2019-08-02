package com.rabbitwfly.beans.factory.support;

import com.rabbitwfly.beans.factory.config.RuntimeBeanReference;
import com.rabbitwfly.beans.factory.config.TypedStringValue;

/**
 * 将<property name ="accountDao" ref="accountDao"></property>
 * accountDao 转换成实例bean
 * @Author chentao
 * Date 2019/7/31
 **/
public class BeanDefinitionValueResolver {

    private final DefaultBeanFactory factory;

    public BeanDefinitionValueResolver(DefaultBeanFactory factory) {
        this.factory = factory;
    }

    public Object resolveValueIfNecessary(Object value){
        if(value instanceof RuntimeBeanReference){
            RuntimeBeanReference ref = (RuntimeBeanReference) value;
            String refName = ref.getBeanName();
            Object bean = this.factory.getBean(refName);
            return bean;
        } else if(value instanceof TypedStringValue){
            return ((TypedStringValue)value).getValue();
        } else {
            throw new RuntimeException("the value " + value + " has not implemented");
        }
    }
}

