package ttmik.loginbuttons;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import ttmik.LoginTest;
import ttmik.model.GooglePage;

public class GoogleLoginTest extends LoginTest {

    private static final Logger LOGGER = LogManager.getLogger(GoogleLoginTest.class);
    private static final String XPATH_ERROR_MESSAGE = "/html/body/div[1]/div[1]/div[2]/div/div[2]/" +
            "div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div";

    public GoogleLoginTest() {
        super(LOGGER);
    }

    @Test
    public void testGoogleButton() {
        LOGGER.info("Initiate login with invalid credentials...");

        GooglePage googlePage = PageFactory.initElements(driver, GooglePage.class);

        openPlatformLoginPage(googlePage);
        switchToNewOpenedWindow();
        fillInEmail(googlePage);
        login(googlePage);
        assertErrorMessage(By.xpath(XPATH_ERROR_MESSAGE));
        closeAllTabs();
    }
}