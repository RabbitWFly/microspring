package com.rabbitwfly.context.support;

import com.rabbitwfly.core.io.ClassPathResource;
import com.rabbitwfly.core.io.Resource;

/**
 * @Author chentao
 * Date 2019/7/30
 * 从classpath下读取bean.xml
 **/
public class ClassPathXmlApplicationContext extends AbstractApplicationContext {

    public ClassPathXmlApplicationContext(String configFile) {
       super(configFile);
    }

    @Override
    protected Resource getResourcePath(String configFile) {
        return new ClassPathResource(configFile);
    }
}

