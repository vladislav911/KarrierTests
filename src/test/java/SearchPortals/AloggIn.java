package SearchPortals;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import static org.testng.Assert.*;

import static org.testng.Assert.fail;

import org.testng.annotations.Test;

public class AloggIn extends TestBaseSearchPortals {

    @Test(priority = 1)
    public void loggin() throws Exception {
        // Go to http://karrierestart.no/registrering
        driver.get(baseUrl);
        waitForElementPresent(By.id("responsive-menu"));
        driver.findElement(By.id("nav-login")).click();
        waitForElementPresent(By.xpath("//*[@id='login-cntr']/div/div[1]"));
        driver.findElement(By.id("UserName")).clear();
        driver.findElement(By.id("UserName")).sendKeys(Email2);
        driver.findElement(By.id("LoginPassword")).clear();
        driver.findElement(By.id("LoginPassword")).sendKeys("test");
        driver.findElement(By.className("login-btn")).click();
        waitForElementPresent(By.id("account-menu"));
        Thread.sleep(3000);
        assertEquals(driver.getCurrentUrl(), baseUrl + "/account");
    }
}

