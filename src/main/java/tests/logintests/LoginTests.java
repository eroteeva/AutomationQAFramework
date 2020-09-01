package tests.logintests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.AbstractLoginTests;
import tests.ExcelUtils;
import pageclasses.HomePage;
import pageclasses.LoginPage;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;

public class LoginTests extends AbstractLoginTests {

    String dataFilePath = "D:\\Automation\\Test_Musala\\AutomationQAFramework\\testdata\\Credentials.xlsx";

    @DataProvider(name = "Authentication")
    public Object[][] credentials() throws IOException {

        File dataFile = new File(dataFilePath);
        return ExcelUtils.getCredentialsTestData(dataFile);
    }

    @Test(dataProvider = "Authentication", invocationCount = 5)
    public void loginWithInvalidCredentials(String sUsername, String sPassword) {
        Reporter.log("TEST: Login with invalid username and password.", true);

        HomePage homePage = new HomePage();

        Reporter.log("Click on Sing In Button", true);
        homePage.clickSignIn();

        LoginPage loginPage = new LoginPage();

        Reporter.log("Enter username and password", true);
        loginPage.getUsernameField().sendKeys(sUsername);
        loginPage.getPasswordField().sendKeys(sPassword);

        Reporter.log("Click Sign In", true);
        loginPage.getSignInButton().click();

        Assert.assertTrue(loginPage.getWrongCredentialsMessageElement().isDisplayed(), "Wrong user or password message is displayed");

    }
}
