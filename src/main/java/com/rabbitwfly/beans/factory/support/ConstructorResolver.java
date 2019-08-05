package com.rabbitwfly.beans.factory.support;

import com.rabbitwfly.beans.BeanDefinition;
import com.rabbitwfly.beans.ConstructorArgument;
import com.rabbitwfly.beans.SimpleTypeConverter;
import com.rabbitwfly.beans.factory.BeanCreationException;
import com.rabbitwfly.util.ClassUtils;

import java.lang.reflect.Constructor;
import java.util.List;

/**
 * 将<constructor-arg ref="accountDao"/>
 * accountDao 转换成实例bean
 * @Author chentao
 * Date 2019/8/5
 * Description
 **/
public class ConstructorResolver {
    private final DefaultBeanFactory factory;

    public ConstructorResolver(DefaultBeanFactory factory) {
        this.factory = factory;
    }

    public Object autowireConstructor(BeanDefinition bd) {
        Constructor<?> constructorToUse = null;
        Object[] argsToUse = null;

        Class beanClass = bd.getBeanClass();

        if (null == beanClass) {
            try {
                beanClass = ClassUtils.getDefaultClassLoader().loadClass(bd.getBeanClassName());
                bd.setBeanClass(beanClass);
            } catch (ClassNotFoundException e) {
                throw new BeanCreationException(bd.getId(), "Instantiation of bean failed, can't resolve class", e);
            }
        }
        Constructor[] candidates = beanClass.getConstructors();

        BeanDefinitionValueResolver valueResolver = new BeanDefinitionValueResolver(this.factory);

        ConstructorArgument cargs = bd.getConstructorArgument();
        SimpleTypeConverter typeConverter = new SimpleTypeConverter();

        for (int i = 0; i < candidates.length; i++) {
            Class[] parameterTypes = candidates[i].getParameterTypes();
            if (parameterTypes.length != cargs.getArgumentCount()) {
                continue;
            }
            argsToUse = new Object[parameterTypes.length];
            boolean result = this.valuesMatchTypes(parameterTypes, cargs.getArgumentValues(), argsToUse, valueResolver, typeConverter);
            if (result) {
                constructorToUse = candidates[i];
                break;
            }
        }

        //找不到一个合适的构造函数
        if (constructorToUse == null) {
            throw new BeanCreationException(bd.getId(), "can't find a apporiate constructor");
        }

        try {
            return constructorToUse.newInstance(argsToUse);
        } catch (Exception e) {
            throw new BeanCreationException(bd.getId(), "can't find a create instance using " + constructorToUse);
        }
    }

    private boolean valuesMatchTypes(Class[] parameterTypes, List<ConstructorArgument.ValueHolder> argumentValues, Object[] argsToUse, BeanDefinitionValueResolver valueResolver, SimpleTypeConverter typeConverter) {

        for (int i = 0; i < parameterTypes.length; i++) {
            ConstructorArgument.ValueHolder valueHolder = argumentValues.get(i);
            // 判断参数类型有可能是RuntimeBeanReference 也有可能是TypedStringValue
            Object originalValue = valueHolder.getValue();

            try {
                // 获取真正的值
                Object resolvedValue = valueResolver.resolveValueIfNecessary(originalValue);

                // 专程对应的参数类型 如 "1" Integer
                Object convertedValue = typeConverter.convertIfNecessary(resolvedValue, parameterTypes[i]);
                argsToUse[i] = convertedValue;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return false;
            }
        }
        return true;
    }
}

