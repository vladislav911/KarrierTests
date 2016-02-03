package Registration;

import org.testng.annotations.*;
import static org.testng.Assert.*;

import org.openqa.selenium.By;

public class AMoveToPageRegistration extends TestDataBaseRegistration {

    @Test(priority=1)
    public void MoveToPageStep1AndCheck() throws Exception {
        // Go to page karrierestart
        driver.get(baseUrl);
        // Click button Ny bruker
        driver.findElement(By.linkText("Ny bruker")).click();
        // Click button Jobbsøker / kandidat
        driver.findElement(By.linkText("Jobbsøker / kandidat")).click();
        // Verify Email field
        try {
            assertTrue(isElementPresent(By.id("Email")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        // Verify Passord field
        try {
            assertTrue(isElementPresent(By.id("RegistratePassword")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        // Verify Confirm Passord field
        try {
            assertTrue(isElementPresent(By.id("ConfirmPassword")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        // Verify button Register
        try {
            assertTrue(isElementPresent(By.id("submit")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        // Verify button Facebook`
        try {
            assertTrue(isElementPresent(By.cssSelector("div.auth-wrapper > #Facebook")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        // Verify button Google
        try {
            assertTrue(isElementPresent(By.cssSelector("div.auth-wrapper > #Google")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        // Verify button Linkedin
        try {
            assertTrue(isElementPresent(By.cssSelector("div.auth-wrapper > #LinkedIn")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }
}

