import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;

public class TestOV {
    public static WebDriver driver;
    public static LoginPage loginPage;
    public static MenuPage menuPage;
    public static FormPage formPage;
    public static LogoffPage logoffPage;

    @Parameters({"path", "url"})
    @BeforeClass
    public static void setup(String path, String url) {
        System.setProperty("webdriver.chrome.driver", path);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    @Parameters({"login", "password"})
    @Test
    public void loginTest(String login, String password){
        loginPage = new LoginPage(driver);
        loginPage.login(login, password);
    }

    @Parameters({"menu_item"})
    @Test (dependsOnMethods = {"loginTest"})
    public void getMenuItemTest(String item){
        menuPage = new MenuPage(driver);
        menuPage.getMenuItem(item);
    }

    @Parameters({"form_item1"})
    @Test (dependsOnMethods = {"getMenuItemTest"})
    public void getSiteFormTest1(String item){
        formPage = new FormPage(driver);
        formPage.getFormItem(item);

        ArrayList<String> windowsList = new ArrayList<>();
        windowsList.add(driver.getWindowHandle());

        formPage.switchWindowList(windowsList);
        formPage.checkFormValue("S:Site ID", "AL13934");
        formPage.checkFormValue("S:City", "Haynesville");
        formPage.checkFormValue("S:Structure Height (meters)", "547.7256");
        formPage.getTab("C:Candidate", "a");
        formPage.switchWindowList(windowsList);
        formPage.checkFormValue("C:Cand ID", "a");
        formPage.checkFormValueDropDown("C:Cand Rank", "Primary");
        formPage.checkFormValue("C:ZIP", "66251");
        formPage.closeForms(windowsList);
    }

    @Parameters({"form_item2"})
    @Test (dependsOnMethods = {"getSiteFormTest1"})
    public void getSiteFormTest2(String item){
        formPage = new FormPage(driver);
        formPage.getFormItem(item);

        ArrayList<String> windowsList = new ArrayList<>();
        windowsList.add(driver.getWindowHandle());

        formPage.switchWindowList(windowsList);
        formPage.checkFormValue("S:Site ID", "AL13936");
        formPage.checkFormValue("S:City", "Montgomery.");
        formPage.checkFormValue("S:Structure Height (meters)", "45.72");
        formPage.getTab("C:Candidate", "b");
        formPage.switchWindowList(windowsList);
        formPage.checkFormValue("C:Cand ID", "b");
        formPage.checkFormValueDropDown("C:Cand Rank", "Backup 1");
        formPage.checkFormValue("C:ZIP", "31062");
        formPage.closeForms(windowsList);
    }

    @AfterClass
    public static void quit() {
        logoffPage = new LogoffPage(driver);
        logoffPage.logoff();
        driver.quit();
    }
}
