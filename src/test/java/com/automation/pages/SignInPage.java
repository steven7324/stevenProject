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

import static com.automation.util.SingletonBrowser.getInstanceOfSingletonBrowser;


public class SignInPage {

    private Wait<WebDriver> wait;
    private Actions actions;

    @FindBy(id = "email")
    private WebElement txtEmail;

    @FindBy(id = "passwd")
    private WebElement txtPassword;

    @FindBy(id = "SubmitLogin")
    private WebElement btnSubmit;

    public SignInPage() {
        wait = new FluentWait<>(getInstanceOfSingletonBrowser().getDriver()).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class)
                .ignoring(MoveTargetOutOfBoundsException.class);
        actions = new Actions(getInstanceOfSingletonBrowser().getDriver());
        PageFactory.initElements(getInstanceOfSingletonBrowser().getDriver(), this);
    }

    public void sendTheCredentials(String username, String password) {
        wait.until(ExpectedConditions.visibilityOf(txtEmail));
        txtEmail.sendKeys(username);
        wait.until(ExpectedConditions.elementToBeClickable(txtPassword));
        txtPassword.sendKeys(password);
        btnSubmit.click();

    }

}
