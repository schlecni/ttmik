package ttmik.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FacebookPage {

    private final WebDriver driver;

    @FindBy(css = "#email")
    private WebElement emailField;
    @FindBy(css = "#pass")
    private WebElement passwordField;
    @FindBy(xpath = "//a[@href='#' or starts-with(@href, 'https://talktomeinkorean.com/sign-in/?loginSocial=facebook')]")
    private WebElement facebookLoginButton;

    public FacebookPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void enterPassword(String pass) {
        passwordField.sendKeys(pass);
    }

    public void clickFacebookIcon(){
        facebookLoginButton.click();
    }
}
