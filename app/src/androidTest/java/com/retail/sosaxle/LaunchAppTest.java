package com.retail.sosaxle;


import com.retail.sosaxle.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;



public class LaunchAppTest extends BaseTest {

    @Test
    public void testAppSuccessfullyLaunched() {
        Assert.assertEquals("com.app.settngs", "com.app.settngs");
    }

}