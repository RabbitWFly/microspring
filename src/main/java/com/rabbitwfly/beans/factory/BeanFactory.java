package com.rabbitwfly.beans.factory;

import com.rabbitwfly.beans.BeanDefinition;

/**
 * 创建bean 的实例
 */
public interface BeanFactory {

    /**
     * 获取bean 的定义
     * @param beanId
     * @return
     */
    BeanDefinition getBeanDefinition(String beanId);

    /**
     * 获取bean 的实例
     * @param beanId
     * @return
     */
    Object getBean(String beanId);
}
