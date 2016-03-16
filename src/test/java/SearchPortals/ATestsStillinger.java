package SearchPortals;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import net.sourceforge.htmlunit.corejs.javascript.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import static org.testng.Assert.*;

import static org.testng.Assert.fail;

import org.testng.annotations.Test;

import java.io.IOException;

public class ATestsStillinger extends TestBaseSearchPortals {

    @Test(priority = 1)
    public void searchFreeTextIncorrect() throws Exception {
        goToPageStillinger();
        // Close reklam
        driver.findElement(By.xpath("//*[@id='staticad']/div/div[1]")).click();
        driver.findElement(By.id("searchtext")).sendKeys("adasdasdgfhfg");
        driver.findElement(By.className("search-top-submit")).click();
        waitForElementPresent(By.xpath("//*[@id='filter']/h3"));
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl/dt")).getText(), "Søketekst :");
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl/dd/span")).getText(), "adasdasdgfhfg");
        assertEquals(driver.findElement(By.xpath("//div[@id='f-search-results']/div/p[3]")).getText(), "No results - please change the search criteria sada sd asd as");
    }

    @Test(priority = 2)
    public void searchFreeTextCorrect() throws Exception {
        goToPageStillinger();
        driver.findElement(By.id("searchtext")).sendKeys("manager");
        driver.findElement(By.className("search-top-submit")).click();
        waitForElementPresent(By.xpath("//*[@id='filter']/h3"));
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl/dt")).getText(), "Søketekst :");
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl/dd/span")).getText(), "manager");
        assertEquals(driver.getCurrentUrl(), baseUrl + "/jobb?searchtext=manager");
    }

    @Test(priority = 3)
    public void searchAndAddItemsAllCategory() throws Exception {
        goToPageStillinger();
        // Search Arbeidssted
        driver.findElement(By.id("searchtext")).sendKeys("Ukra");
        waitForElementPresent(By.xpath("//*[@id='ui-id-1']"));
        assertEquals(driver.findElement(By.xpath("//ul[@id='ui-id-1']/li")).getText(), "Treff i Steder");
        assertEquals(driver.findElement(By.xpath("//ul[@id='ui-id-1']/li[2]")).getText(), "Aukra");
        assertEquals(driver.findElement(By.xpath("//ul[@id='ui-id-1']/li[3]")).getText(), "Ukraina");
        driver.findElement(By.id("searchtext")).sendKeys(Keys.DOWN);
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
        waitForTitle("Ledige stillinger - IT-arkitekt - Ukraina");
        Thread.sleep(1000);

        // Search Fagomrade
        driver.findElement(By.id("searchtext")).sendKeys("Undervisning");
        waitForElementPresent(By.xpath("//*[@id='ui-id-1']"));
        Thread.sleep(1000);
        driver.findElement(By.id("searchtext")).sendKeys(Keys.DOWN);
        driver.findElement(By.id("searchtext")).sendKeys(Keys.DOWN);
        Thread.sleep(1500);
        driver.findElement(By.id("searchtext")).sendKeys(Keys.ENTER);
        waitForTitle("Ledige stillinger - Undervisning, lærer- og lektorfag - IT-arkitekt - Ukraina");
        Thread.sleep(1000);

        // Search Bransje
        driver.findElement(By.id("searchtext")).sendKeys("Bygg / Anlegg");
        waitForElementPresent(By.xpath("//*[@id='ui-id-1']"));
        Thread.sleep(1000);
        driver.findElement(By.id("searchtext")).sendKeys(Keys.DOWN);
        Thread.sleep(1500);
        driver.findElement(By.id("searchtext")).sendKeys(Keys.ENTER);
        waitForTitle("Ledige stillinger - Undervisning, lærer- og lektorfag - IT-arkitekt - Bygg / Anlegg / Entreprenør - Ukraina");
        Thread.sleep(1000);

         // Search Firmanavn
        driver.findElement(By.id("searchtext")).sendKeys("Hewlett");
        waitForElementPresent(By.xpath("//*[@id='ui-id-1']"));
        Thread.sleep(1000);
        driver.findElement(By.id("searchtext")).sendKeys(Keys.DOWN);
        Thread.sleep(1500);
        driver.findElement(By.id("searchtext")).sendKeys(Keys.ENTER);
        waitForTitle("Ledige stillinger - Undervisning, lærer- og lektorfag - IT-arkitekt - Bygg / Anlegg / Entreprenør - Ukraina - Hewlett-Packard Norway (HP)");
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
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl[5]/dt")).getText(), "Arbeidsgiver :");
        driver.findElement(By.xpath("//*[@id='filter']/div/div")).click();
        driver.findElement(By.xpath("//*[@id='filter']/div/div")).sendKeys(Keys.DOWN);
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl[5]/dd/span")).getText(), "Hewlett-Packard Norway (HP)");
    }

