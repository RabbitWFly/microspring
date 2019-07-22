package com.rabbitwfly.beans.factory;

import com.rabbitwfly.beans.BeansException;

/**
 * @Author chentao
 * Date 2019/7/19
 * Description
 **/
public class BeanDefinitionStoreException extends BeansException {

    public BeanDefinitionStoreException(String message, Throwable cause){
        super(message, cause);
    }
}

