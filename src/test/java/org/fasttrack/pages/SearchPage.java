package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import java.util.List;

public class SearchPage extends BasePage {

    @FindBy( css =  ".price span[class*=\"woocommerce-Price-amount amount\"]")
    private List<WebElementFacade> listOfAllProduct;

    @FindBy(css="a[rel*=\"bookmark\"]")
    private List<WebElementFacade> listOfItemsFoundByName;

    @FindBy( css = "#primary > main > form > select")
    private WebElementFacade sortButton;

    @FindBy( css = "#primary > main > form > select > option:nth-child(4)")
    private WebElementFacade sortByPriceLowToHigh;

    @FindBy(css ="#primary > main > form > select > option:nth-child(5)")
    private WebElementFacade sortByPriceHighToLow;

    @FindBy(css ="div.item.post-28.product.type-product.status-publish.has-post-thumbnail.product_cat-music.last.instock.sale.downloadable.virtual.taxable.purchasable.product-type-simple  div.price > span " )
    private WebElementFacade lowestPriceProductInList;

    @FindBy(css = "div.p-info > div.price > span > span")
    private WebElementFacade highestPriceProductInList;


    public boolean displayProduct(String name) {
        waitFor(listOfItemsFoundByName.get(0));
        for (WebElementFacade element : listOfItemsFoundByName) {
            if (element.getText().equalsIgnoreCase(name)) {
                element.isDisplayed();
                return true;
            }
        }
        return false;
    }

    public void sortListOfProductsByPriceLowToHigh(){
        sortButton.selectByVisibleText("Sort by price: low to high");
    }

    public void sortListOfProductsByPriceHighToLow(){
        sortButton.selectByVisibleText("Sort by price: high to low");
    }

    public boolean isPriceLowToHighCorrect(){
        return getIntPriceFromPrice(listOfAllProduct.get(0).getText())
                <getIntPriceFromPrice(listOfAllProduct.get(listOfAllProduct.size()-1).getText());
    }

    public boolean isPriceHighToLowCorrect(){
        return getIntPriceFromPrice(listOfAllProduct.get(listOfAllProduct.size()-1).getText())
                <getIntPriceFromPrice(listOfAllProduct.get(0).getText());
    }

}



