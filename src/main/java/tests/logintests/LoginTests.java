package tests.logintests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.AbstractLoginTests;
import tests.ExcelUtils;
import pageclasses.HomePage;
import pageclasses.LoginPage;

import java.io.File;
import java.io.IOException;

public class LoginTests extends AbstractLoginTests {

    String dataFilePath = "D:\\Automation\\Test_Musala\\AutomationQAFramework\\testdata\\Credentials.xlsx";

    @BeforeMethod
    private void loadHomePage(){
        loadBaseURL();
    }

    @DataProvider(name = "Authentication")
    public Object[][] credentials() throws IOException {

        File dataFile = new File(dataFilePath);
        return ExcelUtils.getCredentialsTestData(dataFile);
    }

    @Test(dataProvider = "Authentication", invocationCount = 5)
    public void loginWithInvalidCredentials(String sUsername, String sPassword) {

        HomePage homePage = new HomePage();

        homePage.clickSignIn();

        LoginPage loginPage = new LoginPage();
        loginPage.getUsernameField().sendKeys(sUsername);
        loginPage.getPasswordField().sendKeys(sPassword);

        loginPage.getSignInButton().click();

        Assert.assertTrue(loginPage.getWrongCredentialsMessageElement().isDisplayed(), "Wrong user or password message is displayed");

    }
}
