package com.retail.sosaxle.base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class BasePage {
    protected AppiumDriver driver;

    // Default wait time for explicit waits
    private final Duration WAIT_TIMEOUT = Duration.ofSeconds(15);

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        // Initialize elements using AppiumFieldDecorator for Page Object Model
        // This will automatically find elements annotated with @AndroidFindBy, @iOSXCUITFindBy, etc.

    }

}
