package com.dreamfactory.addressbook.uitests.pages;

import com.dreamfactory.addressbook.uitests.model.User;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class RegistrationPage extends PageObject {

    @FindBy(ngModel="firstName")
    private WebElementFacade firstName;

    @FindBy(ngModel="lastName")
    private WebElementFacade lastName;

    @FindBy(ngModel="username")
    private WebElementFacade email;

    @FindBy(ngModel="password")
    private WebElementFacade password;

    @FindBy(xpath="//form[@name='registerForm']//button[@ng-click='register()']")
    private WebElementFacade registerLink;

    public void typeFirstName(String value) {
        firstName.type(value);
    }
    public void typeLastName(String value) {
        lastName.type(value);
    }
    public void typeEmail(String value) {
        lastName.type(value);
    }
    public void typePassword(String value) {
        lastName.type(value);
    }
    public void clickRegister() {
        registerLink.click();
    }

    /**
     * Fill registration form
     * @param user type of User
     * @see User
     */
    public void fillForm(User user) {
        Map<WebElementFacade, String> formDataFields = new HashMap<>();
        formDataFields.put(firstName, user.getFirstName());
        formDataFields.put(lastName, user.getLastName());
        formDataFields.put(email, user.getEmail());
        formDataFields.put(password, user.getPassword());
        for(Map.Entry<WebElementFacade, String> entry : formDataFields.entrySet()){
            WebElementFacade field = entry.getKey();
            String value = entry.getValue();
            if (StringUtils.isNoneEmpty(value)){
                field.type(value);
            }
        }
    }

}