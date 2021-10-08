package com.automation.test;

import com.automation.pages.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static com.automation.drivers.instantiateDriver.getInstanceOfWebDriver;


public class BuyClothesTest {

    private AddToCartPage addToCart;
    private SignInPage toSignIn;
    private CheckoutClothPage checkoutCloth;
    private SummaryPage inTheSummaryStep;
    private ShippingPage inTheShippingStep;
    private AddressPage inTheAddressStep;
    private PaymentPage inThePaymentStep;
    private CompleteBuyPage toCompleteBuy;
    private VerifyBuyPage toVerifyBuy;

    @BeforeEach
    public void setUp() {
        getInstanceOfWebDriver().getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        getInstanceOfWebDriver().getDriver().navigate().to("http://automationpractice.com/");
        addToCart = new AddToCartPage();
        checkoutCloth = new CheckoutClothPage();
        toSignIn = new SignInPage();
        inTheSummaryStep = new SummaryPage();
        inTheAddressStep = new AddressPage();
        inTheShippingStep = new ShippingPage();
        inThePaymentStep = new PaymentPage();
        toCompleteBuy = new CompleteBuyPage();
        toVerifyBuy = new VerifyBuyPage();
    }

    @Test
    public void addSomethingToCartAndBuyIt() {
        addToCart.theChosenCloth();
        checkoutCloth.inTheMainPage();
        inTheSummaryStep.proceedToCheckout();
        toSignIn.sendTheCredentials("steven7324@yopmail.com", "Steven21");
        inTheAddressStep.proceedToCheckout();
        inTheShippingStep.proceedToCheckout();
        inThePaymentStep.chooseThePaymentMethod();
        toCompleteBuy.confirmTheOrder();
        Assertions.assertEquals("Your order on My Store is complete.", toVerifyBuy.getCompleteOrderMessage());
    }

    @AfterEach
    public void tearDown() {
        getInstanceOfWebDriver().closeInstance();
    }

}
