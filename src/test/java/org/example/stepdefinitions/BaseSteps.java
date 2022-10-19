package org.example.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.example.amazon_page_objects.BasePage;
import org.example.driversetup.factory.WebDriverFactory;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class BaseSteps {
    public static final Map<String, BasePage> PAGES_MAP = new HashMap<>();
    public static WebDriver webDriver;

    @Before
    public void initiateDriver() {
        webDriver= new WebDriverFactory().getWebDriver();
    }

    @After
    public void closeDriver() {
        webDriver.close();
        webDriver.quit();
    }
}
