package org.fasttrack.features;

import org.fasttrack.utils.EnvConstants;
import org.junit.Test;

public class RegisterTest extends BaseTest{

    @Test
    public void checkRegisterStrongPasswordTest(){
        registerSteps.navigateToLoginPage();
        registerSteps.createUserCredentials(EnvConstants.REGISTER_USERNAME, EnvConstants.REGISTER_STRONGPASS);
        registerSteps.verifyPasswordStrength("Strong");
        registerSteps.registerButtonIsEnabled();
    }

    @Test
    public void checkRegisterWeakPasswordTest(){
        registerSteps.navigateToLoginPage();
        registerSteps.createUserCredentials(EnvConstants.REGISTER_USERNAME, EnvConstants.REGISTER_WEAKPASS);
        registerSteps.verifyPasswordStrength("Very weak - Please enter a stronger password.");
        registerSteps.registerButtonIsDisabled();
    }

    @Test
    public void checkRegisterMediumPasswordTest(){
        registerSteps.navigateToLoginPage();
        registerSteps.createUserCredentials(EnvConstants.REGISTER_USERNAME, EnvConstants.REGISTER_MEDIUMPASS);
        registerSteps.verifyPasswordStrength("Medium");
        registerSteps.registerButtonIsEnabled();
    }

    @Test
    public void registerTest(){
        registerSteps.navigateToLoginPage();
        registerSteps.createUserCredentials(EnvConstants.REGISTER_USERNAME, EnvConstants.REGISTER_STRONGPASS);
        registerSteps.verifyPasswordStrength("Strong");
        registerSteps.registerButtonIsEnabled();
        registerSteps.clickRegisterUser();
    }

    @Test
    public void setMyAccountInfo(){
        loginSteps.navigateToLoginPage();
        loginSteps.enterCredentials(EnvConstants.USER_EMAIL, EnvConstants.USER_PASS);
        loginSteps.clickLogin();
        registerSteps.saveUserAddress();

    }

}
