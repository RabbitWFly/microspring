package com.rabbitwfly.beans;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author chentao
 * Date 2019/8/5
 * 描述bean的constructor-arg的所有属性 集合 如  <constructor-arg ref="accountDao"/>
 **/
public class ConstructorArgument {

    private final List<ValueHolder> argumentValues = new LinkedList<ValueHolder>();

    public ConstructorArgument() {
    }

    public void addArgumentValue(ValueHolder valueHolder){
        this.argumentValues.add(valueHolder);
    }

    public List<ValueHolder> getArgumentValues() {
        return Collections.unmodifiableList(this.argumentValues);
    }

    public boolean isEmpty(){
        return this.argumentValues.isEmpty();
    }

    public int getArgumentCount(){
        return this.argumentValues.size();
    }

    public void clear(){
        this.argumentValues.clear();
    }

    /**
     * 对应每一个<constructor-arg ref="accountDao"/>标签内容
     */
    public static class ValueHolder{
        private Object value;

        private String type;

        private String name;

        public ValueHolder(Object value) {
            this.value = value;
        }

        public ValueHolder(Object value, String type) {
            this.value = value;
            this.type = type;
        }

        public ValueHolder(Object value, String type, String name) {
            this.value = value;
            this.type = type;
            this.name = name;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

