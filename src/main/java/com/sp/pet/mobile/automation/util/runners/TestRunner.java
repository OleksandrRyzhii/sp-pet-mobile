package com.sp.pet.mobile.automation.util.runners;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public abstract class TestRunner {
    protected static final ThreadLocal<AppiumDriver<MobileElement>> DRIVER = new ThreadLocal<>();
    protected static AppiumDriverLocalService service;

    public static AppiumDriver<MobileElement> getAppiumDriver() {
        return DRIVER.get();
    }

    //TODO
}
