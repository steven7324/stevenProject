package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.NoSuchElementException;


public class PaymentPage {

    WebDriver driver;
    Wait<WebDriver> wait;
    Actions actions;

    @FindBy(className = "bankwire")
    private WebElement btnPaymentMethod;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class)
                .ignoring(MoveTargetOutOfBoundsException.class);
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public void chooseThePaymentMethod() {
        wait.until(ExpectedConditions.visibilityOf(btnPaymentMethod));
        btnPaymentMethod.click();

    }

}
