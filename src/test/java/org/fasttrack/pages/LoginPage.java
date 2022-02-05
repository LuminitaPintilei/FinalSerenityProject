package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import java.time.Duration;

public class LoginPage extends BasePage {

    @FindBy(id = "username")
    private WebElementFacade usernameField;

    @FindBy(id = "password")
    private WebElementFacade passwordField;

    @FindBy(css ="div.u-column1.col-1 > form > p:nth-child(3) > button")
    private WebElementFacade loginButton;

    @FindBy(xpath = "//*[@id=\"post-7\"]/div/div/ul")
    private WebElementFacade invalidEmailAddressMessage;


    public void setUsernameField(String email){
        waitFor(usernameField);
        withTimeoutOf(Duration.ofSeconds(10)).waitFor(usernameField);
        typeInto(usernameField, email);
    }

    public void setPasswordField(String pass){
        typeInto(passwordField, pass);
    }

    public void clickLoginButton(){
        clickOn(loginButton);
    }

    public String getInvalidEmailAddressMessageError(){
        waitFor(invalidEmailAddressMessage);
        return invalidEmailAddressMessage.getTextContent();
    }


}
