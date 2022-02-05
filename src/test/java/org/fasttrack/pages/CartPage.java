package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import java.util.List;


public class CartPage extends BasePage {

    @FindBy(css = "table td[class=\"product-subtotal\"] [class*=\"woocommerce-Price-amount amount\"]:nth-child(1)")
    private List<WebElementFacade> listOfSubtotalPrices;

    @FindBy(css = "table td[data-title=\"Subtotal\"] [class*=\"woocommerce-Price-amount amount\"]:nth-child(1)")
    private WebElementFacade subtotalText;

    @FindBy(css = "td[data-title=\"Shipping\"] [class*=\"woocommerce-Price-amount amount\"]")
    private WebElementFacade shippingFeeText;

    @FindBy(css = "table td[data-title=\"Total\"] strong [class*=\"woocommerce-Price-amount amount\"]:nth-child(1)")
    private WebElementFacade grandTotal;

    @FindBy(css = "a[href*=\"add-to-cart=17\"]")
    private WebElementFacade addHoodieWithLogoProductToCart;

    @FindBy(css = ".woocommerce-message")
    private WebElementFacade confirmationMessageForAddingToCart;

    @FindBy(css = "div.woocommerce-message")
    private WebElementFacade cartUpdatedMessage;

    @FindBy(css = "input[id*= \"quantity\"]")
    private List<WebElementFacade> listOfQuantityOfProducts;

    @FindBy(css = "[value =\"Update cart\"]")
    private WebElementFacade updateCartButton;

    @FindBy(css = "p.cart-empty")
    private WebElementFacade cartEmptyMessage;

    @FindBy(css= ".action a[data-product_id=\"16\"]")
    private WebElementFacade variableProduct;

    @FindBy(id ="pa_color")
    private WebElementFacade colorSelector;

    @FindBy(css="option[value=\"blue\"]:nth-child(2)")
    private WebElementFacade blueColor;

    @FindBy(id="logo")
    private WebElementFacade logoSelector;

    @FindBy(css="option[value=\"Yes\"]:nth-child(2)")
    private WebElementFacade yesLabelLogo;

    @FindBy(css="button[class=\"single_add_to_cart_button button alt\"]")
    private WebElementFacade addToCartButton;
    
    @FindBy(css=".product-name > a[href*=\"attribute\"]")
    private WebElementFacade variableProductInCart;



    public void getHoodieWithLogoProductToCart() {
        clickOn(addHoodieWithLogoProductToCart);
    }

    public boolean isProductAddedToCart() {
        return (confirmationMessageForAddingToCart).getText() == "“Hoodie with Logo” has been added to your cart.";
    }

    public boolean isCartUpdated() {
        waitFor(5);
        return (cartUpdatedMessage).getText() == "Cart updated" && updateCartButton.isDisabled();
    }

    public boolean isCartUpdatedWithInvalidQty(){
        (cartUpdatedMessage).isPresent();
        return false;
    }

    public int getSubtotalPricesCalculated() {
        int sum = 0;
        for (WebElementFacade element : listOfSubtotalPrices) {
            sum += getIntPriceFromPrice(element.getText());
        }
        return sum;
    }

    public boolean isSubtotalPriceCorrect() {
        return getSubtotalPricesCalculated() == getIntPriceFromPrice(subtotalText.getText());
    }

    public int getSubtotalPriceWithTaxes() {
        String x = subtotalText.getText();
        String y = "0";
        if (shippingFeeText.isPresent()) {
            y = shippingFeeText.getText();
        }
        return getIntPriceFromPrice(x) + getIntPriceFromPrice(y);
    }

    public boolean isGrandTotalPriceCorrect() {
        return getSubtotalPriceWithTaxes() == getIntPriceFromPrice(grandTotal.getText());
    }

    public void changeQtyForEachProductInCart(String value) {

        for (WebElementFacade element : listOfQuantityOfProducts) {
            typeInto(element, value);
        }
    }

    public void updateCart () {
            if (updateCartButton.isEnabled())
                clickOn(updateCartButton);
    }

    public boolean isCartEmpty () {
            return cartEmptyMessage.getText() == "Your cart is currently empty.";
    }

    public void selectProductWithVariations(){
            clickOn(variableProduct);
    }

    public void selectBlueColor(){
        clickOn(colorSelector);
        clickOn(blueColor);
    }

    public void selectLogoOption(){
        clickOn(logoSelector);
        clickOn(yesLabelLogo);
    }

    public void addToCart(){
        clickOn(addToCartButton);
    }
         
    public boolean isVariableProductInCart(){
            return variableProductInCart.getTextContent() == " Blue, Yes";
    }
}





