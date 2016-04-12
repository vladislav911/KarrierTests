package TestsVideopresentasjon;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AMyFile extends TestBaseVideopresentasjon {
    @Test(priority = 1)
    public void addVideoFromMyFiles () throws Exception {
        loggIn();
        closeReklam();
        goToPageVideopresentasjon();
        // Click button Spill inn / last opp video!
        driver.findElement(By.linkText("Spill inn / last opp video!")).click();
        waitForElementPresent(By.xpath("//*[@id='vp-switch']"));
        // Click button Velg fra "Mine filer"
        driver.findElement(By.xpath("//*[@id='swt-files']")).click();
        waitForElementPresent(By.xpath("//*[@id='selectVideoFile_chosen']/a"));
        // Open drop-down Ingen
        driver.findElement(By.xpath("//*[@id='selectVideoFile_chosen']/a/div/b")).click();
        waitForElementPresent(By.xpath("//*[@id='selectVideoFile_chosen']/div/div/input"));
        // Choose Video 11111.mp4
        driver.findElement(By.xpath("//div[@id='selectVideoFile_chosen']/div/ul/li[2]")).click();
        Thread.sleep(3000);
        // Click button Lagre
        driver.findElement(By.xpath("//div[3]/form/div/div[2]/input")).click();
        waitForElementPresent(By.xpath("//*[@id='pv']/div/div[1]/a"));
        // Click button Avslutt redigering
        driver.findElement(By.xpath("//*[@id='main-story']/a")).click();
    }

    @Test(priority = 2)
    public void assertAddVideo () throws Exception {
        goToPageVideopresentasjon();
        Assert.assertEquals(driver.findElement(By.xpath("//div[2]/div[4]/div[2]/div/div/span")).getText(), "Min videopresentasjon");
        Assert.assertTrue(isElementPresent(By.id("preview-video_jwplayer_display")));
        // Click button Rediger
        driver.findElement(By.xpath("//*[@id='pv']/div/div[1]/a")).click();
        waitForElementPresent(By.xpath("//*[@id='selectVideoFile_chosen']/a"));
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='selectVideoFile_chosen']/a/span")).getText(), "Video 11111.mp4");
    }

    @Test(priority = 3)
    public void changeVideo () throws Exception {
        goToPageVideopresentasjon();
        // Click button Rediger
        driver.findElement(By.xpath("//*[@id='pv']/div/div[1]/a")).click();
        waitForElementPresent(By.xpath("//*[@id='selectVideoFile_chosen']/a"));
        // Open drop-down Ingen
        driver.findElement(By.xpath("//*[@id='selectVideoFile_chosen']/a/div/b")).click();
        waitForElementPresent(By.xpath("//*[@id='selectVideoFile_chosen']/div/div/input"));
        // Choose Video Video 55555.mp4
        driver.findElement(By.xpath("//div[@id='selectVideoFile_chosen']/div/ul/li[3]")).click();
        Thread.sleep(3000);
        // Click button Lagre
        driver.findElement(By.xpath("//div[3]/form/div/div[2]/input")).click();
        waitForElementPresent(By.xpath("//*[@id='pv']/div/div[1]/a"));
        // Click button Avslutt redigering
        driver.findElement(By.xpath("//*[@id='main-story']/a")).click();
    }

    @Test(priority = 4)
    public void assertVideoChanged () throws Exception {
        goToPageVideopresentasjon();
        Assert.assertEquals(driver.findElement(By.xpath("//div[2]/div[4]/div[2]/div/div/span")).getText(), "Min videopresentasjon");
        Assert.assertTrue(isElementPresent(By.id("preview-video_jwplayer_display")));
        // Click button Rediger
        driver.findElement(By.xpath("//*[@id='pv']/div/div[1]/a")).click();
        waitForElementPresent(By.xpath("//*[@id='selectVideoFile_chosen']/a"));
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='selectVideoFile_chosen']/a/span")).getText(), "Video 55555.mp4");
    }

    @Test(priority = 5)
    public void checkButtonAvbryt () throws Exception {
        goToPageVideopresentasjon();
        // Click button Rediger
        driver.findElement(By.xpath("//*[@id='pv']/div/div[1]/a")).click();
        waitForElementPresent(By.xpath("//*[@id='selectVideoFile_chosen']/a"));
        Thread.sleep(2000);
        // Click button Avbryt
        driver.findElement(By.xpath("//*[@id='vp-files-form']/div/div[2]/a")).click();
        waitForElementPresent(By.xpath("//*[@id='pv']/div/div[1]/a"));
        Assert.assertEquals(driver.findElement(By.xpath("//div[2]/div[4]/div[2]/div/div/span")).getText(), "Min videopresentasjon");
    }

    @Test(priority = 6)
    public void deleteVideo() throws Exception {
        goToPageVideopresentasjon();
        // Click button Rediger
        driver.findElement(By.xpath("//*[@id='pv']/div/div[1]/a")).click();
        waitForElementPresent(By.xpath("//*[@id='selectVideoFile_chosen']/a"));
        // Click button Delete Video
        driver.findElement(By.xpath("//*[@id='vp-files-form']/div/div[1]/a/i")).click();
        Thread.sleep(3000);
        waitForElementPresent(By.xpath("//*[@id='pv']/div[1]/span"));
    }

    @Test(priority = 7)
    public void assertVideoDeleted () throws Exception {
        goToPageVideopresentasjon();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='pv']/div[2]/a")).getText().contains("Spill inn / last opp video!"));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='pv']/div[1]/span")).getText().contains("Presenter deg selv og din bakgrunn med en videopresentasjon"));
    }
}
