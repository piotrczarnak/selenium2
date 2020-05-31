package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends  BasePage{

    @FindBy(name = "username")
    private WebElement loginField;
    @FindBy(name = "password")
    private WebElement passwordField;
    @FindBy(name = "signon")
    private WebElement loginButton;
    @FindBy(css = "ul.messages li")
    private WebElement errorId;
    @FindBy(css = "#WelcomeContent")
    private WebElement welcomeText;

    @Step("Tried login with login: {login} and password: {password}")
    public LoginPage tryToLogin(String login, String password) {
        methods().typeText(loginField, login);
        methods().typeText(passwordField, password);
        methods().click(loginButton);
        log().info("Typed into User Name Field {}", login, "and Password Name Field{} ", password);
        return this;
    }

    public String getWarningMessage(){
        methods().waitWebElementLocated(errorId);
        return errorId.getText();
    }

    public boolean isLoginIsPresented(){
        return loginField.isDisplayed();
    }

    public boolean isWelcomeTextIsPresented(){
        return welcomeText.isDisplayed();
    }
}
