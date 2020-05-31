package driver;

public enum BrowserType {

    CHROME("chrome"),
    FIREFOX("firefox"),
    IE("ie");

    private String name;

    BrowserType(String name){
        this.name = name;
    }

}
