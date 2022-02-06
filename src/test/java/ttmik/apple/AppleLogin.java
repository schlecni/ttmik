package ttmik.apple;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppleLogin {

    @Test
    public void testAppleButton() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://talktomeinkorean.com/wp-login.php");
        driver.findElement(By.xpath("//a[@href='#' or starts-with(@href, 'https://talktomeinkorean.com/sign-in/?loginSocial=apple')]")).click();

        Assert.assertTrue(driver.findElement(By.id("login_error")).getText().contains("Error"));

        System.out.println("The received error message was: '" + driver.findElement(By.id("login_error")).getText() + "'.");
    }
}
