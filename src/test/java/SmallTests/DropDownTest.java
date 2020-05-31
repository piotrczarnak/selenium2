package SmallTests;

import methods.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDownTest {

    WebDriver driver;
    String url ="http://theinternet.przyklady.javastart.pl/dropdown";
    Utils method;

    @BeforeMethod
    public void initiateDriver(){
        System.setProperty("webdriver.chrome.driver", "/Users/picz/Downloads/chromedriver");
        driver = new ChromeDriver();
        method = new Utils(driver);
    }

    @Test
    public void dropdownTest(){
        driver.navigate().to(url);
        WebElement selectField = driver.findElement(By.id("dropdown"));
        Select select = new Select(selectField);
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Please select an option");
        select.selectByValue("1");
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Option 1");
        select.selectByValue("2");
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Option 2");
    }

    @AfterMethod
    public void quit(){
        driver.close();
        driver.quit();
    }
}
