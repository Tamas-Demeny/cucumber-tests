package org.example.amazon_page_objects;

import org.example.amazon_page_objects.modules.*;
import org.example.amazon_page_objects.modules.page_locators.PageLocators;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public abstract class BasePage implements PageLocators {
    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchBar;
    @FindBy(xpath = "//span[contains(text(),\"Deliver to\")]")
    public WebElement DELIVER_TO_BUTTON;
    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public DeliverToModule clickDeliverTo(){
        DELIVER_TO_BUTTON.click();
        return new DeliverToModule(driver);
    }

    public SearchResultsPage searchMethod(String searchedElement) {
        searchBar.sendKeys(searchedElement);
        searchBar.submit();
        return new SearchResultsPage(driver);
    }

    public String deliverToLocation(){
        return new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(NEW_LOCATION)).getText();
    }

    public String amountOfProductInCart() {
        WebElement amountOfProductInCart = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(AMOUNT_OF_PRODUCT_IN_CART));
        return amountOfProductInCart.getText();
    }

    public CartPage openCart(){
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(AMOUNT_OF_PRODUCT_IN_CART))
                .click();
        return new CartPage(driver);
    }
}
