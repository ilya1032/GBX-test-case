package pageobjects;

import enums.NavItems;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NavigationBar extends AbstractBase {

    @FindBy(xpath = "//div[@data-onboarding='navigationBar']//a")
    private List<WebElement> navItems;

    public NavigationBar(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickNavItem(NavItems item) {
        for (WebElement element: navItems) {
            if (element.getAttribute("href").contains(item.getItemHref())) {
                element.click();
                break;
            }
        }
    }
}
