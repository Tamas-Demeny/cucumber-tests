package org.example.amazon_page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    @FindBy(xpath = "//div[@class=\"a-section a-spacing-none quadrant-container quadrant-container-0\"]")
    WebElement firstCategory;

    @FindBy(xpath = "//span[@id=\"nav-link-accountList-nav-line-1\"]")
    WebElement signInButton;
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage openAmazonHomePage(){
        driver.get("https://www.amazon.com/");
        return this;
    }

    public SearchResultsPage clickOnFirstCategory(){
        firstCategory.click();
        return new SearchResultsPage(driver);
    }

    public SignInPage clickSignIn() {
        signInButton.click();
        return new SignInPage(driver);
    }
}
