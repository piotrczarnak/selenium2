package driver;

import listeners.WebDriverEventListenerRegister;
import configuration.ConfigurationVariables;
import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static ThreadLocal<WebDriver> localThreadDriver = new ThreadLocal<>();
    private static ThreadLocal<BrowserType> localThreadBrowserType = new ThreadLocal<>();
    private static WebDriver driver;

    private  DriverManager(){
    }
    public static void setDriverType(String browserType){
        if(browserType == null){
            localThreadBrowserType.set(ConfigurationVariables.BROWSER);
        } else {
            localThreadBrowserType.set(BrowserType.valueOf(browserType));
        }
    }

    private static void setDriver(){
        if(localThreadDriver.get() == null) {
            driver = BrowserFactory.getBrowser(ConfigurationVariables.IS_REMOTE, localThreadBrowserType.get());
            localThreadDriver.set(driver);
        }
        driver = WebDriverEventListenerRegister.registerObjectOfEventListener(driver);
        localThreadDriver.set(driver);
    }

    public static WebDriver getDriver(){
        setDriver();
    return localThreadDriver.get();
    }

    public static void goToWebPage(String url){localThreadDriver.get().navigate().to(url);
    }



    public static void killDriver(){
        if(!ConfigurationVariables.BROWSER.equals(BrowserType.FIREFOX)){
        localThreadDriver.get().close();
        }
        localThreadDriver.get().quit();
        localThreadDriver.remove();
        localThreadBrowserType.remove();
    }
}
