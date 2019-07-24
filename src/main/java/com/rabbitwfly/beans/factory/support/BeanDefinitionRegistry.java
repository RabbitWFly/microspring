package com.rabbitwfly.beans.factory.support;

import com.rabbitwfly.beans.BeanDefinition;

/**
 * 注册 BeanDefinition 接口
 */
public interface BeanDefinitionRegistry {

    /**
     * 获取beanDefinition
     * @param beanId
     * @return
     */
    BeanDefinition getBeanDefinition(String beanId);

    /**
     * 注册 beanDefinition
     * @param beanId
     * @param bd
     */
    void registerBeanDefinition(String beanId, BeanDefinition bd);
}
