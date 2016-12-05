package nl.benkhard.testautomation.model;

import com.google.common.base.Predicate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by tcbenkhard on 01/12/16.
 */
public class GooglePage {
    private WebDriver driver;

    public GooglePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getSearchBar() {
        return driver.findElement(By.id("lst-ib"));
    }

    public WebElement getGoogleSearchButton() {
        return driver.findElement(By.name("btnG"));
    }

    public void waitForResults() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(new Predicate<WebDriver>() {
            public boolean apply(WebDriver webDriver) {
                return webDriver.findElement(By.className("srg")).isDisplayed();
            }
        });
    }

    public List<WebElement> getSearchResults() {
        return driver.findElements(By.className("g"));
    }
}
