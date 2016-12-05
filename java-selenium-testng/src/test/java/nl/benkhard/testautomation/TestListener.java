package nl.benkhard.testautomation;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.log4testng.Logger;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Listens for test events and will intercept them.
 */
public class TestListener implements ITestListener {
    Logger log = Logger.getLogger(TestListener.class);

    public void onTestStart(ITestResult iTestResult) { }

    public void onTestSuccess(ITestResult iTestResult) { }

    public void onTestFailure(ITestResult iTestResult) { }

    public void onTestSkipped(ITestResult iTestResult) { }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) { }

    /**
     * Intercepts the event when a testclass is started.
     * Injects a WebDriver based on parameters of the current TestNG Test.
     * @param iTestContext The context of the test
     */
    public void onStart(ITestContext iTestContext) {
        log.info("Starting TestListener");
        String browser = iTestContext.getCurrentXmlTest().getParameter("browser");
        String hub = iTestContext.getCurrentXmlTest().getParameter("hub_url");

        try {
            WebDriver driver = WebDriverFactory.createInstance(new URL(hub), browser);
            DriverManager.setDriver(driver);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void onFinish(ITestContext iTestContext) { }
}
