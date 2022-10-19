package org.example.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.example.amazon_page_objects.SignInPage;
import org.testng.Assert;

import static org.example.stepdefinitions.BaseSteps.PAGES_MAP;

public class SignInPageSteps {
    @And("On the {} page, the user introduces incorrect {} to Email or Phone Nr field")
    public void enterInvalidUsername(String page, String username) {
        SignInPage signInPage = (SignInPage) PAGES_MAP.get(page);
        signInPage.sendInvalidUsernameAndContinue(username);
    }

    @Then("User gets error message {} on {} page")
    public void compareErrorMessage(String expectedMessage, String page) {
        SignInPage signInPage = (SignInPage) PAGES_MAP.get(page);
        Assert.assertEquals(signInPage.getErrorMessage(), expectedMessage);
    }
}
