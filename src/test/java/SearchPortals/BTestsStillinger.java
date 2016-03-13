package SearchPortals;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import static org.testng.Assert.*;

import static org.testng.Assert.fail;

import org.testng.annotations.Test;

public class BTestsStillinger extends TestBaseSearchPortals {

    @Test(priority = 1)
    public void searchFreeTextIncorrect() throws Exception {
        goToPageStillinger();
        driver.findElement(By.id("searchtext")).sendKeys("adasdasdgfhfg");
        driver.findElement(By.cssSelector("div.search-top-submit.firepath-matching-node")).click();
        waitForElementPresent(By.xpath("//*[@id='filter']/h3"));
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl")).getText(), "Søketekst : adasdasdgfhfg");
        assertEquals(driver.findElement(By.xpath("//div[@id='f-search-results']/div/p[3]")).getText(), "No results - please change the search criteria sada sd asd as");
    }

    @Test(priority = 2)
    public void searchFreeTextCorrect() throws Exception {
        goToPageStillinger();
        driver.findElement(By.id("searchtext")).clear();
        driver.findElement(By.id("searchtext")).sendKeys("manager");
        driver.findElement(By.cssSelector("div.search-top-submit.firepath-matching-node")).click();
        waitForElementPresent(By.xpath("//*[@id='filter']/h3"));
        assertEquals(driver.findElement(By.xpath("//div[@id='filter']/div/div/dl")).getText(), "Søketekst :  manager");
        assertEquals(driver.findElement(By.xpath("//div[@id='f-search-results']/div/p[3]")).getText(), "No results - please change the search criteria sada sd asd as");
    }
}

