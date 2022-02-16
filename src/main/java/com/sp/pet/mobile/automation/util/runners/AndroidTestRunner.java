package com.sp.pet.mobile.automation.util.runners;

import com.sp.pet.mobile.automation.models.Configuration;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static com.sp.pet.mobile.automation.repo.ConfigurationRepo.getAndroidConfigurationProperties;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.*;
import static io.appium.java_client.remote.MobileCapabilityType.*;
import static io.appium.java_client.service.local.AppiumDriverLocalService.buildDefaultService;
import static java.lang.String.format;
import static org.openqa.selenium.Platform.ANDROID;
import static org.openqa.selenium.ScreenOrientation.PORTRAIT;
import static org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME;

public abstract class AndroidTestRunner extends TestRunner {

    protected static final Configuration ANDROID_CONFIG = getAndroidConfigurationProperties();

    @BeforeAll
    public static void globalSetUp() {
        service = buildDefaultService();
        service.start();

        //https://appium.io/docs/en/writing-running-appium/caps/ - description of capabilities
        var capabilities = new DesiredCapabilities();
        capabilities.setCapability(NEW_COMMAND_TIMEOUT, "60");
        capabilities.setCapability(ORIENTATION, PORTRAIT);
        capabilities.setCapability(PLATFORM_NAME, ANDROID);
        capabilities.setCapability(AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(APP_PACKAGE, ANDROID_CONFIG.getAppPackage());
        capabilities.setCapability(APP_ACTIVITY, ANDROID_CONFIG.getAppActivity());
        capabilities.setCapability("appiumVersion", ANDROID_CONFIG.getAppiumVersion());
        capabilities.setCapability(DEVICE_NAME, ANDROID_CONFIG.getDeviceName());
        capabilities.setCapability(PLATFORM_VERSION, ANDROID_CONFIG.getPlatformVersion());
        capabilities.setCapability(ANDROID_INSTALL_TIMEOUT, "100000");
        capabilities.setCapability(APP, ANDROID_CONFIG.getAppPath());

        var wdHubUrl = ANDROID_CONFIG.getAppiumServerUrl();

        try {
            DRIVER.set(new AppiumDriver<MobileElement>(new URL(wdHubUrl), capabilities));
        } catch (MalformedURLException e) {
            throw new AssertionError(format("Error with appium server %s. %s ", wdHubUrl, e));
        }

    }
}
