import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTests {

    @Test
    public void test1() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://talktomeinkorean.com/wp-login.php");

        WebElement userLogin = driver.findElement(By.id("user_login"));
        userLogin.sendKeys("blabla");

        WebElement userPassword = driver.findElement(By.id("user_pass"));
        userPassword.sendKeys("vqnerakbh");

        driver.findElement(By.id("wp-submit")).click();
        driver.findElement(By.xpath("/html/body/div[1]/form/div[2]/div/div/a[1]/div/div/svg")).click();

        Assert.assertTrue(driver.findElement(By.id("login_error")).getText().contains("Error"));

        System.out.println("The received error message was: '" + driver.findElement(By.id("login_error")).getText() + "'.");
    }

    @Test
    public void testGoogleButton() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://talktomeinkorean.com/wp-login.php");
        driver.findElement(By.xpath("//a[@href='#' or starts-with(@href, 'https://talktomeinkorean.com/sign-in/?loginSocial=google')]")).click();

//        Assert.assertTrue(driver.findElement(By.id("login_error")).getText().contains("Error"));

//        System.out.println("The received error message was: '" + driver.findElement(By.id("login_error")).getText() + "'.");
    }

}
