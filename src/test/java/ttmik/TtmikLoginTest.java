package ttmik;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import ttmik.model.TtmikPage;


public class TtmikLoginTest extends LoginTest {

    private static final Logger LOGGER = LogManager.getLogger(TtmikLoginTest.class);
    public static final String ERROR_MESSAGE_ID = "login_error";

    public TtmikLoginTest() {
        super(LOGGER);
    }

    @Test
    public void test_login_with_wrong_credentials() {
        TtmikPage loginPage = PageFactory.initElements(driver, TtmikPage.class);

        fillInEmail(loginPage);
        fillInPassword(loginPage);
        login(loginPage);
        assertErrorMessage(By.id(ERROR_MESSAGE_ID));
        closeAllTabs();
    }

}
