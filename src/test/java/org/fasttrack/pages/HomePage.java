package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;


public class HomePage extends BasePage {


    @FindBy( id =  "menu-item-66")
    private WebElementFacade shopListOfProducts;

    @FindBy( id = "menu-item-64")
    private WebElementFacade myAccountMenu;

    @FindBy(css = "div.u-column1.col-1 > form > p:nth-child(3) > button")
    private WebElementFacade loginLink;

    @FindBy(xpath = "//*[@id=\"masthead\"]/div/div[1]/div[2]/i")
    private WebElementFacade searchIcon;

    @FindBy(css = ".search-form input[type=text]")
    private WebElementFacade searchField;

    @FindBy(css = "i:only-child.icon-search")
    private WebElementFacade enterSearchButton;

    @FindBy( css ="a.cart-control")
    private WebElementFacade cartIcon;

    @FindBy ( css = "#primary > main > div > div")
    private WebElementFacade productsCatalog;


    public void openShop(){
        clickOn(shopListOfProducts);
    }

    public boolean isProductsCatalogDisplayed(){
        productsCatalog.isDisplayed();
        return true;
    }

    public void clickMyAccountMenu(){
        waitFor(myAccountMenu).waitUntilVisible();
        clickOn(myAccountMenu);
    }

    public void clickLoginLink(){
        clickOn(loginLink);
    }

    public void clickOnSearchIcon(){
        clickOn(searchIcon);
    }

    public void setSearchField(String value){
        typeInto(searchField,value);
    }

    public void clickEnterSearchButton(){
        clickOn(enterSearchButton);
    }

    public void clickOnCartIcon(){
        element(cartIcon).click();
    }


}

