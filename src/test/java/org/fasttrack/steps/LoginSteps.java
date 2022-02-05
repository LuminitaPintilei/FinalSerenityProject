package org.fasttrack.steps;

import net.thucydides.core.annotations.Step;

public class LoginSteps extends BaseSteps{


    @Step
    public void navigateToLoginPage(){
        homePage.clickMyAccountMenu();
        homePage.clickLoginLink();
    }

    @Step
    public void enterCredentials(String email, String pass){
        loginPage.setUsernameField(email);
        loginPage.setPasswordField(pass);
    }

    @Step
    public void clickLogin(){
        loginPage.clickLoginButton();
    }

    @Step
    public void checkUserIsLoggedIn(String userName){
        myAccountPage.checkUserLoggedIn(userName);
    }

    @Step
    public void doLogin(String user, String pass){
        navigateToLoginPage();
        enterCredentials(user, pass);
        clickLogin();
    }

    @Step
    public void checkInvalidEmailAddressMessage(String message){
        loginPage.getInvalidEmailAddressMessageError();
    }

    @Step
    public void doLogout(){
        myAccountPage.logout();
    }
}

