package com.rabbitwfly.beans;

/**
 * @Author chentao
 * Date 2019/7/31
 * 描述bean的property属性 如  <property name ="accountDao" ref="accountDao"></property>
 **/
public class PropertyValue {

    /**
     * property name ="accountDao"
     */
    private final String name;

    /**
     * property ref="accountDao"
     */
    private final Object value;

    /**
     * 表示是否转换
     */
    private Boolean converted = false;

    /**
     * 转换后的实体类 ref="accountDao" 对应的 new AccountDao();
     */
    private Object convertedValue;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }

    public Boolean isConverted() {
        return this.converted;
    }

    public Object getConvertedValue() {
        return convertedValue;
    }

    public void setConvertedValue(Object convertedValue) {
        this.convertedValue = convertedValue;
    }
}

