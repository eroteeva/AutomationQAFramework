package tests.homepagetests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.*;

import java.util.List;

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
        Assert.assertEquals(expectedUrl, driver.getCurrentUrl());

        MusalaPage musalaPage = new MusalaPage();
        Assert.assertTrue(musalaPage.getCompanyLogo().isDisplayed(), "Company logo is displayed.");

        //Go back to the Muffin tab
        loadHomePage();
        homePage.getFacebookLink().click();

        String expectedUrlFacebookLink = "https://www.facebook.com/MUFFINconference/";
        Assert.assertEquals(expectedUrlFacebookLink, driver.getCurrentUrl());

        FacebookPage facebookPage = new FacebookPage();
        Assert.assertTrue(facebookPage.getProfilePicture().isDisplayed(), "Company logo is displayed.");

    }

    @Test
    public void archivesTest() {
        HomePage homePage = new HomePage();
        homePage.getArchivesLink().click();

        List<WebElement> events = driver.findElements(By.xpath("//div[@class='event-magnifier']"));

        //scroll down and click the last event on the list
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        String xpath = String.format("(//div[@class='event-magnifier'])[%d]", events.size() - 1);
        driver.findElement(By.xpath(xpath)).click();

        //Print in the console the full event schedule in the following format:
        List<WebElement> lectureElements =
                driver.findElements(By.xpath("//div[@class='collapse-list']/preceding::li[@class='list-group-item header-timeslot']" +
                        "//span[(not(contains(@class,'timeslot'))) and (not(contains(@class,'icon')))] | //div[@class='speaker-info']"));

        for (WebElement element : lectureElements) {
            System.out.println(element.getText());
        }

    }

}
