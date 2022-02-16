package com.sp.pet.mobile.automation.repo;

import com.sp.pet.mobile.automation.models.Configuration;
import lombok.Getter;
import lombok.experimental.UtilityClass;

import java.util.ResourceBundle;

import static org.apache.commons.lang3.StringUtils.EMPTY;


@UtilityClass
@Getter
public class ConfigurationRepo {

    private static ResourceBundle bundle = ResourceBundle.getBundle("configuration");

    public static Configuration getAndroidConfigurationProperties() {
        return Configuration
                .builder()
                .appiumVersion(getProperty("appium.version"))
                .appiumServerUrl(getProperty("appium.server.url"))
                .appPath(getProperty("android.app.path"))
                .appPackage(getProperty("android.app.package"))
                .appActivity(getProperty("android.app.activity"))
                .deviceName(getProperty("android.device.name"))
                .platformVersion(getProperty("android.platform.version"))
                .browserName(getProperty("android.browser.name"))
                .build();
    }

    private static String getProperty(String key) {
        return bundle.containsKey(key) ?
                bundle.getString(key)
                : EMPTY;
    }

}
