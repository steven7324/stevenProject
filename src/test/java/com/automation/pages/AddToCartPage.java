package com.automation.pages;

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

import static com.automation.drivers.InstantiateDriver.getInstanceOfWebDriver;


public class AddToCartPage {

    private Wait<WebDriver> wait;
    private Actions actions;

    @FindBy(css = "li[class*='first-item-of-mobile-line'] a[class='product-name'][title='Faded Short Sleeve T-shirts']")
    private WebElement btnViewCloth;

    @FindBy(css = "li[class*='first-item-of-mobile-line'] a[data-id-product='1']")
    private WebElement btnAddToCart;

    public AddToCartPage() {
        wait = new FluentWait<>(getInstanceOfWebDriver().getDriver()).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class)
                .ignoring(MoveTargetOutOfBoundsException.class)
                .ignoring(Throwable.class);
        actions = new Actions(getInstanceOfWebDriver().getDriver());
        PageFactory.initElements(getInstanceOfWebDriver().getDriver(), this);
    }

    public CheckoutClothPage theChosenCloth() {
        btnViewCloth.sendKeys(Keys.DOWN);
        wait.until(ExpectedConditions.visibilityOf(btnViewCloth));
        actions.moveToElement(btnViewCloth).perform();
        wait.until(ExpectedConditions.visibilityOf(btnAddToCart));
        btnAddToCart.click();
        return new CheckoutClothPage();

    }

}
