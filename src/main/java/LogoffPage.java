import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LogoffPage {
    public static WaitElement waitElement;

    public WebDriver driver;
    public LogoffPage(WebDriver driver) {
        this.driver = driver;
    }

    public void logoff() {
        waitElement = new WaitElement(driver);
        JavascriptExecutor jse = (JavascriptExecutor)driver;

        WebElement topPanelUserNameLbl = waitElement.waitElementClickableId("topPanelUserNameLbl");
        jse.executeScript("arguments[0].click();", topPanelUserNameLbl);
//        topPanelUserNameLbl.click();

        WebElement itemLogoff = waitElement.waitElementClickableId("itemLogoff");
        jse.executeScript("arguments[0].click();", itemLogoff);
//        itemLogoff.click();
    }
}
