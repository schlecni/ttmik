package ttmik.loginbuttons;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import ttmik.LoginTest;
import ttmik.model.FacebookPage;

public class FacebookLoginTest extends LoginTest {

    private static final Logger LOGGER = LogManager.getLogger(FacebookLoginTest.class);
    public static final String XPATH_ERROR_MESSAGE = "/html/body/div/div[2]/div[1]/form/div[1]/div[1]";

    public FacebookLoginTest() {
        super(LOGGER);
    }

    @Test
    public void testFacebookButton() throws InterruptedException {
        FacebookPage facebookPage = PageFactory.initElements(driver, FacebookPage.class);

        openPlatformLoginPage(facebookPage);
        String facebookLoginPage = switchToNewOpenedWindow();

        freezeTheBrowserForMilliseconds(2000);
        String currentWindow = driver.getWindowHandle();

        // switch to cookies page
        for (String window : driver.getWindowHandles()) {
            if (currentWindow.equals(window) || facebookLoginPage.equals(window)) {
                continue;
            }

            driver.switchTo().window(window);
        }

        // accept cookies
        facebookPage.acceptCookies();

        fillInEmail(facebookPage);
        fillInPassword(facebookPage);
        login(facebookPage);
        assertErrorMessage(By.xpath(XPATH_ERROR_MESSAGE));
        closeAllTabs();
    }
}
