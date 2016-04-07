package SearchPortals;
import org.openqa.selenium.*;
import org.testng.Assert;
import static org.testng.Assert.*;

import static org.testng.Assert.fail;

import org.testng.annotations.Test;

import java.util.List;

public class GTestsRekrutter extends TestsBaseSearchPortals {

    @Test(priority = 1)
    public void AddItemsAllCategory() throws Exception {
        goToPageRekrutter();
        // Add Bransje
        driver.findElement(By.xpath("//div[@id='fv0']/ul/li[3]/label/i")).click();
        waitForTitle("Rekrutterere - Eiendom / Eiendomsmegling");
        // Add Fagområde
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id='main-story']/div[1]/div/div[2]/div[1]/div[3]/div/div[1]/h3")));
        driver.findElement(By.xpath("//*[@id='main-story']/div[1]/div/div[2]/div[1]/div[3]/div/div[2]/div/ul/li[15]/label/i")).click();
        waitForTitle("Rekrutterere - Undervisning, l&#230;rer- og lektorfag - Eiendom / Eiendomsmegling");
        // Add Yrke
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id='main-story']/div[1]/div/div[2]/div[1]/div[3]/div/div[2]/div")));
        driver.findElement(By.xpath(".//*[@id='fv1']/ul/li[1]/label/i")).click();
        waitForTitle("Rekrutterere - Undervisning, l&#230;rer- og lektorfag - BIM-tekniker - Eiendom / Eiendomsmegling");
        // Add Sted
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id='main-story']/div[1]/div/div[2]/div[1]/div[3]/div/div[3]/h3")));
        driver.findElement(By.xpath("//div[4]/div/div[2]/ul/li[454]/label/i")).click();
        waitForTitle("Rekrutterere - Undervisning, l&#230;rer- og lektorfag - BIM-tekniker - Eiendom / Eiendomsmegling - Utlandet");
    }

    @Test(priority = 2)
    public void assertAddItemsToFiltrList() throws Exception {
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl/dt")).getText(), "Fagområde :");
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl/dd/span")).getText(), "Undervisning, lærer- og lektorfag");
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl[2]/dt")).getText(), "Yrke :");
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl[2]/dd/span")).getText(), "BIM-tekniker");
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl[3]/dt")).getText(), "Bransje :");
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl[3]/dd/span")).getText(), "Eiendom / Eiendomsmegling");
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl[4]/dt")).getText(), "Arbeidssted :");
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl[4]/dd/span")).getText(), "Utlandet");
    }

    @Test(priority = 3)
    public void assertCheckBoxesMark() throws Exception {
        WebElement checkBoxUkraina = driver.findElement(By.xpath("//*[@id=\"f-location-0\"]"));
        Assert.assertEquals("true",checkBoxUkraina.getAttribute("checked"));

        WebElement checkBoxUndervisning = driver.findElement(By.xpath("//*[@id=\"f-Undervisning, lærer- og lektorfag-14\"]"));
        Assert.assertEquals("true",checkBoxUndervisning.getAttribute("checked"));

        WebElement checkBoxBygg = driver.findElement(By.xpath("//*[@id=\"f-Eiendom / Eiendomsmegling-3\"]"));
        Assert.assertEquals("true",checkBoxBygg.getAttribute("checked"));

        WebElement checkBoxIT = driver.findElement(By.xpath(".//*[@id='f- BIM-tekniker-935']"));
        Assert.assertEquals("true",checkBoxIT.getAttribute("checked"));
    }

    @Test(priority = 4)
    public void deleteFilterList() throws Exception {
        scrollPageUp();
        driver.findElement(By.xpath("//*[@id='filter']/h3/span[2]/a/span")).click();
        waitForTitle("Rekrutterere");

        WebElement checkBoxUkraina = driver.findElement(By.xpath("//*[@id=\"f-location-0\"]"));
        Assert.assertEquals(null,checkBoxUkraina.getAttribute("checked"));

        WebElement checkBoxUndervisning = driver.findElement(By.xpath("//*[@id=\"f-Undervisning, lærer- og lektorfag-14\"]"));
        Assert.assertEquals(null,checkBoxUndervisning.getAttribute("checked"));

        WebElement checkBoxBygg = driver.findElement(By.xpath("//*[@id=\"f-Eiendom / Eiendomsmegling-3\"]"));
        Assert.assertEquals(null,checkBoxBygg.getAttribute("checked"));

        WebElement checkBoxIT = driver.findElement(By.xpath(".//*[@id='f- BIM-tekniker-935']"));
        Assert.assertEquals(null,checkBoxIT.getAttribute("checked"));
    }

    @Test(priority = 5)
    public void searchByBransje() throws Exception {
        goToPageRekrutter();
        String AmountKandidater1 = driver.findElement(By.xpath("//*[@id='search-result-cnt']/div[1]/div/div[1]/span/span")).getText();
        // Add Bransje
        driver.findElement(By.xpath("//div[@id='main-story']/div/div/div[2]/div/div[3]/div/div/div/div/span/input")).sendKeys("Kultur");
        waitForElementPresent(By.xpath("//li[38]/label/i"));
        driver.findElement(By.xpath("//li[38]/label/i")).click();
        waitForTitle("Rekrutterere - Kultur / Kunst / &#216;vrige kreative fag");
        String AmountKandidater2 = driver.findElement(By.xpath("//*[@id='search-result-cnt']/div[1]/div/div[1]/span/span")).getText();
        Assert.assertNotEquals(AmountKandidater1, AmountKandidater2);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='search-result-cnt']")).getText().contains("Test Kontaktperson"));
        Thread.sleep(500);
    }

    @Test(priority = 6)
    public void searchByFagområde() throws Exception {
        goToPageRekrutter();
        String AmountKandidater1 = driver.findElement(By.xpath("//*[@id='search-result-cnt']/div[1]/div/div[1]/span/span")).getText();
        // Add Fagområde
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id='main-story']/div[1]/div/div[2]/div[1]/div[3]/div/div[1]/h3")));
        driver.findElement(By.xpath("//div[2]/div/ul/li[5]/label/i")).click();
        waitForTitle("Rekrutterere - Idrett, kropps&#248;ving og friluftsliv");
        String AmountKandidater2 = driver.findElement(By.xpath("//*[@id='search-result-cnt']/div[1]/div/div[1]/span/span")).getText();
        Assert.assertNotEquals(AmountKandidater1, AmountKandidater2);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='search-result-cnt']")).getText().contains("Test Kontaktperson"));
        Thread.sleep(500);
    }

    @Test(priority = 7)
    public void searchByYrke() throws Exception {
        goToPageRekrutter();
        String AmountKandidater1 = driver.findElement(By.xpath("//*[@id='search-result-cnt']/div[1]/div/div[1]/span/span")).getText();
        // Add Yrke
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id='main-story']/div[1]/div/div[2]/div[1]/div[3]/div/div[2]/div")));
        driver.findElement(By.xpath("//div[@id='main-story']/div/div/div[2]/div/div[3]/div/div[3]/div/div/span/input")).sendKeys("Meteorolog");
        waitForElementPresent(By.xpath("//div[@id='fv1']/ul/li[479]/label/i"));
        driver.findElement(By.xpath("//div[@id='fv1']/ul/li[479]/label/i")).click();
        waitForTitle("Rekrutterere - Meteorolog");
        String AmountKandidater2 = driver.findElement(By.xpath("//*[@id='search-result-cnt']/div[1]/div/div[1]/span/span")).getText();
        Assert.assertNotEquals(AmountKandidater1, AmountKandidater2);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='search-result-cnt']")).getText().contains("Test Kontaktperson"));
        Thread.sleep(500);
    }

    @Test(priority = 8)
    public void searchBySted() throws Exception {
        goToPageRekrutter();
        String AmountKandidater1 = driver.findElement(By.xpath("//*[@id='search-result-cnt']/div[1]/div/div[1]/span/span")).getText();
        // Add Sted
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id='main-story']/div[1]/div/div[2]/div[1]/div[3]/div/div[3]/h3")));
        driver.findElement(By.xpath("//div[@id='main-story']/div/div/div[2]/div/div[3]/div/div[4]/div/div/span/input")).sendKeys("Vietnam");
        waitForElementPresent(By.xpath("//div[4]/div/div[2]/ul/li[686]/label/i"));
        driver.findElement(By.xpath("//div[4]/div/div[2]/ul/li[686]/label/i")).click();
        waitForTitle("Rekrutterere - Vietnam");
        String AmountKandidater2 = driver.findElement(By.xpath("//*[@id='search-result-cnt']/div[1]/div/div[1]/span/span")).getText();
        Assert.assertNotEquals(AmountKandidater1, AmountKandidater2);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='search-result-cnt']")).getText().contains("Test Kontaktperson"));
        Thread.sleep(500);
    }
}