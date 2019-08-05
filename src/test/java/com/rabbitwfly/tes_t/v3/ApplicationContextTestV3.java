package com.rabbitwfly.tes_t.v3;

import com.rabbitwfly.context.ApplicationContext;
import com.rabbitwfly.context.support.ClassPathXmlApplicationContext;
import com.rabbitwfly.service.v3.NioCoderService;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Author chentao
 * Date 2019/8/5
 * Description
 **/
public class ApplicationContextTestV3 {

    @Test
    public void testGetBeanProperty() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-v3.xml");
        NioCoderService nioCoderService = (NioCoderService) ctx.getBean("nioCoder");

        Assert.assertNotNull(nioCoderService.getAccountDao());
        Assert.assertNotNull(nioCoderService.getItemDao());
        Assert.assertNotNull(nioCoderService.getVersion());

    }
}

