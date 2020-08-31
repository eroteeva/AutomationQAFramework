package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(xpath = "//input[@name='username']")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@id='btn-sign-in']")
    private WebElement signInButton;

    @FindBy(xpath = "//p[@class='state-muffin-message' and text()='Wrong user or password.']")
    private WebElement wrongCredentialsMessage;

    public WebElement getUsernameField(){
        return usernameField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getSignInButton() {
        return signInButton;
    }

    public WebElement getWrongCredentialsMessageElement() {
        return wrongCredentialsMessage;
    }



}
