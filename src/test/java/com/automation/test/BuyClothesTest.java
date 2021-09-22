package com.automation.test;

import com.automation.pages.*;
import com.automation.util.BrowserManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;


public class BuyClothesTest {

    private WebDriver driver = BrowserManager.build();
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
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.navigate().to("http://automationpractice.com/");
        addToCart = new AddToCartPage(driver);
        checkoutCloth = new CheckoutClothPage(driver);
        toSignIn = new SignInPage(driver);
        inTheSummaryStep = new SummaryPage(driver);
        inTheAddressStep = new AddressPage(driver);
        inTheShippingStep = new ShippingPage(driver);
        inThePaymentStep = new PaymentPage(driver);
        toCompleteBuy = new CompleteBuyPage(driver);
        toVerifyBuy = new VerifyBuyPage(driver);
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
        Assertions.assertEquals(toVerifyBuy.shouldSeeTheSuccessMessage(), "Your order on My Store is complete.");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}
