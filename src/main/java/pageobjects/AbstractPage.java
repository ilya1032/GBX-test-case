package pageobjects;

import enums.NavItems;
import org.openqa.selenium.WebDriver;

public class AbstractPage extends AbstractBase {

    private NavigationBar navigationBar;

    protected AbstractPage(WebDriver webDriver) {
        super(webDriver);
        navigationBar = new NavigationBar(webDriver);
    }

    public void selectMenu(NavItems item) {
        this.navigationBar.clickNavItem(item);
    }

    public NavigationBar getNavigationBar() {
        return navigationBar;
    }
}
