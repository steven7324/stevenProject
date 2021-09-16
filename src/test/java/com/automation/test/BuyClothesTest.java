package com.automation.test;

import com.automation.test.util.BrowserManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.awt.*;
import java.time.Duration;
import java.util.NoSuchElementException;


public class BuyClothesTest {

    public WebDriver driver = BrowserManager.build();
    Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30))
            .pollingEvery(Duration.ofSeconds(3))
            .ignoring(NoSuchElementException.class)
            .ignoring(MoveTargetOutOfBoundsException.class);

    Actions actions = new Actions(driver);

    @Test
    public void addSomethingToCartAndBuyIt() {
        driver.navigate().to("http://automationpractice.com/");
        //addToCart and Checkout
        WebElement btnViewCloth = driver.findElement(By.xpath("(//ul[@id='homefeatured']/li//a[@class='product-name'])[1]"));

        btnViewCloth.sendKeys(Keys.DOWN);

        wait.until(ExpectedConditions.visibilityOf(btnViewCloth));
        actions.moveToElement(btnViewCloth).perform();

        WebElement btnAddToCart = driver.findElement(By.xpath("(//span[normalize-space()='Add to cart'])[1]"));
        wait.until(ExpectedConditions.visibilityOf(btnAddToCart));
        btnAddToCart.click();

        WebElement btnCheckout = driver.findElement(By.xpath("//a[@title='Proceed to checkout']"));
        wait.until(ExpectedConditions.visibilityOf(btnCheckout));
        btnCheckout.click();

        WebElement btnCheckoutSummary = driver.findElement(By.xpath("//span[text()='Proceed to checkout']"));
        btnCheckoutSummary.click();
        //login
        WebElement txtEmail = driver.findElement(By.id("email"));
        wait.until(ExpectedConditions.visibilityOf(txtEmail));
        txtEmail.sendKeys("steven7324@yopmail.com");
        WebElement txtPassword = driver.findElement(By.id("passwd"));
        txtPassword.sendKeys("Steven21");
        WebElement btnSubmit = driver.findElement(By.id("SubmitLogin"));
        btnSubmit.click();

        WebElement btnCheckoutAddress = driver.findElement(By.xpath("//span[text()='Proceed to checkout']"));
        btnCheckoutAddress.click();

        //Shipping
        WebElement ckbAgreeTerms = driver.findElement(By.id("cgv"));
        ckbAgreeTerms.click();
        WebElement btnCheckoutShipping = driver.findElement(By.xpath("//button[normalize-space() = 'Proceed to checkout']"));
        btnCheckoutShipping.click();

        //payment
        WebElement btnPaymentMethod = driver.findElement(By.className("bankwire"));
        btnPaymentMethod.click();

        //Confirm order
        WebElement btnConfirmOrder = driver.findElement(By.xpath("//button[normalize-space()='I confirm my order']"));
        btnConfirmOrder.click();

        //Verify the order is completed
        WebElement verifyElement = driver.findElement(By.xpath("//p[@class='cheque-indent']"));
        wait.until(ExpectedConditions.visibilityOf(verifyElement));
        Assertions.assertEquals(verifyElement.getText(), "Your order on My Store is complete.");
        driver.quit();
    }

}
