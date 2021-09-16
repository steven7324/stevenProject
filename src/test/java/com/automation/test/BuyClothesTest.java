package com.automation.test;

import com.automation.pages.BuyClothesPage;
import com.automation.util.BrowserManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;


public class BuyClothesTest {

    public WebDriver driver = BrowserManager.build();

    @Test
    public void addSomethingToCartAndBuyIt() {
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.navigate().to("http://automationpractice.com/");

        //addToCart and Checkout
        BuyClothesPage buyClothes = new BuyClothesPage(driver);
        buyClothes.setBtnViewCloth();

        buyClothes.setBtnAddToCart();
        buyClothes.setBtnCheckout();

        buyClothes.setBtnCheckoutSummary();

        buyClothes.login();

        buyClothes.setBtnCheckoutAddress();

        buyClothes.setCkbAgreeTerms();
        buyClothes.setBtnPaymentMethod();

        buyClothes.setBtnConfirmOrder();

        //Verify buy
        buyClothes.setVerifyElement();

    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

}
