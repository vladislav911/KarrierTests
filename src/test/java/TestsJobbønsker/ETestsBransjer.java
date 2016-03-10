package TestsJobbønsker;
import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.fail;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ETestsBransjer extends TestBaseJobbønsker {

    @Test(priority = 1)
    public void verifyItemAdd() throws Exception {
        goToBransjer();
        choseBransjeFirstPositionItem();
        waitForElementPresent(By.xpath("//*[@id='topitems']/li/div"));
        refreshPageBransjer();
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li/div")).getText(), "Advokattjenester / Prosedyre");
    }

    @Test(priority = 2)
    public void verifyDeleteItemFromDropDown() throws Exception {
        choseBransjeFirstPositionItem();
        waitForElementPresent(By.xpath("//*[@id='topitems']/li[2]/div"));
        refreshPageBransjer();
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[2]/div")).getText(), "Bankvirksomhet");
    }

    @Test(priority = 3)
    public void verifyAdd10Items() throws Exception {
        choseBransjeFirstPositionItem();
        waitForElementPresent(By.xpath("//*[@id='topitems']/li[3]/div"));
        choseBransjeFirstPositionItem();
        waitForElementPresent(By.xpath("//*[@id='topitems']/li[4]/div"));
        choseBransjeFirstPositionItem();
        waitForElementPresent(By.xpath("//*[@id='topitems']/li[5]/div"));
        choseBransjeFirstPositionItem();
        waitForElementPresent(By.xpath("//*[@id='industryList']/div/div/div[2]/ul[2]/li/div"));
        choseBransjeFirstPositionItem();
        waitForElementPresent(By.xpath("//*[@id='industryList']/div/div/div[2]/ul[2]/li[2]/div"));
        choseBransjeFirstPositionItem();
        waitForElementPresent(By.xpath("//*[@id='industryList']/div/div/div[2]/ul[2]/li[3]/div"));
        choseBransjeFirstPositionItem();
        waitForElementPresent(By.xpath("//*[@id='industryList']/div/div/div[2]/ul[2]/li[4]/div"));
        choseBransjeFirstPositionItem();
        waitForElementPresent(By.xpath("//*[@id='industryList']/div/div/div[2]/ul[2]/li[5]/div"));
        refreshPageBransjer();
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li/div")).getText(), "Advokattjenester / Prosedyre");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[2]/div")).getText(), "Bankvirksomhet");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[3]/div")).getText(), "Bygg / Anlegg / Entreprenør");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[4]/div")).getText(), "Eiendom / Eiendomsmegling");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[5]/div")).getText(), "Engineering");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='industryList']/div/div/div[2]/ul[2]/li/div")).getText(), "Farmasi / Legemiddel");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='industryList']/div/div/div[2]/ul[2]/li[2]/div")).getText(), "Finans -verdipapirer / megling");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='industryList']/div/div/div[2]/ul[2]/li[3]/div")).getText(), "Forsikring / Assuranse");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='industryList']/div/div/div[2]/ul[2]/li[4]/div")).getText(), "Forskning og utvikling");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='industryList']/div/div/div[2]/ul[2]/li[5]/div")).getText(), "Helse / Velvære / Trening");
    }

    @Test(priority = 4)
    public void moveWithFire() throws Exception {
        // Move Items (ckick fire)
        driver.findElement(By.xpath("//*[@id='industryList']/div/div/div[2]/ul[2]/li[3]/div/i")).click();
        refreshPageBransjer();
        // Check position after first moving
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li/div")).getText(), "Advokattjenester / Prosedyre");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[2]/div")).getText(), "Bankvirksomhet");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[3]/div")).getText(), "Bygg / Anlegg / Entreprenør");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[4]/div")).getText(), "Eiendom / Eiendomsmegling");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[5]/div")).getText(), "Forsikring / Assuranse");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='industryList']/div/div/div[2]/ul[2]/li/div")).getText(), "Engineering");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='industryList']/div/div/div[2]/ul[2]/li[2]/div")).getText(), "Farmasi / Legemiddel");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='industryList']/div/div/div[2]/ul[2]/li[3]/div")).getText(), "Finans -verdipapirer / megling");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='industryList']/div/div/div[2]/ul[2]/li[4]/div")).getText(), "Forskning og utvikling");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='industryList']/div/div/div[2]/ul[2]/li[5]/div")).getText(), "Helse / Velvære / Trening");
        // Second moving Items
        driver.findElement(By.xpath("//*[@id='industryList']/div/div/div[2]/ul[2]/li[4]/div/i")).click();
        refreshPageBransjer();
        // Check position after second moving
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li/div")).getText(), "Advokattjenester / Prosedyre");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[2]/div")).getText(), "Bankvirksomhet");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[3]/div")).getText(), "Bygg / Anlegg / Entreprenør");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[4]/div")).getText(), "Eiendom / Eiendomsmegling");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[5]/div")).getText(), "Forskning og utvikling");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='industryList']/div/div/div[2]/ul[2]/li/div")).getText(), "Engineering");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='industryList']/div/div/div[2]/ul[2]/li[2]/div")).getText(), "Farmasi / Legemiddel");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='industryList']/div/div/div[2]/ul[2]/li[3]/div")).getText(), "Finans -verdipapirer / megling");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='industryList']/div/div/div[2]/ul[2]/li[4]/div")).getText(), "Forsikring / Assuranse");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='industryList']/div/div/div[2]/ul[2]/li[5]/div")).getText(), "Helse / Velvære / Trening");
    }

    @Test(priority = 5)
    public void moveWithArrow() throws Exception {
        // First moving
        driver.findElement(By.xpath("//*[@id='topitems']/li[2]/div/div/i")).click();
        refreshPageBransjer();
        // Check position after first moving
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li/div")).getText(), "Bankvirksomhet");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[2]/div")).getText(), "Advokattjenester / Prosedyre");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[3]/div")).getText(), "Bygg / Anlegg / Entreprenør");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[4]/div")).getText(), "Eiendom / Eiendomsmegling");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[5]/div")).getText(), "Forskning og utvikling");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='industryList']/div/div/div[2]/ul[2]/li/div")).getText(), "Engineering");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='industryList']/div/div/div[2]/ul[2]/li[2]/div")).getText(), "Farmasi / Legemiddel");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='industryList']/div/div/div[2]/ul[2]/li[3]/div")).getText(), "Finans -verdipapirer / megling");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='industryList']/div/div/div[2]/ul[2]/li[4]/div")).getText(), "Forsikring / Assuranse");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='industryList']/div/div/div[2]/ul[2]/li[5]/div")).getText(), "Helse / Velvære / Trening");
        // Second moving
        driver.findElement(By.xpath("//ul[@id='topitems']/li[5]/div/div/i")).click();
        refreshPageBransjer();
        // Check position after second moving
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li/div")).getText(), "Bankvirksomhet");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[2]/div")).getText(), "Advokattjenester / Prosedyre");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[3]/div")).getText(), "Bygg / Anlegg / Entreprenør");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[4]/div")).getText(), "Forskning og utvikling");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[5]/div")).getText(), "Eiendom / Eiendomsmegling");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='industryList']/div/div/div[2]/ul[2]/li/div")).getText(), "Engineering");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='industryList']/div/div/div[2]/ul[2]/li[2]/div")).getText(), "Farmasi / Legemiddel");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='industryList']/div/div/div[2]/ul[2]/li[3]/div")).getText(), "Finans -verdipapirer / megling");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='industryList']/div/div/div[2]/ul[2]/li[4]/div")).getText(), "Forsikring / Assuranse");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='industryList']/div/div/div[2]/ul[2]/li[5]/div")).getText(), "Helse / Velvære / Trening");
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
        refreshPageBransjer();
        // Check position after moving
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li/div")).getText(), "Advokattjenester / Prosedyre");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[2]/div")).getText(), "Forskning og utvikling");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[3]/div")).getText(), "Bygg / Anlegg / Entreprenør");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[4]/div")).getText(), "Eiendom / Eiendomsmegling");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[5]/div")).getText(), "Bankvirksomhet");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='industryList']/div/div/div[2]/ul[2]/li/div")).getText(), "Engineering");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='industryList']/div/div/div[2]/ul[2]/li[2]/div")).getText(), "Farmasi / Legemiddel");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='industryList']/div/div/div[2]/ul[2]/li[3]/div")).getText(), "Finans -verdipapirer / megling");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='industryList']/div/div/div[2]/ul[2]/li[4]/div")).getText(), "Forsikring / Assuranse");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='industryList']/div/div/div[2]/ul[2]/li[5]/div")).getText(), "Helse / Velvære / Trening");
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
        refreshPageBransjer();
        // Check position after moving
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li/div")).getText(), "Finans -verdipapirer / megling");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[2]/div")).getText(), "Farmasi / Legemiddel");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[3]/div")).getText(), "Advokattjenester / Prosedyre");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[4]/div")).getText(), "Forskning og utvikling");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[5]/div")).getText(), "Bygg / Anlegg / Entreprenør");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='industryList']/div/div/div[2]/ul[2]/li/div")).getText(), "Bankvirksomhet");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='industryList']/div/div/div[2]/ul[2]/li[2]/div")).getText(), "Eiendom / Eiendomsmegling");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='industryList']/div/div/div[2]/ul[2]/li[3]/div")).getText(), "Engineering");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='industryList']/div/div/div[2]/ul[2]/li[4]/div")).getText(), "Forsikring / Assuranse");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='industryList']/div/div/div[2]/ul[2]/li[5]/div")).getText(), "Helse / Velvære / Trening");
    }

    @Test(priority = 7)
    public void deleteFewItems() throws Exception {
        scrollPageUp();
        driver.findElement(By.xpath("//ul[@id='topitems']/li[5]/div/div/a/i")).click();
        scrollPageUp();
        driver.findElement(By.xpath("//*[@id='industryList']/div/div/div[2]/ul[2]/li[5]/div/a/i")).click();
        Thread.sleep(1000);
        refreshPageBransjer();
        assertElementNotPresent(By.xpath("//*[@id='topitems']/li[5]/div"));
        assertElementNotPresent(By.xpath("//*[@id='industryList']/div/div/div[2]/ul[2]/li[5]/div"));
    }

    /*@Test(priority = 8)
    public void deleteAllItems() throws Exception {
    }*/
}