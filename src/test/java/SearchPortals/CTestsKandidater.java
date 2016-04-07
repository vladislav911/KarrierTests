package SearchPortals;
import org.openqa.selenium.*;
import org.testng.Assert;
import static org.testng.Assert.*;

import static org.testng.Assert.fail;

import org.testng.annotations.Test;

public class CTestsKandidater extends TestsBaseSearchPortals {

    @Test(priority = 1)
    public void searchFreeTextIncorrect() throws Exception {
        goToPageKandidater();
        driver.findElement(By.id("searchtext")).sendKeys("adasdasdgfhfg");
        driver.findElement(By.className("search-top-submit")).click();
        waitForElementPresent(By.xpath("//*[@id='filter']/h3"));
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl/dt")).getText(), "Søketekst :");
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl/dd/span")).getText(), "adasdasdgfhfg");
        assertEquals(driver.findElement(By.xpath("//div[@id='f-search-results']/div/p[3]")).getText(), "No results - please change the search criteria sada sd asd as");
    }

    @Test(priority = 2)
    public void searchFreeTextCorrect() throws Exception {
        goToPageKandidater();
        driver.findElement(By.id("searchtext")).sendKeys("manager");
        driver.findElement(By.className("search-top-submit")).click();
        waitForElementPresent(By.xpath("//*[@id='filter']/h3"));
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl/dt")).getText(), "Søketekst :");
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl/dd/span")).getText(), "manager");
        assertEquals(driver.getCurrentUrl(), baseUrl + "/kandidater?searchtext=manager");
    }

    @Test(priority = 3)
    public void searchAndAddItemsAllCategory() throws Exception {
        goToPageKandidater();
        Thread.sleep(1000);
        // Search Arbeidssted
        driver.findElement(By.id("searchtext")).sendKeys("Ukra");
        waitForElementPresent(By.xpath("//ul[@id='ui-id-1']/li"));
        assertEquals(driver.findElement(By.xpath("//ul[@id='ui-id-1']/li")).getText(), "Treff i Steder");
        assertEquals(driver.findElement(By.xpath("//ul[@id='ui-id-1']/li[2]")).getText(), "Aukra");
        assertEquals(driver.findElement(By.xpath("//ul[@id='ui-id-1']/li[3]")).getText(), "Ukraina");
        driver.findElement(By.id("searchtext")).sendKeys(Keys.DOWN);
        Thread.sleep(500);
        driver.findElement(By.id("searchtext")).sendKeys(Keys.DOWN);
        Thread.sleep(500);
        driver.findElement(By.id("searchtext")).sendKeys(Keys.ENTER);
        waitForElementPresent(By.xpath("//*[@id='filter']/h3"));
        waitForTitle("Kandidater - Ukraina - 1");
        refreshPage();

        // Search Yrke
        driver.findElement(By.id("searchtext")).sendKeys("IT-");
        waitForElementPresent(By.xpath("//ul[@id='ui-id-1']/li"));
        driver.findElement(By.id("searchtext")).sendKeys(Keys.DOWN);
        Thread.sleep(500);
        driver.findElement(By.id("searchtext")).sendKeys(Keys.DOWN);
        Thread.sleep(500);
        driver.findElement(By.id("searchtext")).sendKeys(Keys.ENTER);
        waitForTitle("Kandidater - IT-arkitekt - Ukraina - 1");
        refreshPage();

        // Search Fagomrade
        driver.findElement(By.id("searchtext")).sendKeys("Undervisning");
        waitForElementPresent(By.xpath("//ul[@id='ui-id-1']/li"));
        driver.findElement(By.id("searchtext")).sendKeys(Keys.DOWN);
        Thread.sleep(500);
        driver.findElement(By.id("searchtext")).sendKeys(Keys.DOWN);
        Thread.sleep(500);
        driver.findElement(By.id("searchtext")).sendKeys(Keys.ENTER);
        waitForTitle("Kandidater - Undervisning, lærer- og lektorfag - IT-arkitekt - Ukraina - 1");
        refreshPage();

        // Search Bransje
        driver.findElement(By.id("searchtext")).sendKeys("Bygg / Anlegg");
        waitForElementPresent(By.xpath("//ul[@id='ui-id-1']/li"));
        driver.findElement(By.id("searchtext")).sendKeys(Keys.DOWN);
        Thread.sleep(500);
        driver.findElement(By.id("searchtext")).sendKeys(Keys.ENTER);
        waitForTitle("Kandidater - Undervisning, lærer- og lektorfag - IT-arkitekt - Bygg / Anlegg / Entreprenør - Ukraina - 1");
        refreshPage();
    }

