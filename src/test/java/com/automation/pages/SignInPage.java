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

import static com.automation.drivers.InstantiateDriver.getInstanceOfWebDriver;


public class SignInPage {

    private Wait<WebDriver> wait;
    private Actions actions;

    @FindBy(css = "#email")
    private WebElement txtEmail;

    @FindBy(css = "#passwd")
    private WebElement txtPassword;

    @FindBy(css = "#SubmitLogin")
    private WebElement btnSubmit;

    public SignInPage() {
        wait = new FluentWait<>(getInstanceOfWebDriver().getDriver()).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class)
                .ignoring(MoveTargetOutOfBoundsException.class)
                .ignoring(Throwable.class);
        actions = new Actions(getInstanceOfWebDriver().getDriver());
        PageFactory.initElements(getInstanceOfWebDriver().getDriver(), this);
    }

    public AddressPage sendTheCredentials(String username, String password) {
        wait.until(ExpectedConditions.visibilityOf(txtEmail));
        txtEmail.sendKeys(username);
        txtPassword.sendKeys(password);
        btnSubmit.click();
        return new AddressPage();

    }

}
