package com.automation.test.util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserManager {

    public static WebDriver build() {
        String BROWSER = System.getProperty("BROWSER", "chrome");

        switch (BROWSER) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                WebDriver chromeDriver = new ChromeDriver();
                chromeDriver.manage().window().maximize();
                return chromeDriver;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                WebDriver firefoxDriver = new FirefoxDriver();
                firefoxDriver.manage().window().maximize();
                return firefoxDriver;
            default:
                throw new IllegalStateException("Unexpected value: " + BROWSER);
        }
    }

}
