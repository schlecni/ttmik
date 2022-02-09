import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import ttmik.model.TTMIKPage;


public class TTMIKLogin {

    private static final Logger LOGGER = LogManager.getLogger(TTMIKLogin.class);

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
//        System.setProperty("webdriver.edge.driver", "D:\\learning\\ChromeDriver_win64\\msChromeDriver.exe");
    }

    @Test
    public void test_login_with_wrong_credentials() throws InterruptedException {
        // Initialize the driver for chrome, this one communicates with the browser and its pages
        WebDriver driver = new ChromeDriver();

        // navigate to the talk to me in korea page
        driver.get("https://talktomeinkorean.com/wp-login.php");

        TTMIKPage loginPage = PageFactory.initElements(driver, TTMIKPage.class);
        // search for the user element in login form
        loginPage.enterUsername("blabla");

        // search for the password element in login form
        loginPage.enterPassword("vqnerakbh");

        // submit the login form
        loginPage.submitForm();

        // verify that the error message displayed contains Error
        Assert.assertTrue(loginPage.getLoginErrorMessage().contains("Error"));

        // print in the console the received error message from the chrome drive (the message in the ttmik page)
        LOGGER.info("The received error message was: '{}'.", loginPage.getLoginErrorMessage());
        driver.quit();
    }

}
