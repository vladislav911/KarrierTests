package SearchPortals;
import org.openqa.selenium.*;
import org.testng.Assert;
import static org.testng.Assert.*;

import static org.testng.Assert.fail;

import org.testng.annotations.Test;

import java.util.List;

public class HFranchiser extends TestsBaseSearchPortals {

    @Test(priority = 1)
    public void searchFreeTextIncorrect() throws Exception {
        goToPageFranchiser();
        driver.findElement(By.id("searchtext")).sendKeys("adasdasdgfhfg");
        driver.findElement(By.className("search-top-submit")).click();
        waitForElementPresent(By.xpath("//*[@id='filter']/h3"));
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl/dt")).getText(), "Søketekst :");
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl/dd/span")).getText(), "adasdasdgfhfg");
        assertEquals(driver.findElement(By.xpath("//div[@id='f-search-results']/div/p[3]")).getText(), "No results - please change the search criteria sada sd asd as");
    }

    @Test(priority = 2)
    public void searchFreeTextCorrect() throws Exception {
        goToPageFranchiser();
        driver.findElement(By.id("searchtext")).sendKeys("manager");
        driver.findElement(By.className("search-top-submit")).click();
        waitForElementPresent(By.xpath("//*[@id='filter']/h3"));
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl/dt")).getText(), "Søketekst :");
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl/dd/span")).getText(), "manager");
        assertEquals(driver.getCurrentUrl(), baseUrl + "/franchiser?searchtext=manager");
    }

    @Test(priority = 3)
    public void searchAndAddItemsAllCategory() throws Exception {
        goToPageFranchiser();
        // Search Arbeidssted
        driver.findElement(By.id("searchtext")).sendKeys("Ukra");
        waitForElementPresent(By.xpath("//*[@id='ui-id-1']"));
        assertEquals(driver.findElement(By.xpath("//ul[@id='ui-id-1']/li")).getText(), "Treff i Steder");
        assertEquals(driver.findElement(By.xpath("//ul[@id='ui-id-1']/li[2]")).getText(), "Aukra");
        assertEquals(driver.findElement(By.xpath("//ul[@id='ui-id-1']/li[3]")).getText(), "Ukraina");
        driver.findElement(By.id("searchtext")).sendKeys(Keys.DOWN);
        Thread.sleep(500);
        driver.findElement(By.id("searchtext")).sendKeys(Keys.DOWN);
        Thread.sleep(500);
        driver.findElement(By.id("searchtext")).sendKeys(Keys.ENTER);
        waitForElementPresent(By.xpath("//*[@id='filter']/h3"));
        refreshPage();

        // Search Bransje
        driver.findElement(By.id("searchtext")).sendKeys("Bygg / Anlegg");
        waitForElementPresent(By.xpath("//*[@id='ui-id-1']"));
        Thread.sleep(2000);
        driver.findElement(By.id("searchtext")).sendKeys(Keys.DOWN);
        Thread.sleep(500);
        driver.findElement(By.id("searchtext")).sendKeys(Keys.ENTER);
        waitForTitle("Franchise - Bygg / Anlegg / Entreprenør - Ukraina");
        refreshPage();

        // Search Firmanavn
        driver.findElement(By.id("searchtext")).sendKeys("Hewlett");
        waitForElementPresent(By.xpath("//*[@id='ui-id-1']"));
        Thread.sleep(2000);
        driver.findElement(By.id("searchtext")).sendKeys(Keys.DOWN);
        Thread.sleep(500);
        driver.findElement(By.id("searchtext")).sendKeys(Keys.ENTER);
        waitForTitle("Franchise - Bygg / Anlegg / Entreprenør - Ukraina - Hewlett-Packard Norway (HP)");
    }

    @Test(priority = 4)
    public void assertAddItemsToFiltrList() throws Exception {
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl/dt")).getText(), "Bransje :");
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl/dd/span")).getText(), "Bygg / Anlegg / Entreprenør");
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl[2]/dt")).getText(), "Arbeidssted :");
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl[2]/dd/span")).getText(), "Ukraina");
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl[3]/dt")).getText(), "Arbeidsgiver :");
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl[3]/dd/span")).getText(), "Hewlett-Packard Norway (HP)");
    }