    @Test(priority = 5)
    public void assertCheckBoxesMark() throws Exception {
        WebElement checkBoxUkraina = driver.findElement(By.xpath("//*[@id=\"f-location-207\"]"));
        Assert.assertEquals("true",checkBoxUkraina.getAttribute("checked"));

        WebElement checkBoxIT = driver.findElement(By.xpath("//*[@id=\"f-IT-arkitekt-657\"]"));
        Assert.assertEquals("true",checkBoxIT.getAttribute("checked"));

        WebElement checkBoxUndervisning = driver.findElement(By.xpath("//*[@id=\"f-Undervisning, lærer- og lektorfag-14\"]"));
        Assert.assertEquals("true",checkBoxUndervisning.getAttribute("checked"));

        WebElement checkBoxBygg = driver.findElement(By.xpath("//*[@id=\"f-Bygg / Anlegg / Entreprenør-31\"]"));
        Assert.assertEquals("true",checkBoxBygg.getAttribute("checked"));
    }

    @Test(priority = 6)
    public void deleteFilterList() throws Exception {
        driver.findElement(By.xpath("//*[@id='filter']/h3/span[2]/a/span")).click();
        waitForTitle("Ledige stillinger");

        WebElement checkBoxUkraina = driver.findElement(By.xpath("//*[@id=\"f-location-207\"]"));
        Assert.assertEquals(null,checkBoxUkraina.getAttribute("checked"));

        WebElement checkBoxIT = driver.findElement(By.xpath("//*[@id=\"f-IT-arkitekt-657\"]"));
        Assert.assertEquals(null,checkBoxIT.getAttribute("checked"));

        WebElement checkBoxUndervisning = driver.findElement(By.xpath("//*[@id=\"f-Undervisning, lærer- og lektorfag-14\"]"));
        Assert.assertEquals(null,checkBoxUndervisning.getAttribute("checked"));

        WebElement checkBoxBygg = driver.findElement(By.xpath("//*[@id=\"f-Bygg / Anlegg / Entreprenør-31\"]"));
        Assert.assertEquals(null,checkBoxBygg.getAttribute("checked"));
    }

    @Test(priority = 7)
    public void addItemsFromCategories() throws Exception {
        goToPageStillinger();
        // Add Omfang
        driver.findElement(By.xpath("//label/i")).click();
        waitForTitle("Ledige stillinger - Heltid");
        Assert.assertTrue(isElementPresent(By.xpath("//div[@id='filter']/div")));

        // Add Arbeidssted
        driver.findElement(By.xpath("//*[@id='p-0']/label/i")).click();
        waitForTitle("Ledige stillinger - Heltid - Utlandet");

        // Add Yrke
        driver.findElement(By.xpath("//*[@id='fv0']/ul/li[2]/label/i")).click();
        waitForTitle("Ledige stillinger - Heltid - 3D-tegner - Utlandet");

        // Add Fagområde
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id='main-story']/div[1]/div/div[2]/div[1]/div[1]/div[3]/div[4]")));
        driver.findElement(By.xpath("//div[@id='main-story']/div/div/div[2]/div/div/div[3]/div[4]/div/ul/li[7]/label/i")).click();
        waitForTitle("Ledige stillinger - Heltid - Jus - 3D-tegner - Utlandet");

        // Add Bransje
        driver.findElement(By.xpath("//*[@id='fv1']/ul/li[5]/label/i")).click();
        waitForTitle("Ledige stillinger - Heltid - Jus - 3D-tegner - Engineering - Utlandet");

