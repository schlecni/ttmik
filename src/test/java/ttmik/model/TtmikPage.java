package ttmik.model;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TtmikPage implements LoginPage {

    @FindBy(id = "user_login")
    private WebElement usernameField;
    @FindBy(id = "user_pass")
    private WebElement passwordField;
    @FindBy(id = "wp-submit")
    private WebElement submitButton;

    @Override
    public void fillInEmail(String email) {
        usernameField.sendKeys(email);
    }

    @Override
    public void fillInPassword(String password) {
        passwordField.sendKeys(password);
    }

    @Override
    public void login() {
        submitButton.click();
    }

    @Override
    public void clickPlatformIcon() {
        //TODO not necessary here
    }
}
