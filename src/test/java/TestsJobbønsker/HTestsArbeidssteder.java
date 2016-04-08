package TestsJobbønsker;
import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.fail;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HTestsArbeidssteder extends TestBaseJobbønsker {

    @Test(priority = 1)
    public void verifyItemAdd() throws Exception {
        goToArbeidssteder();
        choseStedThirdPositionItem();
        waitForElementPresent(By.xpath("//*[@id='topitems']/li/div"));
        refreshPageArbeidssteder();
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li/div")).getText(), "Asker");
    }

    @Test(priority = 2)
    public void verifyDeleteItemFromDropDown() throws Exception {
        choseStedThirdPositionItem();
        waitForElementPresent(By.xpath("//*[@id='topitems']/li[2]/div"));
        refreshPageArbeidssteder();
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[2]/div")).getText(), "Aurskog-Høland");
    }

    @Test(priority = 3)
    public void verifyAdd10Items() throws Exception {
        choseStedThirdPositionItem();
        waitForElementPresent(By.xpath("//*[@id='topitems']/li[3]/div"));
        choseStedThirdPositionItem();
        waitForElementPresent(By.xpath("//*[@id='topitems']/li[4]/div"));
        choseStedThirdPositionItem();
        waitForElementPresent(By.xpath("//*[@id='topitems']/li[5]/div"));
        choseStedThirdPositionItem();
        waitForElementPresent(By.xpath("//*[@id='locationList']/div/div/div[2]/ul[2]/li/div/ul/li/div"));
        choseStedThirdPositionItem();
        waitForElementPresent(By.xpath("//*[@id='locationList']/div/div/div[2]/ul[2]/li/div/ul/li[2]/div"));
        choseStedThirdPositionItem();
        waitForElementPresent(By.xpath("//*[@id='locationList']/div/div/div[2]/ul[2]/li/div/ul/li[3]/div"));
        choseStedThirdPositionItem();
        waitForElementPresent(By.xpath("//*[@id='locationList']/div/div/div[2]/ul[2]/li/div/ul/li[4]/div"));
        choseStedThirdPositionItem();
        waitForElementPresent(By.xpath("//*[@id='locationList']/div/div/div[2]/ul[2]/li/div/ul/li[5]/div"));
        refreshPageArbeidssteder();
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li/div")).getText(), "Asker");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[2]/div")).getText(), "Aurskog-Høland");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[3]/div")).getText(), "Bærum");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[4]/div")).getText(), "Eidsvoll");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[5]/div")).getText(), "Enebakk");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='locationList']/div/div/div[2]/ul[2]/li/div/ul/li/div")).getText(), "Fet");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='locationList']/div/div/div[2]/ul[2]/li/div/ul/li[2]/div")).getText(), "Frogn");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='locationList']/div/div/div[2]/ul[2]/li/div/ul/li[3]/div")).getText(), "Gjerdrum");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='locationList']/div/div/div[2]/ul[2]/li/div/ul/li[4]/div")).getText(), "Hurdal");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='locationList']/div/div/div[2]/ul[2]/li/div/ul/li[5]/div")).getText(), "Lørenskog");
    }

    @Test(priority = 4)
    public void moveWithFire() throws Exception {
        // Move Items (ckick fire)
        driver.findElement(By.xpath("//*[@id='locationList']/div/div/div[2]/ul[2]/li/div/ul/li[3]/div/i")).click();
        refreshPageArbeidssteder();
        // Check position after first moving
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li/div")).getText(), "Asker");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[2]/div")).getText(), "Aurskog-Høland");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[3]/div")).getText(), "Bærum");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[4]/div")).getText(), "Eidsvoll");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[5]/div")).getText(), "Gjerdrum");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='locationList']/div/div/div[2]/ul[2]/li/div/ul/li/div")).getText(), "Enebakk");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='locationList']/div/div/div[2]/ul[2]/li/div/ul/li[2]/div")).getText(), "Fet");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='locationList']/div/div/div[2]/ul[2]/li/div/ul/li[3]/div")).getText(), "Frogn");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='locationList']/div/div/div[2]/ul[2]/li/div/ul/li[4]/div")).getText(), "Hurdal");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='locationList']/div/div/div[2]/ul[2]/li/div/ul/li[5]/div")).getText(), "Lørenskog");
        // Second moving Items
        driver.findElement(By.xpath("//*[@id='locationList']/div/div/div[2]/ul[2]/li/div/ul/li[4]/div/i")).click();
        refreshPageArbeidssteder();
        // Check position after second moving
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li/div")).getText(), "Asker");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[2]/div")).getText(), "Aurskog-Høland");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[3]/div")).getText(), "Bærum");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[4]/div")).getText(), "Eidsvoll");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[5]/div")).getText(), "Hurdal");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='locationList']/div/div/div[2]/ul[2]/li/div/ul/li/div")).getText(), "Enebakk");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='locationList']/div/div/div[2]/ul[2]/li/div/ul/li[2]/div")).getText(), "Fet");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='locationList']/div/div/div[2]/ul[2]/li/div/ul/li[3]/div")).getText(), "Frogn");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='locationList']/div/div/div[2]/ul[2]/li/div/ul/li[4]/div")).getText(), "Gjerdrum");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='locationList']/div/div/div[2]/ul[2]/li/div/ul/li[5]/div")).getText(), "Lørenskog");
    }

    @Test(priority = 5)
    public void moveWithArrow() throws Exception {
        // First moving
        driver.findElement(By.xpath("//*[@id='topitems']/li[2]/div/div/i")).click();
        refreshPageArbeidssteder();
        // Check position after first moving
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li/div")).getText(), "Aurskog-Høland");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[2]/div")).getText(), "Asker");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[3]/div")).getText(), "Bærum");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[4]/div")).getText(), "Eidsvoll");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[5]/div")).getText(), "Hurdal");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='locationList']/div/div/div[2]/ul[2]/li/div/ul/li/div")).getText(), "Enebakk");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='locationList']/div/div/div[2]/ul[2]/li/div/ul/li[2]/div")).getText(), "Fet");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='locationList']/div/div/div[2]/ul[2]/li/div/ul/li[3]/div")).getText(), "Frogn");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='locationList']/div/div/div[2]/ul[2]/li/div/ul/li[4]/div")).getText(), "Gjerdrum");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='locationList']/div/div/div[2]/ul[2]/li/div/ul/li[5]/div")).getText(), "Lørenskog");
        // Second moving
        driver.findElement(By.xpath("//ul[@id='topitems']/li[5]/div/div/i")).click();
        refreshPageArbeidssteder();
        // Check position after second moving
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li/div")).getText(), "Aurskog-Høland");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[2]/div")).getText(), "Asker");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[3]/div")).getText(), "Bærum");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[4]/div")).getText(), "Hurdal");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[5]/div")).getText(), "Eidsvoll");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='locationList']/div/div/div[2]/ul[2]/li/div/ul/li/div")).getText(), "Enebakk");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='locationList']/div/div/div[2]/ul[2]/li/div/ul/li[2]/div")).getText(), "Fet");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='locationList']/div/div/div[2]/ul[2]/li/div/ul/li[3]/div")).getText(), "Frogn");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='locationList']/div/div/div[2]/ul[2]/li/div/ul/li[4]/div")).getText(), "Gjerdrum");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='locationList']/div/div/div[2]/ul[2]/li/div/ul/li[5]/div")).getText(), "Lørenskog");
    }

    @Test(priority = 6)
    public void moveWithDragAndDrop() throws Exception {
        goToArbeidssteder();
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
        refreshPageArbeidssteder();
        // Check position after moving
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li/div")).getText(), "Asker");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[2]/div")).getText(), "Hurdal");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[3]/div")).getText(), "Bærum");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[4]/div")).getText(), "Eidsvoll");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[5]/div")).getText(), "Aurskog-Høland");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='locationList']/div/div/div[2]/ul[2]/li/div/ul/li/div")).getText(), "Enebakk");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='locationList']/div/div/div[2]/ul[2]/li/div/ul/li[2]/div")).getText(), "Fet");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='locationList']/div/div/div[2]/ul[2]/li/div/ul/li[3]/div")).getText(), "Frogn");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='locationList']/div/div/div[2]/ul[2]/li/div/ul/li[4]/div")).getText(), "Gjerdrum");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='locationList']/div/div/div[2]/ul[2]/li/div/ul/li[5]/div")).getText(), "Lørenskog");
        // Scroll page to top Items
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//li[2]/div")));
        ((JavascriptExecutor) driver).executeScript("scroll(0,450)");
        // Move 2 Item CategoryList to Top Items
        Actions slider3 = new Actions(driver)
                .dragAndDropBy(driver.findElement(By.xpath("//li/div/ul/li[2]/div")), 0, -200);
        slider3
                .build()
                .perform();
        Thread.sleep(1000);
        // Move 3 Item CategoryList to Top Items
        Actions slider4 = new Actions(driver)
                .dragAndDropBy(driver.findElement(By.xpath("//li/div/ul/li[3]/div")), 0, -260);
        slider4
                .build()
                .perform();
        Thread.sleep(1000);
        refreshPageArbeidssteder();
       /// Check position after moving
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li/div")).getText(), "Frogn");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[2]/div")).getText(), "Fet");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[3]/div")).getText(), "Asker");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[4]/div")).getText(), "Hurdal");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[5]/div")).getText(), "Bærum");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='locationList']/div/div/div[2]/ul[2]/li/div/ul/li/div")).getText(), "Aurskog-Høland");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='locationList']/div/div/div[2]/ul[2]/li/div/ul/li[2]/div")).getText(), "Eidsvoll");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='locationList']/div/div/div[2]/ul[2]/li/div/ul/li[3]/div")).getText(), "Enebakk");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='locationList']/div/div/div[2]/ul[2]/li/div/ul/li[4]/div")).getText(), "Gjerdrum");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='locationList']/div/div/div[2]/ul[2]/li/div/ul/li[5]/div")).getText(), "Lørenskog");
    }

    @Test(priority = 7)
    public void deleteFewItems() throws Exception {
        scrollPageUp();
        driver.findElement(By.xpath("//ul[@id='topitems']/li[5]/div/div/a/i")).click();
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//li[2]/div")));
        ((JavascriptExecutor) driver).executeScript("scroll(0,450)");
        driver.findElement(By.xpath("//*[@id='locationList']/div/div/div[2]/ul[2]/li/div/ul/li[5]/div/a/i")).click();
        Thread.sleep(1000);
        refreshPageArbeidssteder();
        assertElementNotPresent(By.xpath("//*[@id='topitems']/li[5]/div"));
        assertElementNotPresent(By.xpath("//*[@id='locationList']/div/div/div[2]/ul[2]/li/div/ul/li[5]/div"));
    }

    @Test(priority = 8)
    public void deleteLocationList() throws Exception {
        scrollPageUp();
        driver.findElement(By.xpath("//*[@id='locationList']/div/div/div[2]/ul[2]/li/div/a/i")).click();
        Thread.sleep(1000);
        refreshPageArbeidssteder();
        assertElementNotPresent(By.xpath("//*[@id='topitems']/li[1]/div"));
        assertElementNotPresent(By.xpath("//*[@id='topitems']/li[2]/div"));
        assertElementNotPresent(By.xpath("//*[@id='topitems']/li[3]/div"));
        assertElementNotPresent(By.xpath("//*[@id='topitems']/li[4]/div"));
        assertElementNotPresent(By.xpath("//*[@id='topitems']/li[5]/div"));
        assertElementNotPresent(By.xpath("//*[@id='locationList']/div/div/div[2]/ul[2]/li/div/ul/li/div"));
        assertElementNotPresent(By.xpath("//*[@id='locationList']/div/div/div[2]/ul[2]/li/div/ul/li[2]/div"));
        assertElementNotPresent(By.xpath("//*[@id='locationList']/div/div/div[2]/ul[2]/li/div/ul/li[3]/div"));
        assertElementNotPresent(By.xpath("//*[@id='locationList']/div/div/div[2]/ul[2]/li/div/ul/li[4]/div"));
    }
    /*@Test(priority = 9)
    public void deleteAllItems() throws Exception {
        loggIn();
        goToBransjer();
        // Close reklam
        driver.findElement(By.xpath("//*[@id='staticad']/div/div[1]")).click();
        scrollPageUp();
        driver.findElement(By.linkText("Slett alle")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[3]/div/button")).click();
        Thread.sleep(10000);
        driver.navigate().refresh();
        Thread.sleep(1000);
        assertElementNotPresent(By.xpath("//*[@id='topitems']/li[1]/div"));
        assertElementNotPresent(By.xpath("//*[@id='topitems']/li/div"));
    }*/
}