import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTests {

    @Test
    public void test1() {
        // Initialize the driver for chrome, this one communicates with the browser and its pages
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // navigate to the talk to me in korea page
        driver.get("https://talktomeinkorean.com/wp-login.php");

        // search for the user element in login form
        WebElement userLogin = driver.findElement(By.id("user_login"));
        userLogin.sendKeys("blabla");

        // search for the password element in login form
        WebElement userPassword = driver.findElement(By.id("user_pass"));
        userPassword.sendKeys("vqnerakbh");

        // submit the login form
        driver.findElement(By.id("wp-submit")).click();

        // driver.findElement(By.xpath("/html/body/div[1]/form/div[2]/div/div/a[1]/div/div/svg")).click();

        // verify that the error message displayed contains Error
        Assert.assertTrue(driver.findElement(By.id("login_error")).getText().contains("Error"));

        // print in the console the received error message from the chrome drive (the message in the ttmik page)
        System.out.println("The received error message was: '" + driver.findElement(By.id("login_error")).getText() + "'.");
    }

}
