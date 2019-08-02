package com.rabbitwfly.beans.propertyeditors;

import com.rabbitwfly.util.DateUtil;
import com.rabbitwfly.util.StringUtils;

import java.beans.PropertyEditorSupport;
import java.time.format.DateTimeFormatter;

/**
 * 将字符串转换成date类型
 * <property name="birthday" value="2019-01-21"></property>
 * @Author chentao
 * Date 2019/8/2
 **/
public class CustomDateEditor extends PropertyEditorSupport {
    private final DateTimeFormatter formatter;

    private final boolean allowEmpty;

    public CustomDateEditor(boolean allowEmpty) {
        this(allowEmpty, null);
    }

    public CustomDateEditor(boolean allowEmpty, DateTimeFormatter dateTimeFormatter) {
        this.allowEmpty = allowEmpty;
        this.formatter = dateTimeFormatter;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        String input = (text != null ? text.trim() : null);
        if (this.allowEmpty && !StringUtils.hasLength(input)) {
            setValue(null);
        } else if (this.formatter != null) {
            setValue(DateUtil.getDateBySr(input, formatter));
        } else {
            setValue(DateUtil.getDateBySr(input));
        }
    }

    @Override
    public String getAsText() {
        return getValue().toString();
    }
}

