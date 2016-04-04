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

public class FMoveEditDeleteItemArbeid extends TestBaseCV {
    @Test(priority = 1)
    public void MoveItems() throws Exception {
        // Go to Arbeid
        driver.get(baseUrl + "/CV/JobList");
        Thread.sleep(1000);
        // Check Correct position items
        assertTrue(driver.findElement(By.xpath("//div[2]/div/div[2]/a")).getText().contains("Home"));
        assertTrue(driver.findElement(By.xpath("//div[2]/div[2]/a")).getText().contains("Freelance"));
        assertTrue(driver.findElement(By.xpath("//div[3]/div[2]/a")).getText().contains("Work"));
        // Move Work to first Position
        WebElement draggable = driver.findElement(By.xpath("//div[3]/div[3]/ul/li"));
        Actions builder = new Actions(driver);
        builder.dragAndDropBy(draggable, 0, -120).build().perform();
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(1000);
        assertTrue(driver.findElement(By.xpath("//div[2]/div/div[2]/a")).getText().contains("Work"));
        assertTrue(driver.findElement(By.xpath("//div[2]/div[2]/a")).getText().contains("Home"));
        assertTrue(driver.findElement(By.xpath("//div[3]/div[2]/a")).getText().contains("Freelance"));
        // Move Home to third position
        WebElement draggable2 = driver.findElement(By.xpath("//div[2]/div[3]/ul/li"));
        Actions builder2 = new Actions(driver);
        builder.dragAndDropBy(draggable2, 0, +60).build().perform();
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(1000);
        assertTrue(driver.findElement(By.xpath("//div[2]/div/div[2]/a")).getText().contains("Work"));
        assertTrue(driver.findElement(By.xpath("//div[2]/div[2]/a")).getText().contains("Freelance"));
        assertTrue(driver.findElement(By.xpath("//div[3]/div[2]/a")).getText().contains("Home"));
    }
    @Test(priority = 2)
    public void DeleteItem() throws Exception {
        // Go to Arbeid
        driver.get(baseUrl + "/CV/JobList");
        Thread.sleep(1000);
        // Check Correct position items
        assertTrue(driver.findElement(By.xpath("//div[2]/div/div[2]/a")).getText().contains("Work"));
        assertTrue(driver.findElement(By.xpath("//div[2]/div[2]/a")).getText().contains("Freelance"));
        assertTrue(driver.findElement(By.xpath("//div[3]/div[2]/a")).getText().contains("Home"));
        driver.findElement(By.xpath("//a[contains(text(),'Freelance , Krepro')]"));
        // Delete Item Freelance
        driver.findElement(By.xpath("//div[2]/div[3]/ul/li[3]/a")).click();
        driver.findElement(By.xpath("//*[@id='cbRemove_cnt']/div[1]/div[3]/div/button[1]")).click();
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(1000);
        Assert.assertEquals(0, driver.findElements(By.xpath("//a[contains(text(),'Freelance , Krepro')]")).size());
    }
    @Test(priority = 3)
    public void EditItemAndRefreshPage() throws Exception {
        // Go to Arbeid
        driver.get(baseUrl + "/CV/JobList");
        Thread.sleep(1000);
        // Click Edit button
        driver.findElement(By.linkText("Work , Gassco")).click();
        Thread.sleep(1000);
        // Type Fra
        driver.findElement(By.id("FromDate")).clear();
        driver.findElement(By.id("FromDate")).sendKeys("06.07.2009");
        // Type Til
        driver.findElement(By.id("ToDate")).clear();
        driver.findElement(By.id("ToDate")).sendKeys("08.08.2012");
        // Type Tittel
        driver.findElement(By.id("Title")).clear();
        driver.findElement(By.id("Title")).sendKeys("School");
        // Type Beskrivelse av stillingen
        driver.findElement(By.id("Description")).clear();
        driver.findElement(By.id("Description")).sendKeys("Edit test information for first item!");
        // Type Arbeidsgiver
        driver.findElement(By.id("Employer")).clear();
        driver.findElement(By.id("Employer")).sendKeys("Hydroenergi");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//ul[@id='ui-id-1']/li")).click();
        // Chose Bransje - Helsesektor
        driver.findElement(By.xpath("//*[@id='SelectedIndustry_chosen']/ul")).click();
        driver.findElement(By.xpath("//*[@id='SelectedIndustry_chosen']/div/ul/li[11]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Chose Stillingstype - Internship
        driver.findElement(By.xpath("//*[@id='SelectedEmploymentTypes_chosen']/ul")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='SelectedEmploymentTypes_chosen']/div/ul/li[7]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Chose Fagområde - Hotell- og reiselivsfag
        driver.findElement(By.xpath("//*[@id='SelectedSubjects_chosen']/ul")).click();
        driver.findElement(By.xpath("//*[@id='SelectedSubjects_chosen']/div/ul/li[4]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Chose Yrker - Dekoratør
        driver.findElement(By.xpath("//*[@id='SelectedProfessions_chosen']/ul")).click();
        driver.findElement(By.xpath("//*[@id='SelectedProfessions_chosen']/div/ul/li[10]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Chose Sted - Aremark
        driver.findElement(By.xpath("//*[@id='SelectedLocations_chosen']/ul")).click();
        driver.findElement(By.xpath("//*[@id='SelectedLocations_chosen']/div/ul/li[27]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(1000);
        // Assert not save changes
        assertNotEquals(driver.findElement(By.id("FromDate")).getAttribute("value"), "06.07.2009");
        assertNotEquals(driver.findElement(By.id("ToDate")).getAttribute("value"), "08.08.2012");
        assertNotEquals(driver.findElement(By.id("Title")).getAttribute("value"), "School");
        assertNotEquals(driver.findElement(By.id("Employer")).getAttribute("value"), "Hydroenergi");
        assertNotEquals(driver.findElement(By.id("Description")).getAttribute("value"), "Edit test information for first item!");
        assertFalse(driver.findElement(By.xpath("//div[2]/div/ul")).getText().contains("Helsesektor"));
        assertFalse(driver.findElement(By.xpath("//div[9]/div[2]/div/ul")).getText().contains("Internship"));
        assertFalse(driver.findElement(By.xpath("//div[10]/div[2]/div/ul")).getText().contains("Hotell- og reiselivsfag"));
        assertFalse(driver.findElement(By.xpath("//div[11]/div[2]/div/ul")).getText().contains("Dekoratør"));
        assertFalse(driver.findElement(By.xpath("//div[12]/div[2]/div/ul")).getText().contains("Aremark"));
    }
    @Test(priority = 4)
    public void EditItemAndCancel() throws Exception {
        // Go to Arbeid
        driver.get(baseUrl + "/CV/JobList");
        Thread.sleep(1000);
        // Click Edit button
        driver.findElement(By.linkText("Work , Gassco")).click();
        Thread.sleep(1000);
        // Type Fra
        driver.findElement(By.id("FromDate")).clear();
        driver.findElement(By.id("FromDate")).sendKeys("06.07.2009");
        // Type Til
        driver.findElement(By.id("ToDate")).clear();
        driver.findElement(By.id("ToDate")).sendKeys("08.08.2012");
        // Type Tittel
        driver.findElement(By.id("Title")).clear();
        driver.findElement(By.id("Title")).sendKeys("School");
        // Type Beskrivelse av stillingen
        driver.findElement(By.id("Description")).clear();
        driver.findElement(By.id("Description")).sendKeys("Edit test information for first item!");
        // Type Arbeidsgiver
        driver.findElement(By.id("Employer")).clear();
        driver.findElement(By.id("Employer")).sendKeys("Hydroenergi");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//ul[@id='ui-id-1']/li")).click();
        // Chose Bransje - Helsesektor
        driver.findElement(By.xpath("//*[@id='SelectedIndustry_chosen']/ul")).click();
        driver.findElement(By.xpath("//*[@id='SelectedIndustry_chosen']/div/ul/li[11]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Chose Stillingstype - Internship
        driver.findElement(By.xpath("//*[@id='SelectedEmploymentTypes_chosen']/ul")).click();
        driver.findElement(By.xpath("//*[@id='SelectedEmploymentTypes_chosen']/div/ul/li[7]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Chose Fagområde - Hotell- og reiselivsfag
        driver.findElement(By.xpath("//*[@id='SelectedSubjects_chosen']/ul")).click();
        driver.findElement(By.xpath("//*[@id='SelectedSubjects_chosen']/div/ul/li[4]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Chose Yrker - Dekoratør
        driver.findElement(By.xpath("//*[@id='SelectedProfessions_chosen']/ul")).click();
        driver.findElement(By.xpath("//*[@id='SelectedProfessions_chosen']/div/ul/li[10]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Chose Sted - Aremark
        driver.findElement(By.xpath("//*[@id='SelectedLocations_chosen']/ul")).click();
        driver.findElement(By.xpath("//*[@id='SelectedLocations_chosen']/div/ul/li[27]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.linkText("Avbryt")).click();
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(1000);
        // Click Edit button
        driver.findElement(By.linkText("Work , Gassco")).click();
        Thread.sleep(1000);
        // Assert not save changes
        assertNotEquals(driver.findElement(By.id("FromDate")).getAttribute("value"), "06.07.2009");
        assertNotEquals(driver.findElement(By.id("ToDate")).getAttribute("value"), "08.08.2012");
        assertNotEquals(driver.findElement(By.id("Title")).getAttribute("value"), "School");
        assertNotEquals(driver.findElement(By.id("Employer")).getAttribute("value"), "Hydroenergi");
        assertNotEquals(driver.findElement(By.id("Description")).getAttribute("value"), "Edit test information for first item!");
        assertFalse(driver.findElement(By.xpath("//div[2]/div/ul")).getText().contains("Helsesektor"));
        assertFalse(driver.findElement(By.xpath("//div[9]/div[2]/div/ul")).getText().contains("Internship"));
        assertFalse(driver.findElement(By.xpath("//div[10]/div[2]/div/ul")).getText().contains("Hotell- og reiselivsfag"));
        assertFalse(driver.findElement(By.xpath("//div[11]/div[2]/div/ul")).getText().contains("Dekoratør"));
        assertFalse(driver.findElement(By.xpath("//div[12]/div[2]/div/ul")).getText().contains("Aremark"));
    }


    @Test(priority = 5)
    public void EditItem() throws Exception {
        // Go to Arbeid
        driver.get(baseUrl + "/CV/JobList");
        Thread.sleep(1000);
        // Click Edit button
        driver.findElement(By.linkText("Work , Gassco")).click();
        Thread.sleep(1000);
        // Type Fra
        driver.findElement(By.id("FromDate")).clear();
        driver.findElement(By.id("FromDate")).sendKeys("06.07.2009");
        // Type Til
        driver.findElement(By.id("ToDate")).clear();
        driver.findElement(By.id("ToDate")).sendKeys("08.08.2012");
        // Type Tittel
        driver.findElement(By.id("Title")).clear();
        driver.findElement(By.id("Title")).sendKeys("School");
        // Type Beskrivelse av stillingen
        driver.findElement(By.id("Description")).clear();
        driver.findElement(By.id("Description")).sendKeys("Edit test information for first item!");
        // Type Arbeidsgiver
        driver.findElement(By.id("Employer")).clear();
        driver.findElement(By.id("Employer")).sendKeys("Hydroenergi");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//ul[@id='ui-id-1']/li")).click();
        // Chose Bransje - Helsesektor
        driver.findElement(By.xpath("//*[@id='SelectedIndustry_chosen']/ul")).click();
        driver.findElement(By.xpath("//*[@id='SelectedIndustry_chosen']/div/ul/li[11]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Chose Stillingstype - Internship
        driver.findElement(By.xpath("//*[@id='SelectedEmploymentTypes_chosen']/ul")).click();
        driver.findElement(By.xpath("//*[@id='SelectedEmploymentTypes_chosen']/div/ul/li[7]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Chose Fagområde - Hotell- og reiselivsfag
        driver.findElement(By.xpath("//*[@id='SelectedSubjects_chosen']/ul")).click();
        driver.findElement(By.xpath("//*[@id='SelectedSubjects_chosen']/div/ul/li[4]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Chose Yrker - Dekoratør
        driver.findElement(By.xpath("//*[@id='SelectedProfessions_chosen']/ul")).click();
        driver.findElement(By.xpath("//*[@id='SelectedProfessions_chosen']/div/ul/li[10]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Chose Sted - Aremark
        driver.findElement(By.xpath("//*[@id='SelectedLocations_chosen']/ul")).click();
        driver.findElement(By.xpath("//*[@id='SelectedLocations_chosen']/div/ul/li[27]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(1000);
        // Click Edit button
        driver.findElement(By.linkText("School , Hydroenergi")).click();
        Thread.sleep(1000);
        // Assert save changes
        assertEquals(driver.findElement(By.id("FromDate")).getAttribute("value"), "06.07.2009");
        assertEquals(driver.findElement(By.id("ToDate")).getAttribute("value"), "08.08.2012");
        assertEquals(driver.findElement(By.id("Title")).getAttribute("value"), "School");
        assertEquals(driver.findElement(By.id("Employer")).getAttribute("value"), "Hydroenergi");
        assertEquals(driver.findElement(By.id("Description")).getAttribute("value"), "Edit test information for first item!");
        assertTrue(driver.findElement(By.xpath("//div[2]/div/ul")).getText().contains("Helsesektor"));
        assertTrue(driver.findElement(By.xpath("//div[9]/div[2]/div/ul")).getText().contains("Internship"));
        assertTrue(driver.findElement(By.xpath("//div[10]/div[2]/div/ul")).getText().contains("Hotell- og reiselivsfag"));
        assertTrue(driver.findElement(By.xpath("//div[11]/div[2]/div/ul")).getText().contains("Dekoratør"));
        assertTrue(driver.findElement(By.xpath("//div[12]/div[2]/div/ul")).getText().contains("Aremark"));
    }
}