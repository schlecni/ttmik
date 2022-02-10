package ttmik;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

    public static final String GECKO_FIREFOX_DRIVER = "webdriver.gecko.driver";
    public static final String GECKO_FIREFOX_DRIVER_PATH = "C://SeleniumDrivers//geckodriver//geckodriver.exe";

    public static final String CHROME_DRIVER = "webdriver.chrome.driver";
    public static final String CHROME_DRIVER_PATH = "D:\\chromedriver_98.0.4758.80\\chromedriver.exe";

    public static final String EDGE_DRIVER = "webdriver.edge.driver";
    public static final String EDGE_DRIVER_PATH = "C://SeleniumDrivers//msedgedriver//msedgedriver.exe";

    private BrowserFactory() {
    }

    public static WebDriver getDriverInstance(BrowserName browserName, String url) {
        WebDriver browserDriver = null;

        switch (browserName) {
            case FIREFOX:
                System.setProperty(GECKO_FIREFOX_DRIVER, GECKO_FIREFOX_DRIVER_PATH);
                browserDriver = new FirefoxDriver();
                break;
            case CHROME:
                System.setProperty(CHROME_DRIVER, CHROME_DRIVER_PATH);
                browserDriver = new ChromeDriver();
                break;
            case EDGE:
                System.setProperty(EDGE_DRIVER, EDGE_DRIVER_PATH);
                browserDriver = new EdgeDriver();
                break;
        }

        browserDriver.get(url);
        return browserDriver;
    }
}