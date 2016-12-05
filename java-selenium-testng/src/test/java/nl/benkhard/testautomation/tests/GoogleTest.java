package nl.benkhard.testautomation.tests;

import nl.benkhard.testautomation.DriverManager;
import nl.benkhard.testautomation.model.GooglePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class GoogleTest {
    public static String appURL = "http://www.google.com";
    private WebDriver driver;

    /**
     * Sets the driver to be used by the test. The driver communicates
     * with the browser.
     */
    @BeforeClass
    public void setUp() {
        driver = DriverManager.getDriver();
    }


    /**
     * Will check the Google start page to have the correct title
     */
    @Test
    public void testGooglePageTitle() {
        driver.navigate().to(appURL);
        String strPageTitle = driver.getTitle();
        Assert.assertTrue(strPageTitle.equalsIgnoreCase("Google"), "Page title doesn't match");
    }

    /**
     * Will check that the page title containst the search query
     */
    @Test
    public void testGoogleSearchQueryDisplayedInTitle() throws InterruptedException {
        driver.navigate().to(appURL);
        String searchQuery = "Hondjes";
        GooglePage google = new GooglePage(driver);

        google.getSearchBar().sendKeys(searchQuery);
        google.getGoogleSearchButton().click();
        google.waitForResults();

        String strPageTitle = driver.getTitle();
        Assert.assertTrue(strPageTitle.equalsIgnoreCase(searchQuery+" - Google zoeken"), "Page title doesn't match");
    }

    /**
     * Will check that the first search result has the correct title
     */
    @Test
    public void testGoogleFirstResultHasCorrectTitle() {
        driver.navigate().to(appURL);
        String searchQuery = "Hondjes";
        GooglePage google = new GooglePage(driver);

        google.getSearchBar().sendKeys(searchQuery);
        google.getGoogleSearchButton().click();
        google.waitForResults();
        List<WebElement> results = google.getSearchResults();
        WebElement firstResult = results.get(0);
        String title = firstResult.findElement(By.className("r")).getText();

        assertEquals(title, "Home • www.hondjes.nl", "First result has wrong title");
    }

    /**
     * Closes the browser after the testclass is completed.
     */
    @AfterClass
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}