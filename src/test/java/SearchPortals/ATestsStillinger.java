package SearchPortals;
import org.openqa.selenium.*;
import org.testng.Assert;
import static org.testng.Assert.*;

import static org.testng.Assert.fail;

import org.testng.annotations.Test;

public class ATestsStillinger extends TestsBaseSearchPortals {

    @Test(priority = 1)
    public void searchFreeTextIncorrect() throws Exception {
        goToPageStillinger();
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
        goToPageStillinger();
        driver.findElement(By.id("searchtext")).sendKeys("Test Organisasjonen");
        Thread.sleep(500);
        driver.findElement(By.className("search-top-submit")).click();
        waitForElementPresent(By.xpath("//*[@id='filter']/h3"));
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl/dt")).getText(), "Søketekst :");
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl/dd/span")).getText(), "Test Organisasjonen");
        assertEquals(driver.getCurrentUrl(), baseUrl + "/jobb?searchtext=Test+Organisasjonen");
    }

    @Test(priority = 3)
    public void searchAndAddItemsAllCategory() throws Exception {
        goToPageStillinger();
        Thread.sleep(1500);
        // Search Arbeidssted
        driver.findElement(By.id("searchtext")).sendKeys("Ukraina");
        waitForElementPresent(By.xpath("//body/ul/li[2]"));
        Thread.sleep(1500);
        driver.findElement(By.id("searchtext")).sendKeys(Keys.DOWN);
        Thread.sleep(1500);
        driver.findElement(By.id("searchtext")).sendKeys(Keys.ENTER);
        waitForElementPresent(By.xpath("//*[@id='filter']/h3"));
        waitForTitle("Ledige stillinger - Ukraina");
        Thread.sleep(1000);

        // Search Yrke
        driver.findElement(By.id("searchtext")).sendKeys("IT-");
        waitForElementPresent(By.xpath("//*[@id='ui-id-1']"));
        Thread.sleep(1000);
        driver.findElement(By.id("searchtext")).sendKeys(Keys.DOWN);
        Thread.sleep(1000);
        driver.findElement(By.id("searchtext")).sendKeys(Keys.DOWN);
        Thread.sleep(1500);
        driver.findElement(By.id("searchtext")).sendKeys(Keys.ENTER);
        waitForTitle("Ledige stillinger - IT-arkitekt - Ukraina");
        Thread.sleep(1000);

        // Search Fagomrade
        driver.findElement(By.id("searchtext")).sendKeys("Undervisning");
        waitForElementPresent(By.xpath("//*[@id='ui-id-1']"));
        Thread.sleep(2000);
        driver.findElement(By.id("searchtext")).sendKeys(Keys.DOWN);
        Thread.sleep(1000);
        driver.findElement(By.id("searchtext")).sendKeys(Keys.DOWN);
        Thread.sleep(1500);
        driver.findElement(By.id("searchtext")).sendKeys(Keys.ENTER);
        waitForTitle("Ledige stillinger - Undervisning, lærer- og lektorfag - IT-arkitekt - Ukraina");
        Thread.sleep(1000);

        // Search Bransje
        driver.findElement(By.id("searchtext")).sendKeys("Bygg / Anlegg");
        waitForElementPresent(By.xpath("//*[@id='ui-id-1']"));
        Thread.sleep(2000);
        driver.findElement(By.id("searchtext")).sendKeys(Keys.DOWN);
        Thread.sleep(1500);
        driver.findElement(By.id("searchtext")).sendKeys(Keys.ENTER);
        waitForTitle("Ledige stillinger - Undervisning, lærer- og lektorfag - IT-arkitekt - Bygg / Anlegg / Entreprenør - Ukraina");
        Thread.sleep(1000);

         // Search Firmanavn
        driver.findElement(By.id("searchtext")).sendKeys("Hewlett");
        waitForElementPresent(By.xpath("//*[@id='ui-id-1']"));
        Thread.sleep(2000);
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
    public void searchJobByOmfang() throws Exception {
        goToPageStillinger();
        // Add Omfang - Diltid
        driver.findElement(By.xpath("//div[@id='main-story']/div/div/div[2]/div/div/div[3]/div/div/ul/li[2]/label/i")).click();
        waitForTitle("Ledige stillinger - Deltid");
        Assert.assertTrue(isElementPresent(By.xpath("//div[@id='filter']/div")));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='search-result-cnt']")).getText().contains("Test tittle"));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='search-result-cnt']")).getText().contains("Åpen søknad – Test Organisasjonen"));
    }

    @Test(priority = 8)
    public void searchJobByArbeidssted() throws Exception {
        goToPageStillinger();
        // Add Arbeidssted - Burkina Faso
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id='searchtext']")));
        driver.findElement(By.xpath("//div[@id='main-story']/div/div/div[2]/div/div/div[3]/div[2]/div/div/span/input")).sendKeys("Burkina");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[484]/label/i")).click();
        waitForTitle("Ledige stillinger - Burkina Faso");
        Assert.assertTrue(isElementPresent(By.xpath("//div[@id='filter']/div")));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='search-result-cnt']")).getText().contains("Åpen søknad – Test Organisasjonen"));
    }

    @Test(priority = 9)
    public void searchJobByYrke() throws Exception {
        goToPageStillinger();
        // Add Yrke - Zoolog
        driver.findElement(By.xpath("//div[@id='main-story']/div/div/div[2]/div/div/div[3]/div[3]/div/div/span/input")).sendKeys("Zoolog");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[795]/label/i")).click();
        waitForTitle("Ledige stillinger - Zoolog");
        Assert.assertTrue(isElementPresent(By.xpath("//div[@id='filter']/div")));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='search-result-cnt']")).getText().contains("Åpen søknad – Test Organisasjonen"));
    }

    @Test(priority = 10)
    public void searchJobByFagområde() throws Exception {
        goToPageStillinger();
        // Add Fagområde - Undervisning, lærer- og lektorfag
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id='main-story']/div[1]/div/div[2]/div[1]/div[1]/div[3]/div[4]")));
        driver.findElement(By.xpath("//div[@id='main-story']/div/div/div[2]/div/div/div[3]/div[4]/div/ul/li[15]/label/i")).click();
        waitForTitle("Ledige stillinger - Undervisning, lærer- og lektorfag");
        Assert.assertTrue(isElementPresent(By.xpath("//div[@id='filter']/div")));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='search-result-cnt']")).getText().contains("Åpen søknad – Test Organisasjonen"));
    }

    @Test(priority = 11)
    public void searchJobByBransje() throws Exception {
        goToPageStillinger();
        // Add Bransje - Varehandel / Dagligvare / Butikk
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id='main-story']/div[1]/div/div[2]/div[1]/div[1]/div[3]/div[4]")));
        driver.findElement(By.xpath("//div[@id='main-story']/div/div/div[2]/div/div/div[3]/div[5]/div/div/span/input")).sendKeys("Varehandel");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[5]/div/div[2]/ul/li[44]/label/i")).click();
        waitForTitle("Ledige stillinger - Varehandel / Dagligvare / Butikk");
        Assert.assertTrue(isElementPresent(By.xpath("//div[@id='filter']/div")));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='search-result-cnt']")).getText().contains("Åpen søknad – Test Organisasjonen"));
    }

    @Test(priority = 12)
    public void searchJobByFirmanavn() throws Exception {
        goToPageStillinger();
        // Add Firmanavn - Test Organisasjonen
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(".//*[@id='main-story']/div[1]/div/div[2]/div[1]/div[1]/div[3]/div[5]/h3")));
        driver.findElement(By.id("companyLookup")).sendKeys("Test Organisasjonen");
        waitForElementPresent(By.xpath("//ul[@id='ui-id-2']/li"));
        Thread.sleep(500);
        driver.findElement(By.id("companyLookup")).sendKeys(Keys.DOWN);
        driver.findElement(By.id("companyLookup")).sendKeys(Keys.ENTER);
        waitForTitle("Ledige stillinger - Test Organisasjonen");
        Assert.assertTrue(isElementPresent(By.xpath("//div[@id='filter']/div")));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='search-result-cnt']")).getText().contains("Test tittle"));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='search-result-cnt']")).getText().contains("Åpen søknad – Test Organisasjonen"));
    }
}
