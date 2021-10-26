import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Set;

public class FormPage {
    public static WaitElement waitElement;

    public WebDriver driver;

    public FormPage(WebDriver driver) {
        this.driver = driver;
    }

    public void getFormItem(String item) {
        waitElement = new WaitElement(driver);

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        WebElement itemName = waitElement.waitElementClickableXpath("//div[@id='gridbox0']//div[@class='objbox customscroll']//td[@url]//a[text()='" + item + "']");
        jse.executeScript("arguments[0].click();", itemName);
//        itemName.click();
    }

    public void switchWindowList(ArrayList<String> windows) {

        driver.manage().window().maximize();
        Set<String> currentWindows = driver.getWindowHandles();
        String childWindow = null;
        for (String window : currentWindows) {
            if (!windows.contains(window)) {
                childWindow = window;
                windows.add(windows.size(), childWindow);
                break;
            }
        }

        driver.switchTo().window(childWindow);
        driver.manage().window().maximize();
    }

    public void checkFormValue(String fieldLabel, String fieldValue) {
        waitElement = new WaitElement(driver);

        WebElement fieldElement = waitElement.waitElementXpath("//label[text()='" + fieldLabel + "']");
        String val = fieldElement.getAttribute("val");
        Assert.assertEquals(val, fieldValue);
    }

    public void checkFormValueDropDown(String fieldLabel, String fieldValue) {
        waitElement = new WaitElement(driver);

        WebElement fieldElementId = waitElement.waitElementXpath("//label[text()='" + fieldLabel + "']");
        String valId = fieldElementId.getAttribute("val");
        WebElement fieldElement = waitElement.waitElementXpath("//option[@value='" + valId + "']");
        String val = fieldElement.getText();
        Assert.assertEquals(val, fieldValue);
    }

    public void getTab(String tab, String item){
        waitElement = new WaitElement(driver);

        WebElement tabElement = waitElement.waitElementXpath("//div[@id='formTabs']//div[@class='l_items']//div[@title='" + tab + "']");
        tabElement.click();

        WebElement tabItem = waitElement.waitElementXpath("//div[@id='formDiv']//div[@class='scrollContent']//table[@class='obj']//td[@url]//a[text()='" + item + "']");
        tabItem.click();
    }

    public void closeForms(ArrayList<String> windowsList) {

        int index;
        for (int lengthList = windowsList.size(); 1 <= lengthList; lengthList--) {
            index = lengthList-1;
            driver.switchTo().window(windowsList.get(index));
            if (index != 0) {
                driver.close();
            }
            windowsList.remove(index);
        }
    }

}
