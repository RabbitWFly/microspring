package com.rabbitwfly.beans.factory.support;

import com.rabbitwfly.beans.BeanDefinition;
import com.rabbitwfly.beans.ConstructorArgument;
import com.rabbitwfly.beans.PropertyValue;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author chentao
 * Date 2019/7/19
 * BeanDefinition 实现类
 **/
public class GenericBeanDefinition implements BeanDefinition {

    private String id;
    private String beanClassName;
    private boolean singleton = true;
    private boolean prototype = false;
    private String scope = SCOPE_DEFAULT;
    private Class beanClass;


    List<PropertyValue> propertyValues = new ArrayList<>();
    private ConstructorArgument constructorArgument = new ConstructorArgument();

    public GenericBeanDefinition(String id, String beanClassName) {
        this.id = id;
        this.beanClassName = beanClassName;
    }

    @Override
    public boolean isSingleton() {
        return this.singleton;
    }

    @Override
    public boolean isPrototype() {
        return this.prototype;
    }

    @Override
    public String getScope() {
        return this.scope;
    }

    @Override
    public void setScope(String scope) {
        this.scope = scope;
        this.singleton = SCOPE_SINGLETON.equals(scope) || SCOPE_DEFAULT.equals(scope);
        this.prototype = SCOPE_PROTOTYPE.equals(scope);
    }

    @Override
    public String getBeanClassName() {
        return this.beanClassName;
    }

    @Override
    public List<PropertyValue> getPropertyValues() {
        return this.propertyValues;
    }

    @Override
    public ConstructorArgument getConstructorArgument() {
        return this.constructorArgument;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public boolean hasConstructorArgumentValues() {
        return !this.constructorArgument.isEmpty();
    }

    @Override
    public Class getBeanClass() {
        return beanClass;
    }

    @Override
    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}

