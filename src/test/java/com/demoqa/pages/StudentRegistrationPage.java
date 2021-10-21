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

import static com.automation.drivers.InstantiateDriver.getInstanceOfWebDriver;

public class StudentRegistrationPage {

    private Wait<WebDriver> wait;
    private Actions actions;
    private Student student;

    @FindBy(css = "#firstName")
    private WebElement txtName;
    @FindBy(css = "#lastName")
    private WebElement txtLastName;
    @FindBy(css = "#userEmail")
    private WebElement txtEmail;
    @FindBy(css = "label[for='gender-radio-1']")
    private WebElement rdbMaleGender;
    @FindBy(css = "#userNumber")
    private WebElement txtMobile;
    @FindBy(css = "#dateOfBirthInput")
    private WebElement txtBirthDate;
    @FindBy(css = "#subjectsInput")
    private WebElement lstSubjects;
    @FindBy(css = "label[for='hobbies-checkbox-1']")
    private WebElement cklHobbiesSports;
    @FindBy(css = "#uploadPicture.form-control-file")
    private WebElement uploadPicture;
    @FindBy(css = "#currentAddress")
    private WebElement txtCurrentAddress;
    @FindBy(css = "#react-select-3-input")
    private WebElement lstStateAndCity;
    @FindBy(css = "#react-select-4-input")
    private WebElement lstCity;
    @FindBy(css = "#submit")
    private WebElement btnSubmit;

    public StudentRegistrationPage() {
        wait = new FluentWait<>(getInstanceOfWebDriver().getDriver()).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class)
                .ignoring(MoveTargetOutOfBoundsException.class);
        actions = new Actions(getInstanceOfWebDriver().getDriver());
        PageFactory.initElements(getInstanceOfWebDriver().getDriver(), this);
        student = new Student();

    }

    public VerifyRegistrationPage fillTheForm(String name, String lastname, String email, String mobile, String birthDate, String subjects, String filePath, String address, String state, String city) {
        student.setName(name);
        student.setLastName(lastname);
        student.setEmail(email);
        student.setMobile(mobile);
        student.setBirthDate(birthDate);
        student.setSubjects(subjects);
        student.setFilePath(filePath);
        student.setAddress(address);
        student.setState(state);
        student.setCity(city);

        txtName.sendKeys(student.getName());
        txtLastName.sendKeys(student.getLastName());
        txtEmail.sendKeys(student.getEmail());
        rdbMaleGender.click();
        txtMobile.sendKeys(student.getMobile());
        txtMobile.sendKeys(Keys.TAB);
        txtBirthDate.sendKeys(Keys.SPACE);
        txtBirthDate.sendKeys(student.getBirthDate());
        txtBirthDate.sendKeys(Keys.ENTER);
        txtCurrentAddress.sendKeys(Keys.TAB);
        wait.until(ExpectedConditions.visibilityOf(lstSubjects));
        lstSubjects.sendKeys(student.getSubjects());
        lstSubjects.sendKeys(Keys.TAB);
        cklHobbiesSports.click();
        uploadPicture.sendKeys(student.getFilePath());
        txtCurrentAddress.sendKeys(student.getAddress());
        lstStateAndCity.sendKeys(student.getState());
        lstStateAndCity.sendKeys(Keys.TAB);
        wait.until(ExpectedConditions.elementToBeClickable(lstCity));
        lstCity.sendKeys(student.getCity());
        lstCity.sendKeys(Keys.TAB);

        wait.until(ExpectedConditions.visibilityOf(btnSubmit));
        btnSubmit.submit();
        return new VerifyRegistrationPage();

    }

    public VerifyRegistrationPage fillTheForm(String name, String lastName, String mobile) {
        student.setName(name);
        txtName.sendKeys(student.getName());
        student.setLastName(lastName);
        txtLastName.sendKeys(student.getLastName());
        rdbMaleGender.click();
        student.setMobile(mobile);
        txtMobile.sendKeys(student.getMobile());
        txtMobile.sendKeys(Keys.TAB);
        txtCurrentAddress.sendKeys(Keys.TAB);
        wait.until(ExpectedConditions.visibilityOf(btnSubmit));
        btnSubmit.submit();
        return new VerifyRegistrationPage();

    }
}
