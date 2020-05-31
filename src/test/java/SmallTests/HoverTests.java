package SmallTests;

import methods.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HoverTests {

    private WebDriver driver;
    private String url = "http://theinternet.przyklady.javastart.pl/hovers";
    private Utils methods;

    @BeforeMethod
    public void initiateDriver(){
        System.setProperty("webdriver.chrome.driver", "/Users/picz/Downloads/chromedriver");
        driver = new ChromeDriver();
        methods = new Utils(driver);
    }

    @Test
    public void test(){
        String pictureIdString = "//div[@class='figure']";
        driver.navigate().to(url);
        methods.waitElementLocated(By.id("content"));
        int numberOfPictures = methods.returnListOfElements(By.xpath(pictureIdString)).size();
        for(int i = numberOfPictures;i > 0;i--){
            String exactPictureIdString = pictureIdString + "[" + Integer.toString(i) + "]";
            methods.moveToElement(By.xpath(exactPictureIdString));
            Assert.assertTrue(methods.returnWebElement(By.xpath(exactPictureIdString + "/div/h5")).isDisplayed());
        }

    }

    @AfterMethod
    public void quit(){
        driver.close();
        driver.quit();
    }
}
