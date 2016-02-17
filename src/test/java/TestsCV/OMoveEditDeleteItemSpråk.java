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

public class OMoveEditDeleteItemSpråk extends TestBaseCV {
    @Test(priority = 1)
    public void MoveItems() throws Exception {
        // Go to Languages
        driver.get(baseUrl + "/CV/Languages");
        Thread.sleep(1000);
        // Close reklama
        //driver.findElement(By.xpath("//*[@id='staticad']/div/div[1]")).click();
        // Check Correct position items
        assertTrue(driver.findElement(By.xpath("//div[2]/div/div[2]/a")).getText().contains("Grunnleggende"));
        assertTrue(driver.findElement(By.xpath("//div[2]/div[2]/a")).getText().contains("Flytende"));
        assertTrue(driver.findElement(By.xpath("//div[3]/div[2]/a")).getText().contains("Middels"));
        // Move Item Middels to first Position
        WebElement draggable = driver.findElement(By.xpath("//div[3]/div[4]/ul/li"));
        Actions builder = new Actions(driver);
        builder.dragAndDropBy(draggable, 0, -130).build().perform();
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(1000);
        assertTrue(driver.findElement(By.xpath("//div[2]/div/div[2]/a")).getText().contains("Middels"));
        assertTrue(driver.findElement(By.xpath("//div[2]/div[2]/a")).getText().contains("Grunnleggende"));
        assertTrue(driver.findElement(By.xpath("//div[3]/div[2]/a")).getText().contains("Flytende"));
        // Move Item Grunnleggende to third position
        WebElement draggable2 = driver.findElement(By.xpath("//div[2]/div[4]/ul/li"));
        Actions builder2 = new Actions(driver);
        builder.dragAndDropBy(draggable2, 0, +80).build().perform();
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(1000);
        assertTrue(driver.findElement(By.xpath("//div[2]/div/div[2]/a")).getText().contains("Middels"));
        assertTrue(driver.findElement(By.xpath("//div[2]/div[2]/a")).getText().contains("Flytende"));
        assertTrue(driver.findElement(By.xpath("//div[3]/div[2]/a")).getText().contains("Grunnleggende"));
    }
    @Test(priority = 2)
    public void DeleteItem() throws Exception {
        // Go to Languages
        driver.get(baseUrl + "/CV/Languages");
        Thread.sleep(1000);
        // Check Correct position items
        assertTrue(driver.findElement(By.xpath("//div[2]/div/div[2]/a")).getText().contains("Middels"));
        assertTrue(driver.findElement(By.xpath("//div[2]/div[2]/a")).getText().contains("Flytende"));
        assertTrue(driver.findElement(By.xpath("//div[3]/div[2]/a")).getText().contains("Grunnleggende"));
        driver.findElement(By.xpath("//a[contains(text(),'Grunnleggende')]"));
        // Delete Item Grunnleggende
        driver.findElement(By.xpath("//div[3]/div[4]/ul/li[3]/a")).click();
        driver.findElement(By.linkText("Ja")).click();
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(1000);
        Assert.assertEquals(0, driver.findElements(By.xpath("//a[contains(text(),'Grunnleggende')]")).size());
    }
    @Test(priority = 3)
    public void EditItemAndRefreshPage() throws Exception {
        // Go to Languages
        driver.get(baseUrl + "/CV/Languages");
        Thread.sleep(1000);
        // Click Edit button
        driver.findElement(By.linkText("Middels")).click();
        Thread.sleep(1000);
        // Chose Sprak - Ukr
        driver.findElement(By.xpath("//div[@id='LanguageId_chosen']/a")).click();
        driver.findElement(By.xpath("//li[101]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Chose Muntlig nivå
        driver.findElement(By.xpath("//div[@id='OralLevel_chosen']/a")).click();
        driver.findElement(By.xpath("//div[@id='OralLevel_chosen']/div/ul/li")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Chose Skriftlig nivå
        driver.findElement(By.xpath("//div[@id='WrittenLevel_chosen']/a")).click();
        driver.findElement(By.xpath("//div[@id='WrittenLevel_chosen']/div/ul/li")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(1000);
        // Assert not save changes
        assertEquals(driver.findElement(By.xpath("//div[@id='LanguageId_chosen']/a/span")).getText(), "Ukrainsk");
        assertEquals(driver.findElement(By.xpath("//div[@id='OralLevel_chosen']/a/span")).getText(), "Middels");
        assertEquals(driver.findElement(By.xpath("//div[@id='WrittenLevel_chosen']/a/span")).getText(), "Middels");
    }
    @Test(priority = 4)
    public void EditItemAndCancel() throws Exception {
        // Go to Languages
        driver.get(baseUrl + "/CV/Languages");
        Thread.sleep(1000);
        // Click Edit button
        driver.findElement(By.linkText("Middels")).click();
        Thread.sleep(1000);
        // Chose Sprak - Ukr
        driver.findElement(By.xpath("//div[@id='LanguageId_chosen']/a")).click();
        driver.findElement(By.xpath("//li[101]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Chose Muntlig nivå
        driver.findElement(By.xpath("//div[@id='OralLevel_chosen']/a")).click();
        driver.findElement(By.xpath("//div[@id='OralLevel_chosen']/div/ul/li")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Chose Skriftlig nivå
        driver.findElement(By.xpath("//div[@id='WrittenLevel_chosen']/a")).click();
        driver.findElement(By.xpath("//div[@id='WrittenLevel_chosen']/div/ul/li")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.linkText("Avbryt")).click();
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Middels")).click();
        // Assert not save changes
        assertEquals(driver.findElement(By.xpath("//div[@id='LanguageId_chosen']/a/span")).getText(), "Ukrainsk");
        assertEquals(driver.findElement(By.xpath("//div[@id='OralLevel_chosen']/a/span")).getText(), "Middels");
        assertEquals(driver.findElement(By.xpath("//div[@id='WrittenLevel_chosen']/a/span")).getText(), "Middels");
    }
    @Test(priority = 5)
    public void EditItem() throws Exception {
        // Go to Languages
        driver.get(baseUrl + "/CV/Languages");
        Thread.sleep(1000);
        // Click Edit button
        driver.findElement(By.linkText("Middels")).click();
        Thread.sleep(1000);
        // Chose Sprak - Ukr
        driver.findElement(By.xpath("//div[@id='LanguageId_chosen']/a")).click();
        driver.findElement(By.xpath("//li[101]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Chose Muntlig nivå
        driver.findElement(By.xpath("//div[@id='OralLevel_chosen']/a")).click();
        driver.findElement(By.xpath("//div[@id='OralLevel_chosen']/div/ul/li")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Chose Skriftlig nivå
        driver.findElement(By.xpath("//div[@id='WrittenLevel_chosen']/a")).click();
        driver.findElement(By.xpath("//div[@id='WrittenLevel_chosen']/div/ul/li")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Grunnleggende")).click();
        // Assert not save changes
        assertEquals(driver.findElement(By.xpath("//div[@id='LanguageId_chosen']/a/span")).getText(), "Marshallesisk");
        assertEquals(driver.findElement(By.xpath("//div[@id='OralLevel_chosen']/a/span")).getText(), "Grunnleggende");
        assertEquals(driver.findElement(By.xpath("//div[@id='WrittenLevel_chosen']/a/span")).getText(), "Grunnleggende");
    }
}