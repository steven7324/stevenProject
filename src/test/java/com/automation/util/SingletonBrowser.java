package com.automation.util;

import org.openqa.selenium.WebDriver;

public class SingletonBrowser {

    private static SingletonBrowser instanceOfSingletonBrowser = null;

    private final WebDriver driver;

    private SingletonBrowser() {
        driver = BrowserManager.build();
    }

    synchronized public static SingletonBrowser getInstanceOfSingletonBrowser() {

        if (instanceOfSingletonBrowser == null) {
            instanceOfSingletonBrowser = new SingletonBrowser();
        }

        return instanceOfSingletonBrowser;
    }

    public WebDriver getDriver() {
        return driver;
    }

}
