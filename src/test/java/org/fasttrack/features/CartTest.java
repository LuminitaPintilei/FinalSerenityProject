package org.fasttrack.features;

import org.fasttrack.utils.EnvConstants;
import org.junit.Test;

public class CartTest extends BaseTest{

    @Test
    public void addToCarLoginUserTest(){
        loginSteps.doLogin(EnvConstants.USER_EMAIL, EnvConstants.USER_PASS);
        searchSteps.openShop();
        cartSteps.clickAddHoodieWithLogoProductToCart();
        cartSteps.verifyMessageProductAddedToCart();
    }

    @Test
    public void addToCartAsGuestTest(){
        searchSteps.openShop();
        cartSteps.clickAddHoodieWithLogoProductToCart();
        cartSteps.verifyMessageProductAddedToCart();
    }

    @Test
    public void checkCartTotalSummaryTest(){
        loginSteps.doLogin(EnvConstants.USER_EMAIL, EnvConstants.USER_PASS);
        cartSteps.navigateToCart();
        cartSteps.checkSubtotalPriceIsDisplayedCorrectly();
        cartSteps.checkGrandTotalPriceIsCorrect();
    }

    @Test
    public void updateQtyForAllItemsFromCartToSpecificValue(){
        loginSteps.doLogin(EnvConstants.USER_EMAIL, EnvConstants.USER_PASS);
        cartSteps.navigateToCart();
        cartSteps.changeQtyCart("15");
        cartSteps.clickUpdateCart();
        cartSteps.checkUpdateCart();
    }

    @Test
    public void emptyCartByChangingQtyToZeroTest(){
        loginSteps.doLogin(EnvConstants.USER_EMAIL, EnvConstants.USER_PASS);
        cartSteps.navigateToCart();
        cartSteps.changeQtyCart("0");
        cartSteps.clickUpdateCart();
        cartSteps.checkEmptyCart();
    }

    @Test
    public void verifyInvalidQtyCartTest(){
        loginSteps.doLogin(EnvConstants.USER_EMAIL, EnvConstants.USER_PASS);
        searchSteps.openShop();
        cartSteps.clickAddHoodieWithLogoProductToCart();
        cartSteps.navigateToCart();
        cartSteps.changeQtyCart("4.6");
        cartSteps.clickUpdateCart();
        cartSteps.verifyInvalidQtyFormat();
    }

    @Test
    public void verifyIfProductsRemainInCartAfterLogoutTest(){
        loginSteps.doLogin(EnvConstants.USER_EMAIL, EnvConstants.USER_PASS);
        searchSteps.openShop();
        cartSteps.clickAddHoodieWithLogoProductToCart();
        cartSteps.navigateToCart();
        cartSteps.returnToMyAccountPage();
        loginSteps.doLogout();
        loginSteps.doLogin(EnvConstants.USER_EMAIL, EnvConstants.USER_PASS);
        cartSteps.navigateToCart();
        cartSteps.checkCartIsNotEmpty();

    }

    @Test
    public void addProductWithVariationsToCartTest(){
        loginSteps.doLogin(EnvConstants.USER_EMAIL, EnvConstants.USER_PASS);
        searchSteps.openShop();
        cartSteps.addVariableProductToCart();
        cartSteps.navigateToCart();
        cartSteps.checkOptionsSelectedAreInCart();

    }
}
