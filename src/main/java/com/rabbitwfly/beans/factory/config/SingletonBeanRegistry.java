package com.rabbitwfly.beans.factory.config;

/**
 * SingleBean的注册接口
 */
public interface SingletonBeanRegistry {

    /**
     * singlebean 注册
     * @param beanName
     * @param singletonObject
     */
    void registerSingleton(String beanName, Object singletonObject);

    /**
     * 获取singlebean
     * @param beanName
     * @return
     */
    Object getSingleton(String beanName);
}
