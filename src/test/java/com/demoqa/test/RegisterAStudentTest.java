package com.demoqa.test;

import com.demoqa.pages.StudentRegistrationPage;
import com.demoqa.pages.VerifyRegistrationPage;
import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;

import static com.automation.drivers.UniqueInstanceBrowser.getInstanceOfSingletonBrowser;


public class RegisterAStudentTest {

    private StudentRegistrationPage toRegisterTheStudent;
    private VerifyRegistrationPage toVerifyRegistration;

    @BeforeEach
    public void setUp() {
        getInstanceOfSingletonBrowser().getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        getInstanceOfSingletonBrowser().getDriver().navigate().to("https://demoqa.com/automation-practice-form");
        toRegisterTheStudent = new StudentRegistrationPage();
        toVerifyRegistration = new VerifyRegistrationPage();
    }

    @Test
    public void completeTheRegistrationForTheStudent() {
        toRegisterTheStudent.fillTheFormWithMandatoryFields("Juan", "Perez", "3124567897");
        Assertions.assertEquals("Thanks for submitting the form", toVerifyRegistration.getCompleteRegistrationMessage());
    }

    @AfterEach
    public void tearDown() {
        getInstanceOfSingletonBrowser().closeInstanceOfSingletonBrowser();
    }

}
