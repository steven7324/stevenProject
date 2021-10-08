package com.automation.drivers;

import org.openqa.selenium.WebDriver;

public class instantiateDriver {

    private static instantiateDriver instanceOfWebDriver = null;

    private final WebDriver driver;

    private instantiateDriver() {
        driver = BrowserManager.build();
    }

    synchronized public static instantiateDriver getInstanceOfWebDriver() {

        if (instanceOfWebDriver == null) {
            instanceOfWebDriver = new instantiateDriver();
        }

        return instanceOfWebDriver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void closeInstance(){
        instanceOfWebDriver = null;
        driver.quit();
    }

}
