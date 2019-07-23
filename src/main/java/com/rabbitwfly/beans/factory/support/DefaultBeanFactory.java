package com.rabbitwfly.beans.factory.support;

import com.rabbitwfly.beans.BeanDefinition;
import com.rabbitwfly.beans.factory.BeanCreationException;
import com.rabbitwfly.beans.factory.BeanDefinitionStoreException;
import com.rabbitwfly.beans.factory.BeanFactory;
import com.rabbitwfly.util.ClassUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author chentao
 * Date 2019/7/19
 * BeanFactory 默认实现类
 **/
public class DefaultBeanFactory implements BeanFactory {

    private static final String ID_ATTRIBUTE = "id";
    private static final String CLASS_ATTRIBUTE = "class";

    private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    /**
     * 具体解析bean.xml 的方法，使用dom4j
     * @param configFile
     */
    private void loadBeanDefinition(String configFile){
        ClassLoader cl = ClassUtils.getDefaultClassLoader();
        try(InputStream is = cl.getResourceAsStream(configFile)){
            SAXReader reader = new SAXReader();
            Document doc = reader.read(is);

            Element root = doc.getRootElement();
            Iterator<Element> elementIterator = root.elementIterator();
            while (elementIterator.hasNext()) {
                Element ele = elementIterator.next();
                String id = ele.attributeValue(ID_ATTRIBUTE);
                String beanClassName = ele.attributeValue(CLASS_ATTRIBUTE);
                BeanDefinition bd = new GenericBeanDefinition(id, beanClassName);
                this.beanDefinitionMap.put(id, bd);
            }
        } catch (Exception e){
            throw new BeanDefinitionStoreException("IOException parsing XML document", e);
        }
    }

    @Override
    public BeanDefinition getBeanDefinition(String beanId) {
        return this.beanDefinitionMap.get(beanId);
    }

    @Override
    public Object getBean(String beanId) {
        BeanDefinition bd = this.getBeanDefinition(beanId);
        if(null == bd){
            throw new BeanCreationException("BeanDefinition does not exist");
        }
        ClassLoader cl = ClassUtils.getDefaultClassLoader();
        String beanClassName = bd.getBeanClassName();
        try{
            //使用反射创建bean的实例，需要对象存在默认的无参构造方法
            Class<?> clz = cl.loadClass(beanClassName);
            return clz.newInstance();
        } catch (Exception e){
            throw new BeanCreationException("Bean Definition does not exist");
        }

    }

    @Override
    public void registerBeanDefinition(String beanID, BeanDefinition bd) {
        this.beanDefinitionMap.put(beanID, bd);
    }
}

