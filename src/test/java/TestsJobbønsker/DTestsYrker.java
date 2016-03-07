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

public class DTestsYrker extends TestBaseJobbønsker {

    @Test(priority = 1)
    public void verifyItemNotPresentWithoutYrke () throws Exception {
        goToYrker();
        choseKategoriEstetiske();
        assertElementNotPresent(By.xpath("//*[@id='topitems']/li/div"));
        assertElementNotPresent(By.xpath("//*[@id='topitems']/li[1]/div"));
    }

    @Test(priority = 2)
    public void verifyItemAddWithoutKategori() throws Exception {
        goToYrker();
        choseYrkeAdvokat();
        waitForElementPresent(By.xpath("//*[@id='topitems']/li/div"));
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li/div")).getText(), "Advokat");
    }

    @Test(priority = 3)
    public void verifyItemAddWithKategoriAndYrker() throws Exception {
        goToYrker();
        choseKategoriEstetiske();
        choseYrkeAnimator();
        waitForElementPresent(By.xpath("//*[@id='topitems']/li[2]/div"));
        refreshPageYrker();
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li/div")).getText(), "Advokat");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[2]/div")).getText(), "Animatør");
    }

    @Test(priority = 4)
    public void verifyDoubleItemNotAdd() throws Exception {
        choseYrkeAnimator();
        waitForElementPresent(By.xpath("//*[@id='topitems']/li[3]/div"));
        refreshPageYrker();
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li/div")).getText(), "Advokat");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[2]/div")).getText(), "Animatør");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[3]/div")).getText(), "Adjunkt");
    }

    @Test(priority = 5)
    public void verifyAdd10Items() throws Exception {
        choseKategoriJus();
        scrollPageUp();
        choseYrkeAdvokatfullmektig();
        waitForElementPresent(By.xpath("//*[@id='topitems']/li[4]/div"));

        scrollPageUp();
        choseYrkeDommer();
        waitForElementPresent(By.xpath("//*[@id='topitems']/li[5]/div"));

        scrollPageUp();
        choseYrkeEtterforsker();
        waitForElementPresent(By.xpath("//*[@id='professionList']/div/div/div[2]/ul[2]/li/div"));

        scrollPageUp();
        choseYrkeDomstolsjurist();
        waitForElementPresent(By.xpath("//*[@id='professionList']/div/div/div[2]/ul[2]/li[2]/div"));

        scrollPageUp();
        choseYrkeJurist();
        waitForElementPresent(By.xpath("//*[@id='professionList']/div/div/div[2]/ul[2]/li[3]/div"));

        scrollPageUp();
        choseYrkeDommerfullmektig();
        waitForElementPresent(By.xpath("//*[@id='professionList']/div/div/div[2]/ul[2]/li[4]/div"));

        scrollPageUp();
        choseYrkeAdvokatsekretær();
        waitForElementPresent(By.xpath("//*[@id='professionList']/div/div/div[2]/ul[2]/li[5]/div"));

        refreshPageYrker();
        Assert.assertTrue(isElementPresent(By.xpath("//*[@id='topitems']/li[5]/div")));
        Assert.assertTrue(isElementPresent(By.xpath("//*[@id='professionList']/div/div/div[2]/ul[2]/li[5]/div")));
    }

    @Test(priority = 6)
    public void moveWithFire() throws Exception {
        // Check position before moving
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li/div")).getText(), "Advokat");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[2]/div")).getText(), "Animatør");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[3]/div")).getText(), "Adjunkt");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[4]/div")).getText(), "Advokatfullmektig");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[5]/div")).getText(), "Dommer");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='professionList']/div/div/div[2]/ul[2]/li/div")).getText(), "Advokatsekretær");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='professionList']/div/div/div[2]/ul[2]/li[2]/div")).getText(), "Dommerfullmektig");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='professionList']/div/div/div[2]/ul[2]/li[3]/div")).getText(), "Domstolsjurist");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='professionList']/div/div/div[2]/ul[2]/li[4]/div")).getText(), "Etterforsker");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='professionList']/div/div/div[2]/ul[2]/li[5]/div")).getText(), "Jurist");
        // Move Items (ckick fire)
        driver.findElement(By.xpath("//*[@id='professionList']/div/div/div[2]/ul[2]/li[2]/div/i")).click();
        refreshPageYrker();
        // Check position after first moving
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li/div")).getText(), "Advokat");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[2]/div")).getText(), "Animatør");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[3]/div")).getText(), "Adjunkt");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[4]/div")).getText(), "Advokatfullmektig");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[5]/div")).getText(), "Dommerfullmektig");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='professionList']/div/div/div[2]/ul[2]/li/div")).getText(), "Advokatsekretær");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='professionList']/div/div/div[2]/ul[2]/li[2]/div")).getText(), "Dommer");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='professionList']/div/div/div[2]/ul[2]/li[3]/div")).getText(), "Domstolsjurist");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='professionList']/div/div/div[2]/ul[2]/li[4]/div")).getText(), "Etterforsker");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='professionList']/div/div/div[2]/ul[2]/li[5]/div")).getText(), "Jurist");
        // Second moving
        driver.findElement(By.xpath("//*[@id='professionList']/div/div/div[2]/ul[2]/li[2]/div/i")).click();
        refreshPageYrker();
        // Check position after second moving
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li/div")).getText(), "Advokat");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[2]/div")).getText(), "Animatør");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[3]/div")).getText(), "Adjunkt");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[4]/div")).getText(), "Advokatfullmektig");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[5]/div")).getText(), "Dommer");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='professionList']/div/div/div[2]/ul[2]/li/div")).getText(), "Advokatsekretær");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='professionList']/div/div/div[2]/ul[2]/li[2]/div")).getText(), "Dommerfullmektig");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='professionList']/div/div/div[2]/ul[2]/li[3]/div")).getText(), "Domstolsjurist");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='professionList']/div/div/div[2]/ul[2]/li[4]/div")).getText(), "Etterforsker");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='professionList']/div/div/div[2]/ul[2]/li[5]/div")).getText(), "Jurist");
    }

    @Test(priority = 7)
    public void moveWithArrow() throws Exception {
        // First moving
        driver.findElement(By.xpath("//*[@id='topitems']/li[2]/div/div/i")).click();
        refreshPageYrker();
        // Check position after first moving
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li/div")).getText(), "Animatør");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[2]/div")).getText(), "Advokat");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[3]/div")).getText(), "Adjunkt");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[4]/div")).getText(), "Advokatfullmektig");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[5]/div")).getText(), "Dommer");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='professionList']/div/div/div[2]/ul[2]/li/div")).getText(), "Advokatsekretær");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='professionList']/div/div/div[2]/ul[2]/li[2]/div")).getText(), "Dommerfullmektig");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='professionList']/div/div/div[2]/ul[2]/li[3]/div")).getText(), "Domstolsjurist");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='professionList']/div/div/div[2]/ul[2]/li[4]/div")).getText(), "Etterforsker");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='professionList']/div/div/div[2]/ul[2]/li[5]/div")).getText(), "Jurist");
        // Second moving
        driver.findElement(By.xpath("//ul[@id='topitems']/li[5]/div/div/i")).click();
        refreshPageYrker();
        // Check position after second moving
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li/div")).getText(), "Animatør");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[2]/div")).getText(), "Advokat");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[3]/div")).getText(), "Adjunkt");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[4]/div")).getText(), "Dommer");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[5]/div")).getText(), "Advokatfullmektig");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='professionList']/div/div/div[2]/ul[2]/li/div")).getText(), "Advokatsekretær");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='professionList']/div/div/div[2]/ul[2]/li[2]/div")).getText(), "Dommerfullmektig");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='professionList']/div/div/div[2]/ul[2]/li[3]/div")).getText(), "Domstolsjurist");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='professionList']/div/div/div[2]/ul[2]/li[4]/div")).getText(), "Etterforsker");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='professionList']/div/div/div[2]/ul[2]/li[5]/div")).getText(), "Jurist");
    }

    @Test(priority = 8)
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
        refreshPageYrker();
        // Check position after moving
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li/div")).getText(), "Advokat");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[2]/div")).getText(), "Dommer");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[3]/div")).getText(), "Adjunkt");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[4]/div")).getText(), "Advokatfullmektig");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[5]/div")).getText(), "Animatør");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='professionList']/div/div/div[2]/ul[2]/li/div")).getText(), "Advokatsekretær");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='professionList']/div/div/div[2]/ul[2]/li[2]/div")).getText(), "Dommerfullmektig");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='professionList']/div/div/div[2]/ul[2]/li[3]/div")).getText(), "Domstolsjurist");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='professionList']/div/div/div[2]/ul[2]/li[4]/div")).getText(), "Etterforsker");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='professionList']/div/div/div[2]/ul[2]/li[5]/div")).getText(), "Jurist");
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
        refreshPageYrker();
        // Check position after moving
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li/div")).getText(), "Domstolsjurist");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[2]/div")).getText(), "Dommerfullmektig");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[3]/div")).getText(), "Advokat");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[4]/div")).getText(), "Dommer");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[5]/div")).getText(), "Adjunkt");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='professionList']/div/div/div[2]/ul[2]/li/div")).getText(), "Advokatfullmektig");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='professionList']/div/div/div[2]/ul[2]/li[2]/div")).getText(), "Advokatsekretær");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='professionList']/div/div/div[2]/ul[2]/li[3]/div")).getText(), "Animatør");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='professionList']/div/div/div[2]/ul[2]/li[4]/div")).getText(), "Etterforsker");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='professionList']/div/div/div[2]/ul[2]/li[5]/div")).getText(), "Jurist");
    }
    @Test(priority = 9)
    public void deleteFewItems() throws Exception {
        scrollPageUp();
        driver.findElement(By.xpath("//ul[@id='topitems']/li[5]/div/div/a/i")).click();
        scrollPageUp();
        driver.findElement(By.xpath("//*[@id='professionList']/div/div/div[2]/ul[2]/li[5]/div/a/i")).click();
        Thread.sleep(1000);
        refreshPageYrker();
        assertElementNotPresent(By.xpath("//*[@id='topitems']/li[5]/div"));
        assertElementNotPresent(By.xpath("//*[@id='professionList']/div/div/div[2]/ul[2]/li[5]/div"));
    }

}