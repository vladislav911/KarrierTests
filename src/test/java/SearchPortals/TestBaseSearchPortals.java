package SearchPortals;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
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
            Thread.sleep(500);
        }
    }

    public void waitForTitle(String by) throws InterruptedException {
        for (int second = 0; ; second++) {
            if (second >= 20) fail("timeout");
            try {
                if (by.equals(driver.getTitle())) break;
            } catch (Exception e) {
            }
            Thread.sleep(1000);
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
        // Close reklam
        driver.findElement(By.xpath("//*[@id='staticad']/div/div[1]")).click();
    }


    // METHODS FOR STILLINGER
    public void goToPageStillinger() throws  InterruptedException{
        driver.get(baseUrl + "/jobb");
        waitForElementPresent(By.className("search-portal-wrp"));
    }

    // METHODS FOR ARBEIDSGIVERE
    public void goToPageArbeidsgivere() throws  InterruptedException{
        driver.get(baseUrl + "/arbeidsgivere");
        waitForElementPresent(By.className("search-portal-wrp"));
    }
    // METHODS FOR KANDIDATER
    public void goToPageKandidater() throws  InterruptedException{
        driver.get(baseUrl + "/kandidater");
        waitForElementPresent(By.className("search-portal-wrp"));
    }
}

