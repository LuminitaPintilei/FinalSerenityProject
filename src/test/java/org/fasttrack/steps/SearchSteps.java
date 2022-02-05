package org.fasttrack.steps;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;


public class SearchSteps extends BaseSteps {

    @Step
    public void executeSearch(String keyword){
        homePage.clickOnSearchIcon();
        homePage.setSearchField(keyword);
        homePage.clickEnterSearchButton();
    }

    @Step
    public void openShop(){
        homePage.openShop();
    }

    @Step
    public void isCatalogOfProductsDisplayed(){
        Assert.assertTrue(homePage.isProductsCatalogDisplayed());
    }

    @Step
    public void findAndDisplayProduct(String productName){
        Assert.assertTrue(searchPage.displayProduct(productName));
    }

    @Step
    public void searchAndDisplayProduct(String productName){
        executeSearch(productName);
        findAndDisplayProduct(productName);
    }

    @Step
    public void sortListOfProductsByPriceLowToHigh(){
        searchPage.sortListOfProductsByPriceLowToHigh();
    }

    @Step
    public void sortListOfProductsByPriceHighToLow(){
        searchPage.sortListOfProductsByPriceHighToLow();
    }

    @Step
    public void isPriceLowToHighCorrect(){
        Assert.assertTrue("First price is lower than last.", searchPage.isPriceLowToHighCorrect());
    }

    @Step
    public void isPriceHighToLowCorrect(){
        Assert.assertTrue("First price is grater than last", searchPage.isPriceHighToLowCorrect());
    }
}

