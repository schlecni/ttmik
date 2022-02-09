package ttmik.loginbuttons;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import ttmik.model.FacebookPage;

public class FacebookLoginTest {

    private static final Logger LOGGER = LogManager.getLogger(FacebookLoginTest.class);

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
//        System.setProperty("webdriver.edge.driver", "D:\\learning\\ChromeDriver_win64\\msChromeDriver.exe");
    }

    @Test
    public void testFacebookButton() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://talktomeinkorean.com/wp-login.php");

        FacebookPage facebookPage = PageFactory.initElements(driver, FacebookPage.class);
        facebookPage.clickFacebookIcon();

        String currentWindow = driver.getWindowHandle();
        String facebookLoginPage = null;
        for (String window : driver.getWindowHandles()) {
            if (currentWindow.equals(window)) {
                continue;
            }

            facebookLoginPage = window;
            driver.switchTo().window(window);
        }

        // switch to cookies page
        for (String window : driver.getWindowHandles()) {
            if (currentWindow.equals(window) || facebookLoginPage.equals(window)) {
                continue;
            }

            driver.switchTo().window(window);
        }

        // accept cookies
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div/div/div[3]/button[2]")).click();

        // switch back to facebook login page
        driver.switchTo().window(facebookLoginPage);

        final String email = "kblasj@email.com";
        facebookPage.enterEmail(email);
        LOGGER.info("Enter email: {}", email);


        final String password = "sadawadas";
        facebookPage.enterPassword(password);
        LOGGER.info("Enter password: {}", password);

        // click Login button
        driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/form/div/div[3]/label[2]/input")).click();
        Thread.sleep(1000);
        WebElement invalidEmailField = driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/form/div[1]/div[1]"));
        Assert.assertTrue(invalidEmailField.getText().contains("Incorrect Email"));

        LOGGER.info("The received error message was: '{}'.", invalidEmailField.getText());
        driver.close();
    }
}
