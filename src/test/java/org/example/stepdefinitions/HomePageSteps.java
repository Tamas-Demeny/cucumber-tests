package org.example.stepdefinitions;

import io.cucumber.java.en.*;
import org.example.amazon_page_objects.*;
import org.example.amazon_page_objects.modules.DeliverToModule;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static org.example.stepdefinitions.BaseSteps.PAGES_MAP;
import static org.example.stepdefinitions.BaseSteps.webDriver;

public class HomePageSteps {
    @Given("User opens up the Amazon {}")
    public void openAmazonWebsite(String page) {
        HomePage homePage = new HomePage(webDriver);
        homePage.openAmazonHomePage();
        PAGES_MAP.put(page, homePage);
    }

    @When("User clicks on Deliver To on {}, {} module is opened")
    public void clickDeliverTo(String page, String module) {
        HomePage homepage = (HomePage) PAGES_MAP.get(page);
        DeliverToModule deliverToModule = homepage.clickDeliverTo();
        PAGES_MAP.put(module, deliverToModule);
    }

    @And("User selects delivery to {} in {} module and clicks Done")
    public void selectBarbados(String country, String module) {
        DeliverToModule deliverToModule = (DeliverToModule) PAGES_MAP.get(module);
        deliverToModule.deliverToCountry(country);
    }

    @Then("User Deliver To option, on {} is set to {}")
    public void updatedDeliverToCheck(String page, String country) {
        HomePage homePage = (HomePage) PAGES_MAP.get(page);
        String newLocation = new WebDriverWait(webDriver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                        "//span[@id=\"glow-ingress-line2\"][contains(text(),\"" + country + "\")]")
                ))
                .getText();
        Assert.assertEquals(newLocation, country);
    }

    @When("User selects {} option on the {}")
    public void clickSignIn(String button, String page) {
        HomePage homePage = (HomePage) PAGES_MAP.get(page);
        SignInPage signInPage = homePage.clickSignIn();
        PAGES_MAP.put(button, signInPage);
    }

    @When("User searches for {} and is sent to the {} page")
    public void searchForLaptop(String product, String page) {
        HomePage homePage = (HomePage) PAGES_MAP.get("Home Page");
        SearchResultsPage searchResultsPage = homePage.searchMethod(product);
        PAGES_MAP.put(page, searchResultsPage);
    }
}
