package com.automation.test;

import com.automation.test.util.BrowserManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class BuyPracticeTest {

    public WebDriver driver = BrowserManager.build();
    public WebDriverWait wait = new WebDriverWait(driver,30);

    @Test
    public void addSomethingToCartAndBuyIt() {
        driver.get("http://automationpractice.com/");
        //addToCart and Checkout
        WebElement btnViewCloth = driver.findElement(By.xpath("//ul[@id='homefeatured']/li[1]/div"));

        //Scroll to Element
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", btnViewCloth);
        wait.until(ExpectedConditions.visibilityOf(btnViewCloth));
        btnViewCloth.click();

        wait.until(ExpectedConditions.invisibilityOf(btnViewCloth));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement btnAddToCart = driver.findElement(By.xpath("//p[@id='add_to_cart']//button"));
        js.executeScript("arguments[0].scrollIntoView(true);", btnAddToCart);
        wait.until(ExpectedConditions.visibilityOf(btnAddToCart));
        btnAddToCart.click();

        WebElement btnCheckout = driver.findElement(By.xpath("//a[@title='Proceed to checkout']"));
        js.executeScript("arguments[0].scrollIntoView(true);", btnCheckout);
        wait.until(ExpectedConditions.visibilityOf(btnCheckout));
        btnCheckout.click();

        WebElement btnCheckoutSummary = driver.findElement(By.xpath("//span[text()='Proceed to checkout']"));
        btnCheckoutSummary.click();
        //login
        WebElement txtEmail = driver.findElement(By.id("email"));
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

        Assertions.assertEquals(verifyElement.getText(), "Your order on My Store is complete.");
        driver.quit();
    }

}
