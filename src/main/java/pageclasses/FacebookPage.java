package pageclasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FacebookPage extends PageObject {

    @FindBy(xpath = "//a[@aria-label='Profile picture']")
    private WebElement profilePicture;

    public FacebookPage() {
        super();
    }

    public WebElement getProfilePicture() {
        return profilePicture;
    }

}
