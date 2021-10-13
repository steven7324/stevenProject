package com.automation.test;

import com.automation.pages.AddToCartPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static com.automation.drivers.InstantiateDriver.getInstanceOfWebDriver;


public class BuyClothesTest {

    private AddToCartPage addToCart;

    @BeforeEach
    public void setUp() {
        getInstanceOfWebDriver().getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        getInstanceOfWebDriver().getDriver().navigate().to("http://automationpractice.com/");
        addToCart = new AddToCartPage();
    }

    @Test
    public void addSomethingToCartAndBuyIt() {
        addToCart.theChosenCloth()
                .inTheMainPage()
                .proceedToCheckoutSummary()
                .sendTheCredentials("steven7324@yopmail.com", "Steven21")
                .proceedToCheckoutAddress()
                .proceedToCheckoutShipping()
                .chooseThePaymentMethod()
                .confirmTheOrder()
                .getCompleteOrderMessage("Your order on My Store is complete.");
    }

    @AfterEach
    public void tearDown() {
        getInstanceOfWebDriver().closeInstance();
    }

}
