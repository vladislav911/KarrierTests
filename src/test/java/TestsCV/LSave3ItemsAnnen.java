package TestsCV;
import TestsCV.TestBaseCV;
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

public class LSave3ItemsAnnen extends TestBaseCV {
    @Test(priority = 1)
    public void Save1ItemWithTil() throws Exception {
        // Go to Experiences
        driver.get(baseUrl + "/CV/Experiences");
        // Click Legg til ny button
        driver.findElement(By.linkText("Legg til ny")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("FromDate")).clear();
        driver.findElement(By.id("FromDate")).sendKeys("10.02.2014");
        driver.findElement(By.id("ToDate")).clear();
        driver.findElement(By.id("ToDate")).sendKeys("12.12.2014");
        driver.findElement(By.id("Title")).clear();
        driver.findElement(By.id("Title")).sendKeys("Item №1 Tittel");
        driver.findElement(By.id("Activity")).clear();
        driver.findElement(By.id("Activity")).sendKeys("Test Organisasjon");
        driver.findElement(By.id("Description")).clear();
        driver.findElement(By.id("Description")).sendKeys("Tests1 information Beskrivelse");
        driver.findElement(By.xpath("//div[2]/div/ul")).click();
        driver.findElement(By.xpath("//div[2]/div/div/ul/li[3]")).click();
        driver.findElement(By.id("submit")).click();
        Thread.sleep(1000);
    }

    @Test(priority = 2)
    public void Save2ItemWithoutTil() throws Exception {
        // Go to Experiences
        driver.get(baseUrl + "/CV/Experiences");
        Thread.sleep(1000);
        // Click Legg til ny button
        driver.findElement(By.xpath("//*[@id='wizard-step']/div[2]/div[1]/div/div/div[1]/div/a/i")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("FromDate")).clear();
        driver.findElement(By.id("FromDate")).sendKeys("08.07.2015");
        driver.findElement(By.cssSelector(".checkbox-label>span")).click();
        driver.findElement(By.id("Title")).clear();
        driver.findElement(By.id("Title")).sendKeys("Item №2 Tittel");
        driver.findElement(By.id("Activity")).clear();
        driver.findElement(By.id("Activity")).sendKeys("Test Organisasjon");
        driver.findElement(By.id("Description")).clear();
        driver.findElement(By.id("Description")).sendKeys("Tests2 information Beskrivelse");
        driver.findElement(By.xpath("//div[2]/div/ul")).click();
        driver.findElement(By.xpath("//div[2]/div/div/ul/li[5]")).click();
        driver.findElement(By.id("submit")).click();
        Thread.sleep(1000);
    }

    @Test(priority = 3)
    public void Save3ItemWithoutTil() throws Exception {
        // Go to Experiences
        driver.get(baseUrl + "/CV/Experiences");
        Thread.sleep(1000);
        // Click Legg til ny button
        driver.findElement(By.xpath("//*[@id='wizard-step']/div[2]/div[1]/div/div/div[1]/div/a/i")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("FromDate")).clear();
        driver.findElement(By.id("FromDate")).sendKeys("12.12.2015");
        driver.findElement(By.cssSelector(".checkbox-label>span")).click();
        driver.findElement(By.id("Title")).clear();
        driver.findElement(By.id("Title")).sendKeys("Item №3 Tittel");
        driver.findElement(By.id("Activity")).clear();
        driver.findElement(By.id("Activity")).sendKeys("Test Organisasjon");
        driver.findElement(By.id("Description")).clear();
        driver.findElement(By.id("Description")).sendKeys("Tests2 information Beskrivelse");
        driver.findElement(By.xpath("//div[2]/div/ul")).click();
        driver.findElement(By.xpath("//div[2]/div/div/ul/li[6]")).click();
        driver.findElement(By.id("submit")).click();
        Thread.sleep(1000);
    }

    @Test(priority = 4)
    public void AssertSave1Item() throws Exception {
        // Go to Utdatinng
        driver.get(baseUrl + "/CV/Experiences");
        Thread.sleep(1000);
        // Assert 3 Items Saved
        assertEquals(driver.findElement(By.cssSelector("div.t-title")).getText(), "3 registrerte erfaringer");
        // Open First Item
        driver.findElement(By.linkText("Item №1 Tittel")).click();
        Thread.sleep(1000);
        // Verify Data Save
        assertEquals(driver.findElement(By.id("FromDate")).getAttribute("value"), "10.02.2014");
        assertEquals(driver.findElement(By.id("ToDate")).getAttribute("value"), "12.12.2014");
        assertEquals(driver.findElement(By.id("Title")).getAttribute("value"), "Item №1 Tittel");
        assertEquals(driver.findElement(By.id("Activity")).getAttribute("value"), "Test Organisasjon");
        assertEquals(driver.findElement(By.id("Description")).getAttribute("value"), "Tests1 information Beskrivelse");
        assertEquals(driver.findElement(By.cssSelector("li.search-choice > span")).getText(), "Bergen");
    }
    @Test(priority = 5)
    public void AssertSave2Item() throws Exception {
        // Go to Utdatinng
        driver.get(baseUrl + "/CV/Experiences");
        Thread.sleep(1000);
        // Open First Item
        driver.findElement(By.linkText("Item №2 Tittel")).click();
        Thread.sleep(1000);
        // Verify Data Save
        assertEquals(driver.findElement(By.id("FromDate")).getAttribute("value"), "08.07.2015");
        WebElement TilField = driver.findElement(By.id("ToDate"));
        Assert.assertEquals(false, TilField.isDisplayed());
        assertEquals(driver.findElement(By.id("Title")).getAttribute("value"), "Item №2 Tittel");
        assertEquals(driver.findElement(By.id("Activity")).getAttribute("value"), "Test Organisasjon");
        assertEquals(driver.findElement(By.id("Description")).getAttribute("value"), "Tests2 information Beskrivelse");
        assertEquals(driver.findElement(By.cssSelector("li.search-choice > span")).getText(), "Stavanger");
    }
}
