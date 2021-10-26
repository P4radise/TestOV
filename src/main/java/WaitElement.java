import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitElement {

    public final int SECONDS = 30;
    public WebDriver driver;
    public WaitElement(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitElementId(String id) {
        return new WebDriverWait(driver, Duration.ofSeconds(SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
    }

    public WebElement waitElementName(String name) {
        return new WebDriverWait(driver, Duration.ofSeconds(SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By.name(name)));
    }

    public WebElement waitElementXpath(String xpath) {
        return new WebDriverWait(driver, Duration.ofSeconds(SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

    public WebElement waitElementClickableId(String id) {
        return new WebDriverWait(driver, Duration.ofSeconds(SECONDS))
                .until(ExpectedConditions.elementToBeClickable(By.id(id)));
    }

    public WebElement waitElementClickableXpath(String xpath) {
        return new WebDriverWait(driver, Duration.ofSeconds(SECONDS))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }

    public Boolean waitElementInvisibilityXpath(String xpath) {
        return new WebDriverWait(driver, Duration.ofSeconds(SECONDS))
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
    }

    public Boolean waitElementInvisibilityId(String id) {
        return new WebDriverWait(driver, Duration.ofSeconds(SECONDS))
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(id)));
    }

}
