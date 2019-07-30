package com.rabbitwfly.core.io;

import com.rabbitwfly.util.ClassUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author chentao
 * Date 2019/7/24
 * 对应 ClassPathXmlApplicationContext
 **/
public class ClassPathResource implements Resource {

    private String path;

    public ClassPathResource(String path){
        this.path = path;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        InputStream is = ClassUtils.getDefaultClassLoader().getResourceAsStream(this.path);
        if(null == is){
            throw new FileNotFoundException(path + " cannot be opened");
        }
        return is;
    }

    @Override
    public String getDescription() {
        return this.path;
    }
}

