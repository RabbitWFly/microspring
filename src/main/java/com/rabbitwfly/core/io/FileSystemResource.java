package com.rabbitwfly.core.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author chentao
 * Date 2019/7/24
 * 对应 FileSystemXmlApplicationContext
 **/
public class FileSystemResource implements Resource {

    private String path;
    private File file;

    public FileSystemResource(File file) {
        this.path = file.getPath();
        this.file = file;
    }


    public FileSystemResource(String path){
        this.path = path;
        this.file = new File(path);
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new FileInputStream(this.file);
    }

    @Override
    public String getDescription() {
        return this.file.getAbsolutePath();
    }
}

