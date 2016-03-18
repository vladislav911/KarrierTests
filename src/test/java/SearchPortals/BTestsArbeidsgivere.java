package SearchPortals;
import net.sourceforge.htmlunit.corejs.javascript.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import static org.testng.Assert.*;

import static org.testng.Assert.fail;

import org.testng.annotations.Test;

public class BTestsArbeidsgivere extends TestBaseSearchPortals {

    @Test(priority = 1)
    public void searchFreeTextIncorrect() throws Exception {
        goToPageArbeidsgivere();
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
        goToPageArbeidsgivere();
        driver.findElement(By.id("searchtext")).sendKeys("Test Organisasjonen");
        driver.findElement(By.className("search-top-submit")).click();
        waitForElementPresent(By.xpath("//*[@id='filter']/h3"));
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl/dt")).getText(), "Søketekst :");
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl/dd/span")).getText(), "Test Organisasjonen");
        assertEquals(driver.getCurrentUrl(), baseUrl + "/arbeidsgivere?searchtext=Test+Organisasjonen");
    }

    @Test(priority = 3)
    public void searchAndAddItemsAllCategory() throws Exception {
        goToPageArbeidsgivere();
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
        waitForTitle("Arbeidsgivere - Undervisning, lærer- og lektorfag - Ukraina");
        Thread.sleep(1000);

        // Search Bransje
        driver.findElement(By.id("searchtext")).sendKeys("Bygg / Anlegg");
        waitForElementPresent(By.xpath("//*[@id='ui-id-1']"));
        Thread.sleep(1000);
        driver.findElement(By.id("searchtext")).sendKeys(Keys.DOWN);
        Thread.sleep(1500);
        driver.findElement(By.id("searchtext")).sendKeys(Keys.ENTER);
        waitForTitle("Arbeidsgivere - Undervisning, lærer- og lektorfag - Bygg / Anlegg / Entreprenør - Ukraina");
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
        waitForTitle("Arbeidsgivere");

        WebElement checkBoxUkraina = driver.findElement(By.xpath("//*[@id=\"f-location-207\"]"));
        Assert.assertEquals(null,checkBoxUkraina.getAttribute("checked"));

        WebElement checkBoxUndervisning = driver.findElement(By.xpath("//*[@id=\"f-Undervisning, lærer- og lektorfag-14\"]"));
        Assert.assertEquals(null,checkBoxUndervisning.getAttribute("checked"));

        WebElement checkBoxBygg = driver.findElement(By.xpath("//*[@id=\"f-Bygg / Anlegg / Entreprenør-31\"]"));
        Assert.assertEquals(null,checkBoxBygg.getAttribute("checked"));
    }

    @Test(priority = 7)
    public void searchJobByArbeidssted() throws Exception {
        goToPageArbeidsgivere();
        // Add Arbeidssted - Burkina Faso
        driver.findElement(By.xpath("//div[2]/div/div/span/input")).sendKeys("Chile");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[686]/label/i")).click();
        waitForTitle("Arbeidsgivere - Vietnam");
        Assert.assertTrue(isElementPresent(By.xpath("//div[@id='filter']/div")));
        Thread.sleep(5000);
        String expText = "Test Organisasjonen";
        String pageSource = driver.getPageSource();
        if(pageSource.contains(expText)){
            System.out.println("2) Expected text '"+expText+"' present in the web page.");
        }else{
            System.out.println("2) Expected text '"+expText+"' is not present in the web page.");
        }
    }
}
