package com.sp.pet.mobile.automation.repo;

import java.util.ResourceBundle;

import static java.util.ResourceBundle.getBundle;

public class ConfigurationRepo {
    private static final ResourceBundle BUNDLE = getBundle("configuration");

    public static String getAppiumVersion() {
        return get("appium.version");
    }

    public static String getAppiumServerUrl() {
        return get("appium.server.url");
    }

    public static String getAppPackage() {
        return get("android.app.package");
    }

    public static String getAppActivity() {
        return get("android.app.activity");
    }

    public static String getDeviceName() {
        return get("android.device.name");
    }

    public static String getPlatformVersion() {
        return get("android.platform.version");
    }

    public static String getAppPath() {
        return get("android.app.path");
    }

    private static String get(String property) {
        return BUNDLE.getString(property);
    }
}