    @Test(priority = 4)
    public void assertAddItemsToFiltrList() throws Exception {
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl/dt")).getText(), "Fagområde :");
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl/dd/span")).getText(), "Undervisning, lærer- og lektorfag");
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl[2]/dt")).getText(), "Yrke :");
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl[2]/dd/span")).getText(), "IT-arkitekt");
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl[3]/dt")).getText(), "Bransje :");
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl[3]/dd/span")).getText(), "Bygg / Anlegg / Entreprenør");
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl[4]/dt")).getText(), "Arbeidssted :");
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl[4]/dd/span")).getText(), "Ukraina");
    }

    @Test(priority = 5)
    public void assertCheckBoxesMark() throws Exception {
        WebElement checkBoxUkraina = driver.findElement(By.xpath("//*[@id=\"f-location-207\"]"));
        Assert.assertEquals("true",checkBoxUkraina.getAttribute("checked"));

        WebElement checkBoxUndervisning = driver.findElement(By.xpath("//*[@id=\"f-Undervisning, lærer- og lektorfag-14\"]"));
        Assert.assertEquals("true",checkBoxUndervisning.getAttribute("checked"));

        WebElement checkBoxBygg = driver.findElement(By.xpath("//*[@id=\"f-Bygg / Anlegg / Entreprenør-31\"]"));
        Assert.assertEquals("true",checkBoxBygg.getAttribute("checked"));

        WebElement checkBoxIT = driver.findElement(By.xpath("//*[@id=\"f-IT-arkitekt-657\"]"));
        Assert.assertEquals("true",checkBoxIT.getAttribute("checked"));
    }

    @Test(priority = 6)
    public void deleteFilterList() throws Exception {
        driver.findElement(By.xpath("//*[@id='filter']/h3/span[2]/a/span")).click();
        waitForTitle("Kandidater");

        WebElement checkBoxUkraina = driver.findElement(By.xpath("//*[@id=\"f-location-207\"]"));
        Assert.assertEquals(null,checkBoxUkraina.getAttribute("checked"));

        WebElement checkBoxUndervisning = driver.findElement(By.xpath("//*[@id=\"f-Undervisning, lærer- og lektorfag-14\"]"));
        Assert.assertEquals(null,checkBoxUndervisning.getAttribute("checked"));

        WebElement checkBoxBygg = driver.findElement(By.xpath("//*[@id=\"f-Bygg / Anlegg / Entreprenør-31\"]"));
        Assert.assertEquals(null,checkBoxBygg.getAttribute("checked"));

        WebElement checkBoxIT = driver.findElement(By.xpath("//*[@id=\"f-IT-arkitekt-657\"]"));
        Assert.assertEquals(null,checkBoxIT.getAttribute("checked"));
    }

