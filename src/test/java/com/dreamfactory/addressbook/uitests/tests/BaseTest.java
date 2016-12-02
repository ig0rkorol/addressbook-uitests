package com.dreamfactory.addressbook.uitests.tests;

import com.dreamfactory.addressbook.uitests.http.RestClient;
import com.dreamfactory.addressbook.uitests.model.User;
import com.dreamfactory.addressbook.uitests.steps.CommonSteps;
import com.dreamfactory.addressbook.uitests.steps.LoginSteps;
import com.dreamfactory.addressbook.uitests.steps.RegistrationSteps;
import net.thucydides.core.annotations.Steps;

import static org.junit.Assert.assertTrue;

/**
 * Created by ikorol on 02.12.2016.
 */
public class BaseTest {
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
