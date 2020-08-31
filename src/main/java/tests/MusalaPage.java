package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MusalaPage {

    @FindBy(xpath = "//a[@class='brand']//span[@class='logo']")
    private WebElement companyLogo;

    public WebElement getCompanyLogo() {
        return companyLogo;
    }

}
