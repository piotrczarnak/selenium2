package pages;

import driver.DriverManager;
import methods.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

import javax.rmi.CORBA.Util;

public abstract class BasePage {

    private Logger logger = LogManager.getLogger(this.getClass().getName());
    private Utils methods = new Utils(DriverManager.getDriver());

    public BasePage(){
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    protected Logger log(){
        return logger;
    }

    protected Utils methods(){
        return methods;
    }
}
