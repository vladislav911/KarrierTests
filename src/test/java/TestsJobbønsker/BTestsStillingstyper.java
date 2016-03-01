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

public class BTestsStillingstyper extends TestBaseJobbønsker {
    @Test(priority = 1)
     public void verifyItemNotPresentWithoutOmfang () throws Exception {
        loggIn();
        goToStillingstyper();
        // Close reklam
        driver.findElement(By.xpath("//*[@id='staticad']/div/div[1]")).click();
        waitForElementPresent(By.xpath("//*[@id='employment_chosen']/a"));
        choseStillingstypeFrilans();
        assertElementNotPresent(By.xpath("//*[@id='topitems']/li/div"));
        assertElementNotPresent(By.xpath("//*[@id='topitems']/li[1]/div"));
    }


    @Test(priority = 2)
    public void verifyItemNotPresentWithoutStillingstype() throws Exception {
        goToStillingstyper();
        waitForElementPresent(By.xpath("//*[@id='worktime_chosen']/a"));
        choseOmfangHeltid();
        assertElementNotPresent(By.xpath("//*[@id='topitems']/li/div"));
        assertElementNotPresent(By.xpath("//*[@id='topitems']/li[1]/div"));
    }
    @Test(priority = 3)
    public void verifyItemAdd() throws Exception {
        goToStillingstyper();
        waitForElementPresent(By.xpath("//*[@id='employment_chosen']/a"));
        choseStillingstypeFrilans();
        choseOmfangHeltid();
        waitForElementPresent(By.xpath("//*[@id='topitems']/li/div"));
        refreshPage();
        waitForElementPresent(By.xpath("//*[@id='employment_chosen']/a"));
        Assert.assertTrue(isElementPresent(By.xpath("//*[@id='topitems']/li/div")));
    }

    @Test(priority = 4)
    public void verifyDoubleItemNotAdd() throws Exception {
        choseStillingstypeFrilans();
        choseOmfangDeltid();
        Assert.assertTrue(isElementPresent(By.xpath("//*[@id='topitems']/li/div")));
        assertElementNotPresent(By.xpath("//*[@id='topitems']/li[2]/div"));
        refreshPage();
        waitForElementPresent(By.xpath("//*[@id='employment_chosen']/a"));
        Assert.assertEquals(driver.findElement(By.cssSelector("div.elem-data-cont")).getText(), "Frilans (Deltid)");
        assertElementNotPresent(By.xpath("//*[@id='topitems']/li[2]/div"));
    }
    @Test(priority = 5)
    public void verifyChangeOmfang() throws Exception {
        choseStillingstypeFrilans();
        choseOmfangDeltid();
        Assert.assertTrue(isElementPresent(By.xpath("//*[@id='topitems']/li/div")));
        assertElementNotPresent(By.xpath("//*[@id='topitems']/li[2]/div"));
        refreshPage();
        waitForElementPresent(By.xpath("//*[@id='employment_chosen']/a"));
        assertElementNotPresent(By.xpath("//*[@id='topitems']/li[2]/div"));
    }

