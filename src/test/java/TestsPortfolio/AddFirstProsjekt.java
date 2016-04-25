package TestsPortfolio;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

        // Add Omslagsbilde
        Thread.sleep(1000);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id='project-view']/div[1]/div")));
        driver.findElement(By.linkText("Endre bilde")).click();
        WebDriverWait wait15 = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='projectEditDlg']")));
        // Add file
        WebElement bildeInput = driver.findElement(By.xpath("//*[@id='project-cover-upload']/div/div[2]/input"));
        bildeInput.sendKeys("file://C:/Users\\Vlad\\Desktop\\картинки\\sova.jpg");
        WebDriverWait wait16 = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='project-cover-upload']/div/ul/li")));
        Thread.sleep(1000);
        // Click button Lagre
        driver.findElement(By.xpath("//*[@id='projectEdit_cnt']/div[1]/div[3]/div/button[1]")).click();
        Thread.sleep(1000);

        // Add Ferdigheter
        Thread.sleep(1000);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id='project-view']/div[1]/div")));
        driver.findElement(By.id("skillname")).sendKeys("Portrettfoto");
        WebDriverWait wait17 = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/ul/li/a/span")));
        driver.findElement(By.id("skillname")).sendKeys(Keys.DOWN);
        driver.findElement(By.id("skillname")).sendKeys(Keys.ENTER);
        WebDriverWait wait18 = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='skill-list']/ul/li")));
    }

    @Test(priority = 4)
    public void AssertCorrectDataSave() throws Exception {
        goToPagePortfolioProject();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='project-view']/div[3]/div[2]/h1")).getText(), "Test Prosjekt №1");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='project-view']/div[3]/div[4]")).getText(), "It's test description111");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='project-content']/div[2]/div[2]/h3")).getText(), "Test overskrift 1111");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='project-content']/div[4]/div[2]/div")).getText(), "Test tekxt 1111");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='project-content']/div[6]/div[2]/div/p")).getText(), "Test description bild 1111");
        Assert.assertEquals(driver.findElement(By.xpath("//div/div[2]/span")).getText(), "3333.mp4");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='skill-list']/ul/li")).getText(), "Portrettfoto");
    }

    @Test(priority = 5)
    public void EditData() throws Exception {
        // Edit Project name
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id='project-view']/div[1]/div")));
        driver.findElement(By.xpath("//div[@id='project-view']/div[3]/div[2]/div/a/i")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='Name']")));
        Thread.sleep(500);
        driver.findElement(By.id("Name")).clear();
        Thread.sleep(500);
        driver.findElement(By.id("Name")).sendKeys("№2 Test Prosjekt");
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id='projectEdit_cnt']/div[1]/div[3]/div/button[1]")).click();
        WebDriverWait wait2 = new WebDriverWait(driver, 30);
        wait2.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@id='project-view']/div[3]/div[2]/h1"),"№2 Test Prosjekt"));

        // Edit beskrivelse
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id='project-view']/div[3]/div[1]")));
        driver.findElement(By.xpath("//*[@id='project-view']/div[3]/div[3]/div[2]/a/i")).click();
        WebDriverWait wait3 = new WebDriverWait(driver, 10);
        wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='Description']")));
        Thread.sleep(500);
        driver.findElement(By.id("Description")).clear();
        Thread.sleep(500);
        driver.findElement(By.id("Description")).sendKeys("222 - It's test description");
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id='projectEdit_cnt']/div[1]/div[3]/div/button[1]")).click();
        WebDriverWait wait4 = new WebDriverWait(driver, 30);
        wait4.until(ExpectedConditions.textToBePresentInElementLocated(By.id("project-desciption"),"222 - It's test description"));

        // Edit Overskrift
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id='project-view']/div[3]/div[3]")));
        driver.findElement(By.xpath("//*[@id='project-content']/div[2]/div[1]/div[1]/a/i")).click();
        WebDriverWait wait5 = new WebDriverWait(driver, 10);
        wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='Content']")));
        Thread.sleep(500);
        driver.findElement(By.id("Content")).clear();
        Thread.sleep(500);
        driver.findElement(By.id("Content")).sendKeys("2222 Test overskrift");
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id='blockEdit_cnt']/div[1]/div[3]/div/button[1]")).click();
        WebDriverWait wait6 = new WebDriverWait(driver, 30);
        wait6.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@id='project-content']/div[2]/div[2]/h3"),"2222 Test overskrift"));

        // Edit Tekst
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id='project-view']/div[3]/div[5]/div/div")));
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id='project-content']/div[4]/div[1]/div[1]/a/i")).click();
        WebDriverWait wait7 = new WebDriverWait(driver, 10);
        wait7.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='Content']")));
        Thread.sleep(500);
        driver.findElement(By.id("Content")).clear();
        Thread.sleep(500);
        driver.findElement(By.id("Content")).sendKeys("2222 Test tekxt");
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id='blockEdit_cnt']/div[1]/div[3]/div/button[1]")).click();
        WebDriverWait wait8 = new WebDriverWait(driver, 30);
        wait8.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@id='project-content']/div[4]/div[2]/div"),"2222 Test tekxt"));

        // Edit Foto description
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id='project-content']/div[4]/div[1]")));
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id='project-content']/div[6]/div[1]/div[1]/a/i")).click();
        WebDriverWait wait9 = new WebDriverWait(driver, 10);
        wait9.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ImageFileDescription']")));
        Thread.sleep(500);
        driver.findElement(By.id("ImageFileDescription")).clear();
        Thread.sleep(500);
        driver.findElement(By.id("ImageFileDescription")).sendKeys("2222 Test description bild");
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id='blockEdit_cnt']/div[1]/div[3]/div/button[1]")).click();
        WebDriverWait wait10 = new WebDriverWait(driver, 30);
        wait10.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[6]/div[2]/div/p"),"2222 Test description bild"));

        // Edit Ferdigheter
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id='project-view']/div[1]/div")));
        Thread.sleep(500);
        driver.findElement(By.xpath("//div[@id='skill-list']/ul/li/a/span")).click();
        WebDriverWait wait11 = new WebDriverWait(driver, 30);
        wait11.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[2]/div[2]/div[5]/div"),"Legg inn relaterte ferdigheter for riktig kategorisering av prosjektet"));
        Thread.sleep(500);
        driver.findElement(By.id("skillname")).sendKeys("Internasjonal");
        WebDriverWait wait12 = new WebDriverWait(driver, 30);
        wait12.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/ul/li/a/span")));
        driver.findElement(By.id("skillname")).sendKeys(Keys.DOWN);
        driver.findElement(By.id("skillname")).sendKeys(Keys.ENTER);
        WebDriverWait wait13 = new WebDriverWait(driver, 30);
        wait13.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='skill-list']/ul/li")));

        // Edit document names
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id='project-view']/div[3]/div[7]")));
        Thread.sleep(500);
        driver.findElement(By.xpath("//td[2]/div/a")).click();
        WebDriverWait wait14 = new WebDriverWait(driver, 10);
        wait14.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='FileTitle']")));
        Thread.sleep(500);
        driver.findElement(By.id("FileTitle")).clear();
        Thread.sleep(500);
        driver.findElement(By.id("FileTitle")).sendKeys("5555.mp4");
        Thread.sleep(500);
        driver.findElement(By.id("FileDescription")).clear();
        Thread.sleep(500);
        driver.findElement(By.id("FileDescription")).sendKeys("5555");
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id='blockEdit_cnt']/div[1]/div[3]/div/button[1]")).click();
        WebDriverWait wait15 = new WebDriverWait(driver, 30);
        wait15.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div/div[2]/span"),"5555.mp4"));
        WebDriverWait wait16 = new WebDriverWait(driver, 30);
        wait16.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//td/div/div[2]/div"),"5555"));
    }

    @Test(priority = 6)
    public void AssertCorrectDataChanges() throws Exception {
        goToPagePortfolioProject();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='project-view']/div[3]/div[2]/h1")).getText(), "№2 Test Prosjekt");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='project-view']/div[3]/div[4]")).getText(), "222 - It's test description");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='project-content']/div[2]/div[2]/h3")).getText(), "2222 Test overskrift");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='project-content']/div[4]/div[2]/div")).getText(), "2222 Test tekxt");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='project-content']/div[6]/div[2]/div/p")).getText(), "2222 Test description bild");
        Assert.assertEquals(driver.findElement(By.xpath("//td/div/div[2]/span")).getText(), "5555.mp4");
        Assert.assertEquals(driver.findElement(By.xpath("//td/div/div[2]/div")).getText(), "5555");
        Assert.assertEquals(driver.findElement(By.xpath("//div[5]/ul/li")).getText(), "Internasjonal Business");
    }

    @Test(priority = 7)
    public void AddElements() throws Exception {
        // Add overskrift
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id='project-view']/div[3]/div[2]")));
        driver.findElement(By.xpath("//*[@id='project-content']/div[1]/div[1]/div/a")).click();
        Thread.sleep(2000);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id='project-view']/div[3]/div[2]")));
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id='project-content']/div[1]/div[2]/div[1]/a/i")).click();
        WebDriverWait wait1 = new WebDriverWait(driver, 30);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='Content']")));
        Thread.sleep(500);
        driver.findElement(By.id("Content")).clear();
        Thread.sleep(500);
        driver.findElement(By.id("Content")).sendKeys("3333 Test overskrift");
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id='blockEdit_cnt']/div[1]/div[3]/div/button[1]")).click();
        WebDriverWait wait2 = new WebDriverWait(driver, 30);
        wait2.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@id='project-content']/div[2]/div[2]/h3"),"3333 Test overskrift"));

        // Add tekst
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id='project-view']/div[3]/div[2]")));
        driver.findElement(By.xpath("//*[@id='project-content']/div[1]/div[1]/div/a")).click();
        Thread.sleep(2000);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id='project-view']/div[3]/div[2]")));
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id='project-content']/div[1]/div[2]/div[2]/a/i")).click();
        WebDriverWait wait3 = new WebDriverWait(driver, 30);
        wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='Content']")));
        Thread.sleep(500);
        driver.findElement(By.id("Content")).clear();
        Thread.sleep(500);
        driver.findElement(By.id("Content")).sendKeys("3333 Test tekxt");
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id='blockEdit_cnt']/div[1]/div[3]/div/button[1]")).click();
        WebDriverWait wait4 = new WebDriverWait(driver, 30);
        wait4.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@id='project-content']/div[2]/div[2]/div"),"3333 Test tekxt"));

        // Add Photo
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id='project-view']/div[3]/div[2]")));
        driver.findElement(By.xpath("//*[@id='project-content']/div[1]/div[1]/div/a")).click();
        Thread.sleep(2000);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id='project-view']/div[3]/div[2]")));
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id='project-content']/div[1]/div[2]/div[3]/a/i")).click();
        WebDriverWait wait5 = new WebDriverWait(driver, 30);
        wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ImageFileDescription']")));
        driver.findElement(By.id("ImageFileDescription")).sendKeys("Test description bild 3333");
        WebElement fileInput = driver.findElement(By.xpath("//*[@id=\"project-img-upload\"]/div/div[2]/input"));
        fileInput.sendKeys("file://C:/Users\\Vlad\\Desktop\\картинки\\abc.jpg");
        WebDriverWait wait6 = new WebDriverWait(driver, 30);
        wait6.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='rotateLeft']")));
        Thread.sleep(1000);
        // Click button Lagre
        driver.findElement(By.xpath("//*[@id='blockEdit_cnt']/div[1]/div[3]/div/button[1]")).click();
        WebDriverWait wait7 = new WebDriverWait(driver, 30);
        wait7.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@id='project-content']/div[2]/div[2]/div/p"),"Test description bild 3333"));
        Thread.sleep(1000);

        // Add Video
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id='project-view']/div[3]/div[2]")));
        driver.findElement(By.xpath("//*[@id='project-content']/div[1]/div[1]/div/a")).click();
        Thread.sleep(2000);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id='project-view']/div[3]/div[2]")));
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id='project-content']/div[1]/div[2]/div[4]/a/i")).click();
        WebDriverWait wait8 = new WebDriverWait(driver, 10);
        wait8.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='VideoUrl']")));
        driver.findElement(By.id("VideoUrl")).clear();
        driver.findElement(By.id("VideoUrl")).sendKeys("https://www.youtube.com/watch?v=sWqg6B-taUg");
        Thread.sleep(2000);
        // Click button Lagre
        driver.findElement(By.xpath("//*[@id='block-edit-form']/fieldset/div[2]/input[2]")).click();
        WebDriverWait wait9 = new WebDriverWait(driver, 10);
        wait9.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@id='project-content']/div[2]/div/h2"),"Video"));
        Thread.sleep(1000);
    }

    @Test(priority = 8)
    public void AssertCorrectDataAdd() throws Exception {
        goToPagePortfolioProject();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='project-view']/div[3]/div[2]/h1")).getText(), "№2 Test Prosjekt");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='project-view']/div[3]/div[4]")).getText(), "222 - It's test description");
        Assert.assertEquals(driver.findElement(By.xpath("//div[5]/ul/li")).getText(), "Internasjonal Business");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='project-content']/div[2]/div/h2")).getText(), "Video");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='project-content']/div[4]/div[2]/div/p")).getText(), "Test description bild 3333");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='project-content']/div[6]/div[2]/div")).getText(), "3333 Test tekxt");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='project-content']/div[8]/div[2]/h3")).getText(), "3333 Test overskrift");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='project-content']/div[10]/div[2]/h3")).getText(), "2222 Test overskrift");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='project-content']/div[12]/div[2]/div")).getText(), "2222 Test tekxt");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='project-content']/div[14]/div[2]/div/p")).getText(), "2222 Test description bild");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='project-content']/div[16]/div/h2")).getText(), "Video");
        Assert.assertEquals(driver.findElement(By.xpath("//div/div[2]/span")).getText(), "5555.mp4");
        Assert.assertEquals(driver.findElement(By.xpath("//td/div/div[2]/div")).getText(), "5555");
        Thread.sleep(2000);
    }

    @Test(priority = 9)
    public void MoveElements() throws Exception {
        // First move
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id='project-content']/div[4]/div[2]/div/p")));
        Thread.sleep(500);
        WebElement draggable = driver.findElement(By.xpath("//*[@id='project-content']/div[6]/div[1]/div[2]/a/i"));
        Actions builder = new Actions(driver);
        builder.dragAndDropBy(draggable, 0, -1140).build().perform();
        Thread.sleep(3000);
        // Second move
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id='project-content']/div[6]/div[2]/div/p")));
        Thread.sleep(500);
        WebElement draggable2 = driver.findElement(By.xpath("//*[@id='project-content']/div[8]/div[1]/div[2]/a/i"));
        Actions builder2 = new Actions(driver);
        builder2.dragAndDropBy(draggable2, 0, -1140).build().perform();
        Thread.sleep(3000);
        // Third move
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id='project-content']/div[4]/div[1]")));
        Thread.sleep(500);
        WebElement draggable3 = driver.findElement(By.xpath("//*[@id='project-content']/div[6]/div[1]/div[2]/a/i"));
        Actions builder3 = new Actions(driver);
        builder3.dragAndDropBy(draggable3, 0, +1700).build().perform();
        Thread.sleep(3000);
        // Fourth move
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id='project-content']/div[4]/div[1]")));
        Thread.sleep(500);
        WebElement draggable4 = driver.findElement(By.xpath("//*[@id='project-content']/div[6]/div[1]/div[2]/a/i"));
        Actions builder4 = new Actions(driver);
        builder4.dragAndDropBy(draggable4, 0, +1015).build().perform();
        Thread.sleep(3000);
    }

    @Test(priority = 10)
    public void AssertMoveElements() throws Exception {
        goToPagePortfolioProject();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='project-content']/div[2]/div[2]/div")).getText(), "3333 Test tekxt");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='project-content']/div[4]/div[2]/h3")).getText(), "3333 Test overskrift");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='project-content']/div[6]/div[2]/h3")).getText(), "2222 Test overskrift");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='project-content']/div[8]/div[2]/div")).getText(), "2222 Test tekxt");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='project-content']/div[10]/div[2]/div/p")).getText(), "Test description bild 3333");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='project-content']/div[14]/div[2]/div/p")).getText(), "2222 Test description bild");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='project-content']/div[12]/div/h2")).getText(), "Video");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='project-content']/div[16]/div/h2")).getText(), "Video");
    }
}

