package com.dreamfactory.addressbook.uitests.tests;

import com.dreamfactory.addressbook.uitests.http.RestClient;
import com.dreamfactory.addressbook.uitests.model.User;
import com.dreamfactory.addressbook.uitests.model.UserFactory;
import com.dreamfactory.addressbook.uitests.requirements.Application;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.Title;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.dreamfactory.addressbook.uitests.messages.ValidationMessages.EMAIL_ALREADY_USED;

@Story(Application.Registration.class)
@RunWith(SerenityRunner.class)
public class RegistrationTest extends BaseTest{
    private static final User NEW_USER = UserFactory.getUniqueUser();
    private static final User EXISTING_USER = UserFactory.getExistingUser();
    private static final User USER_WITH_BLANK_OPTIONAL_FIELDS = UserFactory.getUserWithBlankOptionalFields();


    @BeforeClass
    public static void createUserIfAbsent(){
        RestClient.registerUser(EXISTING_USER);
    }

    @Test
    @Title("TC 01 : register user with new unique email")
    public void registerNewUser() {
        loginSteps.open_login_page();
        loginSteps.click_register_link();
        registrationSteps.registerUser(NEW_USER);
        loginSteps.login(NEW_USER);
        commonSteps.verify_user_loggedIn();
    }

    @Test
    @Title("TC 02 : register user with existing email")
    public void registerExistingUser() {
        verifyUserExists(EXISTING_USER);
        loginSteps.open_login_page();
        loginSteps.click_register_link();
        registrationSteps.registerUser(EXISTING_USER);
        registrationSteps.verify_registration_form_displayed();
        commonSteps.verify_error_message_appears(EMAIL_ALREADY_USED);
    }

    @Test
    @Title("TC 06 : register user without optional fields")
    public void registerUserWORequiredFields() {
        verifyUserExists(EXISTING_USER);
        loginSteps.open_login_page();
        loginSteps.click_register_link();
        registrationSteps.registerUser(EXISTING_USER);
        registrationSteps.verify_registration_form_displayed();
        commonSteps.verify_error_message_appears(EMAIL_ALREADY_USED);
    }

    // TODO : proxy (ie BrowserMob) can be used to get Response and parse result
}
