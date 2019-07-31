package com.rabbitwfly.tes_t.v2;

import com.rabbitwfly.beans.BeanDefinition;
import com.rabbitwfly.beans.PropertyValue;
import com.rabbitwfly.beans.factory.config.RuntimeBeanReference;
import com.rabbitwfly.beans.factory.support.DefaultBeanFactory;
import com.rabbitwfly.beans.factory.xml.XmlBeanDefinitionReader;
import com.rabbitwfly.core.io.ClassPathResource;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * 测试 property标签
 * <property name ="itemDao" ref="itemDao"></property>
 * <property name ="url" value="https://www.rabbitwfly.com/"></property>
 */
public class BeanDefinitionTestV2 {

    DefaultBeanFactory factory = null;
    XmlBeanDefinitionReader reader = null;

    @Before
    public void setUp() {
        factory = new DefaultBeanFactory();
        reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinition(new ClassPathResource("bean-v2.xml"));
    }

    @Test
    public void testGetBeanDefinition() throws Exception {

        BeanDefinition bd = factory.getBeanDefinition("nioCoder");
        List<PropertyValue> pvs = bd.getPropertyValues();
        Assert.assertTrue(pvs.size() == 3);
        {
            PropertyValue pv = this.getPropertyValues("accountDao", pvs);
            Assert.assertNotNull(pv);
            Assert.assertTrue(pv.getValue() instanceof RuntimeBeanReference);
        }

        {
            PropertyValue pv = this.getPropertyValues("itemDao", pvs);
            Assert.assertNotNull(pv);
            Assert.assertTrue(pv.getValue() instanceof RuntimeBeanReference);
        }
    }

    private PropertyValue getPropertyValues(String name, List<PropertyValue> pvs) {
        for (PropertyValue pv : pvs) {
            if (pv.getName().equals(name)) {
                return pv;
            }
        }
        return null;
    }
}

