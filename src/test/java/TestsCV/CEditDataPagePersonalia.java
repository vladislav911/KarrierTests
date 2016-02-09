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

public class CEditDataPagePersonalia extends TestBaseCV {
    @Test(priority = 1)
    public void EditDataWithSubmit() throws Exception {
        // Go to CV
        driver.get(baseUrl + "/CV/PersonalInfo");
        // Close reklama
        //driver.findElement(By.xpath("//*[@id='staticad']/div/div[1]")).click();
        // Edit First Name
        driver.findElement(By.id("FirstName")).clear();
        driver.findElement(By.id("FirstName")).sendKeys("Tom");
        // Edit MiddleName
        driver.findElement(By.id("MiddleName")).clear();
        driver.findElement(By.id("MiddleName")).sendKeys("Empty");
        // Edit LastName
        driver.findElement(By.id("LastName")).clear();
        driver.findElement(By.id("LastName")).sendKeys("Gin");
        // Edit Dateof Birth
        driver.findElement(By.id("DateOfBirth")).clear();
        driver.findElement(By.id("DateOfBirth")).sendKeys("08.09.1992");
        driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/button[2]")).click();
        // Edit Gender
        driver.findElement(By.cssSelector(".chosen-single")).click();
        driver.findElement(By.xpath("//*[@id='Gender_chosen']/div/div/input")).sendKeys("Kvinne");
        driver.findElement(By.cssSelector(".active-result.highlighted>em")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Edit Nasjonalitet
        driver.findElement(By.xpath("//form[@id='personalInfoForm']/div/div/div[6]/div[2]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.xpath("//form[@id='personalInfoForm']/div/div/div[6]/div[2]/div/ul/li/a")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.xpath("//form[@id='personalInfoForm']/div/div/div[6]/div[2]/div/ul/li/a")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.xpath("//form[@id='personalInfoForm']/div/div/div[6]/div[2]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.xpath("//input[@value='Velg en eller flere']")).sendKeys("Brasil");
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.cssSelector(".active-result.highlighted>em")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.xpath("//form[@id='personalInfoForm']/div/div/div[6]/div[2]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.xpath("//input[@value='Velg en eller flere']")).sendKeys("Cuba");
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.cssSelector(".active-result.highlighted>em")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.id("StreetAddress")).clear();
        driver.findElement(By.id("StreetAddress")).sendKeys("Kirova street");
        driver.findElement(By.id("Zip")).clear();
        driver.findElement(By.id("Zip")).sendKeys("77777");
        driver.findElement(By.id("Location")).clear();
        driver.findElement(By.id("Location")).sendKeys("Kiev");
        Thread.sleep(1000);
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.id("Country_chosen")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='Country_chosen']/div/ul/li[102]")).click();
        Thread.sleep(1000);
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.id("CellPhone")).clear();
        driver.findElement(By.id("CellPhone")).sendKeys("+380 50 122 4567");
        driver.findElement(By.id("Phone")).clear();
        driver.findElement(By.id("Phone")).sendKeys("+4553434334");
        driver.findElement(By.id("Email")).clear();
        driver.findElement(By.id("Email")).sendKeys(Email2);
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(2000);
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        Thread.sleep(100000);
        driver.navigate().refresh();
        assertEquals(driver.findElement(By.id("FirstName")).getAttribute("value"), "Tom");
        assertEquals(driver.findElement(By.id("MiddleName")).getAttribute("value"), "Empty");
        assertEquals(driver.findElement(By.id("LastName")).getAttribute("value"), "Gin");
        assertEquals(driver.findElement(By.id("DateOfBirth")).getAttribute("value"), "08.09.1992");
        assertEquals(driver.findElement(By.cssSelector("a.chosen-single > span")).getText(), "Kvinne");
        assertEquals(driver.findElement(By.xpath("//form[@id='personalInfoForm']/div/div/div[6]/div[2]/div/ul/li/span")).getText(), "Brasil");
        assertEquals(driver.findElement(By.xpath("//form[@id='personalInfoForm']/div/div/div[6]/div[2]/div/ul/li[2]/span")).getText(), "Cuba");
        assertEquals(driver.findElement(By.id("StreetAddress")).getAttribute("value"), "Kirova street");
        assertEquals(driver.findElement(By.id("Zip")).getAttribute("value"), "77777");
        assertEquals(driver.findElement(By.id("Location")).getAttribute("value"), "Kiev");
        assertEquals(driver.findElement(By.cssSelector("#Country_chosen > a.chosen-single > span")).getText(), "Kazakhstan");
        assertEquals(driver.findElement(By.id("CellPhone")).getAttribute("value"), "+380 50 122 4567");
        assertEquals(driver.findElement(By.id("Phone")).getAttribute("value"), "+45 53 43 43 34");
        assertEquals(driver.findElement(By.id("Email")).getAttribute("value"), Email2);
        Thread.sleep(1000);
    }
    @Test(priority = 2)
    public void EditDataWithCancel() throws Exception {
        // Go to CV
        driver.get(baseUrl + "/CV/PersonalInfo");
        // Close reklama
        //driver.findElement(By.xpath("//*[@id='staticad']/div/div[1]")).click();
        // Edit First Name
        driver.findElement(By.id("FirstName")).clear();
        driver.findElement(By.id("FirstName")).sendKeys("Den");
        // Edit MiddleName
        driver.findElement(By.id("MiddleName")).clear();
        driver.findElement(By.id("MiddleName")).sendKeys("QSD");
        // Edit LastName
        driver.findElement(By.id("LastName")).clear();
        driver.findElement(By.id("LastName")).sendKeys("Koufman");
        // Edit Dateof Birth
        driver.findElement(By.id("DateOfBirth")).clear();
        driver.findElement(By.id("DateOfBirth")).sendKeys("06.03.1964");
        driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/button[2]")).click();
        // Edit Gender
        driver.findElement(By.cssSelector(".chosen-single")).click();
        driver.findElement(By.xpath("//*[@id='Gender_chosen']/div/div/input")).sendKeys("Mann");
        driver.findElement(By.cssSelector(".active-result.highlighted>em")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Edit Nasjonalitet
        driver.findElement(By.xpath("//form[@id='personalInfoForm']/div/div/div[6]/div[2]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.xpath("//form[@id='personalInfoForm']/div/div/div[6]/div[2]/div/ul/li/a")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.xpath("//form[@id='personalInfoForm']/div/div/div[6]/div[2]/div/ul/li/a")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.xpath("//form[@id='personalInfoForm']/div/div/div[6]/div[2]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.xpath("//input[@value='Velg en eller flere']")).sendKeys("Angola");
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.cssSelector(".active-result.highlighted>em")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.xpath("//form[@id='personalInfoForm']/div/div/div[6]/div[2]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.xpath("//input[@value='Velg en eller flere']")).sendKeys("Congo");
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.cssSelector(".active-result.highlighted>em")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.id("StreetAddress")).clear();
        driver.findElement(By.id("StreetAddress")).sendKeys("Titova street");
        driver.findElement(By.id("Zip")).clear();
        driver.findElement(By.id("Zip")).sendKeys("454545");
        driver.findElement(By.id("Location")).clear();
        driver.findElement(By.id("Location")).sendKeys("Lvov");
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.xpath("//*[@id='Country_chosen']/a")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.xpath("//*[@id='Country_chosen']/div/div/input")).sendKeys("Japan");
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.xpath("//*[@id='Country_chosen']/div/ul/li/em")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.id("CellPhone")).clear();
        driver.findElement(By.id("CellPhone")).sendKeys("+380 93 555 4555");
        driver.findElement(By.id("Phone")).clear();
        driver.findElement(By.id("Phone")).sendKeys("+4333333333");
        driver.findElement(By.id("Email")).clear();
        driver.findElement(By.id("Email")).sendKeys(Email3);
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        Thread.sleep(100000);
        driver.navigate().refresh();
        assertEquals(driver.findElement(By.id("FirstName")).getAttribute("value"), "Tom");
        assertEquals(driver.findElement(By.id("MiddleName")).getAttribute("value"), "Empty");
        assertEquals(driver.findElement(By.id("LastName")).getAttribute("value"), "Gin");
        assertEquals(driver.findElement(By.id("DateOfBirth")).getAttribute("value"), "08.09.1992");
        assertEquals(driver.findElement(By.cssSelector("a.chosen-single > span")).getText(), "Kvinne");
        assertEquals(driver.findElement(By.xpath("//form[@id='personalInfoForm']/div/div/div[6]/div[2]/div/ul/li/span")).getText(), "Brasil");
        assertEquals(driver.findElement(By.xpath("//form[@id='personalInfoForm']/div/div/div[6]/div[2]/div/ul/li[2]/span")).getText(), "Cuba");
        assertEquals(driver.findElement(By.id("StreetAddress")).getAttribute("value"), "Kirova street");
        assertEquals(driver.findElement(By.id("Zip")).getAttribute("value"), "77777");
        assertEquals(driver.findElement(By.id("Location")).getAttribute("value"), "Kiev");
        assertEquals(driver.findElement(By.cssSelector("#Country_chosen > a.chosen-single > span")).getText(), "Kazakhstan");
        assertEquals(driver.findElement(By.id("CellPhone")).getAttribute("value"), "+380 50 122 4567");
        assertEquals(driver.findElement(By.id("Phone")).getAttribute("value"), "+45 53 43 43 34");
        assertEquals(driver.findElement(By.id("Email")).getAttribute("value"), Email2);
    }
}
