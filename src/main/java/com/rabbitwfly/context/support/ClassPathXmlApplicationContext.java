package com.rabbitwfly.context.support;

import com.rabbitwfly.beans.factory.support.DefaultBeanFactory;
import com.rabbitwfly.beans.factory.xml.XmlBeanDefinitionReader;
import com.rabbitwfly.context.ApplicationContext;
import com.rabbitwfly.core.io.ClassPathResource;
import com.rabbitwfly.core.io.Resource;

/**
 * @Author chentao
 * Date 2019/7/30
 * 从classpath下读取bean.xml
 **/
public class ClassPathXmlApplicationContext implements ApplicationContext {

    private DefaultBeanFactory factory = null;

    public ClassPathXmlApplicationContext(String configFile) {
       factory = new DefaultBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        Resource resource = new ClassPathResource(configFile);
        reader.loadBeanDefinition(resource);
    }

    @Override
    public Object getBean(String beanId) {
        return factory.getBean(beanId);
    }
}

