package com.google.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.sql.Time;
import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class GoogleSeleniumTest {

    protected static final String BROWSER = System.getProperty("BROWSER", "firefox");
    public WebDriver driver;

    @BeforeAll
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
    }

    @Test
    public void searchSomethingInGooglePageWithChrome() throws InterruptedException {
        switch (BROWSER) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
        }

        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        WebElement txtSearchField = driver.findElement(By.name("q"));
        txtSearchField.sendKeys("cars");
        txtSearchField.sendKeys(Keys.ENTER);
        TimeUnit.SECONDS.sleep(5);
        WebElement verifyElement = driver.findElement(By.id("pTwnEc"));

        Assertions.assertTrue(verifyElement.isDisplayed());
        driver.quit();
    }

}
