package com.automation.drivers;

import org.openqa.selenium.WebDriver;

public class InstantiateDriver {

    private static InstantiateDriver instanceOfWebDriver = null;

    private final WebDriver driver;

    private InstantiateDriver() {
        driver = BrowserManager.build();
    }

    synchronized public static InstantiateDriver getInstanceOfWebDriver() {

        if (instanceOfWebDriver == null) {
            instanceOfWebDriver = new InstantiateDriver();
        }

        return instanceOfWebDriver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void closeInstance() {
        instanceOfWebDriver = null;
        driver.quit();
    }

}
