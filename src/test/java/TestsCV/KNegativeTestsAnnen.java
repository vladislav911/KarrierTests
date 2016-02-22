package TestsCV;
import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

import org.testng.annotations.Test;

public class KNegativeTestsAnnen extends TestBaseCV {
    @Test(priority = 1)
    public void SaveWithoutAnyData() throws Exception {
        // Go to Experiences
        driver.get(baseUrl + "/CV/Experiences");
        Thread.sleep(1000);
        // Click Legg til ny button
        driver.findElement(By.linkText("Legg til ny")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("FromDate")).clear();
        driver.findElement(By.id("submit")).click();
        assertEquals(driver.findElement(By.id("FromDate-error")).getText(), "Feltet er påkrevd.");
        assertEquals(driver.findElement(By.id("ToDate-error")).getText(), "Feltet er påkrevd.");
        assertEquals(driver.findElement(By.id("Title-error")).getText(), "Feltet er påkrevd.");
        assertEquals(driver.findElement(By.id("Activity-error")).getText(), "Feltet er påkrevd.");
        assertEquals(driver.findElement(By.id("SelectedCountries-error")).getText(), "Feltet er påkrevd.");
        Thread.sleep(1000);
    }

    @Test(priority = 2)
    public void SaveWithoutSted() throws Exception {
        // Go to Arbeid
        driver.get(baseUrl + "/CV/Experiences");
        // Click Legg til ny button
        driver.findElement(By.linkText("Legg til ny")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("FromDate")).clear();
        driver.findElement(By.id("FromDate")).sendKeys("10.02.2014");
        driver.findElement(By.id("ToDate")).clear();
        driver.findElement(By.id("ToDate")).sendKeys("12.12.2014");
        driver.findElement(By.id("Title")).clear();
        driver.findElement(By.id("Title")).sendKeys("Test information Tittel");
        driver.findElement(By.id("Activity")).clear();
        driver.findElement(By.id("Activity")).sendKeys("Test Organisasjon");
        driver.findElement(By.id("submit")).click();
        assertEquals(driver.findElement(By.id("SelectedCountries-error")).getText(), "Feltet er påkrevd.");
    }
    @Test(priority = 3)
    public void SaveWithoutOrganisasjon() throws Exception {
        driver.findElement(By.id("Activity")).clear();
        driver.findElement(By.xpath("//div[2]/div/ul")).click();
        driver.findElement(By.xpath("//div[2]/div/div/ul/li[3]")).click();
        driver.findElement(By.id("submit")).click();
        assertEquals(driver.findElement(By.id("Activity-error")).getText(), "Feltet er påkrevd.");
    }
    @Test(priority = 4)
    public void SaveWithoutTittel() throws Exception {
        driver.findElement(By.id("Title")).clear();
        driver.findElement(By.id("Activity")).clear();
        driver.findElement(By.id("Activity")).sendKeys("Test Organisasjon");
        driver.findElement(By.id("submit")).click();
        assertEquals(driver.findElement(By.id("Title-error")).getText(), "Feltet er påkrevd.");
    }
    @Test(priority = 5)
    public void SaveWithoutTil() throws Exception {
        driver.findElement(By.id("ToDate")).clear();
        driver.findElement(By.id("Title")).clear();
        driver.findElement(By.id("Title")).sendKeys("Test information Tittel");
        driver.findElement(By.id("submit")).click();
        assertEquals(driver.findElement(By.id("ToDate-error")).getText(), "Feltet er påkrevd.");
    }
    @Test(priority = 6)
    public void SaveWithoutFra() throws Exception {
        driver.findElement(By.id("FromDate")).clear();
        driver.findElement(By.id("ToDate")).clear();
        driver.findElement(By.id("ToDate")).sendKeys("12.12.2014");
        driver.findElement(By.id("submit")).click();
        assertEquals(driver.findElement(By.id("FromDate-error")).getText(), "Feltet er påkrevd.");
    }
    @Test(priority = 7)
    public void SaveWithFradateLateTilDate () throws Exception {
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Type Til
        driver.findElement(By.id("FromDate")).clear();
        driver.findElement(By.id("FromDate")).sendKeys("11.11.2015");
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.id("submit")).click();
        assertEquals(driver.findElement(By.cssSelector("span.field-validation-error")).getText(), "Startdato må være før sluttdato");
    }
    @Test(priority = 8)
    public void SaveWithIncorrectFra () throws Exception {
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Type Til
        driver.findElement(By.id("FromDate")).clear();
        driver.findElement(By.id("FromDate")).sendKeys("1111201223232323");
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.id("submit")).click();
        assertEquals(driver.findElement(By.id("FromDate-error")).getText(), "The field FromDate must be a date.");
    }
    @Test(priority = 9)
    public void SaveWithIncorrectTil () throws Exception {
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Type Til
        driver.findElement(By.id("FromDate")).clear();
        driver.findElement(By.id("FromDate")).sendKeys("11.11.2012");
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Type Til
        driver.findElement(By.id("ToDate")).clear();
        driver.findElement(By.id("ToDate")).sendKeys("1111201223232323");
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.id("submit")).click();
        assertEquals(driver.findElement(By.id("ToDate-error")).getText(), "The field ToDate must be a date.");
    }
    @Test(priority = 10)
    public void DeleteFieldTil () throws Exception {
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.cssSelector(".checkbox-label>span")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        WebElement TilField = driver.findElement(By.id("ToDate"));
        Assert.assertEquals(false, TilField.isDisplayed());
    }
}