package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//div[@data-onboarding='mainNavigationBar']")
    private WebElement mainNavBar;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public WebElement getMainNavBar() {
        return mainNavBar;
    }
}
