package com.rabbitwfly.context.support;

import com.rabbitwfly.beans.factory.support.DefaultBeanFactory;
import com.rabbitwfly.beans.factory.xml.XmlBeanDefinitionReader;
import com.rabbitwfly.context.ApplicationContext;
import com.rabbitwfly.core.io.FileSystemResource;
import com.rabbitwfly.core.io.Resource;

/**
 * @Author chentao
 * Date 2019/7/30
 * 从一个目录下读取bean.xml
 **/
public class FileSystemXmlApplicationContext implements ApplicationContext {

    private DefaultBeanFactory factory = null;

    public FileSystemXmlApplicationContext(String configFile){
        factory = new DefaultBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        Resource resource = new FileSystemResource(configFile);
        reader.loadBeanDefinition(resource);
    }

    @Override
    public Object getBean(String beanId) {
        return factory.getBean(beanId);
    }
}

