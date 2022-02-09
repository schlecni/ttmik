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
import ttmik.model.ApplePage;

public class AppleLoginTest {

    private static final Logger LOGGER = LogManager.getLogger(AppleLoginTest.class);

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
//        System.setProperty("webdriver.edge.driver", "D:\\learning\\ChromeDriver_win64\\msChromeDriver.exe");
    }

    @Test
    public void testAppleButton() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://talktomeinkorean.com/wp-login.php");

        ApplePage applePage = PageFactory.initElements(driver, ApplePage.class);
        applePage.clickAppleIcon();

        String currentWindow = driver.getWindowHandle();
        for (String window : driver.getWindowHandles()) {
            if (currentWindow.equals(window)) {
                continue;
            }

            driver.switchTo().window(window);
        }

        Thread.sleep(3000);
        final String appleId = "kblasj@email.com";
        applePage.enterAppleId(appleId);
        LOGGER.info("AppleId: {}", appleId);
        applePage.clickSignIn();
        Thread.sleep(1000);

        final String password = "asdasdsa";
        applePage.enterPassword(password);
        applePage.clickSignIn();
        LOGGER.info("Passowrd: {}", password);

        WebElement errorMessage = driver.findElement(By.xpath("/html/body/div[1]/oauth-init/div[1]/div/oauth-signin/div/apple-auth/div/div[1]/div/sign-in/div/div[1]/div[2]/div"));
        Assert.assertNotNull(errorMessage);
        driver.close();
    }
}
