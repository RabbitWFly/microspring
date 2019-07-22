package com.rabbitwfly.util;

/**
 * @Author chentao
 * Date 2019/7/19
 * Description
 **/
public abstract class Assert {
    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
    }
}

