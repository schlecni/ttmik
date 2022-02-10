package ttmik.model;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePage implements LoginPage {

    @FindBy(css = "#identifierId")
    private WebElement emailField;
    @FindBy(css = "#identifierNext > div > button > span")
    private WebElement loginButton;
    @FindBy(xpath = "//a[@href='#' or starts-with(@href, 'https://talktomeinkorean.com/sign-in/?loginSocial=google')]")
    private WebElement googleLoginButton;

    @Override
    public void fillInEmail(String email) {
        emailField.sendKeys(email);
    }

    @Override
    public void fillInPassword(String password) {
        //TODO to be implemented when needed
    }

    @Override
    public void login() {
        loginButton.click();
    }

    @Override
    public void clickPlatformIcon() {
        googleLoginButton.click();
    }
}
