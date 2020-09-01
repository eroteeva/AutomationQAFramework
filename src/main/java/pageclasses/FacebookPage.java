package pageclasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FacebookPage extends PageObject {

    @FindBy(xpath = "//*[local-name() = 'g' and @mask='url(#jsc_c_3k)']//*[local-name() = 'image']")
    private WebElement profilePicture;

    public FacebookPage() {
        super();
    }

    public WebElement getProfilePicture() {
        return profilePicture;
    }

}
