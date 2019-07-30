package com.rabbitwfly.v1;

import com.rabbitwfly.core.io.ClassPathResource;
import com.rabbitwfly.core.io.FileSystemResource;
import com.rabbitwfly.core.io.Resource;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Author chentao
 * Date 2019/7/24
 * Description
 **/
public class ResourceTest {

    @Test
    public void testClassPathResource() throws Exception{
        Resource resource = new ClassPathResource("bean-v1.xml");
        Assert.assertNotNull(resource.getInputStream());
    }

    @Test
    public void testFileSystemResource() throws Exception{
        Resource resource = new FileSystemResource("src/test/resources/bean-v1.xml");
        Assert.assertNotNull(resource.getInputStream());
    }
}

