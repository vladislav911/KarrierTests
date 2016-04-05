package SearchPortals;
import org.openqa.selenium.*;
import org.testng.Assert;
import static org.testng.Assert.*;

import static org.testng.Assert.fail;

import org.testng.annotations.Test;

import java.util.List;

public class ITestsMainSearch extends TestsBaseSearchPortals {

    @Test(priority = 1)
    public void searchFreeTextIncorrect() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.cssSelector("#nav-menu > a")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//div[4]/div/form/input")).clear();
        driver.findElement(By.xpath("//div[4]/div/form/input")).sendKeys("asdasdasdas");
        driver.findElement(By.xpath("//div[4]/div/form/button")).click();
        waitForTitle("Søk - asdasdasdas");
        assertEquals(driver.findElement(By.cssSelector("div.search-top-header")).getText(), "Ingen resultater for \"asdasdasdas\"");
    }

    @Test(priority = 2)
    public void searchFreeTexCorrect() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.cssSelector("#nav-menu > a")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//div[4]/div/form/input")).clear();
        driver.findElement(By.xpath("//div[4]/div/form/input")).sendKeys("Test");
        driver.findElement(By.xpath("//div[4]/div/form/button")).click();
        waitForTitle("Søk - Test");
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='main-story']/div[2]")).getText().contains("Ledige stillinger"));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='main-story']/div[2]")).getText().contains("Traineeprogrammer"));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='main-story']/div[2]")).getText().contains("Internships"));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='main-story']/div[2]")).getText().contains("Franchiser"));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='main-story']/div[2]")).getText().contains("Lærlingordninger"));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='main-story']/div[2]")).getText().contains("Arbeidsgivere"));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='main-story']/div[2]")).getText().contains("Kandidater"));
    }

    @Test(priority = 3)
    public void AssertAmountStillinger() throws Exception {
        driver.get(baseUrl + "/search/?term=Test");
        waitForElementPresent(By.xpath("//*[@id='main-story']/div[2]"));
        // Get Amount Stillinger from upper list
        String AmountStillinger = driver.findElement(By.xpath("//*[@id='main-story']/div[2]/div[1]/ul/li[1]/a")).getText();
        StringBuilder sb = new StringBuilder(AmountStillinger);
        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt( 0 );
        String AmountStillinger1 = sb.toString();
        // Get Amount Stillinger from lover list
        String AmountStillinger2 = driver.findElement(By.xpath("//*[@id='main-story']/div[3]/div[1]/div[1]/div[1]/a")).getText();
        // Go to Stillinger
        driver.findElement(By.xpath("//div[2]/div/ul/li/a")).click();
        waitForElementPresent(By.xpath("//*[@id='filter']/h3"));
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/jobb?SearchText=Test");
        // Get Amount Stillinger from page Stillinger
        String AmountStillinger3 = (driver.findElement(By.xpath("//*[@id='search-result-cnt']/div[1]/div/div[1]/span/span[2]")).getText()) + " " + "treff";
        Assert.assertEquals(AmountStillinger2, AmountStillinger1);
        Assert.assertEquals(AmountStillinger2, AmountStillinger3);
    }

    @Test(priority = 4)
    public void AssertAmountTrainee() throws Exception {
        driver.get(baseUrl + "/search/?term=Test");
        waitForElementPresent(By.xpath("//*[@id='main-story']/div[2]"));
        // Get Amount Trainee from upper list
        String AmountTrainee = driver.findElement(By.xpath("//*[@id='main-story']/div[2]/div[1]/ul/li[2]/a")).getText();
        StringBuilder sb = new StringBuilder(AmountTrainee);
        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt( 0 );
        String AmountTrainee1 = sb.toString();
        // Get Amount Trainee from lover list
        String AmountTrainee2 = driver.findElement(By.xpath("//*[@id='main-story']/div[3]/div[1]/div[2]/div[1]/a")).getText();
        // Go to Trainee
        driver.findElement(By.xpath("//div[2]/div/ul/li[2]/a")).click();
        waitForElementPresent(By.xpath("//*[@id='filter']/h3"));
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/traineeordninger?SearchText=Test");
        // Get Amount Trainee from page Trainee
        String AmountTrainee3 = (driver.findElement(By.xpath("//*[@id='search-result-cnt']/div[1]/div/div[1]/span/span[1]")).getText()) + " " + "treff";
        Assert.assertEquals(AmountTrainee2, AmountTrainee1);
        Assert.assertEquals(AmountTrainee2, AmountTrainee3);
    }

    @Test(priority = 5)
    public void AssertAmountInternships() throws Exception {
        driver.get(baseUrl + "/search/?term=Test");
        waitForElementPresent(By.xpath("//*[@id='main-story']/div[2]"));
        // Get Amount Internships from upper list
        String AmountInternships = driver.findElement(By.xpath("//*[@id='main-story']/div[2]/div[1]/ul/li[3]/a")).getText();
        StringBuilder sb = new StringBuilder(AmountInternships);
        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt( 0 );
        String AmountInternships1 = sb.toString();
        // Get Amount Internships from lover list
        String AmountInternships2 = driver.findElement(By.xpath("//*[@id='main-story']/div[3]/div[2]/div[2]/div[1]/a")).getText();
        // Go to Internships
        driver.findElement(By.xpath("//div[2]/div/ul/li[3]/a")).click();
        waitForElementPresent(By.xpath("//*[@id='filter']/h3"));
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/internships?SearchText=Test");
        // Get Amount Internships from page Internships
        String AmountInternships3 = (driver.findElement(By.xpath("//*[@id='search-result-cnt']/div[1]/div/div[1]/span/span[1]")).getText()) + " " + "treff";
        Assert.assertEquals(AmountInternships2, AmountInternships1);
        Assert.assertEquals(AmountInternships2, AmountInternships3);
    }

    @Test(priority = 6)
    public void AssertAmountFranchiser() throws Exception {
        driver.get(baseUrl + "/search/?term=Test");
        waitForElementPresent(By.xpath("//*[@id='main-story']/div[2]"));
        // Get Amount Franchiser from upper list
        String AmountFranchiser = driver.findElement(By.xpath("//*[@id='main-story']/div[2]/div[1]/ul/li[4]/a")).getText();
        StringBuilder sb = new StringBuilder(AmountFranchiser);
        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt( 0 );
        String AmountFranchiser1 = sb.toString();
        // Get Amount Franchiser from lover list
        String AmountFranchiser2 = driver.findElement(By.xpath("//*[@id='main-story']/div[3]/div[2]/div[3]/div[1]/a")).getText();
        // Go to Franchiser
        driver.findElement(By.xpath("//*[@id='main-story']/div[2]/div[1]/ul/li[4]/a")).click();
        waitForElementPresent(By.xpath("//*[@id='filter']/h3"));
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/franchiser?SearchText=Test");
        // Get Amount Franchiser from page Franchiser
        String AmountFranchiser3 = (driver.findElement(By.xpath("//*[@id='search-result-cnt']/div[1]/div/div[1]/span/span[1]")).getText()) + " " + "treff";
        Assert.assertEquals(AmountFranchiser2, AmountFranchiser1);
        Assert.assertEquals(AmountFranchiser2, AmountFranchiser3);
    }

    @Test(priority = 7)
    public void AssertAmountLærlingordninger() throws Exception {
        driver.get(baseUrl + "/search/?term=Test");
        waitForElementPresent(By.xpath("//*[@id='main-story']/div[2]"));
        // Get Amount Lærlingordninger from upper list
        String AmountLærlingordninger = driver.findElement(By.xpath("//*[@id='main-story']/div[2]/div[1]/ul/li[5]/a")).getText();
        StringBuilder sb = new StringBuilder(AmountLærlingordninger);
        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt( 0 );
        String AmountLærlingordninger1 = sb.toString();
        // Get Amount Lærlingordninger from lover list
        String AmountLærlingordninger2 = driver.findElement(By.xpath("//*[@id='main-story']/div[3]/div[1]/div[3]/div[1]/a")).getText();
        // Go to Lærlingordninger
        driver.findElement(By.xpath("//*[@id='main-story']/div[2]/div[1]/ul/li[5]/a")).click();
        waitForElementPresent(By.xpath("//*[@id='filter']/h3"));
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/larlinger?SearchText=Test");
        // Get Amount Lærlingordninger from page Lærlingordninger
        String AmountLærlingordninger3 = (driver.findElement(By.xpath("//*[@id='search-result-cnt']/div[1]/div/div[1]/span/span[1]")).getText()) + " " + "treff";
        Assert.assertEquals(AmountLærlingordninger2, AmountLærlingordninger1);
        Assert.assertEquals(AmountLærlingordninger2, AmountLærlingordninger3);
    }

    @Test(priority = 8)
    public void AssertAmountArbeidsgivere () throws Exception {
        driver.get(baseUrl + "/search/?term=Test");
        waitForElementPresent(By.xpath("//*[@id='main-story']/div[2]"));
        // Get Amount Arbeidsgivere  from upper list
        String AmountArbeidsgivere  = driver.findElement(By.xpath("//*[@id='main-story']/div[2]/div[2]/ul/li[1]/a")).getText();
        StringBuilder sb = new StringBuilder(AmountArbeidsgivere);
        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt( 0 );
        String AmountArbeidsgivere1 = sb.toString();
        // Get Amount Arbeidsgivere  from lover list
        String AmountArbeidsgivere2 = driver.findElement(By.xpath("//*[@id='main-story']/div[3]/div[2]/div[1]/div[1]/a")).getText();
        // Go to Arbeidsgivere
        driver.findElement(By.xpath("//*[@id='main-story']/div[2]/div[2]/ul/li[1]/a")).click();
        waitForElementPresent(By.xpath("//*[@id='filter']/h3"));
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/arbeidsgivere?SearchText=Test");
        // Get Amount Arbeidsgivere from page Arbeidsgivere
        String AmountArbeidsgivere3 = (driver.findElement(By.xpath("//*[@id='search-result-cnt']/div[1]/div/div[1]/span/span[1]")).getText()) + " " + "treff";
        Assert.assertEquals(AmountArbeidsgivere2, AmountArbeidsgivere1);
        Assert.assertEquals(AmountArbeidsgivere2, AmountArbeidsgivere3);
    }

    @Test(priority = 9)
    public void AssertAmountKandidater () throws Exception {
        driver.get(baseUrl + "/search/?term=Test");
        waitForElementPresent(By.xpath("//*[@id='main-story']/div[2]"));
        // Get Amount Kandidater  from upper list
        String AmountKandidater  = driver.findElement(By.xpath("//*[@id='main-story']/div[2]/div[2]/ul/li[2]/a")).getText();
        StringBuilder sb = new StringBuilder(AmountKandidater);
        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt( 0 );
        String AmountKandidater1 = sb.toString();
        // Get Amount Kandidater  from lover list
        String AmountKandidater2 = driver.findElement(By.xpath("//*[@id='main-story']/div[6]/div/a")).getText();
        // Go to Kandidater
        driver.findElement(By.xpath("//*[@id='main-story']/div[2]/div[2]/ul/li[2]/a")).click();
        waitForElementPresent(By.xpath("//*[@id='filter']/h3"));
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/kandidater?SearchText=Test");
        // Get Amount Kandidater from page Kandidater
        String AmountKandidater3 = (driver.findElement(By.xpath("//*[@id='search-result-cnt']/div[1]/div/div[1]/span/span[1]")).getText()) + " " + "treff";
        Assert.assertEquals(AmountKandidater2, AmountKandidater1);
        Assert.assertEquals(AmountKandidater2, AmountKandidater3);
    }
}