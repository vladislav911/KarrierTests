package Registration;

import org.omg.CORBA.Current;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class Tests3PositiveTestsStep1 extends TestDataBase{

    @Test(priority = 1)
    public void CorrectTypePageStep1() throws Exception {
        // go to http://karrierestart.no/registrering
        driver.get(baseUrl + "/registrering");
        // Type Email
        driver.findElement(By.id("Email")).clear();
        driver.findElement(By.id("Email")).sendKeys(Email);
        // Type Password
        driver.findElement(By.id("RegistratePassword")).clear();
        driver.findElement(By.id("RegistratePassword")).sendKeys("test");
        // Type ConfirmPassword
        driver.findElement(By.id("ConfirmPassword")).clear();
        driver.findElement(By.id("ConfirmPassword")).sendKeys("test");
        // Click checkbox
        driver.findElement(By.xpath(".//*[@id='registration_form']/div/div[2]/div[4]/div[2]/label/span")).click();
        // click Registration button
        driver.findElement(By.id("submit")).click();
        // Verify text Litt om hvem du er
        try {
            assertEquals(driver.findElement(By.cssSelector("h1.sh-main-txt")).getText(), "Litt om hvem du er");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        // Verify field Fornavn
        try {
            assertTrue(isElementPresent(By.id("FirstName")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        // Verify field Etternavn
        try {
            assertTrue(isElementPresent(By.id("LastName")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        UrlPageStep2 = driver.getCurrentUrl();
    }

}