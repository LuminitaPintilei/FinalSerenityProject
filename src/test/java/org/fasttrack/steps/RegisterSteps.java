package org.fasttrack.steps;

import net.thucydides.core.annotations.Step;

public class RegisterSteps extends BaseSteps{

    @Step
    public void navigateToLoginPage(){
        homePage.clickMyAccountMenu();
    }

    @Step
    public void createUserCredentials (String email, String pass){
        registerPage.setRegisterUsername(email);
        registerPage.setRegisterPassword(pass);
    }

    @Step
    public void verifyPasswordStrength(String message) {
        registerPage.verifyPasswordStrength(message);
    }

    @Step
    public void registerButtonIsDisabled() {
        registerPage.registerButtonIsDisabled();
    }

    @Step
    public void registerButtonIsEnabled() {
        registerPage.registerButtonIsEnabled();
    }

    @Step
    public void clickRegisterUser(){
        registerPage.clickRegisterButton();
    }

    @Step
    public void saveUserAddress(){
        myAccountPage.clickAddressesButton();
        myAccountPage.clickEditAddressButton();
        myAccountPage.editBillingFirstName();
        myAccountPage.editBillingLastName();
        myAccountPage.editAddress();
        myAccountPage.editCity();
        myAccountPage.editCountry();
        myAccountPage.editPostCode();
        myAccountPage.editPhone();
        myAccountPage.saveAddress();
        myAccountPage.checkMessageForAddressSaved("Address changed successfully.");
    }



}


