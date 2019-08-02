package com.rabbitwfly.beans.factory.support;

import com.rabbitwfly.beans.BeanDefinition;
import com.rabbitwfly.beans.PropertyValue;
import com.rabbitwfly.beans.SimpleTypeConverter;
import com.rabbitwfly.beans.factory.BeanCreationException;
import com.rabbitwfly.beans.factory.BeanFactory;
import com.rabbitwfly.util.ClassUtils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author chentao
 * Date 2019/7/19
 * BeanFactory 默认实现类
 **/
public class DefaultBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory, BeanDefinitionRegistry {

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
        if(bd.isSingleton()){
            Object bean = this.getSingleton(beanId);
            if(null == bean){
                bean = createBean(bd);
                this.registerSingleton(beanId, bean);
            }
            return bean;
        }
        return createBean(bd);

    }

    private Object createBean(BeanDefinition bd){
        //1. 创建实例
        Object bean = instantiateBean(bd);
        //2. 设置属性
        populateBean(bd, bean);
        return bean;
    }

    private void populateBean(BeanDefinition bd, Object bean){
        List<PropertyValue> pvs = bd.getPropertyValues();
        if(null == pvs || pvs.isEmpty()){
            return;
        }

        // 处理 bean.xml 中的 ref 和 value 对应  RuntimeBeanReference TypedStringValue
        //        <property name="itemDao" ref="itemDao"></property>
        //        <property name="url" value="https://www.rabbitwfly.com/"></property>
        BeanDefinitionValueResolver valueResolver = new BeanDefinitionValueResolver(this);
        // 处理bean.xml中的特殊类型 Integer Boolean Date 等
        //        <property name="birthday" value="2019-01-21"></property>
        //        <property name="flag" value="true"></property>
        //        <property name="version" value="1"></property>
        SimpleTypeConverter converter = new SimpleTypeConverter();

        try{
            for(PropertyValue pv : pvs){
                String propertyName = pv.getName();
                Object originalValue = pv.getValue();
                Object resolvedValue = valueResolver.resolveValueIfNecessary(originalValue);
                pv.setConvertedValue(resolvedValue);
                pv.setConvertedValue(true);
                //set 注入使用 java BeanInfo 实现
                BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
                PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
                for (PropertyDescriptor pd : pds) {
                    if (pd.getName().equals(propertyName)) {
                        //类型转换
                        Object convertedValue = converter.convertIfNecessary(resolvedValue, pd.getPropertyType());
                        pd.getWriteMethod().invoke(bean, convertedValue);
                        break;
                    }
                }

            }
        } catch (Exception e){
            throw new BeanCreationException("Failed to obtain BeanInfo for class [" + bd.getBeanClassName() + "]", e);
        }
    }

    private Object instantiateBean(BeanDefinition bd){
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

