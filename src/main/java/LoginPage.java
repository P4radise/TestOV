import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    public static WaitElement waitElement;

    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String userName, String password) {
        waitElement = new WaitElement(driver);

        WebElement usernameElement = waitElement.waitElementName("username");
        usernameElement.sendKeys(userName);

        WebElement passwordElement = waitElement.waitElementId("password");
        passwordElement.sendKeys(password);

        WebElement buttonElement = waitElement.waitElementName("btn");
        buttonElement.click();
    }
}
