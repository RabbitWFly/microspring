package com.rabbitwfly.beans;

/**
 * @Author chentao
 * Date 2019/7/19
 * bean.xml bean的定义
 **/
public interface BeanDefinition {

    /**
     * 获取bean.xml中 bean的全名，入"com.rabbitwlfy.service.v1.NioCoderService"
     * @return
     */
    String getBeanClassName();
}

