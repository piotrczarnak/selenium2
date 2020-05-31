package tests;

import configuration.PropertiesFileLoader;
import configuration.ConfigurationProvider;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import driver.DriverManager;
import methods.Utils;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public class BaseTest {

    public WebDriver driver;
    public Utils methods;

    @Parameters("browser")
    @BeforeMethod
    public void initiateDriver(@Optional String browser){
        PropertiesFileLoader loader = new PropertiesFileLoader();
        ConfigurationProvider.setProperties(loader.getPropertiesFromFile("configuration.properties"));
        DriverManager.setDriverType(browser);
        driver = DriverManager.getDriver();
        methods = new Utils(driver);
    }

    @AfterMethod
    public void quit(){
       DriverManager.killDriver();
    }
}
