package com.sp.pet.mobile.automation.util.runners;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.sp.pet.mobile.automation.providers.AndroidDriverProvider;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static io.appium.java_client.service.local.AppiumDriverLocalService.buildDefaultService;

public abstract class AndroidTestRunner {
    protected static AppiumDriverLocalService service;

    @BeforeAll
    public static void globalSetUp() {
        service = buildDefaultService();
        service.start();
        Configuration.timeout = 90000;
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserSize = null;
        Configuration.browser = AndroidDriverProvider.class.getName();
        Selenide.open();
    }

    @AfterAll
    public static void globalTearDown() {
        service.stop();
    }
}