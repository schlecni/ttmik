package ttmik;

import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ttmik.model.LoginPage;

import static ttmik.BrowserName.CHROME;

public class LoginTest {

    protected static final String TALK_TO_ME_IN_KOREAN_LOGIN_URL = "https://talktomeinkorean.com/wp-login.php";
    protected static final String TEST_EMAIL = "kblaassj@email.com";
    protected static final String TEST_PASSWORD = "ssadawadas";

    private final Logger log;

    protected final WebDriver driver = BrowserFactory.getDriverInstance(CHROME, TALK_TO_ME_IN_KOREAN_LOGIN_URL);

    public LoginTest(Logger logger) {
        log = logger;
    }

    /**
     * Open the platform's login page
     *
     * @param loginPage the login page for which the functionality is tested
     */
    protected void openPlatformLoginPage(LoginPage loginPage) {
        log.info("Open platform's login page...");
        loginPage.clickPlatformIcon();
    }

    /**
     * It switches from parent window to the newly opened one
     *
     * @return the parent window from which the switch was made
     */
    protected String switchToNewOpenedWindow() {
        String parentWindow = driver.getWindowHandle();

        for (String window : driver.getWindowHandles()) {
            if (parentWindow.equals(window)) {
                continue;
            }

            log.info("Switching window from parent window: {} to new window: {}.", parentWindow, window);
            driver.switchTo().window(window);
        }

        return parentWindow;
    }

    /**
     * Fills in the login details and try to log in into the account
     *
     * @param loginPage the login page for which the functionality is tested
     */
    protected void fillInEmail(LoginPage loginPage) {
        freezeTheBrowserForMilliseconds(3000);

        loginPage.fillInEmail(TEST_EMAIL);
        log.info("Filled-in the email: {}.", TEST_EMAIL);

        freezeTheBrowserForMilliseconds(1000);
    }

    /**
     * Fills in the login details and try to log in into the account
     *
     * @param loginPage the login page for which the functionality is tested
     */
    protected void fillInPassword(LoginPage loginPage) {
        freezeTheBrowserForMilliseconds(1000);
        loginPage.fillInPassword(TEST_PASSWORD);
        log.info("Filled-in the password: {}.", TEST_PASSWORD);
        freezeTheBrowserForMilliseconds(2000);
    }


    /**
     * Fills in the login details and try to log in into the account
     *
     * @param loginPage the login page for which the functionality is tested
     */
    protected void login(LoginPage loginPage) {
        loginPage.login();
    }

    /**
     * Asserts the error message display for invalid  credentials
     *
     * @param by the selector used for finding the error message
     */
    protected void assertErrorMessage(By by) {
        freezeTheBrowserForMilliseconds(2000);
        WebElement loginError = driver.findElement(by);

        Assert.assertNotNull(loginError);
        log.info("The received error message was: '{}.'", loginError.getText());
    }

    /**
     * It closes all browser tabs
     */
    protected void closeAllTabs() {
        log.info("Closing all tabs...");
        driver.getWindowHandles().forEach(window -> driver.switchTo().window(window).close());
    }

    /**
     * it freezes the browser for the specified number of milliseconds
     *
     * @param milliseconds the number of milliseconds
     */
    public void freezeTheBrowserForMilliseconds(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            log.error("Something went wrong!");
            closeAllTabs();
        }
    }

}
