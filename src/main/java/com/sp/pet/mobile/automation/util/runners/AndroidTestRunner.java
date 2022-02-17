package com.sp.pet.mobile.automation.util.runners;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static com.sp.pet.mobile.automation.repo.ConfigurationRepo.*;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.*;
import static io.appium.java_client.remote.MobileCapabilityType.*;
import static io.appium.java_client.service.local.AppiumDriverLocalService.buildDefaultService;
import static org.openqa.selenium.Platform.ANDROID;
import static org.openqa.selenium.ScreenOrientation.PORTRAIT;
import static org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME;

public abstract class AndroidTestRunner extends TestRunner {

    @BeforeAll
    public static void globalSetUp() {
        service = buildDefaultService();
        service.start();

        var capabilities = new DesiredCapabilities();
        capabilities.setCapability(NEW_COMMAND_TIMEOUT, 300);
        capabilities.setCapability(ORIENTATION, PORTRAIT);
        capabilities.setCapability(PLATFORM_NAME, ANDROID);
        capabilities.setCapability(AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(APP_PACKAGE, getAppPackage());
        capabilities.setCapability(APP_ACTIVITY, getAppActivity());
        capabilities.setCapability("appiumVersion", getAppiumVersion());
        capabilities.setCapability(DEVICE_NAME, getDeviceName());
        capabilities.setCapability(PLATFORM_VERSION, getPlatformVersion());
        capabilities.setCapability(ANDROID_INSTALL_TIMEOUT, "100000");
        capabilities.setCapability(APP, getAppPath());

        var appiumServerUrl = getAppiumServerUrl();
        try {
            DRIVER.set(new AppiumDriver<MobileElement>(new URL(appiumServerUrl), capabilities));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @AfterAll
    public static void globalTearDown() {
        service.stop();
    }
}