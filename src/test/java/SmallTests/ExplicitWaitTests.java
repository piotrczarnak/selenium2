package SmallTests;

import org.testng.Assert;
import methods.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWaitTests {

    private WebDriver driver;
    private String url = "http://theinternet.przyklady.javastart.pl/dynamic_controls";
    private Utils methods;

    @BeforeMethod
    public void initiateDriver(){
        System.setProperty("webdriver.chrome.driver", "/Users/picz/Downloads/chromedriver");
        driver = new ChromeDriver();
        methods = new Utils(driver);
        driver.navigate().to(url);
    }

    @Test
    public void test(){
        By checkboxId = By.id("checkbox");
        By messageId = By.id("message");
        WebElement checkbox = methods.returnWebElement(checkboxId);
        methods.waitWebElementLocated(checkbox);
        Assert.assertTrue(checkbox.isDisplayed());
        Assert.assertFalse(checkbox.isSelected());
        methods.click(driver.findElement(By.id("btn")));
        methods.waitElementLocated(messageId);
        Assert.assertEquals(messageId, "It's gone!");
        methods.click(driver.findElement(By.id("btn")));
        checkbox = methods.waitElementLocated(checkboxId);
        Assert.assertTrue(checkbox.isDisplayed());
        Assert.assertFalse(checkbox.isSelected());
    }

    @AfterMethod
    public void quit(){
        driver.close();
        driver.quit();
    }
}
