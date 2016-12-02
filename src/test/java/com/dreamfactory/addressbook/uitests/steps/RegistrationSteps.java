package com.dreamfactory.addressbook.uitests.steps;

import com.dreamfactory.addressbook.uitests.model.User;
import com.dreamfactory.addressbook.uitests.pages.RegistrationPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class RegistrationSteps extends ScenarioSteps {

    RegistrationPage registrationPage;

    @Step
    public void registerUser(User user) {
        registrationPage.fillForm(user);
        registrationPage.clickRegister();
    }
    @Step
    public void verify_registration_form_displayed() {

//        assertTrue("Registration page should be displayed", registrationPage.shouldBeDisplayed(););
     registrationPage.shouldBeDisplayed();
    }
}