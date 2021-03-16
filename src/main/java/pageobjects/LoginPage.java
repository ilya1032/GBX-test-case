package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends AbstractBase {

    @FindBy(name="email")
    private WebElement emailField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(xpath="//div[@data-test-id='signin_next']")
    private WebElement signNextButton;

    @FindBy(xpath="//div[@data-test-id='signin_btn']")
    private WebElement signInButton;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void login(String email, String password) {
        emailField.sendKeys(email);
        signNextButton.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.sendKeys(password);
        signInButton.click();
    }

}
