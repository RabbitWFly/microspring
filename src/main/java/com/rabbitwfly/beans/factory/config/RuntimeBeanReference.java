package com.rabbitwfly.beans.factory.config;

/**
 * <property name ="accountDao" ref="accountDao"></property>
 * ref="accountDao"
 * 表明引用的是bean 获取是会转换成实例
 * @Author chentao
 * Date 2019/7/31
 **/
public class RuntimeBeanReference {

    private final String beanName;

    public RuntimeBeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}

