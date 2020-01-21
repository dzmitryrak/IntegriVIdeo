package driver;

public class DriverFactory {

    public static DriverManager getManager(DriverType type) {

        DriverManager driverManager;

        switch (type) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case FIREFOX:
                driverManager = new FirefoxDriverManager();
                break;
/*            case SAFARI:
                driverManager = new SafariDriverManager();*/
            default:
                //TODO implement
                driverManager = null;
                //driverManager = new SafariDriverManager();
                break;
        }
        return driverManager;

    }
}
