import enums.ContextItems;
import enums.NavItems;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyDeskPage;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class AcropliaUITests {

    private WebDriver driver;

    private LoginPage loginPage;

    private static String email;
    private static String password;

    private static Properties properties;

    @BeforeClass
    public static void setUp() throws IOException {
        ChromeDriverManager.chromedriver().setup();
        FileInputStream propertiesFile = new FileInputStream(
                System.getProperty("user.dir") + "/src/test/resources/test.properties");
        properties = new Properties();
        properties.load(propertiesFile);

        email = properties.getProperty("login.email");
        password = properties.getProperty("login.password");
    }

    @Before
    public void initDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get(properties.getProperty("login.url"));
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginTest() {
        String loginPageName = properties.getProperty("login.page_name");
        assertEquals(loginPageName, loginPage.getTitle());

        loginPage.login(email, password);
    }

    @Test
    public void createNoteTest() {
        loginPage.login(email, password);
        HomePage homePage = new HomePage(driver);

        new WebDriverWait(driver, 15).until(
                ExpectedConditions.visibilityOf(homePage.getMainNavBar()));
        assertEquals(homePage.getTitle(), properties.getProperty("home.page_name"));

        homePage.selectMenu(NavItems.MY_DESK);
        MyDeskPage deskPage = new MyDeskPage(driver);

        new WebDriverWait(driver, 15).until(
                ExpectedConditions.visibilityOf(deskPage.getMainArea())
        );
        assertEquals(deskPage.getTitle(), properties.getProperty("my_desk.page_name"));

        deskPage.getNewNoteButton().click();
        deskPage.getCreateInLibraryButton().click();
        deskPage.getMenuItem(ContextItems.NOTE).click();

        Assert.assertTrue(deskPage.getNoteNameField().isDisplayed());
    }

    @After
    public void closeDriver() {
        driver.close();
    }
}
