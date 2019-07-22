package com.rabbitwfly.v1;

import com.rabbitwfly.beans.BeanDefinition;
import com.rabbitwfly.beans.factory.BeanCreationException;
import com.rabbitwfly.beans.factory.BeanDefinitionStoreException;
import com.rabbitwfly.beans.factory.BeanFactory;
import com.rabbitwfly.beans.factory.support.DefaultBeanFactory;
import com.rabbitwfly.service.v1.NioCoderService;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Author chentao
 * Date 2019/7/22
 * Description
 **/
public class BeanFactoryTest {

    /**
     * 测试获取bean
     */
    @Test
    public void testGetBean(){
        BeanFactory factory = new DefaultBeanFactory("bean-v1.xml");
        BeanDefinition bd = factory.getBeanDefinition("nioCoder");

        Assert.assertEquals("com.rabbitwfly.service.v1.NioCoderService", bd.getBeanClassName());
        NioCoderService nioCoderService = (NioCoderService) factory.getBean("nioCoder");

        Assert.assertNotNull(nioCoderService);

    }

    /**
     * 测试无效的bean
     */
    @Test
    public void testInvalidBean(){
        BeanFactory factory = new DefaultBeanFactory("bean-v1.xml");
        try{
            factory.getBean("invalidBean");
        } catch (BeanCreationException e){
            return;
        }
        Assert.fail("expect BeanCreationException ");
    }

    /**
     * 测试无效的xml
     */
    @Test
    public void testInvalidXML(){
        try{
            new DefaultBeanFactory("xxx.xml");
        } catch (BeanDefinitionStoreException e){
            return;
        }
        Assert.fail("expect BeanDefinitionStoreException ");
    }


}

