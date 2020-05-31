package tests;

import configuration.ConfigurationVariables;
import configuration.PropertiesFileLoader;
import driver.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.StartPage;

public class MainPageTests extends BaseTest {

    @Test
    public void verifyMoveFromStartPageToMainPage(){
        DriverManager.goToWebPage(ConfigurationVariables.APPLICATION_URL);

        StartPage start = new StartPage(driver);

        boolean isCatalogPresented = start.goToShop().isCatalogPresented();

        Assert.assertTrue(isCatalogPresented);
    }
}
