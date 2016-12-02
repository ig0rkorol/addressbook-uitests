package com.dreamfactory.addressbook.uitests.tests;

import com.dreamfactory.addressbook.uitests.http.RestClient;
import com.dreamfactory.addressbook.uitests.model.User;
import com.dreamfactory.addressbook.uitests.steps.CommonSteps;
import com.dreamfactory.addressbook.uitests.steps.LoginSteps;
import com.dreamfactory.addressbook.uitests.steps.RegistrationSteps;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

/**
 * Created by ikorol on 02.12.2016.
 */
public class BaseTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public RegistrationSteps registrationSteps;

    @Steps
    public CommonSteps commonSteps;

    @Steps
    public LoginSteps loginSteps;

    public static void verifyUserExists(User user){
        assertTrue("User with email " + user.getEmail() + " not exist ", RestClient.isUserExists(user));
    }
}
