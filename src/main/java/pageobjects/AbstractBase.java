package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AbstractBase {
    protected WebDriver driver;

    public AbstractBase(WebDriver webDriver) {
        this.driver = webDriver;
        PageFactory.initElements(driver, this);
    }

    public String getTitle() {
        return this.driver.getTitle();
    }
}
