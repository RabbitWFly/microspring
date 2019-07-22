package com.rabbitwfly.beans.factory;

import com.rabbitwfly.beans.BeansException;

/**
 * @Author chentao
 * Date 2019/7/20
 * 创建bean 的异常类
 **/
public class BeanCreationException extends BeansException {
    private String beanName;

    public BeanCreationException(String message){
        super(message);
    }

    public BeanCreationException(String message, Throwable cause) {
        super(message, cause);
    }

    public BeanCreationException(String beanName, String msg){
        super("Error creating bean with name '" + beanName + "':" + msg);
        this.beanName = beanName;
    }

    public BeanCreationException(String beanName, String msg, Throwable cause) {
        this(beanName, msg);
        initCause(cause);
    }

    public String getBeanName(){
        return this.beanName;
    }

}

