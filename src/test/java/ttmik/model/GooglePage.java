package ttmik.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePage {

    private final WebDriver driver;

    @FindBy(css = "#identifierId")
    WebElement emailField;
    @FindBy(css = "#identifierNext > div > button > span")
    WebElement loginButton;
    @FindBy(xpath = "//a[@href='#' or starts-with(@href, 'https://talktomeinkorean.com/sign-in/?loginSocial=google')]")
    private WebElement googleLoginButton;

    public GooglePage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void getEmaiField() {
        emailField.getText();
    }

    public void clickLoginButton() {
        loginButton.click();
    }
//
//    public String getErrorMessage() {
//        return errorMessage.getText();
//    }

    public void clickGoogleIcon(){
        googleLoginButton.click();
    }

}
