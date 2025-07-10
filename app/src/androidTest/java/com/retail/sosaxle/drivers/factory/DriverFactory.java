package com.retail.sosaxle.drivers.factory;

import com.retail.sosaxle.drivers.AndroidManager;
import com.retail.sosaxle.drivers.IosManager;
import com.retail.sosaxle.enums.MobilePlatformName;

import static com.retail.sosaxle.enums.MobilePlatformName.ANDROID;
import static com.retail.sosaxle.enums.MobilePlatformName.IOS;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

import io.appium.java_client.AppiumDriver;

public final class DriverFactory {
    private static final Map<MobilePlatformName, Supplier<AppiumDriver>> DRIVER_TYPE_MAP =
            new EnumMap<>(MobilePlatformName.class);

    static {
        DRIVER_TYPE_MAP.put(ANDROID, AndroidManager::createAndroidDriver);
        DRIVER_TYPE_MAP.put(IOS, IosManager::createIOSDriver);
    }

    public static AppiumDriver getDriver(MobilePlatformName mobilePlatformName) {
        return DRIVER_TYPE_MAP.get(mobilePlatformName).get();
    }
}
