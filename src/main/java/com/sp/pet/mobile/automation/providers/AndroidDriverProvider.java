package com.sp.pet.mobile.automation.providers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

import static com.sp.pet.mobile.automation.repo.ConfigurationRepo.*;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.*;
import static io.appium.java_client.remote.MobileCapabilityType.*;
import static io.appium.java_client.remote.MobileCapabilityType.APP;
import static org.openqa.selenium.Platform.ANDROID;
import static org.openqa.selenium.ScreenOrientation.PORTRAIT;
import static org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME;

public class AndroidDriverProvider implements WebDriverProvider {
    @CheckReturnValue
    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull DesiredCapabilities desiredCapabilities) {
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

        URL appiumServerUrl = null;
        try {
            appiumServerUrl = new URL(getAppiumServerUrl());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return new AndroidDriver(appiumServerUrl, capabilities);
    }
}