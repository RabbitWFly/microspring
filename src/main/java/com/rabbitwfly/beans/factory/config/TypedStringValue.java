package com.rabbitwfly.beans.factory.config;

/**
 * <property name ="url" value="https://www.rabbitwfly.com/"></property>
 * value="https://www.rabbitwfly.com/"
 * 表示 引用的字符串 无需转换
 * @Author chentao
 * Date 2019/7/31
 **/
public class TypedStringValue {

    private final String value;

    public TypedStringValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

