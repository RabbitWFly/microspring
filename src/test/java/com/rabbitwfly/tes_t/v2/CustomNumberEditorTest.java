package com.rabbitwfly.tes_t.v2;

import com.rabbitwfly.beans.propertyeditors.CustomNumberEditor;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Author chentao
 * Date 2019/8/2
 * Description
 **/
public class CustomNumberEditorTest {

    @Test
    public void testConvertString2Number(){
        CustomNumberEditor editor = new CustomNumberEditor(Integer.class, true);
        editor.setAsText("1");
        Object value = editor.getValue();
        Assert.assertTrue(value instanceof Integer);
        Assert.assertEquals(1, ((Integer) editor.getValue()).intValue());

        editor.setAsText("");
        Assert.assertTrue(editor.getValue() == null);

        try {
            editor.setAsText("3.1");
        } catch (IllegalArgumentException e) {
            return;
        }
        Assert.fail();
    }
}

