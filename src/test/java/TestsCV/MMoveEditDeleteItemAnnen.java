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

public class MMoveEditDeleteItemAnnen extends TestBaseCV {
    @Test(priority = 1)
    public void MoveItems() throws Exception {
        // Go to Arbeid
        driver.get(baseUrl + "/CV/Experiences");
        Thread.sleep(1000);
        // Check Correct position items
        assertTrue(driver.findElement(By.xpath("//div[2]/div/div[2]/a")).getText().contains("Item №2"));
        assertTrue(driver.findElement(By.xpath("//div[2]/div[2]/a")).getText().contains("Item №3"));
        assertTrue(driver.findElement(By.xpath("//div[3]/div[2]/a")).getText().contains("Item №1"));
        // Move Item №1 to first Position
        WebElement draggable = driver.findElement(By.xpath("//div[3]/div[3]/ul/li"));
        Actions builder = new Actions(driver);
        builder.dragAndDropBy(draggable, 0, -130).build().perform();
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(1000);
        assertTrue(driver.findElement(By.xpath("//div[2]/div/div[2]/a")).getText().contains("Item №1"));
        assertTrue(driver.findElement(By.xpath("//div[2]/div[2]/a")).getText().contains("Item №2"));
        assertTrue(driver.findElement(By.xpath("//div[3]/div[2]/a")).getText().contains("Item №3"));
        // Move Item №3 to third position
        WebElement draggable2 = driver.findElement(By.xpath("//div[2]/div[3]/ul/li"));
        Actions builder2 = new Actions(driver);
        builder.dragAndDropBy(draggable2, 0, +80).build().perform();
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(1000);
        assertTrue(driver.findElement(By.xpath("//div[2]/div/div[2]/a")).getText().contains("Item №1"));
        assertTrue(driver.findElement(By.xpath("//div[2]/div[2]/a")).getText().contains("Item №3"));
        assertTrue(driver.findElement(By.xpath("//div[3]/div[2]/a")).getText().contains("Item №2"));
    }

    @Test(priority = 2)
    public void DeleteItem() throws Exception {
        // Go to Arbeid
        driver.get(baseUrl + "/CV/Experiences");
        Thread.sleep(1000);
        // Check Correct position items
        assertTrue(driver.findElement(By.xpath("//div[2]/div/div[2]/a")).getText().contains("Item №1"));
        assertTrue(driver.findElement(By.xpath("//div[2]/div[2]/a")).getText().contains("Item №3"));
        assertTrue(driver.findElement(By.xpath("//div[3]/div[2]/a")).getText().contains("Item №2"));
        driver.findElement(By.xpath("//a[contains(text(),'Item №3 Tittel')]"));
        // Delete Item BIBELOVERSETTELSE
        driver.findElement(By.xpath("//div[2]/div[3]/ul/li[3]/a")).click();
        driver.findElement(By.xpath("//*[@id='cbRemove_cnt']/div[1]/div[3]/div/button[1]")).click();
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(1000);
        Assert.assertEquals(0, driver.findElements(By.xpath("//a[contains(text(),'Item №3 Tittel')]")).size());
    }

