package com.demoqa.test;

import com.demoqa.pages.StudentRegistrationPage;
import com.demoqa.pages.VerifyRegistrationPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static com.automation.drivers.instantiateDriver.getInstanceOfWebDriver;


public class RegisterAStudentTest {

    private StudentRegistrationPage toRegisterTheStudent;
    private VerifyRegistrationPage toVerifyRegistration;

    @BeforeEach
    public void setUp() {
        getInstanceOfWebDriver().getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        getInstanceOfWebDriver().getDriver().navigate().to("https://demoqa.com/automation-practice-form");
        toRegisterTheStudent = new StudentRegistrationPage();
        toVerifyRegistration = new VerifyRegistrationPage();
    }

    @Test
    public void completeTheRegistrationForTheStudent() {
        toRegisterTheStudent.setName("Juan").setLastName("Perez").setGender().setMobile("3124567897").submit();
        Assertions.assertEquals("Thanks for submitting the form", toVerifyRegistration.getCompleteRegistrationMessage());
    }

    @AfterEach
    public void tearDown() {
        getInstanceOfWebDriver().closeInstance();
    }

}
