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

public class GNegativeTestsUtdanning extends TestBaseCV {
    @Test(priority = 1)
    public void SaveWithoutAnyData() throws Exception {
        // Go to Arbeid
        driver.get(baseUrl + "/CV/Educations");
        // Click Legg til ny button
        driver.findElement(By.linkText("Legg til ny")).click();
        driver.findElement(By.id("submit")).click();
        try {
            assertEquals(driver.findElement(By.id("FromDate-error")).getText(), "Feltet er påkrevd.");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals(driver.findElement(By.id("ToDate-error")).getText(), "Feltet er påkrevd.");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals(driver.findElement(By.id("Title-error")).getText(), "Feltet er påkrevd.");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals(driver.findElement(By.id("SchoolType-error")).getText(), "Feltet er påkrevd.");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals(driver.findElement(By.id("SchoolId-error")).getText(), "Feltet er påkrevd.");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals(driver.findElement(By.id("Speciality-error")).getText(), "Feltet er påkrevd.");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals(driver.findElement(By.id("GraduationType-error")).getText(), "Feltet er påkrevd.");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals(driver.findElement(By.id("Rating-error")).getText(), "Feltet er påkrevd.");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }
    @Test(priority = 2)
    public void SaveWithoutTypeGrad() throws Exception {
        // Go to Arbeid
        driver.get(baseUrl + "/CV/Educations");
        // Click Legg til ny button
        driver.findElement(By.linkText("Legg til ny")).click();
        // Close reklama
        //driver.findElement(By.xpath("//*[@id='staticad']/div/div[1]")).click();
        // Type Fra
        driver.findElement(By.id("FromDate")).clear();
        driver.findElement(By.id("FromDate")).sendKeys("13.11.2011");
        // Type Dato for uteksaminering
        driver.findElement(By.id("ToDate")).clear();
        driver.findElement(By.id("ToDate")).sendKeys("23.04.2013");
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
        driver.findElement(By.id("submit")).click();
        assertEquals(driver.findElement(By.id("GraduationType-error")).getText(), "Feltet er påkrevd.");
    }
    @Test(priority = 3)
    public void SaveWithoutFagområde() throws Exception {
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Type Type grad - Kandidate
        driver.findElement(By.xpath("//div[@id='GraduationType_chosen']/a")).click();
        driver.findElement(By.xpath("//div[@id='GraduationType_chosen']/div/ul/li[3]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.xpath("//div[@id='Speciality_chosen']/ul/li/a")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.id("submit")).click();
        assertEquals(driver.findElement(By.id("Speciality-error")).getText(), "Feltet er påkrevd.");
    }
    @Test(priority = 4)
    public void SaveWithoutSkole() throws Exception {
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Type Fagområde - Jus
        driver.findElement(By.xpath("//div[@id='Speciality_chosen']/ul")).click();
        driver.findElement(By.xpath("//div[@id='Speciality_chosen']/div/ul/li[7]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.xpath("//*[@id='SchoolId_chosen']/a/abbr")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.id("submit")).click();
        assertEquals(driver.findElement(By.id("SchoolId-error")).getText(), "Feltet er påkrevd.");

    }
    @Test(priority = 5)
    public void SaveWithoutSted () throws Exception {
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Type Skole - Apo Melbu
        driver.findElement(By.xpath("//div[@id='SchoolId_chosen']/a")).click();
        driver.findElement(By.xpath("//div[@id='SchoolId_chosen']/div/ul/li[5]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Type Sted eller land - Oslo
        driver.findElement(By.xpath("//div[@id='SchoolCountryId_chosen']/a")).click();
        driver.findElement(By.xpath("//div[@id='SchoolCountryId_chosen']/div/ul/li[1]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.id("submit")).click();
        assertEquals(driver.findElement(By.id("SchoolId-error")).getText(), "Feltet er påkrevd.");
    }
    @Test(priority = 6)
    public void SaveWithoutStudie () throws Exception {
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Type Sted eller land - Oslo
        driver.findElement(By.xpath("//div[@id='SchoolCountryId_chosen']/a")).click();
        driver.findElement(By.xpath("//div[@id='SchoolCountryId_chosen']/div/ul/li[2]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Type Skole - Apo Melbu
        driver.findElement(By.xpath("//div[@id='SchoolId_chosen']/a")).click();
        driver.findElement(By.xpath("//div[@id='SchoolId_chosen']/div/ul/li[5]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.id("Title")).clear();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.id("submit")).click();
        assertEquals(driver.findElement(By.id("Title-error")).getText(), "Feltet er påkrevd.");
    }
    @Test(priority = 7)
    public void SaveWithoutDatoForUteksaminering () throws Exception {
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Type Studie
        driver.findElement(By.id("Title")).clear();
        driver.findElement(By.id("Title")).sendKeys(".NET UTVIKLER");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//ul[@id='ui-id-1']/li")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.id("ToDate")).clear();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.id("submit")).click();
        assertEquals(driver.findElement(By.id("ToDate-error")).getText(), "Feltet er påkrevd.");
    }
    @Test(priority = 8)
    public void SaveWithoutFra () throws Exception {
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Type Dato for uteksaminering
        driver.findElement(By.id("ToDate")).clear();
        driver.findElement(By.id("ToDate")).sendKeys("23.04.2013");
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.id("FromDate")).clear();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.id("submit")).click();
        assertEquals(driver.findElement(By.id("FromDate-error")).getText(), "Feltet er påkrevd.");
    }
    @Test(priority = 9)
    public void SaveWithFradateLateTilDate () throws Exception {
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Type Til
        driver.findElement(By.id("FromDate")).clear();
        driver.findElement(By.id("FromDate")).sendKeys("11.11.2015");
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.id("submit")).click();
        assertEquals(driver.findElement(By.cssSelector("span.field-validation-error")).getText(), "Startdato må være før sluttdato");
    }
    @Test(priority = 10)
    public void SaveWithIncorrectFra () throws Exception {
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Type Til
        driver.findElement(By.id("FromDate")).clear();
        driver.findElement(By.id("FromDate")).sendKeys("1111201223232323");
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.id("submit")).click();
        assertEquals(driver.findElement(By.id("FromDate-error")).getText(), "The field FromDate must be a date.");
    }
    @Test(priority = 11)
    public void SaveWithIncorrectDatoFor () throws Exception {
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Type Til
        driver.findElement(By.id("FromDate")).clear();
        driver.findElement(By.id("FromDate")).sendKeys("11.11.2012");
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Type Til
        driver.findElement(By.id("ToDate")).clear();
        driver.findElement(By.id("ToDate")).sendKeys("1111201223232323");
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.id("submit")).click();
        assertEquals(driver.findElement(By.id("ToDate-error")).getText(), "The field ToDate must be a date.");
    }
    @Test(priority = 12)
    public void DeleteFieldTil () throws Exception {
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.cssSelector(".checkbox-label>span")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        WebElement TilField = driver.findElement(By.id("ToDate"));
        Assert.assertEquals(false, TilField.isDisplayed());
    }
    @Test(priority = 13)
    public void AnnetSkole () throws Exception {
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Type Skole - Apo Melbu
        driver.findElement(By.xpath("//div[@id='SchoolId_chosen']/a")).click();
        driver.findElement(By.xpath(".//*[@id='SchoolId_chosen']/div/ul/li[2]")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        WebElement schoolField = driver.findElement(By.id("SchoolName"));
        Assert.assertEquals(true, schoolField.isDisplayed());
    }
    @Test(priority = 14)
    public void Skriv () throws Exception {
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.id("SchoolName")).clear();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        driver.findElement(By.id("submit")).click();
        assertEquals(driver.findElement(By.id("SchoolName-error")).getText(), "Feltet er påkrevd.");
        Thread.sleep(1000);
    }
}