package TestsPortfolio;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddFirstProsjekt extends TestBasePortfolio {

    @Test(priority = 1)
    public void addAndCancel() throws Exception {
        loggIn();
        closeReklam();
        goToPagePortfolio();
        clickButtonAddProsjekt();
        // Click button "Avbryt"
        driver.findElement(By.xpath("//div[@id='projectEdit_cnt']/div/div[3]/div/button[2]")).click();
        Thread.sleep(1000);
        // Assert Prosjekt not added
        goToPagePortfolio();
        assertElementNotPresent(By.cssSelector("div.n-back"));
    }

    @Test(priority = 2)
    public void tryToAddProsjektWithOutName() throws Exception {
        goToPagePortfolio();
        clickButtonAddProsjekt();
        clickButtonLagre();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("Name-error"),"Prosjektnavn påkrevd."));
    }

    @Test(priority = 3)
    public void AddProsjekt() throws Exception {
        loggIn();
        closeReklam();
        goToPagePortfolio();
        clickButtonAddProsjekt();
        driver.findElement(By.id("Name")).sendKeys("Test Prosjekt №1");
        clickButtonLagre();
        // Wait project view
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='project-view']")));

        // Add descritpton project
        driver.findElement(By.xpath("//div[@id='project-view']/div[3]/div[3]/div[2]/a/i")).click();
        // Wait open description field
        WebDriverWait wait2 = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='Description']")));
        // Type description
        driver.findElement(By.id("Description")).sendKeys("It's test description111");
        clickButtonLagre();
        WebDriverWait wait3 = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("project-desciption"),"It's test description111"));
        Thread.sleep(1000);

        // Add Overskrift project
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id='project-view']/div[3]/div[3]")));
        driver.findElement(By.cssSelector("i.fa.fa-header")).click();
        // Wait open description field
        WebDriverWait wait4 = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='Content']")));
        // Type Overskrift
        driver.findElement(By.id("Content")).sendKeys("Test overskrift 1111");
        // Click button Lagre
        driver.findElement(By.xpath("//*[@id='blockEdit_cnt']/div[1]/div[3]/div/button[1]")).click();
        WebDriverWait wait5 = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@id='project-content']/div[2]/div[2]/h3"),"Test overskrift 1111"));
        Thread.sleep(1000);

        // Add new text
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id='project-desciption']")));
        driver.findElement(By.xpath("//div[@id='project-content']/div[3]/div[2]/div[2]/a/i")).click();
        // Wait open description field
        WebDriverWait wait6 = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='Content']")));
        // Type text
        driver.findElement(By.id("Content")).sendKeys("Test tekxt 1111");
        // Click button Lagre
        driver.findElement(By.xpath("//*[@id='blockEdit_cnt']/div[1]/div[3]/div/button[1]")).click();
        WebDriverWait wait7 = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@id='project-content']/div[4]/div[2]/div"),"Test tekxt 1111"));
        Thread.sleep(1000);

        // Add new bilde
        driver.findElement(By.xpath("//div[@id='project-content']/div[5]/div[2]/div[3]/a/i")).click();
        // Wait open description field
        WebDriverWait wait8 = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ImageFileDescription']")));
        // Type description bild
        driver.findElement(By.id("ImageFileDescription")).sendKeys("Test description bild 1111");
        // Add file
        WebElement fileInput = driver.findElement(By.xpath("//*[@id=\"project-img-upload\"]/div/div[2]/input"));
        fileInput.sendKeys("file://C:/Users\\Vlad\\Desktop\\картинки\\345.jpg");
        WebDriverWait wait9 = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='rotateLeft']")));
        Thread.sleep(1000);
        // Click button Lagre
        driver.findElement(By.xpath("//*[@id='blockEdit_cnt']/div[1]/div[3]/div/button[1]")).click();
        WebDriverWait wait10 = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("p.image-description"),"Test description bild 1111"));
        Thread.sleep(1000);

        // Add new video
        driver.findElement(By.xpath("//div[@id='project-content']/div[7]/div[2]/div[4]/a/i")).click();
        // Wait open url field
        WebDriverWait wait11 = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='VideoUrl']")));
        // Type video url
        driver.findElement(By.id("VideoUrl")).clear();
        driver.findElement(By.id("VideoUrl")).sendKeys("https://www.youtube.com/watch?v=e-pLgvJULOM");
        Thread.sleep(2000);
        // Click button Lagre
        driver.findElement(By.xpath("//*[@id='block-edit-form']/fieldset/div[2]/input[2]")).click();
        WebDriverWait wait12 = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='project-content']/div[8]/div[2]")));
        Thread.sleep(1000);

        // Add Bildegalleri
        Thread.sleep(1000);
        // Add file
        new Select(driver.findElement(By.id("selectedFile-1"))).selectByVisibleText("1111.jpg");
        WebDriverWait wait13 = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[8]/div/div/div/div/div/a/img")));
        Thread.sleep(1000);

        // Add Dokument
        Thread.sleep(1000);
        // Add file
        new Select(driver.findElement(By.id("selectedFile-2"))).selectByVisibleText("3333.mp4");
        WebDriverWait wait14 = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[8]/div/div/div/div/div/a/img")));
        Thread.sleep(1000);
    }
}

