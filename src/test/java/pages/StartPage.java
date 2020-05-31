package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class StartPage extends BasePage{

    @FindBy(css = "#Content a")
    private WebElement loginLink;

    public MainPage goToShop(){
        methods().click(loginLink);
        return new MainPage();
    }
}
