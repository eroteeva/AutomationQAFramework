package tests.homepagetests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageclasses.ArchivePage;
import pageclasses.FacebookPage;
import pageclasses.HomePage;
import pageclasses.MusalaPage;
import tests.*;

import java.util.List;

import static tests.Driver.getCurrentURL;
import static tests.Driver.getDriver;

public class HomePageLinksTests extends AbstractLoginTests {

    @BeforeMethod
    private void loadHomePage() {
        loadBaseURL();
    }

    @Test
    public void footerLinksTest() {
        HomePage homePage = new HomePage();
        homePage.getFooterLink().click();

        String expectedUrl = "http://www.musala.com";
        Assert.assertEquals(expectedUrl, getCurrentURL());

        MusalaPage musalaPage = new MusalaPage();
        Assert.assertTrue(musalaPage.getCompanyLogo().isDisplayed(), "Company logo is displayed.");

        //Go back to the Muffin tab
        loadHomePage();
        homePage.getFacebookLink().click();

        String expectedUrlFacebookLink = "https://www.facebook.com/MUFFINconference/";
        Assert.assertEquals(expectedUrlFacebookLink, getCurrentURL());

        FacebookPage facebookPage = new FacebookPage();
        Assert.assertTrue(facebookPage.getProfilePicture().isDisplayed(), "Company logo is displayed.");

    }

    @Test
    public void archivesTest() {
        HomePage homePage = new HomePage();
        homePage.getArchivesLink().click();

        ArchivePage archivePage = new ArchivePage();

        List<WebElement> events = archivePage.getAllEvents();

        //scroll down and click the last event on the list
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        archivePage.clickOnEvent(events.size() - 1);

        //Print in the console the full event schedule in the following format:
        List<WebElement> lectureElements =
                getDriver().findElements(By.xpath("//div[@class='collapse-list']/preceding::li[@class='list-group-item header-timeslot']" +
                        "//span[(not(contains(@class,'timeslot'))) and (not(contains(@class,'icon')))] | //div[@class='speaker-info']"));

        for (WebElement element : lectureElements) {
            System.out.println(element.getText());
        }

    }

}
