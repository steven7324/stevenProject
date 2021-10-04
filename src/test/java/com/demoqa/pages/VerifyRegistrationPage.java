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

import static com.demoqa.util.SingletonBrowser.getInstanceOfSingletonBrowser;


public class VerifyRegistrationPage {

    private Wait<WebDriver> wait;
    private Actions actions;

    @FindBy(id = "example-modal-sizes-title-lg")
    private WebElement verifyElement;

    public VerifyRegistrationPage() {
        wait = new FluentWait<>(getInstanceOfSingletonBrowser().getDriver()).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class)
                .ignoring(MoveTargetOutOfBoundsException.class);
        actions = new Actions(getInstanceOfSingletonBrowser().getDriver());
        PageFactory.initElements(getInstanceOfSingletonBrowser().getDriver(), this);
    }

    public String getCompleteRegistrationMessage() {
        wait.until(ExpectedConditions.visibilityOf(verifyElement));
        return verifyElement.getText();

    }
}
