package com.dreamfactory.addressbook.uitests.pages;

import com.dreamfactory.addressbook.uitests.config.ConfigProperties;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class LoginPage extends BasePage {

    @FindBy(ngModel="username")
    private WebElementFacade emailField;

    @FindBy(ngModel="password")
    private WebElementFacade passwordField;

    @FindBy(xpath="//button[@ng-click='register()']")
    private WebElementFacade registerLink;

    @FindBy(xpath="//button[@type='submit']")
    private WebElementFacade submitButton;

    public void enterEmail(String email) {
        emailField.type(email);
    }

    public void enterPassword(String password) {
        passwordField.type(password);
    }

    public void clickRegisterLink() {
        registerLink.click();
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    @Override
    public void setDefaultBaseUrl(String defaultBaseUrl) {
        super.setDefaultBaseUrl(ConfigProperties.LOGIN_URL);
    }
}
