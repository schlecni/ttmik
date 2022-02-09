package ttmik.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TTMIKPage {

    private final WebDriver driver;

    @FindBy(id = "user_login")
    private WebElement usernameField;
    @FindBy(id = "user_pass")
    private WebElement passwordField;
    @FindBy(id = "wp-submit")
    private WebElement submitButton;
    @FindBy(id = "login_error")
    private WebElement loginError;
    @FindBy(xpath = "//a[@href='#' or starts-with(@href, 'https://talktomeinkorean.com/sign-in/?loginSocial=google')]")
    private WebElement googleLoginButton;

    public TTMIKPage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public void enterUsername(final String username) {
       usernameField.sendKeys(username);
    }

    public void enterPassword(final String password) {
        passwordField.sendKeys(password);
    }

    public void submitForm() {
        submitButton.click();
    }

    public String getLoginErrorMessage() {
        return loginError.getText();
    }

    public void clickGoogleButton(){
        googleLoginButton.click();
    }
}
