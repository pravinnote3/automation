package com.retail.sosaxle.drivers;
import com.retail.sosaxle.configloader.JsonParser;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;
import java.net.URL;

public class Hooks {
    private static AppiumDriverLocalService localAppiumServer;
    private static String APPIUM_SERVER_URL = "http://localhost:4723/wd/hub/";

    public static void startAppiumServer() {
        System.out.println(String.format("Start local Appium server"));
        AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();
        // Get the Appium port from config.json
        int appiumPort = 4723; //Integer.parseInt(JsonParser.getConfig(ConfigJson.APPIUM_PORT));
        serviceBuilder.usingPort(appiumPort); // Use the specific port
        serviceBuilder.withLogFile(new File("./target/appium_logs.txt"));
        serviceBuilder.withArgument(GeneralServerFlag.ALLOW_INSECURE, "adb_shell");
        serviceBuilder.withArgument(GeneralServerFlag.RELAXED_SECURITY);

        // For Appium 1.x, you might need withBasePath. For Appium 2.x, it's usually not needed.
        localAppiumServer = AppiumDriverLocalService.buildService(serviceBuilder);
        localAppiumServer.start();
        APPIUM_SERVER_URL = localAppiumServer.getUrl().toString();
        System.out.println(String.format("Appium server started on url: '%s'",
                localAppiumServer.getUrl().toString()));


    }

    public static void stopAppiumServer() {
        if (null != localAppiumServer) {
            System.out.println(String.format("Stopping the local Appium server running on: '%s'",
                    localAppiumServer.getUrl()
                            .toString()));
            localAppiumServer.stop();
            System.out.println("Is Appium server running? " + localAppiumServer.isRunning());
        }
    }

    public static URL getAppiumServerUrl() {
        System.out.println("Appium server url: " + localAppiumServer.getUrl());
        return localAppiumServer.getUrl();
    }
}
