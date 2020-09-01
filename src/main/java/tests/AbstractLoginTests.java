package tests;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import static tests.Driver.*;

public class AbstractLoginTests {

    protected TestsConfig testsConfig;

    WebDriver driver;

    private String browser;
    private String baseUrl;

    @BeforeClass(alwaysRun = true)
    public void initializeDriver() throws IOException {
        testsConfig = new TestsConfig();
        browser = testsConfig.getBrowser();
        baseUrl = testsConfig.getBaseUrl();

        startDriver(browser);
    }

    @AfterClass
    public void tearDown(){
        stopDriver();
    }

    protected void loadBaseURL(){
        getURL(baseUrl);
    }

}
