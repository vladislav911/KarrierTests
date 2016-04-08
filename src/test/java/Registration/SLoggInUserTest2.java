package Registration;
import org.testng.Assert;
import org.testng.annotations.*;
import static org.testng.Assert.*;

import org.openqa.selenium.By;

public class SLoggInUserTest2 extends TestDataBaseRegistration {
    @Test(priority = 1)
    public void LoggIn() throws Exception {
        // Open BaseUrl
        driver.get(baseUrl);
        // Login User Test1
        driver.findElement(By.id("nav-login")).click();
        driver.findElement(By.id("UserName")).clear();
        driver.findElement(By.id("UserName")).sendKeys(Email2);
        driver.findElement(By.id("LoginPassword")).clear();
        driver.findElement(By.id("LoginPassword")).sendKeys("test");
        driver.findElement(By.className("login-btn")).click();
        // Verify name user - Test2 User2
        try {
            assertEquals(driver.findElement(By.cssSelector("span.li-txt.overflow-ellipsis")).getText(), "Min side");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }
}

