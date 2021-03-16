package pageobjects;

import enums.ContextItems;
import enums.NavItems;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MyDeskContextMenu extends AbstractBase {

    @FindBy(xpath = "//div[@data-test-id='dropdown_context_menu']//div")
    private List<WebElement> createButtons;

    public MyDeskContextMenu(WebDriver webDriver) {
        super(webDriver);
    }

    public WebElement getItem(ContextItems item) {
        WebElement elementToFind = null;
        for (WebElement element: createButtons) {
            if (element.getAttribute("data-test-id").contains(item.getItemId())) {
                elementToFind = element;
                break;
            }
        }
        return elementToFind;
    }
}
