package tests;

import configuration.ConfigurationVariables;
import configuration.PropertiesFileLoader;
import driver.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.StartPage;

public class LoginTests extends BaseTest {

    @Test
    public void verifyMoveFromMainPageToLogin(){
        DriverManager.goToWebPage(ConfigurationVariables.APPLICATION_URL);

        MainPage mainPage = new StartPage(driver).goToShop();

        boolean isLoginFieldPresented = mainPage.goToLoginPage().isLoginIsPresented();

        Assert.assertTrue(isLoginFieldPresented);
    }

    @Test
    public void correctLoginAndPassword(){
        DriverManager.goToWebPage(ConfigurationVariables.LOGIN_URL);

        LoginPage loginPage = new LoginPage(driver);

        boolean isSignOutIsPresented = loginPage.tryToLogin("j2ee", "j2ee").isWelcomeTextIsPresented();

        Assert.assertTrue(isSignOutIsPresented);
    }

    @Test
    public void wrongLoginAndPassword(){
        DriverManager.goToWebPage(ConfigurationVariables.LOGIN_URL);
        LoginPage loginPage = new LoginPage(driver);

        String warning = loginPage.tryToLogin("dsfsadf", "fsaad").getWarningMessage();

        Assert.assertEquals(warning,"Invalid username or password. Signon failed.");
    }
}
