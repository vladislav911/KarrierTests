package Registration;

import org.testng.annotations.*;
import static org.testng.Assert.*;

import org.openqa.selenium.By;

public class CPositiveTestsStep1 extends TestDataBaseRegistration {

    @Test(priority = 1)
    public void CorrectTypePageStep1() throws Exception {
        // Go to http://karrierestart.no/registrering
        driver.get(baseUrl + "/registrering");
        // Type Email
        driver.findElement(By.id("Email")).clear();
        driver.findElement(By.id("Email")).sendKeys(Email1);
        // Type Password
        driver.findElement(By.id("RegistratePassword")).clear();
        driver.findElement(By.id("RegistratePassword")).sendKeys("test");
        // Type ConfirmPassword
        driver.findElement(By.id("ConfirmPassword")).clear();
        driver.findElement(By.id("ConfirmPassword")).sendKeys("test");
        // Click checkbox
        driver.findElement(By.className("checkbox-label")).click();
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