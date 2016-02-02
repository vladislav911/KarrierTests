package Registration;
import org.omg.CORBA.Current;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class RLoggInAndDeleteUser extends TestDataBase {
    @Test(priority = 1)
    public void LoggIn() throws Exception {
        // Open BaseUrl
        driver.get(baseUrl);
        // Login User Test1
        driver.findElement(By.id("nav-login")).click();
        driver.findElement(By.id("UserName")).clear();
        driver.findElement(By.id("UserName")).sendKeys(Email1);
        driver.findElement(By.id("LoginPassword")).clear();
        driver.findElement(By.id("LoginPassword")).sendKeys("test");
        driver.findElement(By.className("login-btn")).click();
        // Verify name user - Test User
        try {
            assertEquals(driver.findElement(By.cssSelector("span.li-txt.overflow-ellipsis")).getText(), "Test User");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        // Click menu user
        driver.findElement(By.cssSelector(".drop-down-ctrl")).click();
        // Click link - Innstillinger
        driver.findElement(By.linkText("Innstillinger")).click();
        // Click link - Slett profil og alle data
        driver.findElement(By.linkText("Slett profil og alle data")).click();
        // Click link - slett min konto for alltid
        driver.findElement(By.linkText("slett min konto for alltid")).click();
        // Verify Current page = Base Url
        String Url = driver.getCurrentUrl();
        Assert.assertEquals(Url,baseUrl + "/");
        // Verify delete user - Try to login Test User
        driver.get(baseUrl);
        driver.findElement(By.id("nav-login")).click();
        driver.findElement(By.id("UserName")).clear();
        driver.findElement(By.id("UserName")).sendKeys(Email1);
        driver.findElement(By.id("LoginPassword")).clear();
        driver.findElement(By.id("LoginPassword")).sendKeys("test");
        driver.findElement(By.className("login-btn")).click();
        assertEquals(driver.findElement(By.cssSelector("div.error > div > span")).getText(), "Ugyldig brukernavn eller passord");
        String Url1 = driver.getCurrentUrl();
        Assert.assertEquals(Url1,baseUrl + "/");

    }
}

