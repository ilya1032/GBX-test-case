package pageobjects;

import enums.ContextItems;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyDeskPage extends AbstractPage {

    @FindBy(xpath = "//div[@data-onboarding='mainArea']")
    private WebElement mainArea;

    @FindBy(xpath = "//div[@data-onboarding='newTabButton']")
    private WebElement newNoteButton;

    @FindBy(xpath = "//div[@data-test-id='button_create_in_my_library']")
    private WebElement createInLibraryButton;

    @FindBy(xpath = "//input[@data-test-id='input_textpad_name']")
    private WebElement noteNameField;

    private MyDeskContextMenu contextMenu;


    public MyDeskPage(WebDriver webDriver) {
        super(webDriver);
        contextMenu = new MyDeskContextMenu(driver);
    }

    public WebElement getMainArea() {
        return mainArea;
    }

    public WebElement getNoteNameField() {
        return noteNameField;
    }

    public WebElement getMenuItem(ContextItems item) {
        return contextMenu.getItem(item);
    }

    public WebElement getNewNoteButton() {
        return newNoteButton;
    }

    public WebElement getCreateInLibraryButton() {
        return createInLibraryButton;
    }
}
