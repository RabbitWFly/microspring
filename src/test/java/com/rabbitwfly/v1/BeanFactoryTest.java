package com.rabbitwfly.v1;

import com.rabbitwfly.beans.BeanDefinition;
import com.rabbitwfly.beans.factory.BeanCreationException;
import com.rabbitwfly.beans.factory.BeanDefinitionStoreException;
import com.rabbitwfly.beans.factory.support.DefaultBeanFactory;
import com.rabbitwfly.beans.factory.xml.XmlBeanDefinitionReader;
import com.rabbitwfly.core.io.ClassPathResource;
import com.rabbitwfly.service.v1.NioCoderService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * @Author chentao
 * Date 2019/7/22
 * Description
 **/
public class BeanFactoryTest {

    DefaultBeanFactory factory = null;
    XmlBeanDefinitionReader reader = null;

    @Before
    public void setUp(){
        factory = new DefaultBeanFactory();
        reader = new XmlBeanDefinitionReader(factory);
    }

    /**
     * 测试获取bean
     */
    @Test
    public void testGetBean(){
        reader.loadBeanDefinition(new ClassPathResource("bean-v1.xml"));
        BeanDefinition bd = factory.getBeanDefinition("nioCoder");

        assertTrue(bd.isSingleton());
        assertFalse(bd.isPrototype());
        assertEquals(BeanDefinition.SCOPE_DEFAULT, bd.getScope());
        assertEquals("com.rabbitwfly.service.v1.NioCoderService", bd.getBeanClassName());

        NioCoderService nioCoderService = (NioCoderService) factory.getBean("nioCoder");
        assertNotNull(nioCoderService);

        NioCoderService nioCoderService1 = (NioCoderService) factory.getBean("nioCoder");
        assertTrue(nioCoderService.equals(nioCoderService1));

    }

    /**
     * 测试无效的bean
     */
    @Test
    public void testInvalidBean(){
        reader.loadBeanDefinition(new ClassPathResource("bean-v1.xml"));
        try {
            factory.getBean("invalidBean");
        } catch (BeanCreationException e) {
            return;
        }

        Assert.fail("expect BeanCreationException ");
    }

    /**
     * 测试无效的xml
     */
    @Test
    public void testInvalidXML(){
        try {
            reader.loadBeanDefinition(new ClassPathResource("xxx-v1.xml"));
        } catch (BeanDefinitionStoreException e) {
            return;
        }

        Assert.fail("expect BeanDefinitionStoreException ");
    }


}

