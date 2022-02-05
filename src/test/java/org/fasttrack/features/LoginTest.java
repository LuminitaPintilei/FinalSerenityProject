package org.fasttrack.features;

import org.fasttrack.utils.EnvConstants;
import org.junit.Test;

public class LoginTest extends BaseTest{

    @Test
    public void loginWithValidCredentialsTest(){
        loginSteps.navigateToLoginPage();
        loginSteps.enterCredentials(EnvConstants.USER_EMAIL, EnvConstants.USER_PASS);
        loginSteps.clickLogin();
        loginSteps.checkUserIsLoggedIn(EnvConstants.USER_NAME);
    }

    @Test
    public void loginWithInvalidEmailAddressTest(){
        loginSteps.navigateToLoginPage();
        loginSteps.enterCredentials("alo@ss.ss", EnvConstants.USER_PASS);
        loginSteps.clickLogin();
        loginSteps.checkInvalidEmailAddressMessage("ERROR: Invalid email address. Lost your password?");
    }

    @Test
    public void loginWithInvalidPasswordTest(){
        loginSteps.navigateToLoginPage();
        loginSteps.enterCredentials(EnvConstants.USER_EMAIL, "000");
        loginSteps.clickLogin();
        loginSteps.checkInvalidEmailAddressMessage("ERROR: The password you entered for the email address"
                + EnvConstants.USER_EMAIL + " is incorrect. Lost your password?");
    }

    @Test
    public void loginAndLogoutTest(){
        loginSteps.navigateToLoginPage();
        loginSteps.enterCredentials(EnvConstants.USER_EMAIL, EnvConstants.USER_PASS);
        loginSteps.clickLogin();
        loginSteps.doLogout();
    }

}
