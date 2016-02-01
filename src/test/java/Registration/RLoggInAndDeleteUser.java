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
        try {
            assertEquals(driver.findElement(By.cssSelector("span.li-txt.overflow-ellipsis")).getText(), "Test User");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }
    @Test(priority = 2)
    public void DeleteUser() throws Exception {
        driver.findElement(By.cssSelector(".drop-down-ctrl")).click();
        driver.findElement(By.linkText("Innstillinger")).click();
        driver.findElement(By.linkText("Slett profil og alle data")).click();
        driver.findElement(By.linkText("slett min konto for alltid")).click();
        try {
            assertEquals(driver.getCurrentUrl(), baseUrl);
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }

    }
}

