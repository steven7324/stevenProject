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

import static com.automation.drivers.instantiateDriver.getInstanceOfWebDriver;


public class AddToCartPage {

    private Wait<WebDriver> wait;
    private Actions actions;

    @FindBy(xpath = "(//ul[@id='homefeatured']/li//a[@class='product-name'])[1]")
    private WebElement btnViewCloth;

    @FindBy(xpath = "(//span[normalize-space()='Add to cart'])[1]")
    private WebElement btnAddToCart;

    public AddToCartPage() {
        wait = new FluentWait<>(getInstanceOfWebDriver().getDriver()).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class)
                .ignoring(MoveTargetOutOfBoundsException.class);
        actions = new Actions(getInstanceOfWebDriver().getDriver());
        PageFactory.initElements(getInstanceOfWebDriver().getDriver(), this);
    }

    public void theChosenCloth() {
        btnViewCloth.sendKeys(Keys.DOWN);
        wait.until(ExpectedConditions.visibilityOf(btnViewCloth));
        actions.moveToElement(btnViewCloth).perform();
        wait.until(ExpectedConditions.visibilityOf(btnAddToCart));
        btnAddToCart.click();
    }

}
