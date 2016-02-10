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

public class DNegativeTestsArbeid extends TestBaseCV {
    @Test(priority = 1)
    public void LoggIn() throws Exception {
        // Open BaseUrl
        driver.get(baseUrl);
        // Login User Test1
        driver.findElement(By.id("nav-login")).click();
        driver.findElement(By.id("UserName")).clear();
        driver.findElement(By.id("UserName")).sendKeys(Email1);
        driver.findElement(By.id("LoginPassword")).clear();
        driver.findElement(By.id("LoginPassword")).sendKeys("test");
        driver.findElement(By.className("login-btn")).click();
        Thread.sleep(4000);
    }
    @Test(priority = 2)
    public void SaveWithoutSted() throws Exception {
        // Go to Arbeid
        driver.get(baseUrl + "/CV/JobList");
        // Click Legg til ny button
        driver.findElement(By.linkText("Legg til ny")).click();
        // Type Fra
        driver.findElement(By.id("FromDate")).clear();
        driver.findElement(By.id("FromDate")).sendKeys("10.10.2010");
        // Type Til
        driver.findElement(By.id("ToDate")).clear();
        driver.findElement(By.id("ToDate")).sendKeys("11.11.2011");
        // Type Tittel
        driver.findElement(By.id("Title")).clear();
        driver.findElement(By.id("Title")).sendKeys("Work");
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
        driver.findElement(By.id("submit")).click();
        assertEquals(driver.findElement(By.id("SelectedLocations-error")).getText(), "Feltet er påkrevd.");
    }
    @Test(priority = 3)
    public void SaveWithoutYrker () throws Exception {
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Chose Sted - Oslo
        driver.findElement(By.xpath("//*[@id='SelectedLocations_chosen']/ul")).click();
        driver.findElement(By.xpath("//*[@id='SelectedLocations_chosen']/div/ul/li[2]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Delete Yrker - Danser
        driver.findElement(By.xpath("//div[@id='SelectedProfessions_chosen']/ul/li/a")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.id("submit")).click();
        assertEquals(driver.findElement(By.id("SelectedProfessions-error")).getText(), "Feltet er påkrevd.");
    }
    @Test(priority = 4)
    public void SaveWithoutFagområde () throws Exception {
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Chose Yrker - Danser
        driver.findElement(By.xpath("//*[@id='SelectedProfessions_chosen']/ul")).click();
        driver.findElement(By.xpath("//*[@id='SelectedProfessions_chosen']/div/ul/li[9]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Delete Fagområde - Jus
        driver.findElement(By.xpath("//*[@id='SelectedSubjects_chosen']/ul/li[1]/a")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.id("submit")).click();
        assertEquals(driver.findElement(By.id("SelectedSubjects-error")).getText(), "Feltet er påkrevd.");
    }
    @Test(priority = 5)
    public void SaveWithoutStillingstype () throws Exception {
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Chose Fagområde - Jus
        driver.findElement(By.xpath("//*[@id='SelectedSubjects_chosen']/ul")).click();
        driver.findElement(By.xpath("//*[@id='SelectedSubjects_chosen']/div/ul/li[7]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Delete Stillingstype - Frilanse
        driver.findElement(By.xpath("//*[@id='SelectedEmploymentTypes_chosen']/ul/li[1]/a")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.id("submit")).click();
        assertEquals(driver.findElement(By.id("SelectedEmploymentTypes-error")).getText(), "Feltet er påkrevd.");
    }
    @Test(priority = 6)
    public void SaveWithoutBransje () throws Exception {
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Chose Stillingstype - Frilanse
        driver.findElement(By.xpath("//*[@id='SelectedEmploymentTypes_chosen']/ul")).click();
        driver.findElement(By.xpath("//*[@id='SelectedEmploymentTypes_chosen']/div/ul/li[6]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Delete Bransje - Bankvirksomhet
        driver.findElement(By.xpath("//*[@id='SelectedIndustry_chosen']/ul/li[1]/a")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.id("submit")).click();
        assertEquals(driver.findElement(By.id("SelectedIndustry-error")).getText(), "Feltet er påkrevd.");
    }
    @Test(priority = 7)
    public void SaveWithoutArbeidsgiver () throws Exception {
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Chose Bransje - Bankvirksomhet
        driver.findElement(By.xpath("//*[@id='SelectedIndustry_chosen']/ul")).click();
        driver.findElement(By.xpath("//*[@id='SelectedIndustry_chosen']/div/ul/li[2]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Clear Arbeidsgiver
        driver.findElement(By.id("Employer")).clear();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.id("submit")).click();
        assertEquals(driver.findElement(By.id("Employer-error")).getText(), "Feltet er påkrevd.");
    }
    @Test(priority = 8)
    public void SaveWithoutTittel () throws Exception {
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Type Arbeidsgiver
        driver.findElement(By.id("Employer")).clear();
        driver.findElement(By.id("Employer")).sendKeys("Gassco");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//ul[@id='ui-id-1']/li")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Clear Tittel
        driver.findElement(By.id("Title")).clear();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.id("submit")).click();
        assertEquals(driver.findElement(By.id("Title-error")).getText(), "Feltet er påkrevd.");
    }
    @Test(priority = 9)
    public void SaveWithoutTil () throws Exception {
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Type Tittel
        driver.findElement(By.id("Title")).clear();
        driver.findElement(By.id("Title")).sendKeys("Work");
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Clear Til
        driver.findElement(By.id("ToDate")).clear();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.id("submit")).click();
        assertEquals(driver.findElement(By.id("ToDate-error")).getText(), "Feltet er påkrevd.");
    }
    @Test(priority = 10)
    public void SaveWithoutFra () throws Exception {
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Type Til
        driver.findElement(By.id("ToDate")).clear();
        driver.findElement(By.id("ToDate")).sendKeys("11.11.2011");
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Clear Fra
        driver.findElement(By.id("FromDate")).clear();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.id("submit")).click();
        assertEquals(driver.findElement(By.id("FromDate-error")).getText(), "Feltet er påkrevd.");
    }
}
