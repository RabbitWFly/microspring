package com.rabbitwfly.beans;

import java.util.List;

/**
 * @Author chentao
 * Date 2019/7/19
 * bean.xml bean的定义
 **/
public interface BeanDefinition {
    /**
     * 单例
     */
    String SCOPE_SINGLETON = "singleton";

    /**
     * 多例
     */
    String SCOPE_PROTOTYPE = "prototype";
    /**
     * 默认为空即单例模式
     */
    String SCOPE_DEFAULT = "";

    /**
     * 是否为单例
     * @return
     */
    boolean isSingleton();

    /**
     * 是否为多例
     * @return
     */
    boolean isPrototype();

    /**
     * 获取scope配置
     *
     * @return
     */
    String getScope();

    /**
     * 设置scope
     *
     * @param scope
     */
    void setScope(String scope);


    /**
     * 获取bean.xml中 bean的全名，入"com.rabbitwlfy.service.v1.NioCoderService"
     * @return
     */
    String getBeanClassName();

    /**
     * 获取bean.xmo 中的 property 标签内容 <property name ="accountDao" ref="accountDao"></property>
     * @return
     */
    List<PropertyValue> getPropertyValues();
}

