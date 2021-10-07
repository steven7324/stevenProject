package com.automation.drivers;

import org.openqa.selenium.WebDriver;

public class UniqueInstanceBrowser {

    private static UniqueInstanceBrowser instanceOfSingletonBrowser = null;

    private final WebDriver driver;

    private UniqueInstanceBrowser() {
        driver = BrowserManager.build();
    }

    synchronized public static UniqueInstanceBrowser getInstanceOfSingletonBrowser() {

        if (instanceOfSingletonBrowser == null) {
            instanceOfSingletonBrowser = new UniqueInstanceBrowser();
        }

        return instanceOfSingletonBrowser;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void closeInstanceOfSingletonBrowser(){
        instanceOfSingletonBrowser = null;
        driver.quit();
    }

}
