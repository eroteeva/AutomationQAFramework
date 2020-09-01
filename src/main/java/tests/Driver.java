package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Driver {

    private static ThreadLocal<WebDriver> DRIVER = new ThreadLocal<WebDriver>();


    private Driver () throws IOException {
    }

    public static void startDriver(String browser) {

        WebDriver driver = null;

        if ("chrome".equals(browser)) {
            System.setProperty("webdriver.chrome.driver","D:\\Automation\\Selenium\\chromedriver\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if ("firefox".equals(browser)) {
            System.setProperty("webdriver.gecko.driver","D:\\Automation\\Selenium\\firefoxdriver\\geckodriver.exe");
            driver = new FirefoxDriver();
        } else {
            throw new RuntimeException("Unsupported browser");
        }

        DRIVER.set(driver);
    }

    public static WebDriver getDriver() {
        WebDriver driver = DRIVER.get();
        if (driver != null) {
            return driver;
        } else {
            throw new IllegalStateException("Driver not initialized yet");
        }
    }

    public static void stopDriver() {
        try {
            getDriver().quit();
        } finally {
            DRIVER.remove();
        }
    }

    public static void getURL(String url) {
        getDriver().get(url);
    }

    public static String getCurrentURL() {
        return getDriver().getCurrentUrl();
    }

    public static void maximizeWindow(){
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
}
