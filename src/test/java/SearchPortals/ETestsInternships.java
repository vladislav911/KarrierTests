package SearchPortals;
import org.openqa.selenium.*;
import org.testng.Assert;
import static org.testng.Assert.*;

import static org.testng.Assert.fail;

import org.testng.annotations.Test;

public class ETestsInternships extends TestsBaseSearchPortals {

    @Test(priority = 1)
    public void searchFreeTextIncorrect() throws Exception {
        goToPageInternships();
        driver.findElement(By.id("searchtext")).sendKeys("adasdasdgfhfg");
        driver.findElement(By.className("search-top-submit")).click();
        waitForElementPresent(By.xpath("//*[@id='filter']/h3"));
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl/dt")).getText(), "Søketekst :");
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl/dd/span")).getText(), "adasdasdgfhfg");
        assertEquals(driver.findElement(By.xpath("//div[@id='f-search-results']/div/p[3]")).getText(), "No results - please change the search criteria sada sd asd as");
    }

    @Test(priority = 2)
    public void searchFreeTextCorrect() throws Exception {
        goToPageInternships();
        driver.findElement(By.id("searchtext")).sendKeys("manager");
        driver.findElement(By.className("search-top-submit")).click();
        waitForElementPresent(By.xpath("//*[@id='filter']/h3"));
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl/dt")).getText(), "Søketekst :");
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl/dd/span")).getText(), "manager");
        assertEquals(driver.getCurrentUrl(), baseUrl + "/internships?searchtext=manager");
    }

    @Test(priority = 3)
    public void searchAndAddItemsAllCategory() throws Exception {
        goToPageInternships();
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

        // Search Fagomrade
        driver.findElement(By.id("searchtext")).sendKeys("Undervisning");
        waitForElementPresent(By.xpath("//*[@id='ui-id-1']"));
        Thread.sleep(1000);
        driver.findElement(By.id("searchtext")).sendKeys(Keys.DOWN);
        Thread.sleep(1500);
        driver.findElement(By.id("searchtext")).sendKeys(Keys.ENTER);
        waitForTitle("Internships - Undervisning, lærer- og lektorfag - Ukraina");
        Thread.sleep(1000);

        // Search Bransje
        driver.findElement(By.id("searchtext")).sendKeys("Bygg / Anlegg");
        waitForElementPresent(By.xpath("//*[@id='ui-id-1']"));
        Thread.sleep(1000);
        driver.findElement(By.id("searchtext")).sendKeys(Keys.DOWN);
        Thread.sleep(1500);
        driver.findElement(By.id("searchtext")).sendKeys(Keys.ENTER);
        waitForTitle("Internships - Undervisning, lærer- og lektorfag - Bygg / Anlegg / Entreprenør - Ukraina");

        // Search Firmanavn
        driver.findElement(By.id("searchtext")).sendKeys("Hewlett");
        waitForElementPresent(By.xpath("//*[@id='ui-id-1']"));
        Thread.sleep(1000);
        driver.findElement(By.id("searchtext")).sendKeys(Keys.DOWN);
        Thread.sleep(1500);
        driver.findElement(By.id("searchtext")).sendKeys(Keys.ENTER);
        waitForTitle("Internships - Undervisning, lærer- og lektorfag - Bygg / Anlegg / Entreprenør - Ukraina - Hewlett-Packard Norway (HP)");
    }

    @Test(priority = 4)
    public void assertAddItemsToFiltrList() throws Exception {
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl/dt")).getText(), "Fagområde :");
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl/dd/span")).getText(), "Undervisning, lærer- og lektorfag");
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl[2]/dt")).getText(), "Bransje :");
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl[2]/dd/span")).getText(), "Bygg / Anlegg / Entreprenør");
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl[3]/dt")).getText(), "Arbeidssted :");
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl[3]/dd/span")).getText(), "Ukraina");
    }

    @Test(priority = 5)
    public void assertCheckBoxesMark() throws Exception {
        WebElement checkBoxUkraina = driver.findElement(By.xpath("//*[@id=\"f-location-207\"]"));
        Assert.assertEquals("true",checkBoxUkraina.getAttribute("checked"));

        WebElement checkBoxUndervisning = driver.findElement(By.xpath("//*[@id=\"f-Undervisning, lærer- og lektorfag-14\"]"));
        Assert.assertEquals("true",checkBoxUndervisning.getAttribute("checked"));

        WebElement checkBoxBygg = driver.findElement(By.xpath("//*[@id=\"f-Bygg / Anlegg / Entreprenør-31\"]"));
        Assert.assertEquals("true",checkBoxBygg.getAttribute("checked"));
    }