    @Test(priority = 3)
    public void EditItemAndRefreshPage() throws Exception {
        // Go to Educations
        driver.get(baseUrl + "/CV/Experiences");
        Thread.sleep(1000);
        // Click Edit button
        driver.findElement(By.linkText("Item №1 Tittel")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("FromDate")).clear();
        driver.findElement(By.id("FromDate")).sendKeys("15.03.2014");
        driver.findElement(By.id("ToDate")).clear();
        driver.findElement(By.id("ToDate")).sendKeys("19.07.2014");
        driver.findElement(By.id("Title")).clear();
        driver.findElement(By.id("Title")).sendKeys("Edit Item №1 Tittel");
        driver.findElement(By.id("Activity")).clear();
        driver.findElement(By.id("Activity")).sendKeys("Edit Test Organisasjon");
        driver.findElement(By.id("Description")).clear();
        driver.findElement(By.id("Description")).sendKeys("Edit Tests1 information Beskrivelse");
        driver.findElement(By.xpath("//div[2]/div/ul")).click();
        driver.findElement(By.xpath("//div[2]/div/div/ul/li[8]")).click();
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(1000);
        // Assert not save changes
        assertEquals(driver.findElement(By.id("FromDate")).getAttribute("value"), "10.02.2014");
        assertEquals(driver.findElement(By.id("ToDate")).getAttribute("value"), "12.12.2014");
        assertEquals(driver.findElement(By.id("Title")).getAttribute("value"), "Item №1 Tittel");
        assertEquals(driver.findElement(By.id("Activity")).getAttribute("value"), "Test Organisasjon");
        assertEquals(driver.findElement(By.id("Description")).getAttribute("value"), "Tests1 information Beskrivelse");
        assertEquals(driver.findElement(By.cssSelector("li.search-choice > span")).getText(), "Bergen");
    }
    @Test(priority = 4)
    public void EditItemAndCancel() throws Exception {
        // Go to Educations
        driver.get(baseUrl + "/CV/Experiences");
        Thread.sleep(1000);
        // Click Edit button
        driver.findElement(By.linkText("Item №1 Tittel")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("FromDate")).clear();
        driver.findElement(By.id("FromDate")).sendKeys("15.03.2014");
        driver.findElement(By.id("ToDate")).clear();
        driver.findElement(By.id("ToDate")).sendKeys("19.07.2014");
        driver.findElement(By.id("Title")).clear();
        driver.findElement(By.id("Title")).sendKeys("Edit Item №1 Tittel");
        driver.findElement(By.id("Activity")).clear();
        driver.findElement(By.id("Activity")).sendKeys("Edit Test Organisasjon");
        driver.findElement(By.id("Description")).clear();
        driver.findElement(By.id("Description")).sendKeys("Edit Tests1 information Beskrivelse");
        driver.findElement(By.xpath("//div[2]/div/ul")).click();
        driver.findElement(By.xpath("//div[2]/div/div/ul/li[8]")).click();
        driver.findElement(By.linkText("Avbryt")).click();
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(1000);
        // Click Edit button
        driver.findElement(By.linkText("Item №1 Tittel")).click();
        Thread.sleep(1000);
        // Assert not save changes
        assertEquals(driver.findElement(By.id("FromDate")).getAttribute("value"), "10.02.2014");
        assertEquals(driver.findElement(By.id("ToDate")).getAttribute("value"), "12.12.2014");
        assertEquals(driver.findElement(By.id("Title")).getAttribute("value"), "Item №1 Tittel");
        assertEquals(driver.findElement(By.id("Activity")).getAttribute("value"), "Test Organisasjon");
        assertEquals(driver.findElement(By.id("Description")).getAttribute("value"), "Tests1 information Beskrivelse");
        assertEquals(driver.findElement(By.cssSelector("li.search-choice > span")).getText(), "Bergen");
    }
    @Test(priority = 5)
    public void EditItem() throws Exception {
        // Go to Educations
        driver.get(baseUrl + "/CV/Experiences");
        Thread.sleep(1000);
        // Click Edit button
        driver.findElement(By.linkText("Item №1 Tittel")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("FromDate")).clear();
        driver.findElement(By.id("FromDate")).sendKeys("15.03.2014");
        driver.findElement(By.id("ToDate")).clear();
        driver.findElement(By.id("ToDate")).sendKeys("19.07.2014");
        driver.findElement(By.id("Title")).clear();
        driver.findElement(By.id("Title")).sendKeys("Edit Item №1 Tittel");
        driver.findElement(By.id("Activity")).clear();
        driver.findElement(By.id("Activity")).sendKeys("Edit Test Organisasjon");
        driver.findElement(By.id("Description")).clear();
        driver.findElement(By.id("Description")).sendKeys("Edit Tests1 information Beskrivelse");
        driver.findElement(By.xpath("//div[2]/div/ul")).click();
        driver.findElement(By.xpath("//div[2]/div/div/ul/li[8]")).click();
        driver.findElement(By.id("submit")).click();
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(1000);
        // Click Edit button
        driver.findElement(By.linkText("Edit Item №1 Tittel")).click();
        Thread.sleep(1000);
        // Assert save changes
        assertEquals(driver.findElement(By.id("FromDate")).getAttribute("value"), "15.03.2014");
        assertEquals(driver.findElement(By.id("ToDate")).getAttribute("value"), "19.07.2014");
        assertEquals(driver.findElement(By.id("Title")).getAttribute("value"), "Edit Item №1 Tittel");
        assertEquals(driver.findElement(By.id("Activity")).getAttribute("value"), "Edit Test Organisasjon");
        assertEquals(driver.findElement(By.id("Description")).getAttribute("value"), "Edit Tests1 information Beskrivelse");
        assertEquals(driver.findElement(By.xpath("//li[2]/span")).getText(), "Tromsø");
    }
}