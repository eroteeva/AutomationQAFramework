package tests.homepagetests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageclasses.ArchivePage;
import pageclasses.FacebookPage;
import pageclasses.HomePage;
import pageclasses.MusalaPage;
import tests.*;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.List;

import static tests.Driver.*;


public class HomePageLinksTests extends AbstractLoginTests {

    @Test
    public void footerLinksTest() {
        Reporter.log("TEST: Verify that footer links work.", true);

        HomePage homePage = new HomePage();

        Reporter.log("Click on footer link", true);
        homePage.clickFooterLink();

        ArrayList<String> tabs = new ArrayList(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(1));

        String expectedUrl = "http://www.musala.com/";
        Assert.assertEquals(expectedUrl, getCurrentURL());

        MusalaPage musalaPage = new MusalaPage();
        Assert.assertTrue(musalaPage.getCompanyLogo().isDisplayed(), "Company logo is displayed.");

        Reporter.log("Go back to the Muffin tab", true);
        getDriver().switchTo().window(tabs.get(0));

        Reporter.log("Click on facebook link in the footer", true);
        homePage.getFacebookLink().click();

        tabs = new ArrayList(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(2));

        String expectedUrlFacebookLink = "https://www.facebook.com/MUFFINconference/";
        Assert.assertEquals(expectedUrlFacebookLink, getCurrentURL());

        FacebookPage facebookPage = new FacebookPage();
        Assert.assertTrue(facebookPage.getProfilePicture().isDisplayed(), "Profile picture is displayed.");

    }

    @Test
    public void archivesTest() {

        Reporter.log("TEST: Go to archives link and click on last event.", true);

        HomePage homePage = new HomePage();

        Reporter.log("Click on Archive link", true);
        homePage.clickArchiveLink();

        ArchivePage archivePage = new ArchivePage();

        Reporter.log("Scroll down till bottom of the page", true);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        List<WebElement> events = archivePage.getAllEvents();

        Reporter.log("Click on the last event in the list", true);
        if (!events.isEmpty()){
            archivePage.clickOnEvent(events.size() - 1);
        } else {
            throw new AssertionError("No events were found on the page");
        }

        //Print in the console the full event schedule in the following format:
        List<WebElement> lectureElements =
                getDriver().findElements(By.xpath("//div[@class='collapse-list']/preceding::li[@class='list-group-item header-timeslot']" +
                        "//span[(not(contains(@class,'timeslot'))) and (not(contains(@class,'icon')))] | //div[@class='speaker-info']"));

        for (WebElement element : lectureElements) {
            System.out.println(element.getText());
        }

    }

}
