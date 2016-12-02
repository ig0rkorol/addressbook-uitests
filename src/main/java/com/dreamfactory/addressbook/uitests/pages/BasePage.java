package com.dreamfactory.addressbook.uitests.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.WhenPageOpens;
import net.thucydides.core.pages.PageObject;

public class BasePage extends PageObject {

    @FindBy(xpath="//*[@md-font-icon='fa-sign-out']")
    private WebElementFacade logoutIcon;

    @FindBy(xpath="//*[@class='ng-scope md-default-theme md-bottom md-left']//span")
    private WebElementFacade errorMessage;

    public boolean isUserLoggedIn() {
        return logoutIcon.isCurrentlyVisible();
    }

    @WhenPageOpens
    public void makeBrowserWindowFullScreen() {
        getDriver().manage().window().maximize();
    }

    public String getValidationMessage() {
        return errorMessage.getTextValue();
    }

}
