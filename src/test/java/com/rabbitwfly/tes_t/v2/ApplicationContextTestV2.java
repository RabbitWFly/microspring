package com.rabbitwfly.tes_t.v2;

import com.rabbitwfly.context.ApplicationContext;
import com.rabbitwfly.context.support.ClassPathXmlApplicationContext;
import com.rabbitwfly.dao.v2.AccountDao;
import com.rabbitwfly.dao.v2.ItemDao;
import com.rabbitwfly.service.v2.NioCoderService;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * @Author chentao
 * Date 2019/8/1
 * Description
 **/
public class ApplicationContextTestV2 {

    @Test
    public void testGetBeanProperty(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-v2.xml");
        NioCoderService nioCoderService = (NioCoderService) ctx.getBean("nioCoder");

        Assert.assertNotNull(nioCoderService.getAccountDao());
        Assert.assertNotNull(nioCoderService.getItemDao());
        Assert.assertNotNull(nioCoderService.getUrl());
        Assert.assertNotNull(nioCoderService.getBirthday());
        Assert.assertNotNull(nioCoderService.getFlag());
        Assert.assertNotNull(nioCoderService.getVersion());

        assertTrue(nioCoderService.getItemDao() instanceof ItemDao);
        assertTrue(nioCoderService.getAccountDao() instanceof AccountDao);
        assertEquals(nioCoderService.getUrl(), "https://www.rabbitwfly.com/");
        assertTrue(nioCoderService.getBirthday() instanceof Date);
        assertTrue(nioCoderService.getFlag());
        assertEquals(nioCoderService.getVersion(), new Integer(1));
    }

}

