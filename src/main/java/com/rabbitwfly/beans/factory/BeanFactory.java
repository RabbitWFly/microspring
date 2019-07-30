package com.rabbitwfly.beans.factory;

/**
 * 创建bean 的实例
 */
public interface BeanFactory {

    /**
     * 获取bean 的实例
     * @param beanId
     * @return
     */
    Object getBean(String beanId);

}
