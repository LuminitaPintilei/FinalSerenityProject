package org.fasttrack.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.fasttrack.pages.*;
import org.fasttrack.utils.EnvConstants;



public class BaseSteps extends ScenarioSteps {
    public HomePage homePage;
    public LoginPage loginPage;
    public MyAccountPage myAccountPage;
    public SearchPage searchPage;
    public CartPage cartPage;
    public RegisterPage registerPage;
    public CheckoutPage checkoutPage;


    @Step
    public void navigateToHomePage() {
        getDriver().get(EnvConstants.BASE_URL);

    }
}
