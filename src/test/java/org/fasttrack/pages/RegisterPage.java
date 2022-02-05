package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterPage extends BasePage {

    @FindBy( id = "reg_email" )
    private WebElementFacade registerUsername;

    @FindBy( id = "reg_password")
    private WebElementFacade registerPassword;

    @FindBy( css = "p.woocommerce-FormRow.form-row > button")
    private WebElementFacade registerButton;

    @FindBy( css = "*.woocommerce-password-strength")
    private WebElementFacade passwordMessage;



    public void setRegisterUsername(String email){
        typeInto(registerUsername, email);
    }

    public void setRegisterPassword(String pass) {
        typeInto(registerPassword, pass);
    }

    public void clickRegisterButton() {
        clickOn(registerButton);
    }

    public void verifyPasswordStrength(String message) {
        element(passwordMessage).waitUntilVisible();
        passwordMessage.click();
        waitFor(ExpectedConditions.visibilityOf(passwordMessage));
        String actualMessage = passwordMessage.getText();
        Assert.assertTrue("The password strength message should be: " + message ,
                actualMessage.equalsIgnoreCase(message));
    }

    public void registerButtonIsDisabled() {
        element(registerButton).waitUntilVisible();
        Assert.assertTrue("The register button shouldn't be enabled: " + registerButton.isEnabled(),
                registerButton.isDisabled() == true);
    }

    public void registerButtonIsEnabled() {
        element(registerButton).waitUntilVisible();
        Assert.assertTrue("The register button shouldn't be disabled: " + registerButton.isDisplayed(),
                registerButton.isEnabled() == true);
    }





}
