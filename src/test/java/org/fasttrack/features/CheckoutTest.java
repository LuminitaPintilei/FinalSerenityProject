package org.fasttrack.features;

import org.fasttrack.utils.EnvConstants;
import org.junit.Test;

public class CheckoutTest extends BaseTest{

    @Test
    public void placeOrderAsGuestTest(){
        searchSteps.openShop();
        cartSteps.clickAddHoodieWithLogoProductToCart();
        cartSteps.navigateToCart();
        checkoutSteps.proceedToCheckout();
        checkoutSteps.setValidBillingInfo();
        checkoutSteps.placeOrder();
        checkoutSteps.verifyOrderWasPlaced();
    }

    @Test
    public void placeOrderAsLoginUser(){
        loginSteps.navigateToLoginPage();
        loginSteps.enterCredentials(EnvConstants.USER_EMAIL, EnvConstants.USER_PASS);
        loginSteps.clickLogin();
        searchSteps.openShop();
        cartSteps.clickAddHoodieWithLogoProductToCart();
        cartSteps.navigateToCart();
        checkoutSteps.proceedToCheckout();
        checkoutSteps.placeOrder();
        checkoutSteps.verifyOrderWasPlaced();
    }


}
