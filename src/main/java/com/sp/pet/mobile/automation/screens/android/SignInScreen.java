package com.sp.pet.mobile.automation.screens.android;

import com.sp.pet.mobile.automation.models.User;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class SignInScreen {
    public SignInScreen signIn(User user) {
        $x("//android.widget.EditText[contains(@text,'Email')]").sendKeys(user.getEmail());
        $x("//android.widget.EditText[contains(@text,'Password')]").sendKeys(user.getPassword());

        $x("//android.widget.TextView[@text='SIGN IN']/ancestor::*[@resource-id='loginButton']").click();

        $x("//android.widget.ProgressBar")
                .shouldBe(visible)
                .shouldNotBe(visible);

        return this;
    }

    public String getErrorMessage() {
        return $x("//android.widget.ScrollView/android.view.ViewGroup/" +
                "android.view.ViewGroup[4]/android.widget.TextView").text();
    }
}