package org.example.stepdefinitions;

import io.cucumber.java.en.*;
import org.example.amazon_page_objects.*;
import org.testng.Assert;

import static org.example.stepdefinitions.BaseSteps.PAGES_MAP;

public class ProductPageSteps {
    @And("User adds a product to the cart from the {} page")
    public void addProductToCart(String page) {
        ProductPage productPage = (ProductPage) PAGES_MAP.get(page);
        productPage.addToCart();
    }

    @Then("The amount of products in the cart should be updated to {}")
    public void checkUpdatedCart(String amountInCart) {
        ProductPage productPage = (ProductPage) PAGES_MAP.get("Product");
        String actualAmount = productPage.amountOfProductInCart();
        Assert.assertEquals(actualAmount, amountInCart);
    }
}
