package com.rabbitwfly.tes_t.v3;

import com.rabbitwfly.beans.BeanDefinition;
import com.rabbitwfly.beans.factory.support.ConstructorResolver;
import com.rabbitwfly.beans.factory.support.DefaultBeanFactory;
import com.rabbitwfly.beans.factory.xml.XmlBeanDefinitionReader;
import com.rabbitwfly.core.io.ClassPathResource;
import com.rabbitwfly.service.v3.NioCoderService;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Author chentao
 * Date 2019/8/5
 * Description
 **/
public class ConstructorResolverTest3 {

    @Test
    public void testAutowireConstructor() {
        DefaultBeanFactory factory = new DefaultBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinition(new ClassPathResource("bean-v3.xml"));

        BeanDefinition bd = factory.getBeanDefinition("nioCoder");

        ConstructorResolver resolver = new ConstructorResolver(factory);

        NioCoderService nioCoderService = (NioCoderService) resolver.autowireConstructor(bd);
        // 验证实通过构造函数初始化
        Assert.assertEquals(1, nioCoderService.getVersion());
        Assert.assertNotNull(nioCoderService.getAccountDao());
        Assert.assertNotNull(nioCoderService.getItemDao());
    }
}