    @Test(priority = 5)
    public void assertCheckBoxesMark() throws Exception {
        WebElement checkBoxUkraina = driver.findElement(By.xpath("//*[@id=\"f-location-207\"]"));
        Assert.assertEquals("true",checkBoxUkraina.getAttribute("checked"));

        WebElement checkBoxBygg = driver.findElement(By.xpath("//*[@id=\"f-Bygg / Anlegg / Entreprenør-31\"]"));
        Assert.assertEquals("true",checkBoxBygg.getAttribute("checked"));
    }

    @Test(priority = 6)
    public void deleteFilterList() throws Exception {
        driver.findElement(By.xpath("//*[@id='filter']/h3/span[2]/a/span")).click();
        waitForTitle("Franchise");

        WebElement checkBoxUkraina = driver.findElement(By.xpath("//*[@id=\"f-location-207\"]"));
        Assert.assertEquals(null,checkBoxUkraina.getAttribute("checked"));

        WebElement checkBoxBygg = driver.findElement(By.xpath("//*[@id=\"f-Bygg / Anlegg / Entreprenør-31\"]"));
        Assert.assertEquals(null,checkBoxBygg.getAttribute("checked"));
    }

    @Test(priority = 7)
    public void searchJobByBransje() throws Exception {
        goToPageFranchiser();
        String AmountKandidater1 = driver.findElement(By.xpath("//*[@id='search-result-cnt']/div[1]/div/div[1]/span/span")).getText();
        // Add Bransje - IKT / Telekom
        scrollPageUp();
        driver.findElement(By.xpath("//div[@id='fv0']/ul/li[5]/label/i")).click();
        waitForTitle("Franchise - IKT / Telekom");
        String AmountKandidater2 = driver.findElement(By.xpath("//*[@id='search-result-cnt']/div[1]/div/div[1]/span/span")).getText();
        Assert.assertNotEquals(AmountKandidater1, AmountKandidater2);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='search-result-cnt']")).getText().contains("Test tittle"));
        Thread.sleep(500);
    }

    @Test(priority = 8)
    public void searchJobBySted() throws Exception {
        goToPageFranchiser();
        String AmountKandidater1 = driver.findElement(By.xpath("//*[@id='search-result-cnt']/div[1]/div/div[1]/span/span")).getText();
        // Add Sted
        driver.findElement(By.xpath("//div[@id='main-story']/div/div/div[2]/div/div/div[3]/div[2]/div/div/span/input")).sendKeys("Italia");
        waitForElementPresent(By.xpath("//div[@id='main-story']/div/div/div[2]/div/div/div[3]/div[2]/div/div[2]/ul/li[546]/label/i"));
        driver.findElement(By.xpath("//div[@id='main-story']/div/div/div[2]/div/div/div[3]/div[2]/div/div[2]/ul/li[546]/label/i")).click();
        waitForTitle("Franchise - Italia");
        String AmountKandidater2 = driver.findElement(By.xpath("//*[@id='search-result-cnt']/div[1]/div/div[1]/span/span")).getText();
        Assert.assertNotEquals(AmountKandidater1, AmountKandidater2);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='search-result-cnt']")).getText().contains("Test tittle"));
        Thread.sleep(500);
    }

    @Test(priority = 9)
    public void searchJobByFirmanavn() throws Exception {
        goToPageFranchiser();
        // Add Firmanavn - Test Organisasjonen
        driver.findElement(By.id("companyLookup")).sendKeys("Test Organisasjonen");
        waitForElementPresent(By.xpath("//ul[@id='ui-id-2']/li"));
        Thread.sleep(500);
        driver.findElement(By.id("companyLookup")).sendKeys(Keys.DOWN);
        driver.findElement(By.id("companyLookup")).sendKeys(Keys.ENTER);
        waitForTitle("Franchise - Test Organisasjonen");
        Assert.assertTrue(isElementPresent(By.xpath("//div[@id='filter']/div")));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='search-result-cnt']")).getText().contains("Test tittle"));
    }
}