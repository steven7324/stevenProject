package com.demoqa.test;

import com.demoqa.pages.StudentRegistrationPage;
import com.demoqa.pages.VerifyRegistrationPage;
import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;

import static com.demoqa.util.SingletonBrowser.getInstanceOfSingletonBrowser;


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
        toRegisterTheStudent.fillTheForm("Juan", "Perez", "username@prueba.com", "3124567897", "22 Sep 2000", "english", System.getProperty("user.dir") + "\\src\\test\\java\\com\\demoqa\\resources\\toolsQA.png", "Dg 90 55 - 45", "NCR", "Delhi");
        Assertions.assertEquals("Thanks for submitting the form", toVerifyRegistration.getCompleteRegistrationMessage());
    }

    @AfterEach
    public void tearDown() {
        getInstanceOfSingletonBrowser().getDriver().quit();
    }

}
