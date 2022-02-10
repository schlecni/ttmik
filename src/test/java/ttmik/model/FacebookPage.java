package ttmik.model;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FacebookPage implements LoginPage {

    @FindBy(css = "#email")
    private WebElement emailField;
    @FindBy(css = "#pass")
    private WebElement passwordField;
    @FindBy(xpath = "//a[@href='#' or starts-with(@href, 'https://talktomeinkorean.com/sign-in/?loginSocial=facebook')]")
    private WebElement facebookIcon;
    @FindBy(xpath = "/html/body/div/div[2]/div[1]/form/div/div[3]/label[2]/input")
    private WebElement loginButton;
    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div/div/div/div[3]/button[2]")
    private WebElement acceptCookiesButton;

    @Override
    public void fillInEmail(String email) {
        emailField.sendKeys(email);
    }

    @Override
    public void fillInPassword(String password) {
        passwordField.sendKeys(password);
    }

    @Override
    public void login() {
        loginButton.click();
    }

    @Override
    public void clickPlatformIcon() {
        facebookIcon.click();
    }

    public void acceptCookies() {
        acceptCookiesButton.click();
    }
}
