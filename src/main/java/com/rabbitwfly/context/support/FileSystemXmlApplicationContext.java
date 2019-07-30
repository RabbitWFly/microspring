package com.rabbitwfly.context.support;

import com.rabbitwfly.core.io.FileSystemResource;
import com.rabbitwfly.core.io.Resource;

/**
 * @Author chentao
 * Date 2019/7/30
 * 从一个目录下读取bean.xml
 **/
public class FileSystemXmlApplicationContext extends AbstractApplicationContext {


    public FileSystemXmlApplicationContext(String configFile){
        super(configFile);
    }

    @Override
    protected Resource getResourcePath(String configFile) {
        return new FileSystemResource(configFile);
    }
}

