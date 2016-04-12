package TestsVideopresentasjon;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BYoutubeAndVimeo extends TestBaseVideopresentasjon {

    @Test(priority = 1)
    public void addVideoFromYoutube() throws Exception {
        goToPageVideopresentasjon();
        Thread.sleep(2000);
        // Click button Spill inn / last opp video!
        driver.findElement(By.linkText("Spill inn / last opp video!")).click();
        waitForElementPresent(By.xpath("//*[@id='vp-switch']"));
        Thread.sleep(2000);
        // Click button Bruk Youtube eller Vimeo
        driver.findElement(By.xpath("//*[@id='swt-urls']")).click();
        waitForElementPresent(By.xpath("//*[@id='VideoUrl']"));
        // Add video from youtube
        driver.findElement(By.id("VideoUrl")).clear();
        driver.findElement(By.id("VideoUrl")).sendKeys("https://www.youtube.com/watch?v=DPEJB-FCItk");
        // Click button Lagre
        driver.findElement(By.xpath("//div[@id='video-container']/div/div/input")).click();
        waitForElementPresent(By.xpath("//*[@id='pv']/div/div[1]/a"));
        // Click button Avslutt redigering
        driver.findElement(By.xpath("//*[@id='main-story']/a")).click();
    }

    @Test(priority = 2)
    public void assertAddVideo () throws Exception {
        goToPageVideopresentasjon();
        Assert.assertEquals(driver.findElement(By.xpath("//div[2]/div[4]/div[2]/div/div/span")).getText(), "Min videopresentasjon");
        // Click button Rediger
        driver.findElement(By.xpath("//*[@id='pv']/div/div[1]/a")).click();
        waitForElementPresent(By.id("VideoUrl"));
        Assert.assertEquals(driver.findElement(By.id("VideoUrl")).getAttribute("value"), "http://www.youtube.com/embed/DPEJB-FCItk");
    }

    @Test(priority = 3)
    public void changeVideo () throws Exception {
        goToPageVideopresentasjon();
        // Click button Rediger
        driver.findElement(By.xpath("//*[@id='pv']/div/div[1]/a")).click();
        waitForElementPresent(By.id("VideoUrl"));
        // Add video from youtube
        driver.findElement(By.id("VideoUrl")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("VideoUrl")).sendKeys("https://www.youtube.com/watch?v=tcFDPZSqHaQ");
        Thread.sleep(1000);
        // Click button Lagre
        driver.findElement(By.xpath("//div[@id='video-container']/div/div/input")).click();
        waitForElementPresent(By.xpath("//*[@id='pv']/div/div[1]/a"));
        // Click button Avslutt redigering
        driver.findElement(By.xpath("//*[@id='main-story']/a")).click();
    }

    @Test(priority = 4)
    public void assertVideoChanged () throws Exception {
        goToPageVideopresentasjon();
        Assert.assertEquals(driver.findElement(By.xpath("//div[2]/div[4]/div[2]/div/div/span")).getText(), "Min videopresentasjon");
        // Click button Rediger
        driver.findElement(By.xpath("//*[@id='pv']/div/div[1]/a")).click();
        waitForElementPresent(By.id("VideoUrl"));
        Assert.assertEquals(driver.findElement(By.id("VideoUrl")).getAttribute("value"), "http://www.youtube.com/embed/tcFDPZSqHaQ");
    }

    @Test(priority = 5)
    public void checkButtonAvbryt() throws Exception {
        goToPageVideopresentasjon();
        // Click button Rediger
        driver.findElement(By.xpath("//*[@id='pv']/div/div[1]/a")).click();
        waitForElementPresent(By.id("VideoUrl"));
        Thread.sleep(2000);
        // Click button Avbryt
        driver.findElement(By.xpath("//div[@id='video-container']/div/div/a[2]")).click();
        waitForElementPresent(By.xpath("//*[@id='pv']/div/div[1]/a"));
        Assert.assertEquals(driver.findElement(By.xpath("//div[2]/div[4]/div[2]/div/div/span")).getText(), "Min videopresentasjon");
    }

    @Test(priority = 6)
    public void DeleteVideo () throws Exception {
        goToPageVideopresentasjon();
        // Click button Rediger
        driver.findElement(By.xpath("//*[@id='pv']/div/div[1]/a")).click();
        waitForElementPresent(By.id("VideoUrl"));
        Thread.sleep(2000);
        // Click button Nullstill
        driver.findElement(By.xpath("//*[@id='video-container']/div/div[1]/a[3]")).click();
        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pv']/div[1]/span")));
    }

    @Test(priority = 7)
    public void assertVideoDeleted () throws Exception {
        goToPageVideopresentasjon();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='pv']/div[2]/a")).getText().contains("Spill inn / last opp video!"));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='pv']/div[1]/span")).getText().contains("Presenter deg selv og din bakgrunn med en videopresentasjon"));
    }
}