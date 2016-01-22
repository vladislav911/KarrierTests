package Registration;
import org.omg.CORBA.Current;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class Tests5PositiveTestsStep2 extends TestDataBase {
    @Test(priority = 1)
    public void CorrectTypePageStep2() throws Exception {
        driver.get(UrlPageStep2);
        // Type First Name
        driver.findElement(By.id("FirstName")).clear();
        driver.findElement(By.id("FirstName")).sendKeys("Test");
        // Type Last Name
        driver.findElement(By.id("LastName")).clear();
        driver.findElement(By.id("LastName")).sendKeys("User");
        // Chose day
        Select selectByValueDay = new Select(driver.findElement(By.className("day")));
        selectByValueDay.selectByVisibleText("04");
        // Chose month
        Select selectByValueMonth = new Select(driver.findElement(By.className("month")));
        selectByValueMonth.selectByVisibleText("mai");
        // Chose year
        Select selectByValueYear = new Select(driver.findElement(By.className("year")));
        selectByValueYear.selectByVisibleText("1991");
        // Сhose gender
        driver.findElement(By.id("male")).click();
        // Click button Registration
        driver.findElement(By.xpath("//button[@onclick=\"$('#registration_form').submit();\"]")).click();
        // Verify Text present Kontaktinformasjon
        try {
            assertEquals(driver.findElement(By.cssSelector("h1.sh-main-txt")).getText(), "Kontaktinformasjon");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        // Verify field Adresse
        try {
            assertTrue(isElementPresent(By.id("StreetAddress")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        // Verify field Postnummer
        try {
            assertEquals(driver.findElement(By.id("ZipCode")).getAttribute("value"), "");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        // Verify field Sted
        try {
            assertTrue(isElementPresent(By.id("Location")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        String UrlPageStep3 = driver.getCurrentUrl();
    }
}