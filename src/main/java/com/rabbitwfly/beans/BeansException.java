package com.rabbitwfly.beans;

/**
 * @Author chentao
 * Date 2019/7/19
 * bean的异常类
 **/
public class BeansException extends RuntimeException {
    public BeansException(String message){
        super(message);
    }

    public BeansException(String message, Throwable cause){
        super(message, cause);
    }
}

