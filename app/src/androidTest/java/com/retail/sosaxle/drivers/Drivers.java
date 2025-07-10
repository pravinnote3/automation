package com.retail.sosaxle.drivers;

import com.retail.sosaxle.drivers.factory.DriverFactory;
import com.retail.sosaxle.enums.MobilePlatformName;

import java.util.Objects;

public class Drivers {

    public static void initializeDriver(MobilePlatformName mobilePlatformName) {
        DriverManager.setAppiumDriver(DriverFactory.getDriver(mobilePlatformName));
    }

    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
