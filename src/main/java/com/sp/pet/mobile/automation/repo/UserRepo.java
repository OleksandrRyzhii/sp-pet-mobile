package com.sp.pet.mobile.automation.repo;

import com.sp.pet.mobile.automation.models.User;

import java.util.ResourceBundle;

public class UserRepo {
    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle("users");

    public static User getUser() {
        return User.builder()
                .email(get("email"))
                .password(get("password"))
                .build();
    }

    private static String get(String property) {
        return BUNDLE.getString(property);
    }
}