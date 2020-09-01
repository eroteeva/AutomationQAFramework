package pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static tests.Driver.getDriver;

public class ArchivePage extends PageObject {

    public ArchivePage() {
        super();
    }

    public List<WebElement> getAllEvents() {
        return getDriver().findElements(By.xpath("//div[@class='event-magnifier']"));
    }

    public void clickOnEvent(int number) {
        String xpath = String.format("(//div[@class='event-magnifier'])[%d]", number);
        getDriver().findElement(By.xpath(xpath)).click();
    }
}
