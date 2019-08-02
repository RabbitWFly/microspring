package com.rabbitwfly.tes_t.v2;

import com.rabbitwfly.beans.SimpleTypeConverter;
import com.rabbitwfly.beans.TypeConverter;
import com.rabbitwfly.beans.TypeMismatchException;
import com.rabbitwfly.dao.v2.AccountDao;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.fail;

/**
 * @Author chentao
 * Date 2019/8/2
 * Description
 **/
public class TypeConverterTest {
    @Test
    public void testConvertStringToObject() {
        TypeConverter converter = new SimpleTypeConverter();

        // Integer
        {
            Integer integer = converter.convertIfNecessary("1", Integer.class);
            Assert.assertEquals(1, integer.intValue());

            try {
                converter.convertIfNecessary("3.1", Integer.class);
            } catch (TypeMismatchException e) {
                return;
            }
            fail();
        }

        // boolean
        {
            Boolean b = converter.convertIfNecessary("true", Boolean.class);
            Assert.assertEquals(b, b.booleanValue());

            try {
                converter.convertIfNecessary("xxxxxxxx", Integer.class);
            } catch (TypeMismatchException e) {
                return;
            }
            fail();
        }

        // date
        {
            Date birthday = converter.convertIfNecessary("2019-01-22", Date.class);
            Assert.assertTrue(birthday instanceof Date);

            try {
                converter.convertIfNecessary("20190122", Date.class);
            } catch (TypeMismatchException e) {
                return;
            }
            fail();
        }

        // AccountDao
        {
            AccountDao accountDao = converter.convertIfNecessary(new AccountDao(), AccountDao.class);
            Assert.assertNotNull(accountDao);

        }

    }
}

