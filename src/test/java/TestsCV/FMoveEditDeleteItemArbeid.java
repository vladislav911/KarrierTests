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
    /*@Test(priority = 1)
    public void LoggIn() throws Exception {
        // Open BaseUrl
        driver.get(baseUrl);
        // Login User Test1
        driver.findElement(By.id("nav-login")).click();
        driver.findElement(By.id("UserName")).clear();
        driver.findElement(By.id("UserName")).sendKeys("testdd163@mail.ru");
        driver.findElement(By.id("LoginPassword")).clear();
        driver.findElement(By.id("LoginPassword")).sendKeys("test");
        driver.findElement(By.className("login-btn")).click();
        Thread.sleep(4000);
    }*/
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
}