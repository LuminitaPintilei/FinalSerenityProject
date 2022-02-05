package org.fasttrack.pages;


import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;


public class MyAccountPage extends BasePage{

    @FindBy( xpath = "//*[@id=\"post-7\"]/div/div/div/p[1]")
    private WebElementFacade loginHelloMessageElement;

    @FindBy( css = "a[href*=\"address\"]:nth-child(1)")
    private WebElementFacade addressesMenuMyAccount;

    @FindBy( css = "#post-7 > div > div > div > div > div.u-column1.col-1.woocommerce-Address > header > a")
    private WebElementFacade editBillingAddress;

    @FindBy( id = "billing_first_name")
    private WebElementFacade billingFirstName;

    @FindBy( id = "billing_last_name")
    private WebElementFacade billingLastName;

    @FindBy ( id ="select2-billing_country-container")
    private WebElementFacade country;

    @FindBy ( css ="body > span > span > span.select2-search.select2-search--dropdown > input")
    private WebElementFacade  countryDropdownList;

    @FindBy ( id ="select2-billing_country-result-2n2g-RO")
    private WebElementFacade countryRO;

    @FindBy ( id ="billing_address_1")
    private WebElementFacade address;

    @FindBy ( id ="billing_city")
    private WebElementFacade city;

    @FindBy ( id ="billing_postcode")
    private WebElementFacade postCode;

    @FindBy ( id ="billing_phone")
    private WebElementFacade phone;

    @FindBy (css= "#post-7 > div > div > div > form > div > p > button")
    private WebElementFacade saveAddressButton;

    @FindBy (css ="#post-7 > div > div > div.woocommerce-message")
    private WebElementFacade addressSavedMessage;

    @FindBy (css ="li.woocommerce-MyAccount-navigation-link.woocommerce-MyAccount-navigation-link--customer-logout > a")
    private WebElementFacade logoutButton;


    public void checkUserLoggedIn(String userName){
        loginHelloMessageElement.shouldContainText(userName);
    }

    public void clickAddressesButton(){
        clickOn(addressesMenuMyAccount);
    }

    public void clickEditAddressButton (){
        clickOn(editBillingAddress);
    }

    public void editBillingFirstName(){
        typeInto(billingFirstName,"Luminita");
    }

    public void editBillingLastName(){
        typeInto(billingLastName, "Test2");
   }

    public void editCountry(){
        clickOn(country);
        countryDropdownList.typeAndEnter("Romania");
    }

    public void editAddress(){
        typeInto(address,"Cuza 4");
   }

    public void editCity(){
        typeInto(city,"Cluj-Napoca");
   }

    public void editPostCode(){
        typeInto(postCode, "400000");
   }

    public void editPhone(){
        typeInto(phone, "0723444444");
   }

    public void saveAddress(){
       clickOn(saveAddressButton);
   }

    public void checkMessageForAddressSaved(String message){
        addressSavedMessage.shouldContainText(message);
    }

    public void logout(){
        clickOn(logoutButton);
    }

}

