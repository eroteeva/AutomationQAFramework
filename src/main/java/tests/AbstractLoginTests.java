package tests;

import org.junit.AfterClass;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import static tests.Driver.*;

public class AbstractLoginTests {

    protected TestsConfig testsConfig;

    protected String browser;
    private String baseUrl;

    @BeforeClass(alwaysRun = true)
    protected void getConfigurations() throws IOException {
        testsConfig = new TestsConfig();
        browser = testsConfig.getBrowser();
        baseUrl = testsConfig.getBaseUrl();
    }

    @AfterClass
    protected void tearDown() {
        stopDriver();
    }

    @BeforeMethod
    protected void loadHomePage(){
        startDriver(browser);
        maximizeWindow();
        Reporter.log("Loading home page...", true);
        loadBaseURL();
    }

    @AfterMethod
    protected void closeBrowser(){
        stopDriver();
    }

    protected void loadBaseURL() {
        getURL(baseUrl);
    }




}
