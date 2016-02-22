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

public class IMoveEditDeleteItemUtdanning extends TestBaseCV {
    @Test(priority = 1)
    public void MoveItems() throws Exception {
        // Go to Arbeid
        driver.get(baseUrl + "/CV/Educations");
        Thread.sleep(1000);
        // Check Correct position items
        assertTrue(driver.findElement(By.xpath("//div[2]/div/div[2]/a")).getText().contains("KOST"));
        assertTrue(driver.findElement(By.xpath("//div[2]/div[2]/a")).getText().contains("BIBELOVERSETTELSE"));
        assertTrue(driver.findElement(By.xpath("//div[3]/div[2]/a")).getText().contains(".NET"));
        // Move .NET to first Position
        WebElement draggable = driver.findElement(By.xpath("//div[3]/div[3]/ul/li"));
        Actions builder = new Actions(driver);
        builder.dragAndDropBy(draggable, 0, -150).build().perform();
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(1000);
        assertTrue(driver.findElement(By.xpath("//div[2]/div/div[2]/a")).getText().contains(".NET"));
        assertTrue(driver.findElement(By.xpath("//div[2]/div[2]/a")).getText().contains("KOST"));
        assertTrue(driver.findElement(By.xpath("//div[3]/div[2]/a")).getText().contains("BIBELOVERSETTELSE"));
        // Move KOST to third position
        WebElement draggable2 = driver.findElement(By.xpath("//div[2]/div[3]/ul/li"));
        Actions builder2 = new Actions(driver);
        builder.dragAndDropBy(draggable2, 0, +100).build().perform();
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(1000);
        assertTrue(driver.findElement(By.xpath("//div[2]/div/div[2]/a")).getText().contains(".NET"));
        assertTrue(driver.findElement(By.xpath("//div[2]/div[2]/a")).getText().contains("BIBELOVERSETTELSE"));
        assertTrue(driver.findElement(By.xpath("//div[3]/div[2]/a")).getText().contains("KOST"));
    }

    @Test(priority = 2)
    public void DeleteItem() throws Exception {
        // Go to Arbeid
        driver.get(baseUrl + "/CV/Educations");
        Thread.sleep(1000);
        // Check Correct position items
        assertTrue(driver.findElement(By.xpath("//div[2]/div/div[2]/a")).getText().contains(".NET"));
        assertTrue(driver.findElement(By.xpath("//div[2]/div[2]/a")).getText().contains("BIBELOVERSETTELSE"));
        assertTrue(driver.findElement(By.xpath("//div[3]/div[2]/a")).getText().contains("KOST"));
        driver.findElement(By.xpath("//a[contains(text(),'BIBELOVERSETTELSE bachelor (Historie, religion, idéfag), Test skole')]"));
        // Delete Item BIBELOVERSETTELSE
        driver.findElement(By.xpath("//div[2]/div[3]/ul/li[3]/a")).click();
        driver.findElement(By.linkText("Ja")).click();
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(1000);
        Assert.assertEquals(0, driver.findElements(By.xpath("//a[contains(text(),'BIBELOVERSETTELSE bachelor (Historie, religion, idéfag), Test skole')]")).size());
    }

