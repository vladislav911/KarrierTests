package Registration;

import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class TestDataBase {

    static protected Selenium selenium;
    static protected WebDriver driver;
    static protected String baseUrl;
    static protected String UrlPageStep2;
    static protected String UrlPageStep3;
    static protected String UrlPageStep4;
    static protected String UrlPageStep5;
    static protected String UrlPageStep6;
    static protected String UrlPageStep7;
    static protected String Email1;
    static protected String Email2;
    protected StringBuffer verificationErrors = new StringBuffer();
    private boolean acceptNextAlert = true;

    @BeforeTest
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://dev.karrierestart.no";
        Email1 = "testpp19@mail.ru";
        Email2 = "testpp20@mail.ru";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
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

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
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
    public void ClickOnButtonRegistrationStep2() {
        driver.findElement(By.xpath("//button[@onclick=\"$('#registration_form').submit();\"]")).click();
    }
    public void ClickOnButtonRegistrationStep3() {
        driver.findElement(By.xpath("//button[@onclick=\"$('#registration_form').submit();\"]")).click();
    }
    public void ClickOnButtonRegistrationStep4() {
        driver.findElement(By.xpath("//*[@id='registration_form']/div/div[2]/div[1]/div/div[5]/div/button")).click();
    }
    public void ClickOnButtonRegistrationStep5() {
        driver.findElement(By.xpath("//*[@id='registration_form']/div/div[2]/div[1]/div/div[4]/div/button")).click();
    }
    public void ClickOnButtonRegistrationStep6() {
        driver.findElement(By.xpath("//*[@id='registration_cnt']/ul/div[5]/a")).click();
    }
    public void ClickOnButtonRegistrationStep7() {
        driver.findElement(By.xpath("//*[@id='registration_cnt']/div/div[5]/a")).click();
    }
}
