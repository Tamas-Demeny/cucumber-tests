package org.example.amazon_page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignInPage extends BasePage {
    @FindBy(xpath = "//input[@id=\"continue\"]")
    WebElement continueButton;
    @FindBy(xpath = "//span[@class=\"a-list-item\"]")
    WebElement invalidUsernameError;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public SignInPage sendInvalidUsernameAndContinue(String username) {
        WebElement usernameField = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(userName));
        usernameField.sendKeys(username);
        continueButton.click();
        return this;
    }

    public String getErrorMessage() {
        return invalidUsernameError.getText();
    }
}
