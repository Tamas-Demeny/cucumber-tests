package org.example.amazon_page_objects.modules;

import org.example.amazon_page_objects.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class ConfirmationMessage extends BasePage {
    public ConfirmationMessage(WebDriver driver) {
        super(driver);
    }
    public String addedToCartMessage(){
        WebElement addedToCartMessage = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(ADDED_TO_CART_MESSAGE));
        return addedToCartMessage.getText();
    }
}
