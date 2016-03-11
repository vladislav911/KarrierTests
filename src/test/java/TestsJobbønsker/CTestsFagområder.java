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

public class CTestsFagområder extends TestBaseJobbønsker {

    @Test(priority = 1)
    public void verifyItemAdd() throws Exception {
        goToFagområder();
        choseFagområdeFirstPositionItem();
        waitForElementPresent(By.xpath("//*[@id='topitems']/li/div"));
        refreshPageFagområder();
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li/div")).getText(), "Estetiske fag, kunst- og musikk");
    }

    @Test(priority = 2)
    public void verifyDeleteItemFromDropDown() throws Exception {
        choseFagområdeFirstPositionItem();
        waitForElementPresent(By.xpath("//*[@id='topitems']/li[2]/div"));
        refreshPageFagområder();
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[2]/div")).getText(), "Fiskeri-, husdyr- og landbruk");
    }

    @Test(priority = 3)
    public void verifyAdd10Items() throws Exception {
        choseFagområdeFirstPositionItem();
        waitForElementPresent(By.xpath("//*[@id='topitems']/li[3]/div"));
        choseFagområdeFirstPositionItem();
        waitForElementPresent(By.xpath("//*[@id='topitems']/li[4]/div"));
        choseFagområdeFirstPositionItem();
        waitForElementPresent(By.xpath("//*[@id='topitems']/li[5]/div"));
        choseFagområdeFirstPositionItem();
        waitForElementPresent(By.xpath("//*[@id='categoryList']/div/div/div[2]/ul[2]/li/div"));
        choseFagområdeFirstPositionItem();
        waitForElementPresent(By.xpath("//*[@id='categoryList']/div/div/div[2]/ul[2]/li[2]/div"));
        choseFagområdeFirstPositionItem();
        waitForElementPresent(By.xpath("//*[@id='categoryList']/div/div/div[2]/ul[2]/li[3]/div"));
        choseFagområdeFirstPositionItem();
        waitForElementPresent(By.xpath("//*[@id='categoryList']/div/div/div[2]/ul[2]/li[4]/div"));
        choseFagområdeFirstPositionItem();
        waitForElementPresent(By.xpath("//*[@id='categoryList']/div/div/div[2]/ul[2]/li[5]/div"));
        refreshPageFagområder();
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li/div")).getText(), "Estetiske fag, kunst- og musikk");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[2]/div")).getText(), "Fiskeri-, husdyr- og landbruk");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[3]/div")).getText(), "Historie, religion, idéfag");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[4]/div")).getText(), "Hotell- og reiselivsfag");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[5]/div")).getText(), "Idrett, kroppsøving og friluftsliv");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='categoryList']/div/div/div[2]/ul[2]/li/div")).getText(), "Informasjonsteknologi / informatikk");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='categoryList']/div/div/div[2]/ul[2]/li[2]/div")).getText(), "Jus");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='categoryList']/div/div/div[2]/ul[2]/li[3]/div")).getText(), "Matematikk og naturfag");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='categoryList']/div/div/div[2]/ul[2]/li[4]/div")).getText(), "Mediefag, bibliotekfag og journalistikk");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='categoryList']/div/div/div[2]/ul[2]/li[5]/div")).getText(), "Medisin, odontologi, helse- og sosialfag");
    }

    @Test(priority = 4)
    public void moveWithFire() throws Exception {
        // Move Items (ckick fire)
        driver.findElement(By.xpath("//*[@id='categoryList']/div/div/div[2]/ul[2]/li[3]/div/i")).click();
        refreshPageFagområder();
        // Check position after first moving
        Assert.assertEquals(driver.findElement(By.xpath("//li/div")).getText(), "Estetiske fag, kunst- og musikk");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[2]/div")).getText(), "Fiskeri-, husdyr- og landbruk");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[3]/div")).getText(), "Historie, religion, idéfag");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[4]/div")).getText(), "Hotell- og reiselivsfag");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[5]/div")).getText(), "Matematikk og naturfag");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='categoryList']/div/div/div[2]/ul[2]/li/div")).getText(), "Idrett, kroppsøving og friluftsliv");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='categoryList']/div/div/div[2]/ul[2]/li[2]/div")).getText(), "Informasjonsteknologi / informatikk");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='categoryList']/div/div/div[2]/ul[2]/li[3]/div")).getText(), "Jus");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='categoryList']/div/div/div[2]/ul[2]/li[4]/div")).getText(), "Mediefag, bibliotekfag og journalistikk");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='categoryList']/div/div/div[2]/ul[2]/li[5]/div")).getText(), "Medisin, odontologi, helse- og sosialfag");
        // Second moving Items
        driver.findElement(By.xpath("//*[@id='categoryList']/div/div/div[2]/ul[2]/li[4]/div/i")).click();
        refreshPageFagområder();
        // Check position after second moving
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li/div")).getText(), "Estetiske fag, kunst- og musikk");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[2]/div")).getText(), "Fiskeri-, husdyr- og landbruk");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[3]/div")).getText(), "Historie, religion, idéfag");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[4]/div")).getText(), "Hotell- og reiselivsfag");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[5]/div")).getText(), "Mediefag, bibliotekfag og journalistikk");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='categoryList']/div/div/div[2]/ul[2]/li/div")).getText(), "Idrett, kroppsøving og friluftsliv");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='categoryList']/div/div/div[2]/ul[2]/li[2]/div")).getText(), "Informasjonsteknologi / informatikk");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='categoryList']/div/div/div[2]/ul[2]/li[3]/div")).getText(), "Jus");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='categoryList']/div/div/div[2]/ul[2]/li[4]/div")).getText(), "Matematikk og naturfag");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='categoryList']/div/div/div[2]/ul[2]/li[5]/div")).getText(), "Medisin, odontologi, helse- og sosialfag");
    }

    @Test(priority = 5)
    public void moveWithArrow() throws Exception {
        // First moving
        driver.findElement(By.xpath("//*[@id='topitems']/li[2]/div/div/i")).click();
        refreshPageFagområder();
        // Check position after first moving
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li/div")).getText(), "Fiskeri-, husdyr- og landbruk");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[2]/div")).getText(), "Estetiske fag, kunst- og musikk");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[3]/div")).getText(), "Historie, religion, idéfag");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[4]/div")).getText(), "Hotell- og reiselivsfag");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[5]/div")).getText(), "Mediefag, bibliotekfag og journalistikk");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='categoryList']/div/div/div[2]/ul[2]/li/div")).getText(), "Idrett, kroppsøving og friluftsliv");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='categoryList']/div/div/div[2]/ul[2]/li[2]/div")).getText(), "Informasjonsteknologi / informatikk");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='categoryList']/div/div/div[2]/ul[2]/li[3]/div")).getText(), "Jus");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='categoryList']/div/div/div[2]/ul[2]/li[4]/div")).getText(), "Matematikk og naturfag");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='categoryList']/div/div/div[2]/ul[2]/li[5]/div")).getText(), "Medisin, odontologi, helse- og sosialfag");
        // Second moving
        driver.findElement(By.xpath("//ul[@id='topitems']/li[5]/div/div/i")).click();
        refreshPageFagområder();
        // Check position after second moving
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li/div")).getText(), "Fiskeri-, husdyr- og landbruk");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[2]/div")).getText(), "Estetiske fag, kunst- og musikk");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[3]/div")).getText(), "Historie, religion, idéfag");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[4]/div")).getText(), "Mediefag, bibliotekfag og journalistikk");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[5]/div")).getText(), "Hotell- og reiselivsfag");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='categoryList']/div/div/div[2]/ul[2]/li/div")).getText(), "Idrett, kroppsøving og friluftsliv");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='categoryList']/div/div/div[2]/ul[2]/li[2]/div")).getText(), "Informasjonsteknologi / informatikk");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='categoryList']/div/div/div[2]/ul[2]/li[3]/div")).getText(), "Jus");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='categoryList']/div/div/div[2]/ul[2]/li[4]/div")).getText(), "Matematikk og naturfag");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='categoryList']/div/div/div[2]/ul[2]/li[5]/div")).getText(), "Medisin, odontologi, helse- og sosialfag");
    }

    @Test(priority = 6)
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
        refreshPageFagområder();
        // Check position after moving
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li/div")).getText(), "Estetiske fag, kunst- og musikk");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[2]/div")).getText(), "Mediefag, bibliotekfag og journalistikk");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[3]/div")).getText(), "Historie, religion, idéfag");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[4]/div")).getText(), "Hotell- og reiselivsfag");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[5]/div")).getText(), "Fiskeri-, husdyr- og landbruk");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='categoryList']/div/div/div[2]/ul[2]/li/div")).getText(), "Idrett, kroppsøving og friluftsliv");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='categoryList']/div/div/div[2]/ul[2]/li[2]/div")).getText(), "Informasjonsteknologi / informatikk");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='categoryList']/div/div/div[2]/ul[2]/li[3]/div")).getText(), "Jus");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='categoryList']/div/div/div[2]/ul[2]/li[4]/div")).getText(), "Matematikk og naturfag");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='categoryList']/div/div/div[2]/ul[2]/li[5]/div")).getText(), "Medisin, odontologi, helse- og sosialfag");
        // Scroll page to top Items
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//li[2]/div")));
        ((JavascriptExecutor)driver).executeScript("scroll(0,450)");
        // Move 2 Item CategoryList to Top Items
        Actions slider3 = new Actions(driver)
                .dragAndDropBy(driver.findElement(By.xpath("//ul[2]/li[2]/div")),0, -200);
        slider3
                .build()
                .perform();
        Thread.sleep(1000);
        // Move 3 Item CategoryList to Top Items
        Actions slider4 = new Actions(driver)
                .dragAndDropBy(driver.findElement(By.xpath("//ul[2]/li[3]/div")),0, -205);
        slider4
                .build()
                .perform();
        Thread.sleep(1000);
        refreshPageFagområder();
        // Check position after moving
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li/div")).getText(), "Jus");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[2]/div")).getText(), "Informasjonsteknologi / informatikk");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[3]/div")).getText(), "Estetiske fag, kunst- og musikk");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[4]/div")).getText(), "Mediefag, bibliotekfag og journalistikk");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='topitems']/li[5]/div")).getText(), "Historie, religion, idéfag");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='categoryList']/div/div/div[2]/ul[2]/li/div")).getText(), "Fiskeri-, husdyr- og landbruk");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='categoryList']/div/div/div[2]/ul[2]/li[2]/div")).getText(), "Hotell- og reiselivsfag");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='categoryList']/div/div/div[2]/ul[2]/li[3]/div")).getText(), "Idrett, kroppsøving og friluftsliv");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='categoryList']/div/div/div[2]/ul[2]/li[4]/div")).getText(), "Matematikk og naturfag");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='categoryList']/div/div/div[2]/ul[2]/li[5]/div")).getText(), "Medisin, odontologi, helse- og sosialfag");
    }

    @Test(priority = 7)
    public void deleteFewItems() throws Exception {
        goToFagområder();
        scrollPageUp();
        driver.findElement(By.xpath("//ul[@id='topitems']/li[5]/div/div/a/i")).click();
        scrollPageUp();
        driver.findElement(By.xpath("//*[@id='categoryList']/div/div/div[2]/ul[2]/li[5]/div/a/i")).click();
        Thread.sleep(1000);
        refreshPageFagområder();
        assertElementNotPresent(By.xpath("//*[@id='topitems']/li[5]/div"));
        assertElementNotPresent(By.xpath("//*[@id='categoryList']/div/div/div[2]/ul[2]/li[5]/div"));
    }

    /*@Test(priority = 8)
    public void deleteAllItems() throws Exception {

     }*/
}