    @Test(priority = 7)
    public void searchJobByOmfang() throws Exception {
        goToPageKandidater();
        driver.findElement(By.id("searchtext")).sendKeys("Vlad");
        driver.findElement(By.className("search-top-submit")).click();
        Thread.sleep(1000);
        waitForElementPresent(By.xpath("//*[@id='filter']/h3"));
        String AmountKandidater1 = driver.findElement(By.xpath("//*[@id='search-result-cnt']/div[1]/div/div[1]/span/span")).getText();
        // Add Omfang - Deltid
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id='filter']/div")));
        driver.findElement(By.xpath("//div[@id='main-story']/div/div/div[2]/div/div/div[3]/div/div/div/ul/li[2]/label/i")).click();
        waitForTitle("Kandidater - Deltid");
        String AmountKandidater2 = driver.findElement(By.xpath("//*[@id='search-result-cnt']/div[1]/div/div[1]/span/span")).getText();
        Assert.assertNotEquals(AmountKandidater1, AmountKandidater2);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='search-result-cnt']")).getText().contains("Kandidat 105301"));
        Thread.sleep(1000);
    }

    @Test(priority = 8)
    public void searchJobBySted() throws Exception {
        goToPageKandidater();
        driver.findElement(By.id("searchtext")).sendKeys("Vlad");
        driver.findElement(By.className("search-top-submit")).click();
        Thread.sleep(2000);
        String AmountKandidater1 = driver.findElement(By.xpath("//*[@id='search-result-cnt']/div[1]/div/div[1]/span/span")).getText();
        // Add Arbeidssted -  Vietnam
        driver.findElement(By.xpath("//div[2]/div/div/span/input")).sendKeys("Vietnam");
        waitForElementPresent(By.xpath("//li[686]/label/i"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id='searchtext']")));
        driver.findElement(By.xpath("//li[686]/label/i")).click();
        waitForTitle("Kandidater - Vietnam");
        String AmountKandidater2 = driver.findElement(By.xpath("//*[@id='search-result-cnt']/div[1]/div/div[1]/span/span")).getText();
        Assert.assertNotEquals(AmountKandidater1, AmountKandidater2);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='search-result-cnt']")).getText().contains("Kandidat 105301"));
        Thread.sleep(1000);
    }

    @Test(priority = 9)
    public void searchJobByYrke() throws Exception {
        goToPageKandidater();
        driver.findElement(By.id("searchtext")).sendKeys("Vlad");
        driver.findElement(By.className("search-top-submit")).click();
        Thread.sleep(2000);
        String AmountKandidater1 = driver.findElement(By.xpath("//*[@id='search-result-cnt']/div[1]/div/div[1]/span/span")).getText();
        // Add Yrke -  Meteorolog
        driver.findElement(By.xpath("//div[3]/div/div/span/input")).sendKeys("Meteorolog");
       waitForElementPresent(By.xpath("//div[3]/div/div[2]/ul/li[479]/label/i"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id='main-story']/div[1]/div/div[2]/div[1]/div[1]/div[3]/div/div[1]/h3")));
        driver.findElement(By.xpath("//div[3]/div/div[2]/ul/li[479]/label/i")).click();
        waitForTitle("Kandidater - Meteorolog");
        String AmountKandidater2 = driver.findElement(By.xpath("//*[@id='search-result-cnt']/div[1]/div/div[1]/span/span")).getText();
        Assert.assertNotEquals(AmountKandidater1, AmountKandidater2);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='search-result-cnt']")).getText().contains("Kandidat 105301"));
        Thread.sleep(1000);
    }

    @Test(priority = 10)
    public void searchJobByType() throws Exception {
        goToPageKandidater();
        driver.findElement(By.id("searchtext")).sendKeys("Vlad");
        driver.findElement(By.className("search-top-submit")).click();
        Thread.sleep(2000);
        String AmountKandidater1 = driver.findElement(By.xpath("//*[@id='search-result-cnt']/div[1]/div/div[1]/span/span")).getText();
        // Add Type -  Ekstrahjelp
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id='main-story']/div[1]/div/div[2]/div[1]/div[1]/div[3]/div/div[3]/h3")));
        driver.findElement(By.xpath("//div[4]/div/div/ul/li[3]/label/i")).click();
        waitForTitle("Kandidater - Ekstrahjelp");
        String AmountKandidater2 = driver.findElement(By.xpath("//*[@id='search-result-cnt']/div[1]/div/div[1]/span/span")).getText();
        Assert.assertNotEquals(AmountKandidater1, AmountKandidater2);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='search-result-cnt']")).getText().contains("Kandidat 105301"));
        Thread.sleep(1000);
    }

    @Test(priority = 11)
    public void searchJobByFagområde() throws Exception {
        goToPageKandidater();
        driver.findElement(By.id("searchtext")).sendKeys("Vlad");
        driver.findElement(By.className("search-top-submit")).click();
        Thread.sleep(2000);
        String AmountKandidater1 = driver.findElement(By.xpath("//*[@id='search-result-cnt']/div[1]/div/div[1]/span/span")).getText();
        // Add Fagområde -  Jus
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id='main-story']/div[1]/div/div[2]/div[1]/div[1]/div[3]/div/div[4]/h3")));
        driver.findElement(By.xpath("//div[5]/div/ul/li[7]/label/i")).click();
        waitForTitle("Kandidater - Jus");
        String AmountKandidater2 = driver.findElement(By.xpath("//*[@id='search-result-cnt']/div[1]/div/div[1]/span/span")).getText();
        Assert.assertNotEquals(AmountKandidater1, AmountKandidater2);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='search-result-cnt']")).getText().contains("Kandidat 105301"));
        Thread.sleep(1000);
    }

    @Test(priority = 12)
    public void searchJobByBransje() throws Exception {
        goToPageKandidater();
        driver.findElement(By.id("searchtext")).sendKeys("Vlad");
        driver.findElement(By.className("search-top-submit")).click();
        Thread.sleep(2000);
        String AmountKandidater1 = driver.findElement(By.xpath("//*[@id='search-result-cnt']/div[1]/div/div[1]/span/span")).getText();
        // Add Bransje  -  Investmen
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id='main-story']/div[1]/div/div[2]/div[1]/div[1]/div[3]/div/div[5]/h3")));
        driver.findElement(By.xpath("//div[6]/div/div/ul/li[6]/label/i")).click();
        waitForTitle("Kandidater - Investment banking");
        String AmountKandidater2 = driver.findElement(By.xpath("//*[@id='search-result-cnt']/div[1]/div/div[1]/span/span")).getText();
        Assert.assertNotEquals(AmountKandidater1, AmountKandidater2);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='search-result-cnt']")).getText().contains("Kandidat 105301"));
        Thread.sleep(1000);
    }

}
