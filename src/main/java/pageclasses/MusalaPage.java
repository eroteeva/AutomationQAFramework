package pageclasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MusalaPage extends PageObject {

    @FindBy(xpath = "//a[@class='brand']//span[@class='logo']")
    private WebElement companyLogo;

    public MusalaPage() {
        super();
    }

    public WebElement getCompanyLogo() {
        return companyLogo;
    }

}
