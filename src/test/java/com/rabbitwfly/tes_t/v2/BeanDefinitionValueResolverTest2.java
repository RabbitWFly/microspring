package com.rabbitwfly.tes_t.v2;

import com.rabbitwfly.beans.factory.config.RuntimeBeanReference;
import com.rabbitwfly.beans.factory.config.TypedStringValue;
import com.rabbitwfly.beans.factory.support.BeanDefinitionValueResolver;
import com.rabbitwfly.beans.factory.support.DefaultBeanFactory;
import com.rabbitwfly.beans.factory.xml.XmlBeanDefinitionReader;
import com.rabbitwfly.core.io.ClassPathResource;
import com.rabbitwfly.dao.v2.AccountDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author chentao
 * Date 2019/8/1
 * Description
 **/
public class BeanDefinitionValueResolverTest2 {

    DefaultBeanFactory factory = null;
    XmlBeanDefinitionReader reader = null;
    BeanDefinitionValueResolver resolver = null;


    @Before
    public void setUp(){
        factory = new DefaultBeanFactory();
        reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinition(new ClassPathResource("bean-v2.xml"));
        resolver = new BeanDefinitionValueResolver(factory);
    }

    @Test
    public void testResolveRuntimeBeanReference() {

        RuntimeBeanReference reference = new RuntimeBeanReference("accountDao");
        Object value = resolver.resolveValueIfNecessary(reference);

        Assert.assertNotNull(value);
        Assert.assertTrue(value instanceof AccountDao);
    }

    @Test
    public void testResolveTypedStringValue() {

        TypedStringValue stringValue = new TypedStringValue("https://www.rabbitwfly.com/");
        Object value = resolver.resolveValueIfNecessary(stringValue);

        Assert.assertNotNull(value);
        Assert.assertEquals("https://www.rabbitwfly.com/", value);
    }
}

