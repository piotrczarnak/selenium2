package configuration;

import driver.BrowserType;

public class ConfigurationVariables {

    public static final String APPLICATION_URL = ConfigurationProvider.getValueOfProperty("app.url");
    public static final String LOGIN_URL = APPLICATION_URL + "actions/Account.action?signonForm=";
    public static final BrowserType BROWSER = ConfigurationProvider.getBrowserType();
    public static final boolean IS_REMOTE= ConfigurationProvider.getIsRemote();
}
