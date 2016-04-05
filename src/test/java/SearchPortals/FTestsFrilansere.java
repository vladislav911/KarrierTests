package SearchPortals;
import org.openqa.selenium.*;
import org.testng.Assert;
import static org.testng.Assert.*;

import static org.testng.Assert.fail;

import org.testng.annotations.Test;

import java.util.List;

public class FTestsFrilansere extends TestsBaseSearchPortals {

    @Test(priority = 1)
    public void searchFreeTextIncorrect() throws Exception {
        goToPageFrilansere();
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
        String AmountKandidater1 = driver.findElement(By.xpath("//*[@id='search-result-cnt']/div[1]/div/div[1]/span/span")).getText();
        // Add Ferdighetertext -  Water Polo
        driver.findElement(By.id("skillLookup")).sendKeys("Water polo");
        driver.findElement(By.id("skillLookup")).sendKeys(Keys.ENTER);
        waitForTitle("Frilansere - Water polo");
        String AmountKandidater2 = driver.findElement(By.xpath("//*[@id='search-result-cnt']/div[1]/div/div[1]/span/span")).getText();
        Assert.assertNotEquals(AmountKandidater1, AmountKandidater2);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='search-result-cnt']")).getText().contains("Vlad Kovtun"));
        Thread.sleep(500);
    }

    @Test(priority = 8)
    public void searchJobByYrke() throws Exception {
        goToPageFrilansere();
        String AmountKandidater1 = driver.findElement(By.xpath("//*[@id='search-result-cnt']/div[1]/div/div[1]/span/span")).getText();
        // Add Yrke -  Zoolog
        driver.findElement(By.xpath("//div[@id='main-story']/div/div/div[2]/div/div/div[3]/div[2]/div/div/span/input")).sendKeys("Zoolog");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@id='fv2']/ul/li[795]/label/i")).click();
        waitForTitle("Frilansere - Zoolog");
        String AmountKandidater2 = driver.findElement(By.xpath("//*[@id='search-result-cnt']/div[1]/div/div[1]/span/span")).getText();
        Assert.assertNotEquals(AmountKandidater1, AmountKandidater2);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='search-result-cnt']")).getText().contains("Vlad Kovtun"));
        Thread.sleep(500);
    }

    @Test(priority = 9)
    public void searchJobBySted() throws Exception {
        goToPageFrilansere();
        String AmountKandidater1 = driver.findElement(By.xpath("//*[@id='search-result-cnt']/div[1]/div/div[1]/span/span")).getText();
        // Add Sted -  Liberia
        driver.findElement(By.xpath("//div[@id='main-story']/div/div/div[2]/div/div/div[3]/div[3]/div/div/span/input")).sendKeys("Liberia");
        Thread.sleep(1000);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id='main-story']/div[1]/div/div[2]/div[1]/div[1]/div[3]/div[2]/h3")));
        driver.findElement(By.xpath("//div[@id='main-story']/div/div/div[2]/div/div/div[3]/div[3]/div/div[2]/ul/li[569]/label/i")).click();
        waitForTitle("Frilansere - Liberia");
        String AmountKandidater2 = driver.findElement(By.xpath("//*[@id='search-result-cnt']/div[1]/div/div[1]/span/span")).getText();
        Assert.assertNotEquals(AmountKandidater1, AmountKandidater2);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='search-result-cnt']")).getText().contains("Vlad Kovtun"));
        Thread.sleep(500);
    }

    @Test(priority = 10)
    public void searchJobBySkole() throws Exception {
        goToPageFrilansere();
        String AmountKandidater1 = driver.findElement(By.xpath("//*[@id='search-result-cnt']/div[1]/div/div[1]/span/span")).getText();
        // Add Skole - Norsk Høgskole for Helhetsterapi
        driver.findElement(By.xpath("//div[@id='main-story']/div/div/div[2]/div/div/div[3]/div[4]/div/div/span/input")).sendKeys("Norsk Høgskole for Helhetsterapi");
        Thread.sleep(1000);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id='main-story']/div[1]/div/div[2]/div[1]/div[1]/div[3]/div[3]/h3")));
        driver.findElement(By.xpath("//div[@id='fv3']/ul/li[29]/label/i")).click();
        waitForTitle("Frilansere - Norsk H&#248;gskole for Helhetsterapi");
        String AmountKandidater2 = driver.findElement(By.xpath("//*[@id='search-result-cnt']/div[1]/div/div[1]/span/span")).getText();
        Assert.assertNotEquals(AmountKandidater1, AmountKandidater2);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='search-result-cnt']")).getText().contains("Vlad Kovtun"));
        Thread.sleep(500);
    }
}