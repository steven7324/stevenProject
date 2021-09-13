package com.google.test;

import com.google.test.util.Browser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;


public class GoogleSeleniumTest {

    public WebDriver driver = new Browser().browser();

    @Test
    public void searchSomethingInGooglePageWithChrome() throws InterruptedException {
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
