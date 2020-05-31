package driver;

import configuration.ConfigurationProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class BrowserFactory {


    public static WebDriver getBrowser(boolean isRemote, BrowserType browser) {
        if(isRemote){
            DesiredCapabilities capabilities = new DesiredCapabilities();
            switch (browser) {
                case FIREFOX:
                    FirefoxOptions ffOptions = new FirefoxOptions();
                    capabilities.merge(ffOptions);
                    return getRemoteDriver(capabilities);
                case IE:
                    InternetExplorerOptions ieOptions = new InternetExplorerOptions();
                    capabilities.merge(ieOptions);
                    return getRemoteDriver(capabilities);
                case CHROME:
                    ChromeOptions chromeOptions = new ChromeOptions();
                    capabilities.merge(chromeOptions);
                    return getRemoteDriver(capabilities);
                default:
                    throw new IllegalStateException("Unknown browser type! Please check your configuration");
            }
        } else {
            switch (browser) {
                case FIREFOX:
                    System.setProperty("webdriver.gecko.driver", "C:/drivers/geckodriver.exe");
                    return new FirefoxDriver();
                case IE:
                    System.setProperty("webdriver.ie.driver", "C:/drivers/geckodriver.exe");
                    return new InternetExplorerDriver();
                case CHROME:
                    System.setProperty("webdriver.chrome.driver", ConfigurationProvider.getValueOfProperty("chrome.driver.location"));
                    return new ChromeDriver();
                default:
                    throw new IllegalStateException("Unknown browser type! Please check your configuration");
            }
        }
    }

    private static RemoteWebDriver getRemoteDriver(DesiredCapabilities capabilities) {
        return new RemoteWebDriver(capabilities);
    }
}
