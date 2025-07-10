package com.retail.sosaxle.drivers;

import static com.retail.sosaxle.configloader.JsonParser.getConfig;

import com.retail.sosaxle.constants.FrameWorkConstants;
import com.retail.sosaxle.enums.ConfigJson;
import com.retail.sosaxle.exceptions.DriverInitializationException;

import java.net.URL;
import java.time.Duration;
import java.util.Optional;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class AndroidManager {
    public static AppiumDriver createAndroidDriver() {
        try {
            UiAutomator2Options options = new UiAutomator2Options();
            options.setDeviceName(Optional.ofNullable(System.getProperty("deviceName"))
                            .orElse(getConfig(ConfigJson.ANDROID_DEVICE_NAME)))
                    .setUdid(Optional.ofNullable(System.getProperty("udid"))
                            .orElse(getConfig(ConfigJson.ANDROID_UDID)))
                    .setAppPackage(getConfig(ConfigJson.ANDROID_APP_PACKAGE))
                    .setAppActivity(getConfig(ConfigJson.ANDROID_APP_ACTIVITY))
                    .setSystemPort(Integer.parseInt(Optional.ofNullable(System.getProperty("systemPort"))
                            .orElse(getConfig(
                                    ConfigJson.ANDROID_SYSTEM_PORT))));

            return new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
        } catch (Exception e) {
            throw new DriverInitializationException("Failed to initialize driver. Please check the desired capabilities", e);
        }
    }
}
