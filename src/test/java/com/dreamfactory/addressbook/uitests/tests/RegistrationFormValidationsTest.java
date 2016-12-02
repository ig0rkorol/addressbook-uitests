package com.dreamfactory.addressbook.uitests.tests;

import com.dreamfactory.addressbook.uitests.messages.ValidationMessages;
import com.dreamfactory.addressbook.uitests.model.User;
import com.dreamfactory.addressbook.uitests.model.UserFactory;
import com.dreamfactory.addressbook.uitests.requirements.Application;
import com.dreamfactory.addressbook.uitests.steps.LoginSteps;
import com.dreamfactory.addressbook.uitests.steps.RegistrationSteps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.TestData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.Collection;

@Story(Application.Registration.class)
@RunWith(SerenityParameterizedRunner.class)
public class RegistrationFormValidationsTest extends BaseTest{

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public RegistrationSteps registrationSteps;

    @Steps
    public LoginSteps loginSteps;

    private User user;
    private String message;

    public RegistrationFormValidationsTest(User user, String message){
        this.user = user;
        this.message = message;
    }

    @TestData(columnNames = "User,Expected Error")
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {UserFactory.getUserWithoutEmail(), ValidationMessages.EMAIL_REQUIRED},
                {UserFactory.getUserWithoutPassword(), ValidationMessages.PASSWORD_REQUIRED},
                {UserFactory.getUserWithInvalidEmail(), ValidationMessages.EMAIL_INCORRECT},
                {UserFactory.getUserWithPasswordThreeSymbolsLength(), ValidationMessages.PASSWORD_LENGTH_WRONG}
        });
    }

    @Test
    @Title("TC[3-5] : Validate registration form ")
    public void validateRegistrationForm() {
        loginSteps.open_login_page();
        loginSteps.click_register_link();
        registrationSteps.registerUser(user);
        commonSteps.verify_error_message_appears(message);
    }

}