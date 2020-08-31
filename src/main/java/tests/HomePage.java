package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    @FindBy(xpath = "//a[@class='btn btn-nav' and text()='Sign In']\"")
    private WebElement signInButton;

    @FindBy(xpath = "//div[@class='leftPartFooter']//a")
    private WebElement footerLink;

    @FindBy(xpath = "//div[@class='rightPartFooter']//a[@class='pull-right']")
    private WebElement facebookLink;

    @FindBy(xpath = "//a[@class='btn btn-nav' and text()='Archive']")
    private WebElement archivesLink;

    public WebElement getSignInButton() {
        return signInButton;
    }

    public WebElement getFooterLink() {
        return footerLink;
    }

    public WebElement getFacebookLink() {
        return facebookLink;
    }

    public WebElement getArchivesLink() {
        return archivesLink;
    }
}
