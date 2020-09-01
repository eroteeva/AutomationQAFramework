package pageclasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FacebookPage extends PageObject {

    @FindBy(xpath = "//div[@class='_6tay']//img[@class='_6tay']")
    private WebElement profilePicture;

    public FacebookPage() {
        super();
    }

    public WebElement getProfilePicture() {
        return profilePicture;
    }

}
