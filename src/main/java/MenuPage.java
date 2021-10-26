import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MenuPage {
    public static WaitElement waitElement;

    public WebDriver driver;
    public MenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public void getMenuItem(String item) {
        waitElement = new WaitElement(driver);

        WebElement mainLogoElement = waitElement.waitElementId("mainLogo");
        mainLogoElement.click();

        WebElement searchElement = waitElement.waitElementXpath("//div[@id='menu']//input[@class='in_input']");
        searchElement.sendKeys(item);

        WebElement linkElement = waitElement.waitElementXpath("//div[@class='component item_menu link hovered']//a");
        linkElement.click();
    }
}
