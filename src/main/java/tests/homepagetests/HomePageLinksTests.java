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
import org.testng.Reporter;

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

        Reporter.log("Click on footer link", true);
        homePage.getFooterLink().click();

        String expectedUrl = "http://www.musala.com";
        Assert.assertEquals(expectedUrl, getCurrentURL());

        MusalaPage musalaPage = new MusalaPage();
        Assert.assertTrue(musalaPage.getCompanyLogo().isDisplayed(), "Company logo is displayed.");

        Reporter.log("Go back to the Muffin tab", true);
        loadHomePage();

        Reporter.log("Click on facebook link in the footer", true);
        homePage.getFacebookLink().click();

        String expectedUrlFacebookLink = "https://www.facebook.com/MUFFINconference/";
        Assert.assertEquals(expectedUrlFacebookLink, getCurrentURL());

        FacebookPage facebookPage = new FacebookPage();
        Assert.assertTrue(facebookPage.getProfilePicture().isDisplayed(), "Company logo is displayed.");

    }

    @Test
    public void archivesTest() {
        HomePage homePage = new HomePage();

        Reporter.log("Click on Archive link", true);
        homePage.getArchivesLink().click();

        ArchivePage archivePage = new ArchivePage();

        List<WebElement> events = archivePage.getAllEvents();

        Reporter.log("Scroll down till bottom of the page", true);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        Reporter.log("Click on the last event in the list", true);
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
