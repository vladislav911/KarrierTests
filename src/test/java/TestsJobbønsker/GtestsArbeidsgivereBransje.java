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

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.fail;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GtestsArbeidsgivereBransje extends TestBaseJobbønsker {

    @Test(priority = 1)
    public void verifyItemNotAddWithoutBransje () throws Exception {
        goToArbeidsgivereBransje();
        driver.findElement(By.xpath("//*[@id='company_select_chosen']/a")).click();
        Thread.sleep(1500);
        assertElementNotPresent(By.xpath("//*[@id='company_select_chosen']/div/ul/li[1]"));
    }

    @Test(priority = 2)
    public void verifyItemNotAddWithoutFirma () throws Exception {
        choseBransjeAdvokat();
        Thread.sleep(1000);
        refreshPageArbeidsgivereBransje();
        assertElementNotPresent(By.xpath("//*[@id='topitems']/li/div"));
        assertElementNotPresent(By.xpath("//*[@id='topitems']/li[1]/div"));
    }

    @Test(priority = 3)
    public void verifyItemAdd() throws Exception {
        goToArbeidsgivereBransje();
        choseBransjeAdvokat();
        choseFirmaAdvokatfirmaetCLP();
        waitForElementPresent(By.xpath("//*[@id='topitems']/li/div"));
        refreshPageArbeidsgivereBransje();
        Assert.assertTrue(isElementPresent(By.xpath("//*[@id='topitems']/li/div")));
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li/div")).getText(), "Advokatfirmaet CLP");
    }

    @Test(priority = 4)
    public void verifyDoubleItemNotAdd() throws Exception {
        choseBransjeAdvokat();
        choseFirmaAdvokatfirmaetCLP();
        waitForElementPresent(By.xpath("//*[@id='topitems']/li[2]/div"));
        refreshPageArbeidsgivereBransje();
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[2]/div")).getText(), "Advokatfirmaet Eurojuris Haugesund AS");
    }

    @Test(priority = 5)
    public void verifyAdd10Items() throws Exception {
        choseBransjeBankvirksomhet();
        scrollPageUp();
        Thread.sleep(1000);
        choseFirmaABNAmro();
        waitForElementPresent(By.xpath("//*[@id='topitems']/li[3]/div"));

        choseBransjeEiendom();
        scrollPageUp();
        Thread.sleep(1000);
        choseFirmaABBL();
        waitForElementPresent(By.xpath("//*[@id='topitems']/li[4]/div"));

        choseBransjeEngineering();
        scrollPageUp();
        Thread.sleep(1000);
        choseFirmaBS();
        waitForElementPresent(By.xpath("//*[@id='topitems']/li[5]/div"));

        choseBransjeFarmasi();
        scrollPageUp();
        Thread.sleep(1000);
        choseFirmaGE();
        waitForElementPresent(By.xpath("//*[@id='companyList']/div/div/div[2]/ul[2]/li/div"));

        choseBransjeFinans();
        scrollPageUp();
        Thread.sleep(1000);
        choseFirmaABG();
        waitForElementPresent(By.xpath("//*[@id='companyList']/div/div/div[2]/ul[2]/li[2]/div"));

        choseBransjeForsikring();
        scrollPageUp();
        Thread.sleep(1000);
        choseFirmaAGIOS();
        waitForElementPresent(By.xpath("//*[@id='companyList']/div/div/div[2]/ul[2]/li[3]/div"));

        choseBransjeForsikringOg();
        scrollPageUp();
        Thread.sleep(1000);
        choseFirmaABB();
        waitForElementPresent(By.xpath("//*[@id='companyList']/div/div/div[2]/ul[2]/li[4]/div"));

        choseBransjeHelse();
        scrollPageUp();
        Thread.sleep(1000);
        choseFirmaBeauty();
        waitForElementPresent(By.xpath("//*[@id='companyList']/div/div/div[2]/ul[2]/li[5]/div"));
        refreshPageArbeidsgivereBransje();
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li/div")).getText(), "Advokatfirmaet CLP");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[2]/div")).getText(), "Advokatfirmaet Eurojuris Haugesund AS");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[3]/div")).getText(), "ABN Amro");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[4]/div")).getText(), "ABBL");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[5]/div")).getText(), "BS Teknikk");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li/div")).getText(), "ABB");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li[2]/div")).getText(), "ABG Sundal Collier");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li[3]/div")).getText(), "AGIOS AS");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li[4]/div")).getText(), "Beauty Trend");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li[5]/div")).getText(), "GE Norway");
    }

    @Test(priority = 6)
    public void moveWithFire() throws Exception {
        // Move Items (ckick fire)
        driver.findElement(By.xpath("//*[@id='companyList']/div/div/div[2]/ul[2]/li[3]/div/i")).click();
        refreshPageArbeidsgivereBransje();
        // Check position after first moving
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li/div")).getText(), "Advokatfirmaet CLP");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[2]/div")).getText(), "Advokatfirmaet Eurojuris Haugesund AS");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[3]/div")).getText(), "ABN Amro");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[4]/div")).getText(), "ABBL");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[5]/div")).getText(), "AGIOS AS");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li/div")).getText(), "ABB");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li[2]/div")).getText(), "ABG Sundal Collier");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li[3]/div")).getText(), "Beauty Trend");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li[4]/div")).getText(), "BS Teknikk");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li[5]/div")).getText(), "GE Norway");
        // Second moving Items
        driver.findElement(By.xpath("//*[@id='companyList']/div/div/div[2]/ul[2]/li[4]/div/i")).click();
        refreshPageArbeidsgivereBransje();
        // Check position after second moving
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li/div")).getText(), "Advokatfirmaet CLP");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[2]/div")).getText(), "Advokatfirmaet Eurojuris Haugesund AS");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[3]/div")).getText(), "ABN Amro");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[4]/div")).getText(), "ABBL");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[5]/div")).getText(), "BS Teknikk");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li/div")).getText(), "ABB");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li[2]/div")).getText(), "ABG Sundal Collier");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li[3]/div")).getText(), "AGIOS AS");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li[4]/div")).getText(), "Beauty Trend");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li[5]/div")).getText(), "GE Norway");
    }
    @Test(priority = 7)
    public void moveWithArrow() throws Exception {
        // First moving
        driver.findElement(By.xpath("//*[@id='topitems']/li[2]/div/div/i")).click();
        refreshPageArbeidsgivere();
        // Check position after first moving
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li/div")).getText(), "Advokatfirmaet Eurojuris Haugesund AS");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[2]/div")).getText(), "Advokatfirmaet CLP");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[3]/div")).getText(), "ABN Amro");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[4]/div")).getText(), "ABBL");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[5]/div")).getText(), "BS Teknikk");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li/div")).getText(), "ABB");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li[2]/div")).getText(), "ABG Sundal Collier");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li[3]/div")).getText(), "AGIOS AS");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li[4]/div")).getText(), "Beauty Trend");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li[5]/div")).getText(), "GE Norway");
        goToArbeidsgivereBransje();
        // Second moving
        driver.findElement(By.xpath("//ul[@id='topitems']/li[5]/div/div/i")).click();
        refreshPageArbeidsgivereBransje();
        // Check position after second moving
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li/div")).getText(), "Advokatfirmaet Eurojuris Haugesund AS");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[2]/div")).getText(), "Advokatfirmaet CLP");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[3]/div")).getText(), "ABN Amro");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[4]/div")).getText(), "BS Teknikk");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[5]/div")).getText(), "ABBL");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li/div")).getText(), "ABB");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li[2]/div")).getText(), "ABG Sundal Collier");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li[3]/div")).getText(), "AGIOS AS");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li[4]/div")).getText(), "Beauty Trend");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li[5]/div")).getText(), "GE Norway");
    }

    @Test(priority = 8)
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
        refreshPageArbeidsgivereBransje();
        // Check position after moving
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li/div")).getText(), "Advokatfirmaet CLP");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[2]/div")).getText(), "BS Teknikk");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[3]/div")).getText(), "ABN Amro");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[4]/div")).getText(), "ABBL");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[5]/div")).getText(), "Advokatfirmaet Eurojuris Haugesund AS");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li/div")).getText(), "ABB");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li[2]/div")).getText(), "ABG Sundal Collier");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li[3]/div")).getText(), "AGIOS AS");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li[4]/div")).getText(), "Beauty Trend");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li[5]/div")).getText(), "GE Norway");
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
        refreshPageArbeidsgivereBransje();
        // Check position after moving
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li/div")).getText(), "AGIOS AS");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[2]/div")).getText(), "ABG Sundal Collier");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[3]/div")).getText(), "Advokatfirmaet CLP");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[4]/div")).getText(), "BS Teknikk");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[5]/div")).getText(), "ABN Amro");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li/div")).getText(), "ABB");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li[2]/div")).getText(), "ABBL");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li[3]/div")).getText(), "Advokatfirmaet Eurojuris Haugesund AS");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li[4]/div")).getText(), "Beauty Trend");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li[5]/div")).getText(), "GE Norway");
    }

    @Test(priority = 9)
    public void deleteFewItems() throws Exception {
        scrollPageUp();
        driver.findElement(By.xpath("//ul[@id='topitems']/li[5]/div/div/a/i")).click();
        scrollPageUp();
        driver.findElement(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li[5]/div/a/i")).click();
        Thread.sleep(1000);
        refreshPageArbeidsgivereBransje();
        assertElementNotPresent(By.xpath("//*[@id='topitems']/li[5]/div"));
        assertElementNotPresent(By.xpath("//div[@id='companyList']/div/div/div[2]/ul[2]/li[5]/div"));
    }
}