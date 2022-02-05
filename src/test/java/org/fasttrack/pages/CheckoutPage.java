package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;


public class CheckoutPage extends BasePage{

    @FindBy(css="div.wc-proceed-to-checkout>a")
    private WebElementFacade clickButtonProceedToCheckout;

    @FindBy(id="billing_first_name")
    private WebElementFacade setBillingFirstName;

    @FindBy(id="billing_last_name")
    private WebElementFacade setBillingLastName;

    @FindBy(id="billing_company")
    private WebElementFacade setBillingCompany;

    @FindBy(id="billing_country")
    private WebElementFacade setCountryField;

    @FindBy(id="billing_address_1")
    private WebElementFacade setBillingAddress;

    @FindBy(id="billing_address_2")
    private WebElementFacade setBillingAddressTwo;

    @FindBy(id="billing_city")
    private WebElementFacade setBillingCity;

    @FindBy(id="billing_state")
    private WebElementFacade setBillingCounty;

    @FindBy(id="billing_postcode")
    private WebElementFacade setBillingPostcode;

    @FindBy(id="billing_phone")
    private WebElementFacade setBillingPhone;

    @FindBy(id="billing_email")
    private WebElementFacade SetBillingEmail;

    @FindBy(id="place_order")
    private WebElementFacade clickButtonPlaceOrder;

    @FindBy(css=".woocommerce-notice.woocommerce-notice--success.woocommerce-thankyou-order-received")
    private WebElementFacade orderPlacedMessage;



    public void clickOnButtonProceedCheckout() {
        clickOn(clickButtonProceedToCheckout);
    }

    public void setBillingFistName(String firstName){
        typeInto(setBillingFirstName,firstName);
    }

    public void setBillingLastName(String lastName) {
        typeInto(setBillingLastName,lastName);
    }

    public void setBillingCompany( String nameCompany){
        typeInto(setBillingCompany,nameCompany);
    }

    public void setBillingCountryField(String nameCountry){
        setCountryField.selectByVisibleText(nameCountry);
    }

    public  void setBillingAddress(String typeAddress){
        typeInto(setBillingAddress,typeAddress);
    }

    public void setBillingAddressTwo(String typeAddressOptional){
        typeInto(setBillingAddressTwo,typeAddressOptional);
    }

    public void setBillingCity(String cityName) {
        typeInto(setBillingCity,cityName);
    }

    public void setBillingCountyField(String countyName) {
        setBillingCounty.selectByVisibleText(countyName);
    }

    public void setBillingPostcode(String postCode){
        typeInto(setBillingPostcode,postCode);
    }

    public void setBillingPhone(String phone){
        typeInto(setBillingPhone,phone);
    }

    public void setBillingEmail(String emailAddress){
        typeInto(SetBillingEmail,emailAddress);
    }

    public void clickButtonPlaceOrder(){
        waitFor(clickButtonPlaceOrder);
        clickOn(clickButtonPlaceOrder);
    }

    public boolean isProceedToCheckoutButtonPresent(){
        (clickButtonProceedToCheckout).isPresent();
        return false;
    }

    public void getMessageOrderPlaced(String orderMessage){
        waitFor(orderPlacedMessage).waitUntilPresent();
        orderPlacedMessage.shouldContainText(orderMessage);
    }


}

