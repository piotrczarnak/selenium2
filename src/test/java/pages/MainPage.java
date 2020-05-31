package pages;


import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import methods.Utils;


public class MainPage extends BasePage{

    private WebDriver driver;
    @FindBy(css = "#MenuContent a[href*='signonForm']")
    WebElement loginLink;
    @FindBy(id = "MainImageContent")
    WebElement mainImage;

    public boolean isCatalogPresented(){
        return mainImage.isDisplayed();
    }

    public LoginPage goToLoginPage(){
        methods().click(loginLink);
        return new LoginPage();
    }

}