    @Test(priority = 3)
    public void EditItemAndRefreshPage() throws Exception {
        // Go to Educations
        driver.get(baseUrl + "/CV/Educations");
        Thread.sleep(1000);
        // Click Edit button
        driver.findElement(By.linkText(".NET UTVIKLER fagskoleutdanning (Informasjonsteknologi / informatikk), Universitetet for Miljø- og biovitenskap")).click();
        Thread.sleep(1000);
        // Type Fra
        driver.findElement(By.id("FromDate")).clear();
        driver.findElement(By.id("FromDate")).sendKeys("15.12.2011");
        // Type Dato for uteksaminering
        driver.findElement(By.id("ToDate")).clear();
        driver.findElement(By.id("ToDate")).sendKeys("25.02.2013");
        // Type
        driver.findElement(By.id("Description")).clear();
        driver.findElement(By.id("Description")).sendKeys("Edit Test info Beskrivelse");
        driver.findElement(By.id("DegreeDescription")).clear();
        driver.findElement(By.id("DegreeDescription")).sendKeys("Edit Test info Beskrivelse av oppnådde resultater");
        // Type Studie
        driver.findElement(By.id("Title")).clear();
        driver.findElement(By.id("Title")).sendKeys("AIKIDO");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//ul[@id='ui-id-1']/li")).click();
        // Type Sted eller land - Kristiansand
        driver.findElement(By.xpath("//div[@id='SchoolCountryId_chosen']/a")).click();
        driver.findElement(By.xpath("//div[@id='SchoolCountryId_chosen']/div/ul/li[7]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Type Skoletype - Ungdomsskole
        driver.findElement(By.xpath("//div[@id='SchoolType_chosen']/a")).click();
        driver.findElement(By.xpath("//*[@id='SchoolType_chosen']/div/ul/li[3]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Type Skole - Bakketun Folkehøgskole
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='SchoolId_chosen']/a")).click();
        driver.findElement(By.xpath("//div[@id='SchoolId_chosen']/div/ul/li[8]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Type Fagområde - Informasjonsteknologi
        driver.findElement(By.xpath("//div[@id='Speciality_chosen']/ul")).click();
        driver.findElement(By.xpath("//div[@id='Speciality_chosen']/div/ul/li[6]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Type Karakternivå - Top 40
        driver.findElement(By.xpath("//div[@id='Rating_chosen']/a")).click();
        driver.findElement(By.xpath("//div[@id='Rating_chosen']/div/ul/li[5]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Type Type grad - Master of Science
        driver.findElement(By.xpath("//div[@id='GraduationType_chosen']/a")).click();
        driver.findElement(By.xpath("//div[@id='GraduationType_chosen']/div/ul/li[5]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(1000);
        // Assert not save changes
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

    @Test(priority = 4)
    public void EditItemAndCancel() throws Exception {
        // Go to Educations
        driver.get(baseUrl + "/CV/Educations");
        Thread.sleep(1000);
        // Click Edit button
        driver.findElement(By.linkText(".NET UTVIKLER fagskoleutdanning (Informasjonsteknologi / informatikk), Universitetet for Miljø- og biovitenskap")).click();
        Thread.sleep(1000);
        // Type Fra
        driver.findElement(By.id("FromDate")).clear();
        driver.findElement(By.id("FromDate")).sendKeys("15.12.2011");
        // Type Dato for uteksaminering
        driver.findElement(By.id("ToDate")).clear();
        driver.findElement(By.id("ToDate")).sendKeys("25.02.2013");
        // Type
        driver.findElement(By.id("Description")).clear();
        driver.findElement(By.id("Description")).sendKeys("Edit Test info Beskrivelse");
        driver.findElement(By.id("DegreeDescription")).clear();
        driver.findElement(By.id("DegreeDescription")).sendKeys("Edit Test info Beskrivelse av oppnådde resultater");
        // Type Studie
        driver.findElement(By.id("Title")).clear();
        driver.findElement(By.id("Title")).sendKeys("AIKIDO");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//ul[@id='ui-id-1']/li")).click();
        // Type Sted eller land - Kristiansand
        driver.findElement(By.xpath("//div[@id='SchoolCountryId_chosen']/a")).click();
        driver.findElement(By.xpath("//div[@id='SchoolCountryId_chosen']/div/ul/li[7]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Type Skoletype - Ungdomsskole
        driver.findElement(By.xpath("//div[@id='SchoolType_chosen']/a")).click();
        driver.findElement(By.xpath("//*[@id='SchoolType_chosen']/div/ul/li[3]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Type Skole - Bakketun Folkehøgskole
        driver.findElement(By.xpath("//div[@id='SchoolId_chosen']/a")).click();
        driver.findElement(By.xpath("//div[@id='SchoolId_chosen']/div/ul/li[8]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Type Fagområde - Informasjonsteknologi
        driver.findElement(By.xpath("//div[@id='Speciality_chosen']/ul")).click();
        driver.findElement(By.xpath("//div[@id='Speciality_chosen']/div/ul/li[6]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Type Karakternivå - Top 40
        driver.findElement(By.xpath("//div[@id='Rating_chosen']/a")).click();
        driver.findElement(By.xpath("//div[@id='Rating_chosen']/div/ul/li[5]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Type Type grad - Master of Science
        driver.findElement(By.xpath("//div[@id='GraduationType_chosen']/a")).click();
        driver.findElement(By.xpath("//div[@id='GraduationType_chosen']/div/ul/li[5]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.linkText("Avbryt")).click();
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(1000);
        // Click Edit button
        driver.findElement(By.linkText(".NET UTVIKLER fagskoleutdanning (Informasjonsteknologi / informatikk), Universitetet for Miljø- og biovitenskap")).click();
        Thread.sleep(1000);
        // Assert not save changes
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
    public void EditItem() throws Exception {
        // Go to Educations
        driver.get(baseUrl + "/CV/Educations");
        Thread.sleep(1000);
        // Click Edit button
        driver.findElement(By.linkText(".NET UTVIKLER fagskoleutdanning (Informasjonsteknologi / informatikk), Universitetet for Miljø- og biovitenskap")).click();
        Thread.sleep(1000);
        // Type Fra
        driver.findElement(By.id("FromDate")).clear();
        driver.findElement(By.id("FromDate")).sendKeys("15.12.2011");
        // Type Dato for uteksaminering
        driver.findElement(By.id("ToDate")).clear();
        driver.findElement(By.id("ToDate")).sendKeys("25.02.2013");
        // Type
        driver.findElement(By.id("Description")).clear();
        driver.findElement(By.id("Description")).sendKeys("Edit Test info Beskrivelse");
        driver.findElement(By.id("DegreeDescription")).clear();
        driver.findElement(By.id("DegreeDescription")).sendKeys("Edit Test info Beskrivelse av oppnådde resultater");
        // Type Studie
        driver.findElement(By.id("Title")).clear();
        driver.findElement(By.id("Title")).sendKeys("AIKIDO");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//ul[@id='ui-id-1']/li")).click();
        // Type Sted eller land - Kristiansand
        driver.findElement(By.xpath("//div[@id='SchoolCountryId_chosen']/a")).click();
        driver.findElement(By.xpath("//div[@id='SchoolCountryId_chosen']/div/ul/li[7]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Type Skoletype - Ungdomsskole
        driver.findElement(By.xpath("//div[@id='SchoolType_chosen']/a")).click();
        driver.findElement(By.xpath("//*[@id='SchoolType_chosen']/div/ul/li[3]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Type Skole - Bakketun Folkehøgskole
        driver.findElement(By.xpath("//div[@id='SchoolId_chosen']/a")).click();
        driver.findElement(By.xpath("//div[@id='SchoolId_chosen']/div/ul/li[8]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Type Fagområde - Informasjonsteknologi
        driver.findElement(By.xpath("//div[@id='Speciality_chosen']/ul")).click();
        driver.findElement(By.xpath("//div[@id='Speciality_chosen']/div/ul/li[6]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Type Karakternivå - Top 40
        driver.findElement(By.xpath("//div[@id='Rating_chosen']/a")).click();
        driver.findElement(By.xpath("//div[@id='Rating_chosen']/div/ul/li[5]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Type Type grad - Master of Science
        driver.findElement(By.xpath("//div[@id='GraduationType_chosen']/a")).click();
        driver.findElement(By.xpath("//div[@id='GraduationType_chosen']/div/ul/li[5]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        Thread.sleep(2000);
        driver.findElement(By.id("submit")).click();
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(1000);
        // Click Edit button
        driver.findElement(By.linkText("AIKIDO - ENERGI OG BEVISSTHET folkehøgskoleutdanning (Idrett, kroppsøving og friluftsliv), Bakketun Folkehøgskole")).click();
        Thread.sleep(1000);
        // Assert save changes
        assertEquals(driver.findElement(By.id("FromDate")).getAttribute("value"), "15.12.2011");
        assertEquals(driver.findElement(By.id("ToDate")).getAttribute("value"), "25.02.2013");
        assertEquals(driver.findElement(By.id("Title")).getAttribute("value"), "AIKIDO - ENERGI OG BEVISSTHET folkehøgskoleutdanning (Idrett, kroppsøving og friluftsliv)");
        assertEquals(driver.findElement(By.cssSelector("a.chosen-single > span")).getText(), "Kristiansand");
        assertEquals(driver.findElement(By.cssSelector("#SchoolType_chosen > a.chosen-single > span")).getText(), "Ungdomsskole");
        assertEquals(driver.findElement(By.cssSelector("a.chosen-single.chosen-single-with-deselect > span")).getText(), "Bakketun Folkehøgskole");
        assertEquals(driver.findElement(By.cssSelector("li.search-choice > span")).getText(), "Informasjonsteknologi / informatikk");
        assertEquals(driver.findElement(By.id("Description")).getAttribute("value"), "Edit Test info Beskrivelse");
        assertEquals(driver.findElement(By.cssSelector("#GraduationType_chosen > a.chosen-single > span")).getText(), "Master of Science");
        assertEquals(driver.findElement(By.id("DegreeDescription")).getAttribute("value"), "Edit Test info Beskrivelse av oppnådde resultater");
        assertEquals(driver.findElement(By.cssSelector("#Rating_chosen > a.chosen-single > span")).getText(), "Topp 40%");
    }
}