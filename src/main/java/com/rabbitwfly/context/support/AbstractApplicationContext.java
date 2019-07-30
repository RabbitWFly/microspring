package com.rabbitwfly.context.support;

import com.rabbitwfly.beans.factory.support.DefaultBeanFactory;
import com.rabbitwfly.beans.factory.xml.XmlBeanDefinitionReader;
import com.rabbitwfly.context.ApplicationContext;
import com.rabbitwfly.core.io.Resource;

/**
 * @Author chentao
 * Date 2019/7/30
 * Description
 **/
public abstract class AbstractApplicationContext implements ApplicationContext {

    private DefaultBeanFactory factory = null;

    public AbstractApplicationContext(String configFile){
        factory = new DefaultBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        Resource resource = this.getResourcePath(configFile);
        reader.loadBeanDefinition(resource);
    }

    /**
     * 具体由子类实现
     * @param configFile
     * @return
     */
    protected abstract Resource getResourcePath(String configFile);

    @Override
    public Object getBean(String beanId) {
        return factory.getBean(beanId);
    }
}

