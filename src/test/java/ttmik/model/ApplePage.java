package ttmik.model;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ApplePage implements LoginPage {

    @FindBy(id = "account_name_text_field")
    private WebElement appleIdInput;
    @FindBy(id = "password_text_field")
    private WebElement pass;
    @FindBy(id = "sign-in")
    private WebElement signInButton;
    @FindBy(xpath = "//a[@href='#' or starts-with(@href, 'https://talktomeinkorean.com/sign-in/?loginSocial=apple')]")
    private WebElement appleLoginButton;

    @Override
    public void fillInEmail(String email) {
        appleIdInput.sendKeys(email);
    }

    @Override
    public void fillInPassword(String password) {
        pass.sendKeys(password);
    }

    @Override
    public void login() {
        signInButton.click();
    }

    @Override
    public void clickPlatformIcon() {
        appleLoginButton.click();
    }
}
