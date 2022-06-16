package com.example.parstagram;

import android.app.Application;

import com.parse.Parse;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("48ky4sVeyBrDq4NBiV96dF6UPxMTP5yQWT8to1jR")
                .clientKey("WN8mmMCZpFyo6Let0nvwLeG1YdX4w1x4DB6gvC7d")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}

