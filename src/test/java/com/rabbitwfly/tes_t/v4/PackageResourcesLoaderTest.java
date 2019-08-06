package com.rabbitwfly.tes_t.v4;

import com.rabbitwfly.core.io.Resource;
import com.rabbitwfly.core.io.support.PackageResourceLoader;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Author chentao
 * Date 2019/8/6
 * Description
 **/
public class PackageResourcesLoaderTest {

    @Test
    public void testGetResource() throws Exception {
        PackageResourceLoader loader = new PackageResourceLoader();
        Resource[] resources = loader.getResource("com.rabbitwfly.dao.v4");
        Assert.assertEquals(2, resources.length);
    }
}

