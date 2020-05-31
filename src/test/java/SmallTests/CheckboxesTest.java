package SmallTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckboxesTest {

    WebDriver driver;
    String url ="http://theinternet.przyklady.javastart.pl/checkboxes";

    @BeforeMethod
    public void initiateDriver(){
        System.setProperty("webdriver.chrome.driver", "/Users/picz/Downloads/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void checkboesTest(){
        driver.navigate().to(url);
        WebElement checkbox1 = driver.findElement(By.xpath("//input[@type='checkbox']"));
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(checkbox1));
        Assert.assertFalse(checkbox1.isSelected());
        Assert.assertTrue(checkbox2.isSelected());
        checkbox1.click();
        checkbox2.click();
        Assert.assertTrue(checkbox1.isSelected());
        Assert.assertFalse(checkbox2.isSelected());
    }

    @AfterMethod
    public void quit(){
        driver.close();
        driver.quit();
    }
}
