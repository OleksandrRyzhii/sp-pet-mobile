package com.sp.pet.mobile.automation.models;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Configuration {
    private String appPath;
    private String appPackage;
    private String appActivity;
    private String deviceName;
    private String platformVersion;
    private String appiumVersion;
    private String appiumServerUrl;
    private String browserName;
}
