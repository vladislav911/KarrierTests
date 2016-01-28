package Registration;

import org.omg.CORBA.Current;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class Tests2NegativeTestsStep1 extends TestDataBase {

    @Test(priority = 1)
    public void TryToRegistrationWithoutCheckbox() throws Exception {
        // Go to http://karrierestart.no/registrering
        driver.get(baseUrl + "/registrering");
        // Type Email
        driver.findElement(By.id("Email")).clear();
        driver.findElement(By.id("Email")).sendKeys(Email1);
        // Type Password
        driver.findElement(By.id("RegistratePassword")).clear();
        driver.findElement(By.id("RegistratePassword")).sendKeys("test");
        // Type Confirm Password
        driver.findElement(By.id("ConfirmPassword")).clear();
        driver.findElement(By.id("ConfirmPassword")).sendKeys("test");
        // Click Registration button
        driver.findElement(By.id("submit")).click();
        // Verify notification (checkbox)
        try {
            assertEquals(driver.findElement(By.cssSelector("#chk1-error > span")).getText(), "Du må godta betingelsene");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        String Url = driver.getCurrentUrl();
        Assert.assertEquals(Url, baseUrl + "/registrering");
    }

    @Test(priority = 2)
    public void TryToRegistrationWithoutConfirmPassword() throws Exception {
        // Click checkbox button
        driver.findElement(By.className("checkbox-label")).click();
        // Clear Confirmpassword field
        driver.findElement(By.id("ConfirmPassword")).clear();
        // Click Password field
        driver.findElement(By.id("RegistratePassword")).click();
        // Click Registration button
        driver.findElement(By.id("submit")).click();
        // Verify notification (Confirm password)
        try {
            assertEquals(driver.findElement(By.id("ConfirmPassword-error")).getText(), "Passordet og bekreftelses-passordet matcher ikke.");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        String Url = driver.getCurrentUrl();
        Assert.assertEquals(Url, baseUrl + "/registrering");
    }

    @Test(priority = 3)
    public void TryToRegistrationWithoutPassword() throws Exception {
        // Type ConfirmPassword field
        driver.findElement(By.id("ConfirmPassword")).clear();
        driver.findElement(By.id("ConfirmPassword")).sendKeys("test");
        // Clear Password field
        driver.findElement(By.id("RegistratePassword")).clear();
        // Click Registration button
        driver.findElement(By.id("submit")).click();
        // Verify notification (Confirm password)
        try {
            assertEquals(driver.findElement(By.id("ConfirmPassword-error")).getText(), "Passordet og bekreftelses-passordet matcher ikke.");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        String Url = driver.getCurrentUrl();
        Assert.assertEquals(Url, baseUrl + "/registrering");
    }

    @Test(priority = 4)
    public void TryToRegistrationWithoutEmail() throws Exception {
        // Type Password field
        driver.findElement(By.id("RegistratePassword")).clear();
        driver.findElement(By.id("RegistratePassword")).sendKeys("test");
        // Clear Email field
        driver.findElement(By.id("Email")).clear();
        // Click password field
        driver.findElement(By.id("RegistratePassword")).click();
        // Click Registration button
        driver.findElement(By.id("submit")).click();
        // Verify Current Url
        String Url = driver.getCurrentUrl();
        Assert.assertEquals(Url, baseUrl + "/registrering");
    }

    @Test(priority = 5)
    public void TryToRegistrationWithInncorrectEmail() throws Exception {
        // Type inncorrect Email
        driver.findElement(By.id("Email")).clear();
        driver.findElement(By.id("Email")).sendKeys("test1mail.ru");
        // Click Registration button
        driver.findElement(By.id("submit")).click();
        // Verify notification (Invalid email)
        try {
            assertEquals(driver.findElement(By.cssSelector("span.field-validation-error")).getText(), "Please enter a valid email address.");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        String Url = driver.getCurrentUrl();
        Assert.assertEquals(Url, baseUrl + "/registrering");
    }

    @Test(priority = 6)
    public void TryToRegistrationWithSmallPassword() throws Exception {
        // Type Email
        driver.findElement(By.id("Email")).clear();
        driver.findElement(By.id("Email")).sendKeys(Email1);
        // Type incorrect password < 3 symbols
        driver.findElement(By.id("RegistratePassword")).clear();
        driver.findElement(By.id("RegistratePassword")).sendKeys("te");
        // Type incorrect ConfirmPassword < 3 symbols
        driver.findElement(By.id("ConfirmPassword")).clear();
        driver.findElement(By.id("ConfirmPassword")).sendKeys("te");
        // Click Registration button
        driver.findElement(By.id("submit")).click();
        // Verify notification (Password < 3 symbols)
        try {
            assertEquals(driver.findElement(By.id("RegistratePassword-error")).getText(), "Må være på minst 3 tegn");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        String Url = driver.getCurrentUrl();
        Assert.assertEquals(Url, baseUrl + "/registrering");
    }

    @Test(priority = 7)
    public void TryToRegistrationWithDifferencePasswords() throws Exception {
        // Type password
        driver.findElement(By.id("RegistratePassword")).clear();
        driver.findElement(By.id("RegistratePassword")).sendKeys("test1");
        // Type ConfirmPassword
        driver.findElement(By.id("ConfirmPassword")).clear();
        driver.findElement(By.id("ConfirmPassword")).sendKeys("test");
        // Click Registration button
        driver.findElement(By.id("submit")).click();
        // Verify notification (Difference passwords)
        try {
            assertEquals(driver.findElement(By.id("ConfirmPassword-error")).getText(), "Passordet og bekreftelses-passordet matcher ikke1.");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        String Url = driver.getCurrentUrl();
        Assert.assertEquals(Url, baseUrl + "/registrering");
    }
}