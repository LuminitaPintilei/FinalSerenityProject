package org.fasttrack.steps;

import net.thucydides.core.annotations.Step;

public class CheckoutSteps extends BaseSteps{

    @Step
    public void proceedToCheckout() {
        checkoutPage.clickOnButtonProceedCheckout();
    }

    @Step
    public void setValidBillingInfo () {
        checkoutPage.setBillingFistName("ANA");
        checkoutPage.setBillingLastName("POP");
        checkoutPage.setBillingCompany("NU ESTE CAZUL");
        checkoutPage.setBillingCountryField("Romania");
        checkoutPage.setBillingAddress("Str. Avram Iancu nr.2");
        checkoutPage.setBillingAddressTwo("-");
        checkoutPage.setBillingCity("Deva");
        checkoutPage.setBillingCountyField("Hunedoara");
        checkoutPage.setBillingPostcode("330252");
        checkoutPage.setBillingPhone("0772212100");
        checkoutPage.setBillingEmail("ap@yahoo.com");
    }

    @Step
    public void placeOrder() {
        checkoutPage.clickButtonPlaceOrder();
    }

    @Step
    public void verifyOrderWasPlaced(){
        checkoutPage.getMessageOrderPlaced("Thank you. Your order has been received.");
    }

}