    @Test(priority = 6)
    public void deleteFilterList() throws Exception {
        driver.findElement(By.xpath("//*[@id='filter']/h3/span[2]/a/span")).click();
        waitForTitle("Internships");

        WebElement checkBoxUkraina = driver.findElement(By.xpath("//*[@id=\"f-location-207\"]"));
        Assert.assertEquals(null,checkBoxUkraina.getAttribute("checked"));

        WebElement checkBoxUndervisning = driver.findElement(By.xpath("//*[@id=\"f-Undervisning, lærer- og lektorfag-14\"]"));
        Assert.assertEquals(null,checkBoxUndervisning.getAttribute("checked"));

        WebElement checkBoxBygg = driver.findElement(By.xpath("//*[@id=\"f-Bygg / Anlegg / Entreprenør-31\"]"));
        Assert.assertEquals(null,checkBoxBygg.getAttribute("checked"));
    }

    @Test(priority = 7)
    public void searchJobByArbeidssted() throws Exception {
        goToPageInternships();
        // Add Freetext -  Test
        driver.findElement(By.id("searchtext")).sendKeys("Test");
        driver.findElement(By.className("search-top-submit")).click();
        Thread.sleep(2000);
        String AmountKandidater1 = driver.findElement(By.xpath("//div[2]/div/div/div/div/span")).getText();
        // Add Arbeidssted -  Vietnam
        driver.findElement(By.xpath("//div[2]/div/div/span/input")).sendKeys("Vietnam");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[686]/label/i")).click();
        waitForTitle("Internships - Vietnam");
        String AmountKandidater2 = driver.findElement(By.xpath("//div[2]/div/div/div/div/span")).getText();
        Assert.assertNotEquals(AmountKandidater1, AmountKandidater2);
        assertEquals(driver.findElement(By.xpath("//div[@id='f-search-results']/div/div/div/div/div/div/a")).getText(), "Test tittle");
    }

    @Test(priority = 8)
    public void searchJobByFagområde() throws Exception {
        goToPageInternships();
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

    @Test(priority = 9)
    public void searchJobByBransje() throws Exception {
        goToPageInternships();
        // Add Freetext -  Test
        driver.findElement(By.id("searchtext")).sendKeys("Test");
        driver.findElement(By.className("search-top-submit")).click();
        Thread.sleep(2000);
        String AmountKandidater1 = driver.findElement(By.xpath("//div[2]/div/div/div/div/span")).getText();
        // Add Bransje  -   Kommunikasjon
        driver.findElement(By.xpath("//div[@id='fv0']/ul/li[22]/label/i")).click();
        waitForTitle("Internships - Kommunikasjon / PR");
        String AmountKandidater2 = driver.findElement(By.xpath("//div[2]/div/div/div/div/span")).getText();
        Assert.assertNotEquals(AmountKandidater1, AmountKandidater2);
        assertEquals(driver.findElement(By.xpath("//div[@id='f-search-results']/div/div/div/div/div/div/a")).getText(), "Test tittle");
    }

    @Test(priority = 10)
    public void searchJobByFirmanavn() throws Exception {
        goToPageInternships();
        // Add Firmanavn - Test Organisasjonen
        driver.findElement(By.id("companyLookup")).sendKeys("Test Organisasjonen");
        waitForElementPresent(By.xpath("//ul[@id='ui-id-2']/li"));
        Thread.sleep(500);
        driver.findElement(By.id("companyLookup")).sendKeys(Keys.DOWN);
        driver.findElement(By.id("companyLookup")).sendKeys(Keys.ENTER);
        waitForTitle("Internships - Test Organisasjonen");
        Assert.assertTrue(isElementPresent(By.xpath("//div[@id='filter']/div")));
        assertEquals(driver.findElement(By.xpath("//div[@id='f-search-results']/div/div/div/div/div/div/a")).getText(), "Test tittle");
    }
}
