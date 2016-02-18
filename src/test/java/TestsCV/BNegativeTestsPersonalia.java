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

public class BNegativeTestsPersonalia extends TestBaseCV {
    @Test(priority = 1)
    public void SaveWithEmptyReqFields() throws Exception {
        // Go to CV
        driver.get(baseUrl + "/CV/PersonalInfo");
        Thread.sleep(2000);
        driver.findElement(By.id("FirstName")).clear();
        driver.findElement(By.id("LastName")).clear();
        //driver.findElement(By.id("Email")).clear();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.id("submit")).click();
        driver.navigate().refresh();
        Assert.assertEquals(driver.findElement(By.id("FirstName")).getAttribute("value"), "Test3");
        Assert.assertEquals(driver.findElement(By.id("LastName")).getAttribute("value"), "User3");
        Assert.assertEquals(driver.findElement(By.id("Email")).getAttribute("value"), Email1);
    }
    @Test(priority = 2)
    public void SaveWithEmptyLastName() throws Exception {
        driver.findElement(By.id("LastName")).clear();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.id("submit")).click();
        Assert.assertEquals(driver.findElement(By.id("LastName-error")).getText(), "The LastName field is required.");
    }

    @Test(priority = 3)
    public void SaveWithEmptyFirstName() throws Exception {
        driver.findElement(By.id("LastName")).clear();
        driver.findElement(By.id("LastName")).sendKeys("User3");
        driver.findElement(By.id("FirstName")).clear();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.id("submit")).click();
        Assert.assertEquals(driver.findElement(By.id("FirstName-error")).getText(), "Feltet er påkrevd.");
    }

    @Test(priority = 4)
    public void SaveWithLongFirstName() throws Exception {
        driver.findElement(By.id("FirstName")).clear();
        driver.findElement(By.id("FirstName")).sendKeys("012345678901234567890123456789012345678901234567890123");
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.id("submit")).click();
        Assert.assertEquals(driver.findElement(By.id("FirstName-error")).getText(), "FirstName maksimal lengde er 50");
    }

    @Test(priority = 5)
    public void SaveWithLongLastName() throws Exception {
        driver.findElement(By.id("FirstName")).clear();
        driver.findElement(By.id("FirstName")).sendKeys("Test3");
        driver.findElement(By.id("LastName")).clear();
        driver.findElement(By.id("LastName")).sendKeys("012345678901234567890123456789012345678901234567890123");
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.id("submit")).click();
        Assert.assertEquals(driver.findElement(By.id("LastName-error")).getText(), "LastName maksimal lengde er 50");
    }

    @Test(priority = 6)
    public void SaveWithLongMiddleName() throws Exception {
        driver.findElement(By.id("LastName")).clear();
        driver.findElement(By.id("LastName")).sendKeys("User3");
        driver.findElement(By.id("MiddleName")).clear();
        driver.findElement(By.id("MiddleName")).sendKeys("012345678901234567890123456789012345678901234567890123");
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.id("submit")).click();
        Assert.assertEquals(driver.findElement(By.id("MiddleName-error")).getText(), "MiddleName maksimal lengde er 50");
    }

    @Test(priority = 7)
    public void SaveWithInncorrectDate() throws Exception {
        driver.findElement(By.id("MiddleName")).clear();
        driver.findElement(By.id("MiddleName")).sendKeys("TU3");
        driver.findElement(By.id("DateOfBirth")).clear();
        driver.findElement(By.id("DateOfBirth")).sendKeys("012345678901234");
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.id("submit")).click();
        assertEquals(driver.findElement(By.id("DateOfBirth-error")).getText(), "The field DateOfBirth must be a date.");
    }

    @Test(priority = 8)
    public void SaveWithFewNasjonalitet() throws Exception {
        driver.findElement(By.id("DateOfBirth")).clear();
        driver.findElement(By.id("DateOfBirth")).sendKeys("07.05.1989");
        driver.findElement(By.xpath("//form[@id='personalInfoForm']/div/div/div[6]/div[2]")).click();
        driver.findElement(By.xpath("//input[@value='Velg en eller flere']")).sendKeys("Tunis");
        driver.findElement(By.cssSelector(".active-result.highlighted>em")).click();
        driver.findElement(By.xpath("//form[@id='personalInfoForm']/div/div/div[6]/div[2]")).click();
        driver.findElement(By.xpath("//input[@value='Velg en eller flere']")).sendKeys("Argentina");
        driver.findElement(By.cssSelector(".active-result.highlighted>em")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.id("submit")).click();
    }

    @Test(priority = 9)
    public void SaveWithLongAdresse() throws Exception {
        driver.findElement(By.id("StreetAddress")).clear();
        driver.findElement(By.id("StreetAddress")).sendKeys("012345678901234567890123456789012345678901234567890123");
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.id("submit")).click();
        Assert.assertEquals(driver.findElement(By.id("StreetAddress-error")).getText(), "StreetAddress maksimal lengde er 50");
    }

    @Test(priority = 10)
    public void SaveWithLongLocaton() throws Exception {
        driver.findElement(By.id("StreetAddress")).clear();
        driver.findElement(By.id("StreetAddress")).sendKeys("Gagarina street");
        driver.findElement(By.id("Location")).clear();
        driver.findElement(By.id("Location")).sendKeys("012345678901234567890123456789012345678901234567890123");
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.id("submit")).click();
        Assert.assertEquals(driver.findElement(By.id("Location-error")).getText(), "Location maksimal lengde er 50");
    }

    @Test(priority = 11)
    public void SaveWithLongMobiltelefon() throws Exception {
        driver.findElement(By.id("Location")).clear();
        driver.findElement(By.id("Location")).sendKeys("Dnepr");
        driver.findElement(By.id("CellPhone")).clear();
        driver.findElement(By.id("CellPhone")).sendKeys("01234567890123456789012");
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.id("submit")).click();
        Assert.assertEquals(driver.findElement(By.id("CellPhone-error")).getText(), "CellPhone maksimal lengde er 20");
    }

    @Test(priority = 12)
    public void SaveWithLongAnnenTelefon() throws Exception {
        driver.findElement(By.id("CellPhone")).clear();
        driver.findElement(By.id("CellPhone")).sendKeys("+380931233333");
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.id("submit")).click();
        driver.findElement(By.id("Phone")).clear();
        driver.findElement(By.id("Phone")).sendKeys("01234567890123456789012");
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.id("submit")).click();
        Assert.assertEquals(driver.findElement(By.id("Phone-error")).getText(), "Phone maksimal lengde er 20");
    }
}