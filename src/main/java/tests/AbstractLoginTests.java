package tests;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class AbstractLoginTests {

    protected TestsConfig testsConfig;

    private String browser;
    private String baseUrl;

    public WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void initializeDriver() throws IOException {
        testsConfig = new TestsConfig();
        browser = testsConfig.getBrowser();
        baseUrl = testsConfig.getBaseUrl();

        startDriver();
    }

    @AfterClass
    public void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }

    protected void loadBaseURL(){
        driver.get(testsConfig.getBaseUrl());
    }

    private void startDriver() {
        if ("chrome".equals(browser)) {
            System.setProperty("webdriver.chrome.driver","D:\\Automation\\Selenium\\chromedriver\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if ("firefox".equals(browser)) {
            System.setProperty("webdriver.gecko.driver","D:\\Automation\\Selenium\\firefoxdriver\\geckodriver.exe");
            driver = new FirefoxDriver();
        } else {
            throw new RuntimeException("Unsupported browser");
        }
    }

}