        // Add Firmanavn
        driver.findElement(By.id("companyLookup")).sendKeys("Hewlett");
        waitForElementPresent(By.xpath("//ul[@id='ui-id-2']/li"));
        Thread.sleep(1000);
        driver.findElement(By.id("companyLookup")).sendKeys(Keys.DOWN);
        driver.findElement(By.id("companyLookup")).sendKeys(Keys.ENTER);
        waitForTitle("Ledige stillinger - Heltid - Jus - 3D-tegner - Engineering - Utlandet - Hewlett-Packard Norway (HP)");
    }

    @Test(priority = 8)
    public void assertAddItemsToFiltrListFromCategories() throws Exception {
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl/dt")).getText(), "Stillingstype :");
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl/dd/span")).getText(), "Heltid");
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl[2]/dt")).getText(), "Fagområde :");
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl[2]/dd/span")).getText(), "Jus");
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl[3]/dt")).getText(), "Yrke :");
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl[3]/dd/span")).getText(), "3D-tegner");
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl[4]/dt")).getText(), "Bransje :");
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl[4]/dd/span")).getText(), "Engineering");
        driver.findElement(By.xpath("//*[@id='filter']/div/div")).click();
        driver.findElement(By.xpath("//*[@id='filter']/div/div")).sendKeys(Keys.DOWN);
        driver.findElement(By.xpath("//*[@id='filter']/div/div")).sendKeys(Keys.DOWN);
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl[5]/dt")).getText(), "Arbeidssted :");
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl[5]/dd/span")).getText(), "Utlandet");
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl[6]/dt")).getText(), "Arbeidsgiver :");
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl[6]/dd/span")).getText(), "Hewlett-Packard Norway (HP)");
    }

    @Test(priority = 9)
    public void deleteItemsFromFiltrList() throws Exception {
        driver.findElement(By.xpath("//*[@id='filter']/div/div")).click();
        driver.findElement(By.xpath("//*[@id='filter']/div/div")).sendKeys(Keys.UP);
        driver.findElement(By.xpath("//*[@id='filter']/div/div")).sendKeys(Keys.UP);
        // Delete Stillingstype
        scrollPageUp();
        driver.findElement(By.xpath("//*[@id='filter']/div/div/dl[1]/dd/a")).click();
        waitForTitle("Ledige stillinger - Jus - 3D-tegner - Engineering - Utlandet - Hewlett-Packard Norway (HP)");
        // Delete Fagområde
        scrollPageUp();
        driver.findElement(By.xpath("//*[@id='filter']/div/div/dl[1]/dd/a")).click();
        waitForTitle("Ledige stillinger - 3D-tegner - Engineering - Utlandet - Hewlett-Packard Norway (HP)");
        // Delete Yrke
        scrollPageUp();
        driver.findElement(By.xpath("//*[@id='filter']/div/div/dl[1]/dd/a")).click();
        waitForTitle("Ledige stillinger - Engineering - Utlandet - Hewlett-Packard Norway (HP)");
        // Assert deleting boxes mark
        WebElement checkBoxHeltid = driver.findElement(By.xpath("//*[@id=\"f-Heltid-1\"]"));
        Assert.assertEquals(null,checkBoxHeltid.getAttribute("checked"));

        WebElement checkBoxJus = driver.findElement(By.xpath("//*[@id=\"f-Jus-4\"]"));
        Assert.assertEquals(null,checkBoxJus.getAttribute("checked"));

        WebElement checkBox3D = driver.findElement(By.xpath("//*[@id=\"f-3D-tegner-592\"]"));
        Assert.assertEquals(null,checkBox3D.getAttribute("checked"));
    }

    @Test(priority = 10)
    public void deleteItemsFromCategories() throws Exception {
        // Delete Bransje
        scrollPageUp();
        driver.findElement(By.xpath("//*[@id='fv1']/ul/li[5]/label/i")).click();
        waitForTitle("Ledige stillinger - Utlandet - Hewlett-Packard Norway (HP)");
        Thread.sleep(1000);
        // Delete Arbeidsted
        scrollPageUp();
        driver.findElement(By.xpath("//*[@id='p-0']/label/i")).click();
        waitForTitle("Ledige stillinger - Hewlett-Packard Norway (HP)");
    }

    @Test(priority = 11)
    public void deleteFiltrList() throws Exception {
        // Delete Arbeidsgiver
        scrollPageUp();
        driver.findElement(By.xpath("//*[@id='filter']/div/div/dl[1]/dd/a")).click();
        waitForTitle("Ledige stillinger");
        assertElementNotPresent(By.xpath("//div[@id='filter']/div"));
    }
}
