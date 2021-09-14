package com.google.test;

import com.google.test.util.BrowserManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;


public class GoogleSeleniumTest {

    public WebDriver driver = BrowserManager.build();

    @Test
    public void searchSomethingInGooglePageWithChromeAndFirefox() {
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.get("https://www.google.com");
        WebElement txtSearchField = driver.findElement(By.name("q"));
        txtSearchField.sendKeys("cars");
        txtSearchField.sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement verifyElement = driver.findElement(By.id("pTwnEc"));

        Assertions.assertTrue(verifyElement.isDisplayed());
        driver.quit();
    }

}
