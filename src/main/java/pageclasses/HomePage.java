package pageclasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject {

    @FindBy(xpath = "//a[@class='btn btn-nav' and text()='Sign In']")
    private WebElement signInButton;

    @FindBy(xpath = "//div[@class='leftPartFooter']//a")
    private WebElement footerLink;

    @FindBy(xpath = "//div[@class='rightPartFooter']//a[@class='pull-right']")
    private WebElement facebookLink;

    @FindBy(xpath = "//a[@class='btn btn-nav' and text()='Archive']")
    private WebElement archiveLink;

    public HomePage() {
        super();
    }

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
        return archiveLink;
    }

    public void clickSignIn() {
        signInButton.click();
    }

    public void clickFooterLink() {
        footerLink.click();
    }

    public void clickFacebookLink(){
        facebookLink.click();
    }

    public void clickArchiveLink() {
        archiveLink.click();
    }
}
