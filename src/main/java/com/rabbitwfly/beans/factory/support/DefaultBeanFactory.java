package com.rabbitwfly.beans.factory.support;

import com.rabbitwfly.beans.BeanDefinition;
import com.rabbitwfly.beans.factory.BeanCreationException;
import com.rabbitwfly.beans.factory.BeanFactory;
import com.rabbitwfly.util.ClassUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author chentao
 * Date 2019/7/19
 * BeanFactory 默认实现类
 **/
public class DefaultBeanFactory implements BeanFactory, BeanDefinitionRegistry {

    private static final String ID_ATTRIBUTE = "id";
    private static final String CLASS_ATTRIBUTE = "class";

    private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();


    @Override
    public BeanDefinition getBeanDefinition(String beanId) {
        return this.beanDefinitionMap.get(beanId);
    }

    @Override
    public void registerBeanDefinition(String beanID, BeanDefinition bd) {
        this.beanDefinitionMap.put(beanID, bd);
    }

    @Override
    public Object getBean(String beanId) {
        BeanDefinition bd = this.getBeanDefinition(beanId);
        if(null == bd){
            throw new BeanCreationException("BeanDefinition does not exist");
        }
        ClassLoader cl = ClassUtils.getDefaultClassLoader();
        String beanClassName = bd.getBeanClassName();
        try{
            //使用反射创建bean的实例，需要对象存在默认的无参构造方法
            Class<?> clz = cl.loadClass(beanClassName);
            return clz.newInstance();
        } catch (Exception e){
            throw new BeanCreationException("Bean Definition does not exist");
        }

    }

}

