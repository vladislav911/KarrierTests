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

public class HSave3ItemsUtdanning extends TestBaseCV {
    @Test(priority = 1)
    public void Save1ItemWithDatoFor() throws Exception {
        // Go to Utdatinng
        driver.get(baseUrl + "/CV/Educations");
        Thread.sleep(2000);
        // Click Legg til ny button
        driver.findElement(By.linkText("Legg til ny")).click();
        // Type Fra
        driver.findElement(By.id("FromDate")).clear();
        driver.findElement(By.id("FromDate")).sendKeys("13.11.2011");
        // Type Dato for uteksaminering
        driver.findElement(By.id("ToDate")).clear();
        driver.findElement(By.id("ToDate")).sendKeys("23.04.2013");
        // Type
        driver.findElement(By.id("Description")).clear();
        driver.findElement(By.id("Description")).sendKeys("Test info Beskrivelse");
        driver.findElement(By.id("DegreeDescription")).clear();
        driver.findElement(By.id("DegreeDescription")).sendKeys("Test info Beskrivelse av oppnådde resultater");
        // Type Studie
        driver.findElement(By.id("Title")).clear();
        driver.findElement(By.id("Title")).sendKeys(".NET UTVIKLER");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//ul[@id='ui-id-1']/li")).click();
        // Type Sted eller land - Oslo
        driver.findElement(By.xpath("//div[@id='SchoolCountryId_chosen']/a")).click();
        driver.findElement(By.xpath("//div[@id='SchoolCountryId_chosen']/div/ul/li[2]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Type Skoletype - Universitet/Hogskole
        driver.findElement(By.xpath("//div[@id='SchoolType_chosen']/a")).click();
        driver.findElement(By.xpath("//div[@id='SchoolType_chosen']/div/ul/li")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Type Skole - Apo Melbu
        driver.findElement(By.xpath("//div[@id='SchoolId_chosen']/a")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.xpath("//div[@id='SchoolId_chosen']/div/ul/li[5]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Type Fagområde - Jus
        driver.findElement(By.xpath("//div[@id='Speciality_chosen']/ul")).click();
        driver.findElement(By.xpath("//div[@id='Speciality_chosen']/div/ul/li[7]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Type Karakternivå - Top 20
        driver.findElement(By.xpath("//div[@id='Rating_chosen']/a")).click();
        driver.findElement(By.xpath("//div[@id='Rating_chosen']/div/ul/li[3]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Type Type grad - Kandidate
        driver.findElement(By.xpath("//div[@id='GraduationType_chosen']/a")).click();
        driver.findElement(By.xpath("//div[@id='GraduationType_chosen']/div/ul/li[3]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        Thread.sleep(2000);
        driver.findElement(By.id("submit")).click();
        waitForElementPresent(By.xpath("//div[2]/div[2]/div/div/div/div[2]/div"));
    }
    @Test(priority = 2)
    public void Save2ItemWithoutDatoFor() throws Exception {
        // Go to Utdatinng
        driver.get(baseUrl + "/CV/Educations");
        Thread.sleep(1000);
        // Click Legg til ny button
        driver.findElement(By.xpath("//div[@id='wizard-step']/div[2]/div/div/div/div/div/a/i")).click();
        Thread.sleep(1000);
        // Type Fra
        driver.findElement(By.id("FromDate")).clear();
        driver.findElement(By.id("FromDate")).sendKeys("10.11.2011");
        // Type
        driver.findElement(By.id("Description")).clear();
        driver.findElement(By.id("Description")).sendKeys("Test info Beskrivelse");
        driver.findElement(By.id("DegreeDescription")).clear();
        driver.findElement(By.id("DegreeDescription")).sendKeys("Test info Beskrivelse av oppnådde resultater");
        // Delete Dato
        driver.findElement(By.cssSelector(".checkbox-label>span")).click();
        // Type Studie
        driver.findElement(By.id("Title")).clear();
        driver.findElement(By.id("Title")).sendKeys("KOST OG");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//ul[@id='ui-id-1']/li")).click();
        // Type Sted eller land - Stavanger
        driver.findElement(By.xpath("//div[@id='SchoolCountryId_chosen']/a")).click();
        driver.findElement(By.xpath("//div[@id='SchoolCountryId_chosen']/div/ul/li[5]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Type Skoletype - Ungdomsskole
        driver.findElement(By.xpath("//div[@id='SchoolType_chosen']/a")).click();
        driver.findElement(By.xpath("//*[@id='SchoolType_chosen']/div/ul/li[3]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Type Skole - Al Folkeh
        driver.findElement(By.xpath("//div[@id='SchoolId_chosen']/a")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.xpath(".//*[@id='SchoolId_chosen']/div/ul/li[2]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.id("SchoolName")).clear();
        driver.findElement(By.id("SchoolName")).sendKeys("Test skole");
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Type Fagområde - Hotel
        driver.findElement(By.xpath("//div[@id='Speciality_chosen']/ul")).click();
        driver.findElement(By.xpath("//div[@id='Speciality_chosen']/div/ul/li[4]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Type Karakternivå - Top 50
        driver.findElement(By.xpath("//div[@id='Rating_chosen']/a")).click();
        driver.findElement(By.xpath("//div[@id='Rating_chosen']/div/ul/li[6]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Type Type grad - Bachelor
        driver.findElement(By.xpath("//div[@id='GraduationType_chosen']/a")).click();
        driver.findElement(By.xpath("//div[@id='GraduationType_chosen']/div/ul/li[4]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        Thread.sleep(2000);
        driver.findElement(By.id("submit")).click();
        waitForElementPresent(By.xpath("//div[2]/div/div/div/div[2]/div[2]"));
    }
    @Test(priority = 3)
    public void Save3ItemWithoutDatoFor() throws Exception {
        // Go to Utdatinng
        driver.get(baseUrl + "/CV/Educations");
        Thread.sleep(1000);
        // Click Legg til ny button
        driver.findElement(By.xpath("//div[@id='wizard-step']/div[2]/div/div/div/div/div/a/i")).click();
        Thread.sleep(1000);
        // Type Fra
        driver.findElement(By.id("FromDate")).clear();
        driver.findElement(By.id("FromDate")).sendKeys("10.11.2011");
        // Type
        driver.findElement(By.id("Description")).clear();
        driver.findElement(By.id("Description")).sendKeys("Test info Beskrivelse");
        driver.findElement(By.id("DegreeDescription")).clear();
        driver.findElement(By.id("DegreeDescription")).sendKeys("Test info Beskrivelse av oppnådde resultater");
        // Delete Dato
        driver.findElement(By.cssSelector(".checkbox-label>span")).click();
        // Type Studie
        driver.findElement(By.id("Title")).clear();
        driver.findElement(By.id("Title")).sendKeys("BIBELOVER");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//ul[@id='ui-id-1']/li")).click();
        // Type Sted eller land - Stavanger
        driver.findElement(By.xpath("//div[@id='SchoolCountryId_chosen']/a")).click();
        driver.findElement(By.xpath("//div[@id='SchoolCountryId_chosen']/div/ul/li[5]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Type Skoletype - Ungdomsskole
        driver.findElement(By.xpath("//div[@id='SchoolType_chosen']/a")).click();
        driver.findElement(By.xpath("//*[@id='SchoolType_chosen']/div/ul/li[3]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Type Skole - Al Folkeh
        driver.findElement(By.xpath("//div[@id='SchoolId_chosen']/a")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.xpath(".//*[@id='SchoolId_chosen']/div/ul/li[2]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.id("SchoolName")).clear();
        driver.findElement(By.id("SchoolName")).sendKeys("Test skole");
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Type Fagområde - Hotel
        driver.findElement(By.xpath("//div[@id='Speciality_chosen']/ul")).click();
        driver.findElement(By.xpath("//div[@id='Speciality_chosen']/div/ul/li[4]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Type Karakternivå - Top 50
        driver.findElement(By.xpath("//div[@id='Rating_chosen']/a")).click();
        driver.findElement(By.xpath("//div[@id='Rating_chosen']/div/ul/li[6]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Type Type grad - Bachelor
        driver.findElement(By.xpath("//div[@id='GraduationType_chosen']/a")).click();
        driver.findElement(By.xpath("//div[@id='GraduationType_chosen']/div/ul/li[4]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        Thread.sleep(2000);
        driver.findElement(By.id("submit")).click();
        waitForElementPresent(By.xpath("//div[2]/div/div/div/div[2]/div[3]"));
    }
    @Test(priority = 4)
    public void AssertSave1Item() throws Exception {
        // Go to Utdatinng
        driver.get(baseUrl + "/CV/Educations");
        Thread.sleep(1000);
        // Assert 3 Items Saved
        assertEquals(driver.findElement(By.cssSelector("div.t-title")).getText(), "3 registrerte utdanninger");
        // Open First Item
        driver.findElement(By.linkText(".NET UTVIKLER fagskoleutdanning (Informasjonsteknologi / informatikk), Universitetet for Miljø- og biovitenskap")).click();
        Thread.sleep(1000);
        // Verify Data Save
        assertEquals(driver.findElement(By.id("FromDate")).getAttribute("value"), "13.11.2011");
        assertEquals(driver.findElement(By.id("ToDate")).getAttribute("value"), "23.04.2013");
        assertEquals(driver.findElement(By.id("Title")).getAttribute("value"), ".NET UTVIKLER fagskoleutdanning (Informasjonsteknologi / informatikk)");
        assertEquals(driver.findElement(By.cssSelector("a.chosen-single > span")).getText(), "Oslo");
        assertEquals(driver.findElement(By.cssSelector("#SchoolType_chosen > a.chosen-single > span")).getText(), "Universitet / Høgskole");
        assertEquals(driver.findElement(By.cssSelector("a.chosen-single.chosen-single-with-deselect > span")).getText(), "Universitetet for Miljø- og biovitenskap");
        assertEquals(driver.findElement(By.cssSelector("li.search-choice > span")).getText(), "Jus");
        assertEquals(driver.findElement(By.id("Description")).getAttribute("value"), "Test info Beskrivelse");
        assertEquals(driver.findElement(By.cssSelector("#GraduationType_chosen > a.chosen-single > span")).getText(), "Kandidat");
        assertEquals(driver.findElement(By.id("DegreeDescription")).getAttribute("value"), "Test info Beskrivelse av oppnådde resultater");
        assertEquals(driver.findElement(By.cssSelector("#Rating_chosen > a.chosen-single > span")).getText(), "Topp 20%");
    }
    @Test(priority = 5)
    public void AssertSave2Item() throws Exception {
        // Go to Utdatinng
        driver.get(baseUrl + "/CV/Educations");
        Thread.sleep(1000);
        // Open Second Item
        driver.findElement(By.linkText("KOST OG ERNÆRING andre grader/kurs (Medisin, odontologi, helse- og sosialfag), Test skole")).click();
        Thread.sleep(1000);
        // Verify Data Save
        WebElement TilField = driver.findElement(By.id("ToDate"));
        Assert.assertEquals(false, TilField.isDisplayed());
        assertEquals(driver.findElement(By.id("FromDate")).getAttribute("value"), "10.11.2011");
        assertEquals(driver.findElement(By.id("Title")).getAttribute("value"), "KOST OG ERNÆRING andre grader/kurs (Medisin, odontologi, helse- og sosialfag)");
        assertEquals(driver.findElement(By.cssSelector("a.chosen-single > span")).getText(), "Stavanger");
        assertEquals(driver.findElement(By.cssSelector("#SchoolType_chosen > a.chosen-single > span")).getText(), "Ungdomsskole");
        driver.findElement(By.cssSelector("div.row.school-name > div.field-sec.focus-bg-white")).click();
        assertEquals(driver.findElement(By.id("SchoolName")).getAttribute("value"), "Test skole");
        assertEquals(driver.findElement(By.cssSelector("li.search-choice > span")).getText(), "Hotell- og reiselivsfag");
        assertEquals(driver.findElement(By.id("Description")).getAttribute("value"), "Test info Beskrivelse");
        assertEquals(driver.findElement(By.cssSelector("#GraduationType_chosen > a.chosen-single > span")).getText(), "Bachelor");
        assertEquals(driver.findElement(By.id("DegreeDescription")).getAttribute("value"), "Test info Beskrivelse av oppnådde resultater");
        assertEquals(driver.findElement(By.cssSelector("#Rating_chosen > a.chosen-single > span")).getText(), "Topp 50%");
    }
}