package com.rabbitwfly.tes_t.v3;

import com.rabbitwfly.beans.BeanDefinition;
import com.rabbitwfly.beans.ConstructorArgument;
import com.rabbitwfly.beans.factory.config.RuntimeBeanReference;
import com.rabbitwfly.beans.factory.config.TypedStringValue;
import com.rabbitwfly.beans.factory.support.DefaultBeanFactory;
import com.rabbitwfly.beans.factory.xml.XmlBeanDefinitionReader;
import com.rabbitwfly.core.io.ClassPathResource;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @Author chentao
 * Date 2019/8/5
 * Description
 **/
public class BeanDefinitionTestV3 {
    DefaultBeanFactory factory = null;
    XmlBeanDefinitionReader reader = null;

    @Before
    public void setUp() {
        factory = new DefaultBeanFactory();
        reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinition(new ClassPathResource("bean-v3.xml"));
    }

    @Test
    public void testConstructorArgument() {

        BeanDefinition bd = factory.getBeanDefinition("nioCoder");
        Assert.assertEquals("com.rabbitwfly.service.v3.NioCoderService", bd.getBeanClassName());

        ConstructorArgument args = bd.getConstructorArgument();
        List<ConstructorArgument.ValueHolder> valueHolders = args.getArgumentValues();

        Assert.assertEquals(3, valueHolders.size());

        RuntimeBeanReference ref1 = (RuntimeBeanReference) valueHolders.get(0).getValue();
        Assert.assertEquals("accountDao", ref1.getBeanName());

        RuntimeBeanReference ref2 = (RuntimeBeanReference) valueHolders.get(1).getValue();
        Assert.assertEquals("itemDao", ref2.getBeanName());

        TypedStringValue stringValue = (TypedStringValue) valueHolders.get(2).getValue();
        Assert.assertEquals("1", stringValue.getValue());
    }
}

