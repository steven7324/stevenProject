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

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;


public class GoogleSeleniumTest {

    @BeforeAll
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void searchSomethingInGooglePage() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        WebElement txtSearchField = driver.findElement(By.name("q"));
//        WebElement btnSearch = driver.findElement(By.name("btnK"));

        txtSearchField.sendKeys("cars");
        txtSearchField.sendKeys(Keys.ENTER);

        WebElement verifyElement = driver.findElement(By.id("pTwnEc"));
        Assertions.assertTrue(verifyElement.isDisplayed());

        driver.quit();
    }

}
