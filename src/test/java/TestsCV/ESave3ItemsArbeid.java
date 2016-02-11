package TestsCV;
import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

import org.testng.annotations.Test;

public class ESave3ItemsArbeid extends TestBaseCV {
    @Test(priority = 1)
    public void Save1ItemWithFilDate() throws Exception {
        // Go to Arbeid
        driver.get(baseUrl + "/CV/JobList");
        Thread.sleep(1000);
        // Click Legg til ny button
        driver.findElement(By.linkText("Legg til ny")).click();
        Thread.sleep(1000);
        // Type Fra
        driver.findElement(By.id("FromDate")).clear();
        driver.findElement(By.id("FromDate")).sendKeys("10.10.2010");
        // Type Til
        driver.findElement(By.id("ToDate")).clear();
        driver.findElement(By.id("ToDate")).sendKeys("11.11.2011");
        // Type Tittel
        driver.findElement(By.id("Title")).clear();
        driver.findElement(By.id("Title")).sendKeys("Work");
        // Type Beskrivelse av stillingen
        driver.findElement(By.id("Description")).clear();
        driver.findElement(By.id("Description")).sendKeys("test information for first item!");
        // Type Arbeidsgiver
        driver.findElement(By.id("Employer")).clear();
        driver.findElement(By.id("Employer")).sendKeys("Gassco");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//ul[@id='ui-id-1']/li")).click();
        // Chose Bransje - Bankvirksomhet
        driver.findElement(By.xpath("//*[@id='SelectedIndustry_chosen']/ul")).click();
        driver.findElement(By.xpath("//*[@id='SelectedIndustry_chosen']/div/ul/li[2]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Chose Stillingstype - Frilanse
        driver.findElement(By.xpath("//*[@id='SelectedEmploymentTypes_chosen']/ul")).click();
        driver.findElement(By.xpath("//*[@id='SelectedEmploymentTypes_chosen']/div/ul/li[6]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Chose Fagområde - Jus
        driver.findElement(By.xpath("//*[@id='SelectedSubjects_chosen']/ul")).click();
        driver.findElement(By.xpath("//*[@id='SelectedSubjects_chosen']/div/ul/li[7]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Chose Yrker - Danser
        driver.findElement(By.xpath("//*[@id='SelectedProfessions_chosen']/ul")).click();
        driver.findElement(By.xpath("//*[@id='SelectedProfessions_chosen']/div/ul/li[9]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Chose Sted - Oslo
        driver.findElement(By.xpath("//*[@id='SelectedLocations_chosen']/ul")).click();
        driver.findElement(By.xpath("//*[@id='SelectedLocations_chosen']/div/ul/li[2]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(1000);
    }
    @Test(priority = 2)
    public void Save2ItemWithoutFilDate() throws Exception {
        // Go to Arbeid
        driver.get(baseUrl + "/CV/JobList");
        Thread.sleep(1000);
        // Click Legg til ny button
        driver.findElement(By.xpath("//a[contains(@href, '/CV/EditJob/0')]")).click();
        Thread.sleep(1000);
        // Type Fra
        driver.findElement(By.id("FromDate")).clear();
        driver.findElement(By.id("FromDate")).sendKeys("05.03.2012");
        // Click CheckBox
        driver.findElement(By.cssSelector("label.checkbox-label > span")).click();
        // Type Tittel
        driver.findElement(By.id("Title")).clear();
        driver.findElement(By.id("Title")).sendKeys("Home");
        // Type Beskrivelse av stillingen
        driver.findElement(By.id("Description")).clear();
        driver.findElement(By.id("Description")).sendKeys("test information for second item!");
        // Type Arbeidsgiver
        driver.findElement(By.id("Employer")).clear();
        driver.findElement(By.id("Employer")).sendKeys("Krepro");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//ul[@id='ui-id-1']/li")).click();
        // Chose Bransje - Engineering
        driver.findElement(By.xpath("//*[@id='SelectedIndustry_chosen']/ul")).click();
        driver.findElement(By.xpath("//*[@id='SelectedIndustry_chosen']/div/ul/li[5]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Chose Stillingstype - Internship
        driver.findElement(By.xpath("//*[@id='SelectedEmploymentTypes_chosen']/ul")).click();
        driver.findElement(By.xpath("//*[@id='SelectedEmploymentTypes_chosen']/div/ul/li[7]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Chose Fagområde - Informasjonsteknologi
        driver.findElement(By.xpath("//*[@id='SelectedSubjects_chosen']/ul")).click();
        driver.findElement(By.xpath("//*[@id='SelectedSubjects_chosen']/div/ul/li[6]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Chose Yrker - Animatør
        driver.findElement(By.xpath("//*[@id='SelectedProfessions_chosen']/ul")).click();
        driver.findElement(By.xpath("//*[@id='SelectedProfessions_chosen']/div/ul/li[4]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Chose Sted - Stavanger
        driver.findElement(By.xpath("//*[@id='SelectedLocations_chosen']/ul")).click();
        driver.findElement(By.xpath("//*[@id='SelectedLocations_chosen']/div/ul/li[5]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(1000);
    }
    @Test(priority = 3)
    public void Save3ItemWithoutFilDate() throws Exception {
        // Go to Arbeid
        driver.get(baseUrl + "/CV/JobList");
        Thread.sleep(1000);
        // Click Legg til ny button
        driver.findElement(By.xpath("//a[contains(@href, '/CV/EditJob/0')]")).click();
        Thread.sleep(1000);
        // Type Fra
        driver.findElement(By.id("FromDate")).clear();
        driver.findElement(By.id("FromDate")).sendKeys("04.07.2013");
        // Click CheckBox
        driver.findElement(By.cssSelector("label.checkbox-label > span")).click();
        // Type Tittel
        driver.findElement(By.id("Title")).clear();
        driver.findElement(By.id("Title")).sendKeys("Freelance");
        // Type Beskrivelse av stillingen
        driver.findElement(By.id("Description")).clear();
        driver.findElement(By.id("Description")).sendKeys("test information for third item!");
        // Type Arbeidsgiver
        driver.findElement(By.id("Employer")).clear();
        driver.findElement(By.id("Employer")).sendKeys("Krepro");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//ul[@id='ui-id-1']/li")).click();
        // Chose Bransje - Engineering
        driver.findElement(By.xpath("//*[@id='SelectedIndustry_chosen']/ul")).click();
        driver.findElement(By.xpath("//*[@id='SelectedIndustry_chosen']/div/ul/li[5]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Chose Stillingstype - Internship
        driver.findElement(By.xpath("//*[@id='SelectedEmploymentTypes_chosen']/ul")).click();
        driver.findElement(By.xpath("//*[@id='SelectedEmploymentTypes_chosen']/div/ul/li[7]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Chose Fagområde - Informasjonsteknologi
        driver.findElement(By.xpath("//*[@id='SelectedSubjects_chosen']/ul")).click();
        driver.findElement(By.xpath("//*[@id='SelectedSubjects_chosen']/div/ul/li[6]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Chose Yrker - Animatør
        driver.findElement(By.xpath("//*[@id='SelectedProfessions_chosen']/ul")).click();
        driver.findElement(By.xpath("//*[@id='SelectedProfessions_chosen']/div/ul/li[4]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Chose Sted - Stavanger
        driver.findElement(By.xpath("//*[@id='SelectedLocations_chosen']/ul")).click();
        driver.findElement(By.xpath("//*[@id='SelectedLocations_chosen']/div/ul/li[5]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(1000);
    }
    @Test(priority = 4)
    public void AssertSave1Item() throws Exception {
        // Go to Arbeid
        driver.get(baseUrl + "/CV/JobList");
        Thread.sleep(1000);
        // Assert 3 Items Saved
        assertEquals(driver.findElement(By.cssSelector("div.t-title")).getText(), "3 registrerte erfaringer");
        // Open First Item Work
        driver.findElement(By.linkText("Work , Gassco")).click();
        // Verify Data Save
        assertEquals(driver.findElement(By.id("FromDate")).getAttribute("value"), "10.10.2010");
        assertEquals(driver.findElement(By.id("ToDate")).getAttribute("value"), "11.11.2011");
        assertEquals(driver.findElement(By.id("Title")).getAttribute("value"), "Work");
        assertEquals(driver.findElement(By.id("Employer")).getAttribute("value"), "Gassco");
        assertEquals(driver.findElement(By.id("Description")).getAttribute("value"), "test information for first item!");
        assertEquals(driver.findElement(By.cssSelector("li.search-choice > span")).getText(), "Bankvirksomhet");
        assertEquals(driver.findElement(By.cssSelector("#SelectedEmploymentTypes_chosen > ul.chosen-choices > li.search-choice > span")).getText(), "Frilans");
        assertEquals(driver.findElement(By.cssSelector("#SelectedSubjects_chosen > ul.chosen-choices > li.search-choice > span")).getText(), "Jus");
        assertEquals(driver.findElement(By.cssSelector("#SelectedProfessions_chosen > ul.chosen-choices > li.search-choice > span")).getText(), "Danser");
        assertEquals(driver.findElement(By.cssSelector("#SelectedLocations_chosen > ul.chosen-choices > li.search-choice > span")).getText(), "Oslo");
    }
    @Test(priority = 5)
    public void AssertSave2Item() throws Exception {
        // Go to Arbeid
        driver.get(baseUrl + "/CV/JobList");
        Thread.sleep(1000);
        // Open Second Item Home
        driver.findElement(By.linkText("Home , Krepro")).click();
        // Verify Data Save
        assertEquals(driver.findElement(By.id("FromDate")).getAttribute("value"), "05.03.2012");
        WebElement TilField = driver.findElement(By.id("ToDate"));
        Assert.assertEquals(false, TilField.isDisplayed());
        assertEquals(driver.findElement(By.id("Title")).getAttribute("value"), "Home");
        assertEquals(driver.findElement(By.id("Employer")).getAttribute("value"), "Krepro");
        assertEquals(driver.findElement(By.id("Description")).getAttribute("value"), "test information for second item!");
        assertEquals(driver.findElement(By.cssSelector("li.search-choice > span")).getText(), "Engineering");
        assertEquals(driver.findElement(By.cssSelector("#SelectedEmploymentTypes_chosen > ul.chosen-choices > li.search-choice > span")).getText(), "Internship");
        assertEquals(driver.findElement(By.cssSelector("#SelectedSubjects_chosen > ul.chosen-choices > li.search-choice > span")).getText(), "Informasjonsteknologi / informatikk");
        assertEquals(driver.findElement(By.cssSelector("#SelectedProfessions_chosen > ul.chosen-choices > li.search-choice > span")).getText(), "Animatør");
        assertEquals(driver.findElement(By.cssSelector("#SelectedLocations_chosen > ul.chosen-choices > li.search-choice > span")).getText(), "Stavanger");
    }
}