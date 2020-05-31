package SmallTests;

import methods.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploadTests {

    private WebDriver driver;
    private String url = "http://theinternet.przyklady.javastart.pl/upload";
    private Utils methods;

    @BeforeMethod
    public void initiateDriver(){
        System.setProperty("webdriver.chrome.driver", "/Users/picz/Downloads/chromedriver");
        driver = new ChromeDriver();
        methods = new Utils(driver);
    }

    @Test
    public void test(){
        driver.navigate().to(url);
        String fileName = "testfile.txt";
        methods.typeText(methods.returnWebElement(By.id("file-upload")), "/Users/picz/Documents/" + fileName);
        methods.click(methods.returnWebElement(By.id("file-submit")));
        WebElement uploadedFileId = driver.findElement(By.id("uploaded-files"));
        methods.waitWebElementLocated(uploadedFileId);
        Assert.assertEquals(methods.getText(uploadedFileId), fileName);
    }

    @AfterMethod
    public void quit(){
        driver.close();
        driver.quit();
    }
}
