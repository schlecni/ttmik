package ttmik.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ApplePage {

    private final WebDriver driver;

    @FindBy(id = "account_name_text_field")
    private WebElement appleIdInput;
    @FindBy(id= "password_text_field")
    WebElement password;
    @FindBy(id = "sign-in")
    WebElement signInButton;
    @FindBy(xpath = "//a[@href='#' or starts-with(@href, 'https://talktomeinkorean.com/sign-in/?loginSocial=apple')]")
    private WebElement appleLoginButton;

    public ApplePage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterAppleId(String strInput) {
        appleIdInput.sendKeys(strInput);
    }

    public void enterPassword(String pass){
        password.sendKeys(pass);
    }

    public void clickSignIn(){
        signInButton.click();
    }

    public void clickAppleIcon(){
        appleLoginButton.click();
    }
}
