package TestsJobbønsker;
import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ThreadGuard;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.fail;

import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FTestsArbeidsgivereFirmanavn extends TestBaseJobbønsker {

    @Test(priority = 1)
    public void verifyItemAdd() throws Exception {
        loggIn();
        goToArbeidsgivere();
        // Close reklam
        driver.findElement(By.xpath("//*[@id='staticad']/div/div[1]")).click();
        driver.findElement(By.id("CompanyName")).sendKeys("Ab");
        waitForElementPresent(By.xpath("//ul[@id='ui-id-1']/li"));
        driver.findElement(By.xpath("//ul[@id='ui-id-1']/li")).click();
        waitForElementPresent(By.xpath("//*[@id='topitems']/li/div"));
        refreshPageArbeidsgivere();
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li/div")).getText(), "A/STAB");
    }

    @Test(priority = 2)
    public void verifyDoubleItemNotAdd() throws Exception {
        driver.findElement(By.id("CompanyName")).sendKeys("Ab");
        driver.findElement(By.xpath("//ul[@id='ui-id-1']/li")).click();
        refreshPageArbeidsgivere();
        assertElementNotPresent(By.xpath("//*[@id='topitems']/li[2]/div"));
    }

    @Test(priority = 3)
    public void verifyAdd10Items() throws Exception {
        driver.findElement(By.id("CompanyName")).sendKeys("2tal AS.");
        Thread.sleep(1500);
        driver.findElement(By.id("CompanyName")).sendKeys(Keys.DOWN);
        Thread.sleep(500);
        driver.findElement(By.id("CompanyName")).sendKeys(Keys.ENTER);
        waitForElementPresent(By.xpath("//*[@id='topitems']/li[2]/div"));

        driver.findElement(By.id("CompanyName")).sendKeys("3T Produkter");
        Thread.sleep(1500);
        driver.findElement(By.id("CompanyName")).sendKeys(Keys.DOWN);
        Thread.sleep(500);
        driver.findElement(By.id("CompanyName")).sendKeys(Keys.ENTER);
        waitForElementPresent(By.xpath("//*[@id='topitems']/li[3]/div"));

        driver.findElement(By.id("CompanyName")).sendKeys("ARK Alta");
        Thread.sleep(1500);
        driver.findElement(By.id("CompanyName")).sendKeys(Keys.DOWN);
        Thread.sleep(500);
        driver.findElement(By.id("CompanyName")).sendKeys(Keys.ENTER);
        waitForElementPresent(By.xpath("//*[@id='topitems']/li[4]/div"));

        driver.findElement(By.id("CompanyName")).sendKeys("4 SOLUTIONS");
        Thread.sleep(1500);
        driver.findElement(By.id("CompanyName")).sendKeys(Keys.DOWN);
        Thread.sleep(500);
        driver.findElement(By.id("CompanyName")).sendKeys(Keys.ENTER);
        waitForElementPresent(By.xpath("//*[@id='topitems']/li[5]/div"));

        driver.findElement(By.id("CompanyName")).sendKeys("AJ Gassdeteksjon");
        Thread.sleep(1500);
        driver.findElement(By.id("CompanyName")).sendKeys(Keys.DOWN);
        Thread.sleep(500);
        driver.findElement(By.id("CompanyName")).sendKeys(Keys.ENTER);
        waitForElementPresent(By.xpath("//*[@id='companyList']/div/div/div[2]/ul[2]/li/div"));

        driver.findElement(By.id("CompanyName")).sendKeys("123 Bad");
        Thread.sleep(1500);
        driver.findElement(By.id("CompanyName")).sendKeys(Keys.DOWN);
        Thread.sleep(500);
        driver.findElement(By.id("CompanyName")).sendKeys(Keys.ENTER);
        waitForElementPresent(By.xpath("//*[@id='companyList']/div/div/div[2]/ul[2]/li[2]/div"));

        driver.findElement(By.id("CompanyName")).sendKeys("800Renhold");
        Thread.sleep(1500);
        driver.findElement(By.id("CompanyName")).sendKeys(Keys.DOWN);
        Thread.sleep(500);
        driver.findElement(By.id("CompanyName")).sendKeys(Keys.ENTER);
        waitForElementPresent(By.xpath("//*[@id='companyList']/div/div/div[2]/ul[2]/li[3]/div"));

        driver.findElement(By.id("CompanyName")).sendKeys("Bohus Bryne");
        Thread.sleep(1500);
        driver.findElement(By.id("CompanyName")).sendKeys(Keys.DOWN);
        Thread.sleep(500);
        driver.findElement(By.id("CompanyName")).sendKeys(Keys.ENTER);
        waitForElementPresent(By.xpath("//*[@id='companyList']/div/div/div[2]/ul[2]/li[4]/div"));

        driver.findElement(By.id("CompanyName")).sendKeys("KOVO");
        Thread.sleep(1500);
        driver.findElement(By.id("CompanyName")).sendKeys(Keys.DOWN);
        Thread.sleep(500);
        driver.findElement(By.id("CompanyName")).sendKeys(Keys.ENTER);
        waitForElementPresent(By.xpath("//*[@id='companyList']/div/div/div[2]/ul[2]/li[5]/div"));

        refreshPageArbeidsgivere();
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li/div")).getText(), "A/STAB");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[2]/div")).getText(), "2tal AS.");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[3]/div")).getText(), "3T Produkter");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[4]/div")).getText(), "ARK Alta");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[5]/div")).getText(), "4 SOLUTIONS");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li/div")).getText(), "123 Bad");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li[2]/div")).getText(), "800Renhold");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li[3]/div")).getText(), "AJ Gassdeteksjon");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li[4]/div")).getText(), "Bohus Bryne");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li[5]/div")).getText(), "KOVO");
    }

    @Test(priority = 4)
    public void moveWithFire() throws Exception {
        // Move Items (ckick fire)
        driver.findElement(By.xpath("//*[@id='companyList']/div/div/div[2]/ul[2]/li[3]/div/i")).click();
        refreshPageArbeidsgivere();
        // Check position after first moving
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li/div")).getText(), "A/STAB");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[2]/div")).getText(), "2tal AS.");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[3]/div")).getText(), "3T Produkter");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[4]/div")).getText(), "ARK Alta");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[5]/div")).getText(), "AJ Gassdeteksjon");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li/div")).getText(), "123 Bad");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li[2]/div")).getText(), "4 SOLUTIONS");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li[3]/div")).getText(), "800Renhold");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li[4]/div")).getText(), "Bohus Bryne");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li[5]/div")).getText(), "KOVO");
        // Second moving Items
        driver.findElement(By.xpath("//*[@id='companyList']/div/div/div[2]/ul[2]/li[4]/div/i")).click();
        refreshPageArbeidsgivere();
        // Check position after second moving
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li/div")).getText(), "A/STAB");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[2]/div")).getText(), "2tal AS.");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[3]/div")).getText(), "3T Produkter");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[4]/div")).getText(), "ARK Alta");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[5]/div")).getText(), "Bohus Bryne");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li/div")).getText(), "123 Bad");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li[2]/div")).getText(), "4 SOLUTIONS");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li[3]/div")).getText(), "800Renhold");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li[4]/div")).getText(), "AJ Gassdeteksjon");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li[5]/div")).getText(), "KOVO");
    }

    @Test(priority = 5)
    public void moveWithArrow() throws Exception {
        // First moving
        driver.findElement(By.xpath("//*[@id='topitems']/li[2]/div/div/i")).click();
        refreshPageArbeidsgivere();
        // Check position after first moving
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li/div")).getText(), "2tal AS.");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[2]/div")).getText(), "A/STAB");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[3]/div")).getText(), "3T Produkter");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[4]/div")).getText(), "ARK Alta");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[5]/div")).getText(), "Bohus Bryne");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li/div")).getText(), "123 Bad");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li[2]/div")).getText(), "4 SOLUTIONS");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li[3]/div")).getText(), "800Renhold");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li[4]/div")).getText(), "AJ Gassdeteksjon");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li[5]/div")).getText(), "KOVO");
        // Second moving
        driver.findElement(By.xpath("//ul[@id='topitems']/li[5]/div/div/i")).click();
        refreshPageArbeidsgivere();
        // Check position after second moving
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li/div")).getText(), "2tal AS.");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[2]/div")).getText(), "A/STAB");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[3]/div")).getText(), "3T Produkter");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[4]/div")).getText(), "Bohus Bryne");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[5]/div")).getText(), "ARK Alta");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li/div")).getText(), "123 Bad");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li[2]/div")).getText(), "4 SOLUTIONS");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li[3]/div")).getText(), "800Renhold");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li[4]/div")).getText(), "AJ Gassdeteksjon");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li[5]/div")).getText(), "KOVO");
    }

    @Test(priority = 6)
    public void moveWithDragAndDrop() throws Exception {
        // Scroll page to top Items
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//li[2]/div")));
        ((JavascriptExecutor) driver).executeScript("scroll(0,450)");
        // Move 4 Top Item to 3 position
        Actions slider = new Actions(driver)
                .dragAndDropBy(driver.findElement(By.xpath("//li[4]/div")), 0, -45);
        slider
                .build()
                .perform();
        Thread.sleep(1000);
        /// Move 1 Top Item to 5 position
        Actions slider2 = new Actions(driver)
                .dragAndDropBy(driver.findElement(By.xpath("//li/div")),0, 170);
        slider2
                .build()
                .perform();
        Thread.sleep(1000);
        refreshPageArbeidsgivere();
        // Check position after moving
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li/div")).getText(), "A/STAB");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[2]/div")).getText(), "Bohus Bryne");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[3]/div")).getText(), "3T Produkter");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[4]/div")).getText(), "ARK Alta");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[5]/div")).getText(), "2tal AS.");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li/div")).getText(), "123 Bad");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li[2]/div")).getText(), "4 SOLUTIONS");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li[3]/div")).getText(), "800Renhold");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li[4]/div")).getText(), "AJ Gassdeteksjon");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li[5]/div")).getText(), "KOVO");
        // Scroll page to top Items
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//li[2]/div")));
        ((JavascriptExecutor) driver).executeScript("scroll(0,450)");
        // Move 2 Item CategoryList to Top Items
        Actions slider3 = new Actions(driver)
                .dragAndDropBy(driver.findElement(By.xpath("//ul[2]/li[2]/div")), 0, -200);
        slider3
                .build()
                .perform();
        Thread.sleep(1000);
        // Move 3 Item CategoryList to Top Items
        Actions slider4 = new Actions(driver)
                .dragAndDropBy(driver.findElement(By.xpath("//ul[2]/li[3]/div")), 0, -205);
        slider4
                .build()
                .perform();
        Thread.sleep(1000);
        refreshPageArbeidsgivere();
        // Check position after moving
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li/div")).getText(), "800Renhold");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[2]/div")).getText(), "4 SOLUTIONS");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[3]/div")).getText(), "A/STAB");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[4]/div")).getText(), "Bohus Bryne");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[5]/div")).getText(), "3T Produkter");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li/div")).getText(), "123 Bad");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li[2]/div")).getText(), "2tal AS.");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li[3]/div")).getText(), "AJ Gassdeteksjon");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li[4]/div")).getText(), "ARK Alta");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li[5]/div")).getText(), "KOVO");
    }
    @Test(priority = 7)
    public void deleteFewItems() throws Exception {
        scrollPageUp();
        driver.findElement(By.xpath("//ul[@id='topitems']/li[5]/div/div/a/i")).click();
        scrollPageUp();
        driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li[5]/div/a/i")).click();
        Thread.sleep(1000);
        refreshPageArbeidsgivere();
        assertElementNotPresent(By.xpath("//*[@id='topitems']/li[5]/div"));
        assertElementNotPresent(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li[5]/div"));
    }
    @Test(priority = 8)
    public void deleteAllItems() throws Exception {
        scrollPageUp();
        driver.findElement(By.xpath("//*[@id='topitems']/li[4]/div/div/a/i")).click();
        Thread.sleep(1000);
        scrollPageUp();
        driver.findElement(By.xpath("//*[@id='topitems']/li[3]/div/div/a/i")).click();
        Thread.sleep(1000);
        scrollPageUp();
        driver.findElement(By.xpath("//*[@id='topitems']/li[2]/div/div/a/i")).click();
        Thread.sleep(1000);
        scrollPageUp();
        driver.findElement(By.xpath("//*[@id='topitems']/li/div/div/a/i")).click();
        Thread.sleep(1000);
        scrollPageUp();
        driver.findElement(By.xpath("//*[@id='companyList']/div/div/div[2]/ul[2]/li[4]/div/a/i")).click();
        Thread.sleep(1000);
        scrollPageUp();
        driver.findElement(By.xpath("//*[@id='companyList']/div/div/div[2]/ul[2]/li[3]/div/a/i")).click();
        Thread.sleep(1000);
        scrollPageUp();
        driver.findElement(By.xpath("//*[@id='companyList']/div/div/div[2]/ul[2]/li[2]/div/a/i")).click();
        Thread.sleep(1000);
        scrollPageUp();
        driver.findElement(By.xpath("//*[@id='companyList']/div/div/div[2]/ul[2]/li/div/a/i")).click();
        Thread.sleep(1000);
        refreshPageArbeidsgivere();
        assertElementNotPresent(By.xpath("//*[@id='topitems']/li/div/div/a/i"));
        assertElementNotPresent(By.xpath("//*[@id='topitems']/li[1]/div"));
        assertElementNotPresent(By.xpath("//*[@id='companyList']/div/div/div[2]/ul[2]/li/div/a/i"));
        assertElementNotPresent(By.xpath("/*[@id='companyList']/div/div/div[2]/ul[2]/li[1]/div"));
    }
}
