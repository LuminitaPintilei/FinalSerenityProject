package org.fasttrack.features;

import org.fasttrack.utils.EnvConstants;
import org.junit.Test;

public class SearchTest extends BaseTest{

    @Test
    public void searchProductFromHomePageAsGuestTest(){
        searchSteps.searchAndDisplayProduct("Beanie");
    }

    @Test
    public void searchProductFromHomePageAsLoginUser(){
        loginSteps.navigateToLoginPage();
        loginSteps.enterCredentials(EnvConstants.USER_EMAIL, EnvConstants.USER_PASS);
        loginSteps.clickLogin();
        searchSteps.searchAndDisplayProduct("Beanie");
    }

    @Test
    public void openShopMenuTest(){
        searchSteps.openShop();
        searchSteps.isCatalogOfProductsDisplayed();
    }

    @Test
    public void sortListOfProductsByPriceLowToHighTest(){
        searchSteps.openShop();
        searchSteps.sortListOfProductsByPriceLowToHigh();
        searchSteps.isPriceLowToHighCorrect();
    }

    @Test
    public void sortListOfProductsByPriceHighToLowTest(){
        searchSteps.openShop();
        searchSteps.sortListOfProductsByPriceHighToLow();
        searchSteps.isPriceHighToLowCorrect();
    }



}
