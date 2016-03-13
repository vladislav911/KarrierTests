package SearchPortals;

import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class TestBaseSearchPortals {

    static protected WebDriver driver;
    static protected String baseUrl;
    static protected String Email2;
    protected StringBuffer verificationErrors = new StringBuffer();
    private boolean acceptNextAlert = true;

    @BeforeTest
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://dev.karrierestart.no";
        // DONT NEED CHANGE EMAIl
        Email2 = "testtt333@mail.ru";
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1285, 985));
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

    // General methods
    public void refreshPage (){
        driver.navigate().refresh();
    }

    public void scrollPageUp () {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
    }

    public void assertElementNotPresent(By by) {
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        Assert.assertEquals(0, driver.findElements(by).size());
    }

    public void waitForElementPresent(By by) throws InterruptedException {
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(by)) break; } catch (Exception e) {}
            Thread.sleep(100);
        }
    }
    public void deleteUser () {
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
    }

    // METHODS FOR REGISTRATION
    public void clickOnButtonRegistrationStep2() {
        driver.findElement(By.xpath("//button[@onclick=\"$('#registration_form').submit();\"]")).click();
    }
    public void clickOnButtonRegistrationStep3() {
        driver.findElement(By.xpath("//button[@onclick=\"$('#registration_form').submit();\"]")).click();
    }
    public void clickOnButtonRegistrationStep4() {
        driver.findElement(By.xpath("//*[@id='registration_form']/div/div[2]/div[1]/div/div[5]/div/button")).click();
    }
    // METHODS FOR STILLINGER
    public void goToPageStillinger() throws  InterruptedException{
        driver.get(baseUrl + "/jobb");
        waitForElementPresent(By.id("searchtext'"));
    }
}

