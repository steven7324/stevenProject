package com.demoqa.pages;

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

import static com.automation.drivers.InstantiateDriver.getInstanceOfWebDriver;


public class VerifyRegistrationPage {

    private Wait<WebDriver> wait;
    private Actions actions;

    @FindBy(css = "#example-modal-sizes-title-lg")
    private WebElement verifyElement;

    public VerifyRegistrationPage() {
        wait = new FluentWait<>(getInstanceOfWebDriver().getDriver()).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class)
                .ignoring(MoveTargetOutOfBoundsException.class);
        actions = new Actions(getInstanceOfWebDriver().getDriver());
        PageFactory.initElements(getInstanceOfWebDriver().getDriver(), this);
    }

    public String getCompleteRegistrationMessage() {
        wait.until(ExpectedConditions.visibilityOf(verifyElement));
        return verifyElement.getText();

    }
}
