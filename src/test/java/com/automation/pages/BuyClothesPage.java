package com.automation.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
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


public class BuyClothesPage {

    WebDriver driver;
    Wait<WebDriver> wait;
    Actions actions;

    @FindBy(xpath = "(//ul[@id='homefeatured']/li//a[@class='product-name'])[1]")
    public WebElement btnViewCloth;

    @FindBy(xpath = "(//span[normalize-space()='Add to cart'])[1]")
    public WebElement btnAddToCart;

    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    public WebElement btnCheckout;

    @FindBy(xpath = "//span[text()='Proceed to checkout']")
    public WebElement btnCheckoutSummary;

    @FindBy(id = "email")
    public WebElement txtEmail;

    @FindBy(id = "passwd")
    public WebElement txtPassword;

    @FindBy(id = "SubmitLogin")
    public WebElement btnSubmit;

    @FindBy(xpath = "//span[text()='Proceed to checkout']")
    public WebElement btnCheckoutAddress;

    @FindBy(id = "cgv")
    public WebElement ckbAgreeTerms;

    @FindBy(xpath = "//button[normalize-space() = 'Proceed to checkout']")
    public WebElement btnCheckoutShipping;

    @FindBy(className = "bankwire")
    public WebElement btnPaymentMethod;

    @FindBy(xpath = "//button[normalize-space()='I confirm my order']")
    public WebElement btnConfirmOrder;

    @FindBy(xpath = "//p[@class='cheque-indent']")
    public WebElement verifyElement;

    public BuyClothesPage(WebDriver driver) {
        this.driver = driver;
        wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class)
                .ignoring(MoveTargetOutOfBoundsException.class);
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public void setBtnViewCloth() {
        btnViewCloth.sendKeys(Keys.DOWN);
        wait.until(ExpectedConditions.visibilityOf(btnViewCloth));
        actions.moveToElement(btnViewCloth).perform();
    }

    public void setBtnAddToCart() {
        wait.until(ExpectedConditions.visibilityOf(btnAddToCart));
        btnAddToCart.click();
    }

    public void setBtnCheckout() {
        wait.until(ExpectedConditions.visibilityOf(btnCheckout));
        btnCheckout.click();
    }

    public void setBtnCheckoutSummary() {
        btnCheckoutSummary.click();
    }

    public void login() {
        wait.until(ExpectedConditions.visibilityOf(txtEmail));
        txtEmail.sendKeys("steven7324@yopmail.com");
        txtPassword.sendKeys("Steven21");
        btnSubmit.click();

    }

    public void setBtnCheckoutAddress() {
        btnCheckoutAddress.click();
    }

    public void setCkbAgreeTerms() {
        ckbAgreeTerms.click();
        btnCheckoutShipping.click();
    }

    public void setBtnPaymentMethod() {
        wait.until(ExpectedConditions.visibilityOf(btnPaymentMethod));
        btnPaymentMethod.click();

    }

    public void setBtnConfirmOrder() {
        btnConfirmOrder.click();

    }

    public void setVerifyElement() {
        wait.until(ExpectedConditions.visibilityOf(verifyElement));
        Assertions.assertEquals(verifyElement.getText(), "Your order on My Store is complete.");

    }
}
