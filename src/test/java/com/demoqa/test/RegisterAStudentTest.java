package com.demoqa.test;

import com.demoqa.pages.StudentRegistrationPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static com.automation.drivers.InstantiateDriver.getInstanceOfWebDriver;


public class RegisterAStudentTest {

    private StudentRegistrationPage toRegisterTheStudent;

    @BeforeEach
    public void setUp() {
        getInstanceOfWebDriver().getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        getInstanceOfWebDriver().getDriver().navigate().to("https://demoqa.com/automation-practice-form");
        toRegisterTheStudent = new StudentRegistrationPage();
    }

    @Test
    public void completeTheRegistrationForTheStudent() {
        toRegisterTheStudent.fillTheForm("Juan", "Perez", "3124567897")
                .getCompleteRegistrationMessage("Thanks for submitting the form");
    }

    @AfterEach
    public void tearDown() {
        getInstanceOfWebDriver().closeInstance();
    }

}
