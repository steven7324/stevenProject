package com.demoqa.pages;

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

import static com.demoqa.util.SingletonBrowser.getInstanceOfSingletonBrowser;


public class StudentRegistrationPage {

    private Wait<WebDriver> wait;
    private Actions actions;

    @FindBy(id = "firstName")
    private WebElement txtName;
    @FindBy(id = "lastName")
    private WebElement txtLastName;
    @FindBy(id = "userEmail")
    private WebElement txtEmail;
    @FindBy(xpath = "//label[@for='gender-radio-1']")
    private WebElement rdbMaleGender;
    @FindBy(id = "userNumber")
    private WebElement txtMobile;
    @FindBy(id = "dateOfBirthInput")
    private WebElement txtBirthDate;
    @FindBy(id = "subjectsInput")
    private WebElement lstSubjects;
    @FindBy(xpath = "//label[@for='hobbies-checkbox-1']")
    private WebElement cklHobbiesSports;
    @FindBy(css = "#uploadPicture.form-control-file")
    private WebElement uploadPicture;
    @FindBy(id = "currentAddress")
    private WebElement txtCurrentAddress;
    @FindBy(id = "react-select-3-input")
    private WebElement lstStateAndCity;
    @FindBy(id = "react-select-4-input")
    private WebElement lstCity;
    @FindBy(id = "submit")
    private WebElement btnSubmit;

    public StudentRegistrationPage() {
        wait = new FluentWait<>(getInstanceOfSingletonBrowser().getDriver()).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class)
                .ignoring(MoveTargetOutOfBoundsException.class);
        actions = new Actions(getInstanceOfSingletonBrowser().getDriver());
        PageFactory.initElements(getInstanceOfSingletonBrowser().getDriver(), this);
    }

    public void fillTheForm(String name, String lastname, String email, String mobile, String birthDate, String subjects, String filePath, String address, String state, String city) {
        txtName.sendKeys(name);
        txtLastName.sendKeys(lastname);
        txtEmail.sendKeys(email);
        rdbMaleGender.click();
        txtMobile.sendKeys(mobile);
        txtMobile.sendKeys(Keys.TAB);
        txtBirthDate.sendKeys(Keys.SPACE);
        txtBirthDate.sendKeys(birthDate);
        txtBirthDate.sendKeys(Keys.ENTER);
        txtCurrentAddress.sendKeys(Keys.TAB);
        wait.until(ExpectedConditions.visibilityOf(lstSubjects));
        lstSubjects.sendKeys(subjects);
        lstSubjects.sendKeys(Keys.TAB);
        cklHobbiesSports.click();
        uploadPicture.sendKeys(filePath);
        txtCurrentAddress.sendKeys(address);
        lstStateAndCity.sendKeys(state);
        lstStateAndCity.sendKeys(Keys.TAB);
        wait.until(ExpectedConditions.elementToBeClickable(lstCity));
        lstCity.sendKeys(city);
        lstCity.sendKeys(Keys.TAB);

        wait.until(ExpectedConditions.visibilityOf(btnSubmit));
        btnSubmit.submit();

    }

}
