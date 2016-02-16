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

public class LSave3ItemsAnnen extends TestBaseCV {
    @Test(priority = 1)
    public void LoggIn() throws Exception {
        // Open BaseUrl
        driver.get(baseUrl);
        // Login User Test1
        driver.findElement(By.id("nav-login")).click();
        driver.findElement(By.id("UserName")).clear();
        driver.findElement(By.id("UserName")).sendKeys("testdd200@mail.ru");
        driver.findElement(By.id("LoginPassword")).clear();
        driver.findElement(By.id("LoginPassword")).sendKeys("test");
        driver.findElement(By.className("login-btn")).click();
        Thread.sleep(4000);
    }
    @Test(priority = 2)
    public void Save1ItemWithTil() throws Exception {
        // Go to Experiences
        driver.get(baseUrl + "/CV/Experiences");
        // Click Legg til ny button
        driver.findElement(By.linkText("Legg til ny")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("FromDate")).clear();
        driver.findElement(By.id("FromDate")).sendKeys("10.02.2014");
        driver.findElement(By.id("ToDate")).clear();
        driver.findElement(By.id("ToDate")).sendKeys("12.12.2014");
        driver.findElement(By.id("Title")).clear();
        driver.findElement(By.id("Title")).sendKeys("Test information Tittel");
        driver.findElement(By.id("Activity")).clear();
        driver.findElement(By.id("Activity")).sendKeys("Test Organisasjon");
        driver.findElement(By.id("Description")).clear();
        driver.findElement(By.id("Description")).sendKeys("Tests information Beskrivelse");
        driver.findElement(By.xpath("//div[2]/div/ul")).click();
        driver.findElement(By.xpath("//div[2]/div/div/ul/li[3]")).click();
        driver.findElement(By.id("submit")).click();
        Thread.sleep(1000);
    }
}