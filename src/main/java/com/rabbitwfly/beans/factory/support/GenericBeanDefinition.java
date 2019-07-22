package com.rabbitwfly.beans.factory.support;

import com.rabbitwfly.beans.BeanDefinition;

/**
 * @Author chentao
 * Date 2019/7/19
 * BeanDefinition 实现类
 **/
public class GenericBeanDefinition implements BeanDefinition {

    private String id;
    private String beanClassName;

    public GenericBeanDefinition(String id, String beanClassName) {
        this.id = id;
        this.beanClassName = beanClassName;
    }

    @Override
    public String getBeanClassName() {
        return this.beanClassName;
    }
}

