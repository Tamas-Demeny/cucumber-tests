package org.example.stepdefinitions;

import io.cucumber.java.en.*;
import org.example.amazon_page_objects.*;

import static org.example.stepdefinitions.BaseSteps.PAGES_MAP;

public class SearchResultsPageSteps {
    @And("On the {} page, the User selects a product and is redirected to the {} page")
    public void clickOnProduct(String page, String newPage) {
        SearchResultsPage searchResultsPage = (SearchResultsPage) PAGES_MAP.get(page);
        ProductPage productPage = searchResultsPage.clickRedragon();
        PAGES_MAP.put(newPage, productPage);
    }
}
