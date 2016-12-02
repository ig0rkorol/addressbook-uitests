package com.dreamfactory.addressbook.uitests.steps;

import com.dreamfactory.addressbook.uitests.config.ConfigProperties;
import com.dreamfactory.addressbook.uitests.model.User;
import com.dreamfactory.addressbook.uitests.pages.LoginPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class LoginSteps extends ScenarioSteps {

    LoginPage loginPage;

    @Step
    public void enters_email(String email) {
        loginPage.enterEmail(email);
    }

    @Step
    public void enter_password(String password) {
        loginPage.enterPassword(password);
    }

    @Step
    public void click_submit() {
        loginPage.clickSubmitButton();

    }

    @Step
    public void open_login_page() {
        loginPage.openAt(ConfigProperties.LOGIN_URL);
    }

    @Step
    public void click_register_link() {
        loginPage.clickRegisterLink();
    }

    @Step
    public void login(User user) {
        loginPage.enterEmail(user.getEmail());
        loginPage.enterPassword(user.getPassword());
        loginPage.clickSubmitButton();

    }
}