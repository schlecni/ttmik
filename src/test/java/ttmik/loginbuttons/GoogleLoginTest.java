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
import ttmik.model.GooglePage;

public class GoogleLoginTest {

    private static final Logger LOGGER = LogManager.getLogger(GoogleLoginTest.class);

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
//        System.setProperty("webdriver.edge.driver", "D:\\learning\\ChromeDriver_win64\\msChromeDriver.exe");
    }

    @Test
    public void testGoogleButton() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://talktomeinkorean.com/wp-login.php");

        GooglePage googlePage = PageFactory.initElements(driver, GooglePage.class);
        googlePage.clickGoogleIcon();

        String parentWindow = driver.getWindowHandle();
        for (String window : driver.getWindowHandles()) {
            if (parentWindow.equals(window)) {
                continue;
            }

            driver.switchTo().window(window);
        }

        Thread.sleep(3000);
        final String email = "kblasj@email.com";
        googlePage.enterEmail(email);
        LOGGER.info("Email: {}", email);
        googlePage.clickLoginButton();

        WebElement invalidEmailField = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div"));
        Thread.sleep(1000);
        Assert.assertTrue(invalidEmailField.getText().contains("Google nu a fost"));

        LOGGER.info("The received error message was: '{}.'", invalidEmailField.getText());
        driver.close();
    }
}