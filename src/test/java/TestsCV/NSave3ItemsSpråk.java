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

public class NSave3ItemsSpråk extends TestBaseCV {
    @Test(priority = 1)
    public void Save1ItemWithMorsmål() throws Exception {
        // Go to Utdatinng
        driver.get(baseUrl + "/CV/Languages");
        // Click Legg til ny button
        driver.findElement(By.linkText("Legg til ny")).click();
        // Close reklama
        //driver.findElement(By.xpath("//*[@id='staticad']/div/div[1]")).click();
        // Chose Sprak - Ukr
        driver.findElement(By.xpath("//div[@id='LanguageId_chosen']/a")).click();
        driver.findElement(By.xpath("//li[172]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Chose Muntlig nivå
        driver.findElement(By.xpath("//div[@id='OralLevel_chosen']/a")).click();
        driver.findElement(By.xpath("//div[2]/div[2]/div/div/ul/li[2]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Chose Skriftlig nivå
        driver.findElement(By.xpath("//div[@id='WrittenLevel_chosen']/a")).click();
        driver.findElement(By.xpath("//div[3]/div[2]/div/div/ul/li[2]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Chose checkbox Morsmål
        driver.findElement(By.xpath("//form[@id='editLanguageForm']/div[4]/div[2]/label/span")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(1000);
    }
    @Test(priority = 2)
    public void Save2ItemWithoutMorsmål() throws Exception {
        // Go to Utdatinng
        driver.get(baseUrl + "/CV/Languages");
        // Click Legg til ny button
        driver.findElement(By.xpath("//div[@id='wizard-step']/div[2]/div/div/div/div/div[4]/a/i")).click();
        Thread.sleep(100);
        // Chose Sprak - Ukr
        driver.findElement(By.xpath("//div[@id='LanguageId_chosen']/a")).click();
        driver.findElement(By.xpath("//li[72]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Chose Muntlig nivå
        driver.findElement(By.xpath("//div[@id='OralLevel_chosen']/a")).click();
        driver.findElement(By.xpath("//div[2]/div[2]/div/div/ul/li[3]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Chose Skriftlig nivå
        driver.findElement(By.xpath("//div[@id='WrittenLevel_chosen']/a")).click();
        driver.findElement(By.xpath("//div[3]/div[2]/div/div/ul/li[3]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(1000);
    }
    @Test(priority = 3)
    public void Save3ItemWithoutMorsmål() throws Exception {
        // Go to Utdatinng
        driver.get(baseUrl + "/CV/Languages");
        // Click Legg til ny button
        driver.findElement(By.xpath("//div[@id='wizard-step']/div[2]/div/div/div/div/div[4]/a/i")).click();
        Thread.sleep(100);
        // Chose Sprak - Ukr
        driver.findElement(By.xpath("//div[@id='LanguageId_chosen']/a")).click();
        driver.findElement(By.xpath("//li[42]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(1000);
    }
    @Test(priority = 4)
    public void AssertSave1Item() throws Exception {
        // Go to Utdatinng
        driver.get(baseUrl + "/CV/Languages");
        Thread.sleep(1000);
        // Open First Item
        driver.findElement(By.linkText("Middels")).click();
        Thread.sleep(1000);
        // Verify Data Save
        assertEquals(driver.findElement(By.xpath("//div[@id='LanguageId_chosen']/a/span")).getText(), "Ukrainsk");
        assertEquals(driver.findElement(By.xpath("//div[@id='OralLevel_chosen']/a/span")).getText(), "Middels");
        assertEquals(driver.findElement(By.xpath("//div[@id='WrittenLevel_chosen']/a/span")).getText(), "Middels");
    }
    @Test(priority = 5)
    public void AssertSave2Item() throws Exception {
        // Go to Utdatinng
        driver.get(baseUrl + "/CV/Languages");
        Thread.sleep(1000);
        // Open First Item
        driver.findElement(By.linkText("Flytende")).click();
        Thread.sleep(1000);
        // Verify Data Save
        assertEquals(driver.findElement(By.xpath("//div[@id='LanguageId_chosen']/a/span")).getText(), "Italiensk");
        assertEquals(driver.findElement(By.xpath("//div[@id='OralLevel_chosen']/a/span")).getText(), "Flytende");
        assertEquals(driver.findElement(By.xpath("//div[@id='WrittenLevel_chosen']/a/span")).getText(), "Flytende");
    }
}