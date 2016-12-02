package com.dreamfactory.addressbook.uitests.steps;

import com.dreamfactory.addressbook.uitests.pages.BasePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CommonSteps extends ScenarioSteps {
    private static final Logger logger = LoggerFactory.getLogger(CommonSteps.class);
    BasePage anyPage;

    @Step
    public void verify_user_loggedIn() {
        assertTrue("User hasn't LoggedIn", anyPage.isUserLoggedIn());
    }

    @Step
    public void verify_error_message_appears(String expected) {
        String actual = anyPage.getValidationMessage();
        logger.info("Error message is '{}'", actual);
        assertEquals("Validation message doesn't match expected", expected, actual);
    }
}
