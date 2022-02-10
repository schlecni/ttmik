package ttmik.loginbuttons;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import ttmik.LoginTest;
import ttmik.model.ApplePage;

public class AppleLoginTest extends LoginTest {

    private static final Logger LOGGER = LogManager.getLogger(AppleLoginTest.class);
    public static final String XPATH_ERROR_MESSAGE = "/html/body/div[1]/oauth-init/div[1]/div/oauth-signin/div/apple-auth/div/div[1]/div/sign-in/div/div[1]/div[2]/div/p";

    public AppleLoginTest() {
        super(LOGGER);
    }

    @Test
    public void testAppleButton() {
        ApplePage applePage = PageFactory.initElements(driver, ApplePage.class);

        openPlatformLoginPage(applePage);
        switchToNewOpenedWindow();
        fillInEmail(applePage);
        login(applePage);
        fillInPassword(applePage);
        login(applePage);
        assertErrorMessage(By.xpath(XPATH_ERROR_MESSAGE));
        closeAllTabs();
    }
}
