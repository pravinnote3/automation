package com.retail.sosaxle.base;

import com.retail.sosaxle.constants.TestConstants;
import com.retail.sosaxle.drivers.AndroidManager;
import com.retail.sosaxle.drivers.DriverManager;
import com.retail.sosaxle.drivers.Drivers;
import com.retail.sosaxle.drivers.Hooks;
import com.retail.sosaxle.enums.MobilePlatformName;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.time.Duration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest extends Hooks implements TestConstants {
    public static AppiumDriver driver;
    private static AppiumDriverLocalService service;

    @BeforeSuite
    public void beforeAll() {
        startAppiumServer();
    }

    @AfterSuite
    public void afterAll() {
        stopAppiumServer();
    }

    @BeforeMethod
    public void beforeMethod(Method method) {
        Drivers.initializeDriver(MobilePlatformName.ANDROID);
        driver = DriverManager.getDriver();
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        if (null != driver) {
            System.out.println("Close the driver"+result.getTestName());
            driver.quit();
        }
    }
    public static AppiumDriver getDriver() {
        return driver;
    }

    @AfterSuite
    public void tearDown() {
        System.out.println("Tearing down Appium Driver and Server...");
        if (driver != null) {
            driver.quit();
            System.out.println("Appium Driver Quit.");
        }
        if (service != null && service.isRunning()) {
            service.stop();
            System.out.println("Appium Server Stopped.");
        }
    }
}
