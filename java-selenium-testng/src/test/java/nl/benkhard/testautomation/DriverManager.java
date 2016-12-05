package nl.benkhard.testautomation;

import org.openqa.selenium.WebDriver;

/**
 * Will handle selecting a browser and handling it in a thread-safe
 * way.
 */
public class DriverManager {

    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

    /**
     * Stores a Selenium WebDriver for the current Thread.
     * @param driver The webdriver for the current Thread
     */
    public static void setDriver(WebDriver driver) {
        DriverManager.webDriver.set(driver);
    }

    /**
     * @return The Selenium WebDriver assigned to the current Thread
     */
    public static WebDriver getDriver() {
        return webDriver.get();
    }
}
