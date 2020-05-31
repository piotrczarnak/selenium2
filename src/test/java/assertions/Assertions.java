package assertions;

import methods.Utils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Assertions {

    private Logger log = LogManager.getLogger();
    private Utils method;

    public Assertions(WebDriver driver){
        method = new Utils(driver);
    }

    public Assertions isPresent(WebElement element){
        method.waitWebElementLocated(element);
        log.info("Checking if {} presented");
        Assert.assertTrue(element.isDisplayed());
        return this;
    }

    public Assertions isTextCorrect(WebElement element, String stringToCheck){
        method.waitWebElementLocated(element);
            log.info("Checking if {} has text");
        Assert.assertEquals(method.getText(element), stringToCheck);
        return this;
    }
}
