package com.demoqa.pages;

import com.demoqa.model.Student;
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

public class StudentRegistrationPage {

    private Wait<WebDriver> wait;
    private Actions actions;
    private Student student;

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
        wait = new FluentWait<>(getInstanceOfWebDriver().getDriver()).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class)
                .ignoring(MoveTargetOutOfBoundsException.class);
        actions = new Actions(getInstanceOfWebDriver().getDriver());
        PageFactory.initElements(getInstanceOfWebDriver().getDriver(), this);
        student = new Student();

    }

    public StudentRegistrationPage setName(String name) {
        student.setName(name);
        txtName.sendKeys(student.getName());
        return this;
    }

    public StudentRegistrationPage setLastName(String lastName) {
        student.setLastName(lastName);
        txtLastName.sendKeys(student.getLastName());
        return this;
    }

    public StudentRegistrationPage setGender() {
        rdbMaleGender.click();
        return this;

    }
    public StudentRegistrationPage setMobile(String mobile) {
        student.setMobile(mobile);
        txtMobile.sendKeys(student.getMobile());
        txtMobile.sendKeys(Keys.TAB);
        txtCurrentAddress.sendKeys(Keys.TAB);
        return this;
    }

    public void submit() {
        wait.until(ExpectedConditions.visibilityOf(btnSubmit));
        this.btnSubmit.submit();
    }
}
