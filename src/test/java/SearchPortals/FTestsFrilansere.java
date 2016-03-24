package SearchPortals;
import org.openqa.selenium.*;
import org.testng.Assert;
import static org.testng.Assert.*;

import static org.testng.Assert.fail;

import org.testng.annotations.Test;

public class FTestsFrilansere extends TestsBaseSearchPortals {

    @Test(priority = 1)
    public void searchFreeTextIncorrect() throws Exception {
        goToPageFrilansere();
        closeReklam();
        driver.findElement(By.id("searchtext")).sendKeys("adasdasdgfhfg");
        driver.findElement(By.className("search-top-submit")).click();
        waitForElementPresent(By.xpath("//*[@id='filter']/h3"));
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl/dt")).getText(), "Søketekst :");
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl/dd/span")).getText(), "adasdasdgfhfg");
        assertEquals(driver.findElement(By.xpath("//div[@id='f-search-results']/div/p[3]")).getText(), "No results - please change the search criteria sada sd asd as");
    }

    @Test(priority = 2)
    public void searchFreeTextCorrect() throws Exception {
        goToPageFrilansere();
        driver.findElement(By.id("searchtext")).sendKeys("manager");
        driver.findElement(By.className("search-top-submit")).click();
        waitForElementPresent(By.xpath("//*[@id='filter']/h3"));
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl/dt")).getText(), "Søketekst :");
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl/dd/span")).getText(), "manager");
        assertEquals(driver.getCurrentUrl(), baseUrl + "/frilansere?searchtext=manager");
    }
    @Test(priority = 3)
    public void searchAndAddItemsAllCategory() throws Exception {
        goToPageFrilansere();
        // Search Arbeidssted
        driver.findElement(By.id("searchtext")).sendKeys("Ukra");
        waitForElementPresent(By.xpath("//*[@id='ui-id-1']"));
        assertEquals(driver.findElement(By.xpath("//ul[@id='ui-id-1']/li")).getText(), "Treff i Steder");
        assertEquals(driver.findElement(By.xpath("//ul[@id='ui-id-1']/li[2]")).getText(), "Aukra");
        assertEquals(driver.findElement(By.xpath("//ul[@id='ui-id-1']/li[3]")).getText(), "Ukraina");
        Thread.sleep(1000);
        driver.findElement(By.id("searchtext")).sendKeys(Keys.DOWN);
        Thread.sleep(1000);
        driver.findElement(By.id("searchtext")).sendKeys(Keys.DOWN);
        Thread.sleep(1500);
        driver.findElement(By.id("searchtext")).sendKeys(Keys.ENTER);
        waitForElementPresent(By.xpath("//*[@id='filter']/h3"));
        Thread.sleep(1000);

        // Search Yrke
        driver.findElement(By.id("searchtext")).sendKeys("IT-");
        waitForElementPresent(By.xpath("//*[@id='ui-id-1']"));
        Thread.sleep(1000);
        driver.findElement(By.id("searchtext")).sendKeys(Keys.DOWN);
        driver.findElement(By.id("searchtext")).sendKeys(Keys.DOWN);
        Thread.sleep(1500);
        driver.findElement(By.id("searchtext")).sendKeys(Keys.ENTER);
        waitForTitle("Frilansere - IT-arkitekt - Ukraina");
        Thread.sleep(1000);
    }

    @Test(priority = 4)
    public void assertAddItemsToFiltrList() throws Exception {
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl/dt")).getText(), "Yrke :");
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl/dd/span")).getText(), "IT-arkitekt");
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl[2]/dt")).getText(), "Arbeidssted :");
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl[2]/dd/span")).getText(), "Ukraina");
    }

    @Test(priority = 5)
    public void assertCheckBoxesMark() throws Exception {
        WebElement checkBoxUkraina = driver.findElement(By.xpath("//*[@id=\"f-location-207\"]"));
        Assert.assertEquals("true",checkBoxUkraina.getAttribute("checked"));

        WebElement checkBoxIT = driver.findElement(By.xpath("//*[@id=\"f-IT-arkitekt-657\"]"));
        Assert.assertEquals("true",checkBoxIT.getAttribute("checked"));
    }

    @Test(priority = 6)
    public void deleteFilterList() throws Exception {
        driver.findElement(By.xpath("//*[@id='filter']/h3/span[2]/a/span")).click();
        waitForTitle("Frilansere");

        WebElement checkBoxUkraina = driver.findElement(By.xpath("//*[@id=\"f-location-207\"]"));
        Assert.assertEquals(null,checkBoxUkraina.getAttribute("checked"));

        WebElement checkBoxIT = driver.findElement(By.xpath("//*[@id=\"f-IT-arkitekt-657\"]"));
        Assert.assertEquals(null,checkBoxIT.getAttribute("checked"));
    }

    @Test(priority = 7)
    public void searchJobByFerdigheterText() throws Exception {
        goToPageFrilansere();
        // Add Freetext -  Test
        driver.findElement(By.id("skillLookup")).sendKeys("Water polo");
        driver.findElement(By.id("skillLookup")).sendKeys(Keys.ENTER);
        waitForTitle("Frilansere - Water polo");
        Thread.sleep(1000);
        assertEquals(driver.findElement(By.xpath("//div[@id='f-search-results']/div/div/div/a/span")).getText(), "Vlad Kovtun");
    }

    @Test(priority = 8)
    public void searchJobByFagområde() throws Exception {
        goToPageFrilansere();
        // Add Freetext -  Test
        driver.findElement(By.id("searchtext")).sendKeys("Test");
        driver.findElement(By.className("search-top-submit")).click();
        Thread.sleep(2000);
        String AmountKandidater1 = driver.findElement(By.xpath("//div[2]/div/div/div/div/span")).getText();
        // Add Fagområde -  Historie
        driver.findElement(By.xpath("//li[3]/label/i")).click();
        waitForTitle("Internships - Historie, religion, idéfag");
        String AmountKandidater2 = driver.findElement(By.xpath("//div[2]/div/div/div/div/span")).getText();
        Assert.assertNotEquals(AmountKandidater1, AmountKandidater2);
        assertEquals(driver.findElement(By.xpath("//div[@id='f-search-results']/div/div/div/div/div/div/a")).getText(), "Test tittle");
    }


}