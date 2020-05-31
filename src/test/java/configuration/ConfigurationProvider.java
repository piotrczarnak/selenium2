package configuration;

import driver.BrowserType;

import java.util.Properties;

public class ConfigurationProvider {

    private static Properties properties;

    private ConfigurationProvider() {
    }

    public static void setProperties(Properties properties) {
        if(ConfigurationProvider.properties == null){
        ConfigurationProvider.properties = properties;}
    }

    public static String getValueOfProperty(String propertyName) {
        if (properties == null) {
            throw new IllegalArgumentException("Properties not loaded");
        } else {
            return properties.getProperty(propertyName);
        }
    }

    public static BrowserType getBrowserType(){
        return BrowserType.valueOf(getValueOfProperty("browser"));
    }

    public static boolean getIsRemote(){
        return Boolean.parseBoolean(getValueOfProperty("isRemote"));
    }
}
