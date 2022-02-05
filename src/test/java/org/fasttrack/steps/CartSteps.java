package org.fasttrack.steps;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class CartSteps extends BaseSteps {

    @Step
    public void clickAddHoodieWithLogoProductToCart(){
        cartPage.getHoodieWithLogoProductToCart();
    }

    @Step
    public void verifyMessageProductAddedToCart(){
        cartPage.isProductAddedToCart();
    }

    @Step
    public void navigateToCart(){
        homePage.clickOnCartIcon();
    }

    @Step
    public void checkSubtotalPriceIsDisplayedCorrectly(){
        Assert.assertTrue("The subtotal price is not correct!", cartPage.isSubtotalPriceCorrect());
    }

    @Step
    public void checkGrandTotalPriceIsCorrect(){
        Assert.assertTrue("Total price is not correct", cartPage.isGrandTotalPriceCorrect());
    }

    @Step
    public void changeQtyCart(String value){
        cartPage.changeQtyForEachProductInCart(value);
    }

    @Step
    public void clickUpdateCart(){
        cartPage.updateCart();
    }

    @Step
    public void checkUpdateCart(){
        cartPage.isCartUpdated();
    }

    @Step
    public void verifyInvalidQtyFormat(){
         Assert.assertFalse(cartPage.isCartUpdatedWithInvalidQty());
    }

    @Step
    public void checkEmptyCart(){
        cartPage.isCartEmpty();
    }

    @Step
    public void returnToMyAccountPage(){
        homePage.clickMyAccountMenu();
    }

    @Step
    public void checkCartIsNotEmpty(){
        Assert.assertFalse(checkoutPage.isProceedToCheckoutButtonPresent());
    }

    @Step
    public void addVariableProductToCart(){
        cartPage.selectProductWithVariations();
        cartPage.selectBlueColor();
        cartPage.selectLogoOption();
        cartPage.addToCart();
    }

    @Step
    public void checkOptionsSelectedAreInCart(){
        cartPage.isVariableProductInCart();
    }


}

