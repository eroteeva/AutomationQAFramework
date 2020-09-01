package pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static tests.Driver.getDriver;

public class PageObject {

    WebDriver driver;

    protected PageObject() {
        this.driver = getDriver();
        PageFactory.initElements(driver, this);
    }

}
