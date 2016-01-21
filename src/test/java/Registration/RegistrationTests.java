package Registration;

import org.omg.CORBA.Current;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class RegistrationTests extends TestDataBase{

    @Test(priority=100)
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
        // Verify button Facebook
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

    @Test(priority=200)
    public void TryToRegistrationWithoutCheckbox() throws Exception {
        // go to http://karrierestart.no/registrering
        driver.get(baseUrl + "/registrering");
        // type Email
        driver.findElement(By.id("Email")).clear();
        driver.findElement(By.id("Email")).sendKeys(Email);
        // type password
        driver.findElement(By.id("RegistratePassword")).clear();
        driver.findElement(By.id("RegistratePassword")).sendKeys("test");
        // type confirm password
        driver.findElement(By.id("ConfirmPassword")).clear();
        driver.findElement(By.id("ConfirmPassword")).sendKeys("test");
        // click Registration button
        driver.findElement(By.id("submit")).click();
        // verify notification (checkbox)
        try {
            assertEquals(driver.findElement(By.cssSelector("#chk1-error > span")).getText(), "Du må godta betingelsene");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }
    @Test(priority=300)
    public void TryToRegistrationWithoutConfirmpassword() throws Exception {
        // click checkbox button
        driver.findElement(By.xpath(".//*[@id='registration_form']/div/div[2]/div[4]/div[2]/label/span")).click();
        // clear Confirmpassword field
        driver.findElement(By.id("ConfirmPassword")).clear();
        // click Password field
        driver.findElement(By.id("RegistratePassword")).click();
        // click Registration button
        driver.findElement(By.id("submit")).click();
        // verify notification (Confirm password)
        try {
            assertEquals(driver.findElement(By.id("ConfirmPassword-error")).getText(), "Passordet og bekreftelses-passordet matcher ikke.");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }
    @Test(priority=400)
    public void TryToRegistrationWithoutPassword() throws Exception {
        // type ConfirmPassword field
        driver.findElement(By.id("ConfirmPassword")).clear();
        driver.findElement(By.id("ConfirmPassword")).sendKeys("test");
        // clear Password field
        driver.findElement(By.id("RegistratePassword")).clear();
        // click Registration button
        driver.findElement(By.id("submit")).click();
        // verify notification (Confirm password)
        try {
            assertEquals(driver.findElement(By.id("ConfirmPassword-error")).getText(), "Passordet og bekreftelses-passordet matcher ikke.");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @Test(priority=500)
    public void TryToRegistrationWithoutEmail() throws Exception {
        // type Password field
        driver.findElement(By.id("RegistratePassword")).clear();
        driver.findElement(By.id("RegistratePassword")).sendKeys("test");
        // clear Email field
        driver.findElement(By.id("Email")).clear();
        // click password field
        driver.findElement(By.id("RegistratePassword")).click();
        // click Registration button
        driver.findElement(By.id("submit")).click();
        // verify Current Url
        String Url = driver.getCurrentUrl();
        Assert.assertEquals(Url, baseUrl + "/registrering" );
    }

    @Test(priority = 600)
    public void TryToRegistrationWithInncorrectEmail() throws Exception {
        // Type inncorrect Email
        driver.findElement(By.id("Email")).clear();
        driver.findElement(By.id("Email")).sendKeys("test1mail.ru");
        // click Registration button
        driver.findElement(By.id("submit")).click();
        // verify notification (Invalid email)
        try {
            assertEquals(driver.findElement(By.cssSelector("span.field-validation-error")).getText(), "Please enter a valid email address.");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }
    @Test(priority = 700)
    public void TryToRegistrationWithSmallPassword() throws Exception {
        // Type Email
        driver.findElement(By.id("Email")).clear();
        driver.findElement(By.id("Email")).sendKeys(Email);
        // Type incorrect password < 3 symbols
        driver.findElement(By.id("RegistratePassword")).clear();
        driver.findElement(By.id("RegistratePassword")).sendKeys("te");
        // Type incorrect ConfirmPassword < 3 symbols
        driver.findElement(By.id("ConfirmPassword")).clear();
        driver.findElement(By.id("ConfirmPassword")).sendKeys("te");
        // click Registration button
        driver.findElement(By.id("submit")).click();
        // verify notification (Password < 3 symbols)
        try {
            assertEquals(driver.findElement(By.id("RegistratePassword-error")).getText(), "Må være på minst 3 tegn");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }
    @Test(priority = 800)
    public void TryToRegistrationWithDifferencePasswords() throws Exception {
        // Type password
        driver.findElement(By.id("RegistratePassword")).clear();
        driver.findElement(By.id("RegistratePassword")).sendKeys("test1");
        // Type ConfirmPassword
        driver.findElement(By.id("ConfirmPassword")).clear();
        driver.findElement(By.id("ConfirmPassword")).sendKeys("test");
        // click Registration button
        driver.findElement(By.id("submit")).click();
        // verify notification (Difference passwords)
        try {
            assertEquals(driver.findElement(By.id("ConfirmPassword-error")).getText(), "Passordet og bekreftelses-passordet matcher ikke.");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }
    @Test(priority = 900)
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
    }
    @Test(priority = 1000)
    public void TryToRegistrationWithoutGender() throws Exception {
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
        // Get current Url1
        String Url1 = driver.getCurrentUrl();
        // Click button Registration
        driver.findElement(By.xpath("//button[@onclick=\"$('#registration_form').submit();\"]")).click();
        // Get current Url2
        String Url2 = driver.getCurrentUrl();
        // Verify Url1=Url2
        Assert.assertEquals(Url1, Url2 );

    }
}
