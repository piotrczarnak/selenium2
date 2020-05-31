package methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class Utils {

    WebDriver driver;
    private Actions actions;
    private WebDriverWait wait;

    public Utils(WebDriver driver){
        this.driver = driver;
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, 15);
    }

    public WebDriver startDriver(String url){
        System.setProperty("webdriver.chrome.driver", "/Users/picz/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.navigate().to(url);
        return driver;
    }
    public WebElement returnWebElement(By id){
        return driver.findElement(id);
    }

    public List<WebElement> returnListOfElements(By id){
        return driver.findElements(id);
    }

    public WebElement waitElementLocated(By id){
      return  wait.until(ExpectedConditions.visibilityOfElementLocated(id));
    }

    public void waitWebElementLocated(WebElement id){
        wait.until(ExpectedConditions.visibilityOf(id));
    }

    public void click(WebElement element){
        element.click();
    }

    public void typeText(WebElement element,String text){
        clearField(element);
            element.sendKeys(text);
    }

    public void clearField(WebElement element){
        element.clear();
    }
    public String getText(WebElement id){
        return id.getText();
    }

    public void selectByValue(By id, String value){
        new Select(returnWebElement(id)).selectByValue(value);
    }

    public String getFirstSelectedOptionString(By id){
        return new Select(returnWebElement(id)).getFirstSelectedOption().getText();
    }

    public void moveToElement(By id){
        actions.moveToElement(returnWebElement(id)).perform();
    }
}
