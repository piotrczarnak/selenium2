package SmallTests;

import org.testng.Assert;
import methods.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FluentWaitTests2 {

    private WebDriver driver;
    private String url = "http://theinternet.przyklady.javastart.pl/dynamic_loading/2";
    private Utils methods;


    @BeforeMethod
    public void initiateDriver(){
        methods = new Utils(driver);
        methods.startDriver(url);
    }

    @Test
    public void test(){
        FluentWait<WebDriver> fw = new FluentWait<>(driver);
        fw.withTimeout(Duration.ofSeconds(25)).pollingEvery(Duration.ofMillis(200));
        By helloWordStringId = By.id("finish");
        fw.until(ExpectedConditions.visibilityOfElementLocated(By.id("content")));

        Assert.assertFalse(methods.returnWebElement(helloWordStringId).isDisplayed());

        methods.click(methods.returnWebElement(By.cssSelector("button")));
        Assert.assertTrue(fw.until(ExpectedConditions.visibilityOfElementLocated(helloWordStringId)).isDisplayed());


    }

    @AfterMethod
    public void quit(){
        driver.close();
        driver.quit();
    }
}