    @Test(priority = 6)
    public void verifyAdd10Items() throws Exception {
        choseStillingstypeAgent();
        scrollPageUp();
        choseOmfangDeltid();
        waitForElementPresent(By.xpath("//*[@id='topitems']/li[2]/div"));

        choseStillingstypeAnnet();
        scrollPageUp();
        choseOmfangHeltidDeltid();
        waitForElementPresent(By.xpath("//*[@id='topitems']/li[3]/div"));

        choseStillingstypeEkstrahjelp();
        scrollPageUp();
        choseOmfangHeltid();
        waitForElementPresent(By.xpath("//*[@id='topitems']/li[4]/div"));

        choseStillingstypeFast();
        scrollPageUp();
        choseOmfangDeltid();
        waitForElementPresent(By.xpath("//*[@id='topitems']/li[5]/div"));

        choseStillingstypeFranchisetaker();
        scrollPageUp();
        choseOmfangHeltidDeltid();
        waitForElementPresent(By.xpath("//*[@id='jobList']/div/div/div[2]/ul[2]/li[1]/div"));

        choseStillingstypeInternship();
        scrollPageUp();
        choseOmfangHeltid();
        waitForElementPresent(By.xpath("//*[@id='jobList']/div/div/div[2]/ul[2]/li[2]/div"));

        choseStillingstypeLærling();
        scrollPageUp();
        choseOmfangDeltid();
        waitForElementPresent(By.xpath("//*[@id='jobList']/div/div/div[2]/ul[2]/li[3]/div"));


        choseStillingstypeProsjekt();
        scrollPageUp();
        choseOmfangHeltidDeltid();
        waitForElementPresent(By.xpath("//*[@id='jobList']/div/div/div[2]/ul[2]/li[4]/div"));

        choseStillingstypeSommerjobb();
        scrollPageUp();
        choseOmfangHeltid();
        waitForElementPresent(By.xpath("//*[@id='jobList']/div/div/div[2]/ul[2]/li[5]/div"));

        refreshPage();
        waitForElementPresent(By.xpath("//*[@id='employment_chosen']/a"));
        Assert.assertTrue(isElementPresent(By.xpath("//*[@id='topitems']/li[5]/div")));
        Assert.assertTrue(isElementPresent(By.xpath("//*[@id='jobList']/div/div/div[2]/ul[2]/li[5]/div")));
    }
    @Test(priority = 7)
    public void moveWithFire() throws Exception {
        // Check position before moving
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li/div")).getText(), "Frilans (Deltid)");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[2]/div")).getText(), "Agent (Deltid)");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[3]/div")).getText(), "Annet (Heltid / deltid)");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[4]/div")).getText(), "Ekstrahjelp (Heltid)");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[5]/div")).getText(), "Fast ansettelse (Deltid)");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='jobList']/div/div/div[2]/ul[2]/li/div")).getText(), "Franchisetaker (Heltid / deltid)");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='jobList']/div/div/div[2]/ul[2]/li[2]/div")).getText(), "Internship (Heltid)");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='jobList']/div/div/div[2]/ul[2]/li[3]/div")).getText(), "Lærling (Deltid)");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='jobList']/div/div/div[2]/ul[2]/li[4]/div")).getText(), "Prosjekt / Engasjement (Heltid / deltid)");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='jobList']/div/div/div[2]/ul[2]/li[5]/div")).getText(), "Sommerjobb / sesongjobb (Heltid)");
        // Move Items (ckick fire)
        driver.findElement(By.xpath("//div[@id='jobList']/div/div/div[2]/ul[2]/li/div/i")).click();
        refreshPage();
        waitForElementPresent(By.xpath("//*[@id='employment_chosen']/a"));
        // Check position after first moving
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li/div")).getText(), "Frilans (Deltid)");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[2]/div")).getText(), "Agent (Deltid)");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[3]/div")).getText(), "Annet (Heltid / deltid)");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[4]/div")).getText(), "Ekstrahjelp (Heltid)");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[5]/div")).getText(), "Franchisetaker (Heltid / deltid)");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='jobList']/div/div/div[2]/ul[2]/li/div")).getText(), "Fast ansettelse (Deltid)");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='jobList']/div/div/div[2]/ul[2]/li[2]/div")).getText(), "Internship (Heltid)");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='jobList']/div/div/div[2]/ul[2]/li[3]/div")).getText(), "Lærling (Deltid)");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='jobList']/div/div/div[2]/ul[2]/li[4]/div")).getText(), "Prosjekt / Engasjement (Heltid / deltid)");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='jobList']/div/div/div[2]/ul[2]/li[5]/div")).getText(), "Sommerjobb / sesongjobb (Heltid)");
        // Second moving Items
        driver.findElement(By.xpath("//div[@id='jobList']/div/div/div[2]/ul[2]/li[2]/div/i")).click();
        refreshPage();
        waitForElementPresent(By.xpath("//*[@id='employment_chosen']/a"));
        // Check position after second moving
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[2]/div")).getText(), "Agent (Deltid)");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[3]/div")).getText(), "Annet (Heltid / deltid)");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[4]/div")).getText(), "Ekstrahjelp (Heltid)");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[5]/div")).getText(), "Internship (Heltid)");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='jobList']/div/div/div[2]/ul[2]/li/div")).getText(), "Fast ansettelse (Deltid)");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='jobList']/div/div/div[2]/ul[2]/li[2]/div")).getText(), "Franchisetaker (Heltid / deltid)");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='jobList']/div/div/div[2]/ul[2]/li[3]/div")).getText(), "Lærling (Deltid)");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='jobList']/div/div/div[2]/ul[2]/li[4]/div")).getText(), "Prosjekt / Engasjement (Heltid / deltid)");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='jobList']/div/div/div[2]/ul[2]/li[5]/div")).getText(), "Sommerjobb / sesongjobb (Heltid)");
    }
    @Test(priority = 8)
    public void moveWithArrow() throws Exception {
        // First moving
        driver.findElement(By.xpath("//*[@id='topitems']/li[2]/div/div/i")).click();
        refreshPage();
        waitForElementPresent(By.xpath("//*[@id='employment_chosen']/a"));
        // Check position after first moving
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[2]/div")).getText(), "Frilans (Deltid)");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[3]/div")).getText(), "Annet (Heltid / deltid)");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[4]/div")).getText(), "Ekstrahjelp (Heltid)");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[5]/div")).getText(), "Internship (Heltid)");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='jobList']/div/div/div[2]/ul[2]/li/div")).getText(), "Fast ansettelse (Deltid)");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='jobList']/div/div/div[2]/ul[2]/li[2]/div")).getText(), "Franchisetaker (Heltid / deltid)");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='jobList']/div/div/div[2]/ul[2]/li[3]/div")).getText(), "Lærling (Deltid)");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='jobList']/div/div/div[2]/ul[2]/li[4]/div")).getText(), "Prosjekt / Engasjement (Heltid / deltid)");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='jobList']/div/div/div[2]/ul[2]/li[5]/div")).getText(), "Sommerjobb / sesongjobb (Heltid)");
        // Second moving
        driver.findElement(By.xpath("//ul[@id='topitems']/li[5]/div/div/i")).click();
        refreshPage();
        waitForElementPresent(By.xpath("//*[@id='employment_chosen']/a"));
        // Check position after second moving
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[2]/div")).getText(), "Frilans (Deltid)");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[3]/div")).getText(), "Annet (Heltid / deltid)");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[4]/div")).getText(), "Internship (Heltid)");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[5]/div")).getText(), "Ekstrahjelp (Heltid)");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='jobList']/div/div/div[2]/ul[2]/li/div")).getText(), "Fast ansettelse (Deltid)");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='jobList']/div/div/div[2]/ul[2]/li[2]/div")).getText(), "Franchisetaker (Heltid / deltid)");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='jobList']/div/div/div[2]/ul[2]/li[3]/div")).getText(), "Lærling (Deltid)");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='jobList']/div/div/div[2]/ul[2]/li[4]/div")).getText(), "Prosjekt / Engasjement (Heltid / deltid)");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='jobList']/div/div/div[2]/ul[2]/li[5]/div")).getText(), "Sommerjobb / sesongjobb (Heltid)");
    }
    @Test(priority = 9)
    public void moveWithDragAndDrop() throws Exception {
        // Scroll page to top Items
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//li[2]/div")));
        ((JavascriptExecutor)driver).executeScript("scroll(0,450)");
        // Move 4 Top Item to 3 position
        Actions slider = new Actions(driver)
                .dragAndDropBy(driver.findElement(By.xpath("//li[4]/div")),0, -45);
        slider
                .build()
                .perform();
        Thread.sleep(1000);
        // Move 1 Top Item to 5 position
        Actions slider2 = new Actions(driver)
                .dragAndDropBy(driver.findElement(By.xpath("//li/div")),0, 170);
        slider2
                .build()
                .perform();
        Thread.sleep(1000);
        refreshPage();
        waitForElementPresent(By.xpath("//*[@id='employment_chosen']/a"));
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li/div")).getText(), "Frilans (Deltid)");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[2]/div")).getText(), "Internship (Heltid)");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[3]/div")).getText(), "Annet (Heltid / deltid)");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[4]/div")).getText(), "Ekstrahjelp (Heltid)");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[5]/div")).getText(), "Agent (Deltid)");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='jobList']/div/div/div[2]/ul[2]/li/div")).getText(), "Fast ansettelse (Deltid)");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='jobList']/div/div/div[2]/ul[2]/li[2]/div")).getText(), "Franchisetaker (Heltid / deltid)");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='jobList']/div/div/div[2]/ul[2]/li[3]/div")).getText(), "Lærling (Deltid)");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='jobList']/div/div/div[2]/ul[2]/li[4]/div")).getText(), "Prosjekt / Engasjement (Heltid / deltid)");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='jobList']/div/div/div[2]/ul[2]/li[5]/div")).getText(), "Sommerjobb / sesongjobb (Heltid)");
        // Scroll page to top Items
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//li[2]/div")));
        ((JavascriptExecutor)driver).executeScript("scroll(0,450)");
        // Move 2 Item Joblist to Top Items
        Actions slider3 = new Actions(driver)
                .dragAndDropBy(driver.findElement(By.xpath("//ul[2]/li[2]/div")),0, -200);
        slider3
                .build()
                .perform();
        Thread.sleep(1000);
        Actions slider4 = new Actions(driver)
                .dragAndDropBy(driver.findElement(By.xpath("//ul[2]/li[3]/div")),0, -205);
        slider4
                .build()
                .perform();
        Thread.sleep(1000);
        refreshPage();
        waitForElementPresent(By.xpath("//*[@id='employment_chosen']/a"));
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li/div")).getText(), "Lærling (Deltid)");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[2]/div")).getText(), "Franchisetaker (Heltid / deltid)");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[3]/div")).getText(), "Frilans (Deltid)");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[4]/div")).getText(), "Internship (Heltid)");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[5]/div")).getText(), "Annet (Heltid / deltid)");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='jobList']/div/div/div[2]/ul[2]/li/div")).getText(), "Agent (Deltid)");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='jobList']/div/div/div[2]/ul[2]/li[2]/div")).getText(), "Ekstrahjelp (Heltid)");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='jobList']/div/div/div[2]/ul[2]/li[3]/div")).getText(), "Fast ansettelse (Deltid)");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='jobList']/div/div/div[2]/ul[2]/li[4]/div")).getText(), "Prosjekt / Engasjement (Heltid / deltid)");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='jobList']/div/div/div[2]/ul[2]/li[5]/div")).getText(), "Sommerjobb / sesongjobb (Heltid)");
    }
    @Test(priority = 10)
    public void deleteFewItems() throws Exception {
        scrollPageUp();
        driver.findElement(By.xpath("//ul[@id='topitems']/li[5]/div/div/a/i")).click();
        scrollPageUp();
        driver.findElement(By.xpath("//div[@id='jobList']/div/div/div[2]/ul[2]/li[5]/div/a/i")).click();
        Thread.sleep(1000);
        refreshPage();
        waitForElementPresent(By.xpath("//*[@id='employment_chosen']/a"));
        assertElementNotPresent(By.xpath("//*[@id='topitems']/li[5]/div"));
        assertElementNotPresent(By.xpath("//*[@id='jobList']/div/div/div[2]/ul[2]/li[5]/div"));
    }
    @Test(priority = 11)
    public void deleteAllItems() throws Exception {
        loggIn();
        goToStillingstyper();
        waitForElementPresent(By.xpath("//*[@id='employment_chosen']/a"));
        // Close reklam
        driver.findElement(By.xpath("//*[@id='staticad']/div/div[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Slett alle")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Ja")).click();
        Thread.sleep(5000);
        waitForAjax1();
        Thread.sleep(5000);
        refreshPage();
        waitForElementPresent(By.xpath("//*[@id='employment_chosen']/a"));
        assertElementNotPresent(By.xpath("//*[@id='topitems']/li[1]/div"));
        assertElementNotPresent(By.xpath("//*[@id='topitems']/li[2]/div"));
        assertElementNotPresent(By.xpath("//*[@id='topitems']/li[3]/div"));
        assertElementNotPresent(By.xpath("//*[@id='topitems']/li[4]/div"));
        assertElementNotPresent(By.xpath("//*[@id='topitems']/li[5]/div"));
        assertElementNotPresent(By.xpath("//*[@id='jobList']/div/div/div[2]/ul[2]/li[1]/div"));
        assertElementNotPresent(By.xpath("//*[@id='jobList']/div/div/div[2]/ul[2]/li[2]/div"));
        assertElementNotPresent(By.xpath("//*[@id='jobList']/div/div/div[2]/ul[2]/li[3]/div"));
        assertElementNotPresent(By.xpath("//*[@id='jobList']/div/div/div[2]/ul[2]/li[4]/div"));
        assertElementNotPresent(By.xpath("//*[@id='jobList']/div/div/div[2]/ul[2]/li[5]/div"));
    }
}



