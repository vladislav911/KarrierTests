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

public class PSaveAndEditDataFerdigheter extends TestBaseCV {
    @Test(priority = 1)
    public void SaveData() throws Exception {
        // Go to Languages
        driver.get(baseUrl + "/CV/OtherSkills");
        Thread.sleep(1000);
        driver.findElement(By.id("SocialSkills")).clear();
        driver.findElement(By.id("SocialSkills")).sendKeys("Test Information Sosiale ferdigheter og kompetanser");
        driver.findElement(By.id("OrganisationalSkills")).clear();
        driver.findElement(By.id("OrganisationalSkills")).sendKeys("Test Information Organisatoriske ferdigheter og kompetanser");
        driver.findElement(By.id("TechnicalSkills")).clear();
        driver.findElement(By.id("TechnicalSkills")).sendKeys("Test Information Tekniske ferdigheter og kompetanser");
        driver.findElement(By.id("ComputerSkills")).clear();
        driver.findElement(By.id("ComputerSkills")).sendKeys("Test Information IT-ferdigheter og -kompetanser");
        driver.findElement(By.id("ArtisticSkills")).clear();
        driver.findElement(By.id("ArtisticSkills")).sendKeys("Test Information Kunstneriske ferdigheter og kompetanser");
        driver.findElement(By.id("OtherSkills")).clear();
        driver.findElement(By.id("OtherSkills")).sendKeys("Test Information Andre ferdigheter og kompetanser:");
        driver.findElement(By.xpath("//div[2]/div/ul")).click();
        driver.findElement(By.xpath("//li[16]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.id("DrivingLicense")).clear();
        driver.findElement(By.id("DrivingLicense")).sendKeys("Test Information Førerkort");
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(1000);
    }

    @Test(priority = 2)
    public void VerifySaveData() throws Exception {
        // Go to Languages
        driver.get(baseUrl + "/CV/OtherSkills");
        Thread.sleep(1000);
        assertEquals(driver.findElement(By.id("SocialSkills")).getAttribute("value"), "Test Information Sosiale ferdigheter og kompetanser");
        assertEquals(driver.findElement(By.id("OrganisationalSkills")).getAttribute("value"), "Test Information Organisatoriske ferdigheter og kompetanser");
        assertEquals(driver.findElement(By.id("TechnicalSkills")).getAttribute("value"), "Test Information Tekniske ferdigheter og kompetanser");
        assertEquals(driver.findElement(By.id("ComputerSkills")).getAttribute("value"), "Test Information IT-ferdigheter og -kompetanser");
        assertEquals(driver.findElement(By.cssSelector("li.search-choice > span")).getText(), "Java (JDK)");
        assertEquals(driver.findElement(By.id("ArtisticSkills")).getAttribute("value"), "Test Information Kunstneriske ferdigheter og kompetanser");
        assertEquals(driver.findElement(By.id("OtherSkills")).getAttribute("value"), "Test Information Andre ferdigheter og kompetanser:");
        assertEquals(driver.findElement(By.id("DrivingLicense")).getAttribute("value"), "Test Information Førerkort");
    }
    @Test(priority = 3)
    public void EditDataEndRefresh() throws Exception {
        // Go to Languages
        driver.get(baseUrl + "/CV/OtherSkills");
        Thread.sleep(1000);
        driver.findElement(By.id("SocialSkills")).clear();
        driver.findElement(By.id("SocialSkills")).sendKeys("Edit Test Information Sosiale ferdigheter og kompetanser");
        driver.findElement(By.id("OrganisationalSkills")).clear();
        driver.findElement(By.id("OrganisationalSkills")).sendKeys("Edit Test Information Organisatoriske ferdigheter og kompetanser");
        driver.findElement(By.id("TechnicalSkills")).clear();
        driver.findElement(By.id("TechnicalSkills")).sendKeys("Edit Test Information Tekniske ferdigheter og kompetanser");
        driver.findElement(By.id("ComputerSkills")).clear();
        driver.findElement(By.id("ComputerSkills")).sendKeys("Edit Test Information IT-ferdigheter og -kompetanser");
        driver.findElement(By.id("ArtisticSkills")).clear();
        driver.findElement(By.xpath("//div[2]/div/ul/li/a")).click();
        driver.findElement(By.id("ArtisticSkills")).sendKeys("Edit Test Information Kunstneriske ferdigheter og kompetanser");
        driver.findElement(By.id("OtherSkills")).clear();
        driver.findElement(By.id("OtherSkills")).sendKeys("Edit Test Information Andre ferdigheter og kompetanser:");
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.id("DrivingLicense")).clear();
        driver.findElement(By.id("DrivingLicense")).sendKeys("Edit Test Information Førerkort");
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(1000);
        assertEquals(driver.findElement(By.id("SocialSkills")).getAttribute("value"), "Test Information Sosiale ferdigheter og kompetanser");
        assertEquals(driver.findElement(By.id("OrganisationalSkills")).getAttribute("value"), "Test Information Organisatoriske ferdigheter og kompetanser");
        assertEquals(driver.findElement(By.id("TechnicalSkills")).getAttribute("value"), "Test Information Tekniske ferdigheter og kompetanser");
        assertEquals(driver.findElement(By.id("ComputerSkills")).getAttribute("value"), "Test Information IT-ferdigheter og -kompetanser");
        assertEquals(driver.findElement(By.cssSelector("li.search-choice > span")).getText(), "Java (JDK)");
        assertEquals(driver.findElement(By.id("ArtisticSkills")).getAttribute("value"), "Test Information Kunstneriske ferdigheter og kompetanser");
        assertEquals(driver.findElement(By.id("OtherSkills")).getAttribute("value"), "Test Information Andre ferdigheter og kompetanser:");
        assertEquals(driver.findElement(By.id("DrivingLicense")).getAttribute("value"), "Test Information Førerkort");
    }
    @Test(priority = 4)
    public void EditDataEndCancel() throws Exception {
        // Go to Languages
        driver.get(baseUrl + "/CV/OtherSkills");
        Thread.sleep(1000);
        driver.findElement(By.id("SocialSkills")).clear();
        driver.findElement(By.id("SocialSkills")).sendKeys("Edit Test Information Sosiale ferdigheter og kompetanser");
        driver.findElement(By.id("OrganisationalSkills")).clear();
        driver.findElement(By.id("OrganisationalSkills")).sendKeys("Edit Test Information Organisatoriske ferdigheter og kompetanser");
        driver.findElement(By.id("TechnicalSkills")).clear();
        driver.findElement(By.id("TechnicalSkills")).sendKeys("Edit Test Information Tekniske ferdigheter og kompetanser");
        driver.findElement(By.id("ComputerSkills")).clear();
        driver.findElement(By.id("ComputerSkills")).sendKeys("Edit Test Information IT-ferdigheter og -kompetanser");
        driver.findElement(By.id("ArtisticSkills")).clear();
        driver.findElement(By.xpath("//div[2]/div/ul/li/a")).click();
        driver.findElement(By.id("ArtisticSkills")).sendKeys("Edit Test Information Kunstneriske ferdigheter og kompetanser");
        driver.findElement(By.id("OtherSkills")).clear();
        driver.findElement(By.id("OtherSkills")).sendKeys("Edit Test Information Andre ferdigheter og kompetanser:");
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.id("DrivingLicense")).clear();
        driver.findElement(By.id("DrivingLicense")).sendKeys("Edit Test Information Førerkort");
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        Thread.sleep(1000);
        driver.findElement(By.linkText("Avbryt")).click();
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(1000);
        assertEquals(driver.findElement(By.id("SocialSkills")).getAttribute("value"), "Test Information Sosiale ferdigheter og kompetanser");
        assertEquals(driver.findElement(By.id("OrganisationalSkills")).getAttribute("value"), "Test Information Organisatoriske ferdigheter og kompetanser");
        assertEquals(driver.findElement(By.id("TechnicalSkills")).getAttribute("value"), "Test Information Tekniske ferdigheter og kompetanser");
        assertEquals(driver.findElement(By.id("ComputerSkills")).getAttribute("value"), "Test Information IT-ferdigheter og -kompetanser");
        assertEquals(driver.findElement(By.cssSelector("li.search-choice > span")).getText(), "Java (JDK)");
        assertEquals(driver.findElement(By.id("ArtisticSkills")).getAttribute("value"), "Test Information Kunstneriske ferdigheter og kompetanser");
        assertEquals(driver.findElement(By.id("OtherSkills")).getAttribute("value"), "Test Information Andre ferdigheter og kompetanser:");
        assertEquals(driver.findElement(By.id("DrivingLicense")).getAttribute("value"), "Test Information Førerkort");
    }
    @Test(priority = 5)
    public void EditData() throws Exception {
        // Go to Languages
        driver.get(baseUrl + "/CV/OtherSkills");
        Thread.sleep(1000);
        driver.findElement(By.id("SocialSkills")).clear();
        driver.findElement(By.id("SocialSkills")).sendKeys("Edit Test Information Sosiale ferdigheter og kompetanser");
        driver.findElement(By.id("OrganisationalSkills")).clear();
        driver.findElement(By.id("OrganisationalSkills")).sendKeys("Edit Test Information Organisatoriske ferdigheter og kompetanser");
        driver.findElement(By.id("TechnicalSkills")).clear();
        driver.findElement(By.id("TechnicalSkills")).sendKeys("Edit Test Information Tekniske ferdigheter og kompetanser");
        driver.findElement(By.id("ComputerSkills")).clear();
        driver.findElement(By.id("ComputerSkills")).sendKeys("Edit Test Information IT-ferdigheter og -kompetanser");
        driver.findElement(By.id("ArtisticSkills")).clear();
        driver.findElement(By.xpath("//div[2]/div/ul")).click();
        driver.findElement(By.xpath("//div[2]/div/div/ul/li[4]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.id("ArtisticSkills")).sendKeys("Edit Test Information Kunstneriske ferdigheter og kompetanser");
        driver.findElement(By.id("OtherSkills")).clear();
        driver.findElement(By.id("OtherSkills")).sendKeys("Edit Test Information Andre ferdigheter og kompetanser:");
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.id("DrivingLicense")).clear();
        driver.findElement(By.id("DrivingLicense")).sendKeys("Edit Test Information Førerkort");
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        Thread.sleep(1000);
        driver.findElement(By.id("submit")).click();
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(1000);
        assertEquals(driver.findElement(By.id("SocialSkills")).getAttribute("value"), "Edit Test Information Sosiale ferdigheter og kompetanser");
        assertEquals(driver.findElement(By.id("OrganisationalSkills")).getAttribute("value"), "Edit Test Information Organisatoriske ferdigheter og kompetanser");
        assertEquals(driver.findElement(By.id("TechnicalSkills")).getAttribute("value"), "Edit Test Information Tekniske ferdigheter og kompetanser");
        assertEquals(driver.findElement(By.id("ComputerSkills")).getAttribute("value"), "Edit Test Information IT-ferdigheter og -kompetanser");
        assertEquals(driver.findElement(By.xpath("//li/span")).getText(), "C");
        assertEquals(driver.findElement(By.xpath("//li[2]/span")).getText(), "Java (JDK)");
        assertEquals(driver.findElement(By.id("ArtisticSkills")).getAttribute("value"), "Edit Test Information Kunstneriske ferdigheter og kompetanser");
        assertEquals(driver.findElement(By.id("OtherSkills")).getAttribute("value"), "Edit Test Information Andre ferdigheter og kompetanser:");
        assertEquals(driver.findElement(By.id("DrivingLicense")).getAttribute("value"), "Edit Test Information Førerkort");
    }

}