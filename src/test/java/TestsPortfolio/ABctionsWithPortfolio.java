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

import static org.testng.Assert.assertEquals;

public class ABctionsWithPortfolio extends TestBasePortfolio {

    @Test(priority = 1)
    public void ChangeNameOfPortfolioFromPage() throws Exception {
        loggIn();
        closeReklam();
        goToPagePortfolio();
        driver.findElement(By.xpath("//*[@id='portfolio-views']/div[1]/div/a/i")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("Name")).clear();
        Thread.sleep(500);
        driver.findElement(By.id("Name")).sendKeys("Portfolio №777");
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id='portfolioForm_cnt']/div[1]/div[3]/div/button[1]")).click();
        WebDriverWait wait2 = new WebDriverWait(driver, 30);
        wait2.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id='portfolio-views']/div[1]/div"),"Portfolio №777"));
    }

    @Test(priority = 2)
    public void AssertSaveProjectNameFromPage() throws Exception {
        goToPagePortfolio();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='portfolio-views']/div[1]/div")).getText(), "Portfolio №777");
    }

    @Test(priority = 3)
    public void ChangeNameOfPortfolioFromAdmin() throws Exception {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id='CandidateProfileHeader']/div/div[2]/div[2]")));
        // Click Administrer porteføljer
        driver.findElement(By.xpath("//*[@id='portfolio-add']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='portfolioManage_cnt']/div[1]")));
        // Click Edit Portfolio
        driver.findElement(By.xpath("//*[@id='p-list-cnt']/ul/li/a[2]/i")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("Name")).clear();
        Thread.sleep(500);
        driver.findElement(By.id("Name")).sendKeys("Portfolio №999");
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id='portfolioForm_cnt']/div[1]/div[3]/div/button[1]")).click();
        WebDriverWait wait2 = new WebDriverWait(driver, 30);
        wait2.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@id='p-list-cnt']/ul/li"),"Portfolio №999"));
        // Close Edit Form
        driver.findElement(By.xpath("//*[@id='portfolioManage_cnt']/div[1]/div[1]/button")).click();
        WebDriverWait wait3 = new WebDriverWait(driver, 30);
        wait3.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id='portfolio-views']/div[1]/div"),"Portfolio №999"));
    }

    @Test(priority = 4)
    public void AssertSaveProjectNameFromAdmin() throws Exception {
        goToPagePortfolio();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='portfolio-views']/div[1]/div")).getText(), "Portfolio №999");
    }

    @Test(priority = 5)
    public void AddNewPortfolio() throws Exception {
        // Click Administrer porteføljer
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id='CandidateProfileHeader']/div/div[2]/div[2]")));
        driver.findElement(By.xpath("//*[@id='portfolio-add']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='portfolioManage_cnt']/div[1]")));

        // Click Add new Portfolio
        driver.findElement(By.xpath("//*[@id='p-add']")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("Name")).sendKeys("Portfolio №888");
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id='portfolioForm_cnt']/div[1]/div[3]/div/button[1]")).click();
        WebDriverWait wait2 = new WebDriverWait(driver, 30);
        wait2.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id='p-list-cnt']/ul/li[2]"),"Portfolio №888"));

        // Click Add new Portfolio
        driver.findElement(By.xpath("//*[@id='p-add']")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("Name")).sendKeys("Portfolio №777");
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id='portfolioForm_cnt']/div[1]/div[3]/div/button[1]")).click();
        WebDriverWait wait3 = new WebDriverWait(driver, 30);
        wait3.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id='p-list-cnt']/ul/li[3]"),"Portfolio №777"));

        // Close Edit Form
        driver.findElement(By.xpath("//*[@id='portfolioManage_cnt']/div[1]/div[1]/button")).click();
        WebDriverWait wait4 = new WebDriverWait(driver, 30);
        wait3.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id='portfolio-views']/div[3]/div"),"Portfolio №888"));
        WebDriverWait wait5 = new WebDriverWait(driver, 30);
        wait5.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id='portfolio-views']/div[5]/div"),"Portfolio №777"));
    }

    @Test(priority = 6)
    public void AddProjectsInPortfolio() throws Exception {
        // Add Project in Protfolio№ 888
        driver.findElement(By.xpath("//*[@id='project-add']/i")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("Name")).sendKeys("№3 Test Prosjekt");
        // Chose Portfolio
        driver.findElement(By.xpath("//*[@id='SelectedPortfolio_chosen']/a/div/b")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id='SelectedPortfolio_chosen']/div/ul/li[2]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id='projectEdit_cnt']/div[1]/div[3]/div/button[1]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='project-view']/div[1]/div")));
        backFromProsjektToPortfolio();

        // Add Project in Protfolio№ 777
        driver.findElement(By.xpath("//*[@id='project-add']/i")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("Name")).sendKeys("№4 Test Prosjekt");
        // Chose Portfolio
        driver.findElement(By.xpath("//*[@id='SelectedPortfolio_chosen']/a/div/b")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id='SelectedPortfolio_chosen']/div/ul/li[3]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id='projectEdit_cnt']/div[1]/div[3]/div/button[1]")).click();
        WebDriverWait wait2 = new WebDriverWait(driver, 30);
        wait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='project-view']/div[1]/div")));
        backFromProsjektToPortfolio();

        // Add Project in Protfolio№ 999
        driver.findElement(By.xpath("//*[@id='project-add']/i")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("Name")).sendKeys("№1 Test Prosjekt");
        // Chose Portfolio
        driver.findElement(By.xpath("//*[@id='SelectedPortfolio_chosen']/a/div/b")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id='SelectedPortfolio_chosen']/div/ul/li[1]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id='projectEdit_cnt']/div[1]/div[3]/div/button[1]")).click();
        WebDriverWait wait3 = new WebDriverWait(driver, 30);
        wait3.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='project-view']/div[1]/div")));
        backFromProsjektToPortfolio();
    }

    @Test(priority = 7)
    public void AssertSaveCWithProject() throws Exception {
        goToPagePortfolio();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='portfolio-views']/div[1]/div")).getText(), "Portfolio №999");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='portfolio-views']/div[2]/div/div[2]/div[1]/h2/a")).getText(), "№2 Test Prosjekt");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='portfolio-views']/div[2]/div[2]/div[2]/div[1]/h2/a")).getText(), "№1 Test Prosjekt");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='portfolio-views']/div[3]/div")).getText(), "Portfolio №888");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='portfolio-views']/div[4]/div/div[2]/div[1]/h2/a")).getText(), "№3 Test Prosjekt");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='portfolio-views']/div[5]/div")).getText(), "Portfolio №777");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='portfolio-views']/div[6]/div/div[2]/div[1]/h2/a")).getText(), "№4 Test Prosjekt");
    }

    @Test(priority = 8)
    public void MovePortfolio() throws Exception {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id='pp']/div/div[2]/div[2]")));
        Thread.sleep(2000);
        WebElement draggable = driver.findElement(By.xpath("//*[@id='portfolio-views']/div[2]/div[2]/a[4]/i"));
        Actions builder = new Actions(driver);
        builder.dragAndDropBy(draggable, 0, -310).build().perform();
        Thread.sleep(2000);
    }

    @Test(priority = 9)
    public void AssertPortfolioMoved() throws Exception {
        goToPagePortfolio();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='portfolio-views']/div[1]/div")).getText(), "Portfolio №999");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='portfolio-views']/div[2]/div/div[2]/div[1]/h2/a")).getText(), "№1 Test Prosjekt");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='portfolio-views']/div[2]/div[2]/div[2]/div[1]/h2/a")).getText(), "№2 Test Prosjekt");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='portfolio-views']/div[3]/div")).getText(), "Portfolio №888");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='portfolio-views']/div[4]/div/div[2]/div[1]/h2/a")).getText(), "№3 Test Prosjekt");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='portfolio-views']/div[5]/div")).getText(), "Portfolio №777");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='portfolio-views']/div[6]/div/div[2]/div[1]/h2/a")).getText(), "№4 Test Prosjekt");
    }

    @Test(priority = 10)
    public void DeleteProject() throws Exception {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id='pp']/div/div[2]/div[2]")));
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='portfolio-views']/div[2]/div[1]/a[2]/i")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='projectDelete_cnt']/div[1]/div[3]/div/button[1]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id='portfolio-views']/div[2]/div/div[2]/div[1]/h2/a"),"№2 Test Prosjekt"));
    }

    @Test(priority = 11)
    public void AssertProjectDeleted() throws Exception {
        goToPagePortfolio();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='portfolio-views']/div[1]/div")).getText(), "Portfolio №999");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='portfolio-views']/div[2]/div/div[2]/div[1]/h2/a")).getText(), "№2 Test Prosjekt");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='portfolio-views']/div[3]/div")).getText(), "Portfolio №888");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='portfolio-views']/div[4]/div/div[2]/div[1]/h2/a")).getText(), "№3 Test Prosjekt");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='portfolio-views']/div[5]/div")).getText(), "Portfolio №777");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='portfolio-views']/div[6]/div/div[2]/div[1]/h2/a")).getText(), "№4 Test Prosjekt");
    }


    @Test(priority = 12)
    public void DeletePortfolioFromPage() throws Exception {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id='portfolio-views']/div[2]/div/div[2]")));
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='portfolio-views']/div[3]/a/i")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='portfolioDelete_cnt']/div[1]")));
        driver.findElement(By.xpath("//*[@id='portfolioDelete_cnt']/div[1]/div[3]/div/button[1]")).click();
        WebDriverWait wait2 = new WebDriverWait(driver, 30);
        wait2.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id='portfolio-views']/div[4]/div/div[2]/div[1]/h2/a"),"№4 Test Prosjekt"));
    }

    @Test(priority = 13)
    public void AssertPortfolioFromPageDeleted() throws Exception {
        goToPagePortfolio();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='portfolio-views']/div[1]/div")).getText(), "Portfolio №999");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='portfolio-views']/div[2]/div/div[2]/div[1]/h2/a")).getText(), "№2 Test Prosjekt");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='portfolio-views']/div[3]/div")).getText(), "Portfolio №777");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='portfolio-views']/div[4]/div/div[2]/div[1]/h2/a")).getText(), "№4 Test Prosjekt");
    }

    @Test(priority = 14)
    public void DeletePortfolioFromAdmin() throws Exception {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id='CandidateProfileHeader']/div/div[2]/div[2]")));
        driver.findElement(By.xpath("//*[@id='portfolio-add']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='portfolioManage_cnt']/div[1]")));
        // Delete port 2 position
        driver.findElement(By.xpath("//*[@id='p-list-cnt']/ul/li[2]/a[1]/i")).click();
        WebDriverWait wait2 = new WebDriverWait(driver, 30);
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='portfolioDelete_cnt']/div[1]")));
        driver.findElement(By.xpath("//*[@id='portfolioDelete_cnt']/div[1]/div[3]/div/button[1]")).click();
        Thread.sleep(500);
        // Delete port 2 position
        driver.findElement(By.xpath("//*[@id='p-list-cnt']/ul/li/a[1]/i")).click();
        WebDriverWait wait4 = new WebDriverWait(driver, 30);
        wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='portfolioDelete_cnt']/div[1]")));
        driver.findElement(By.xpath("//*[@id='portfolioDelete_cnt']/div[1]/div[3]/div/button[1]")).click();
        // Close Edit Form
        driver.findElement(By.xpath("//*[@id='portfolioManage_cnt']/div[1]/div[1]/button")).click();
        WebDriverWait wait3 = new WebDriverWait(driver, 30);
        wait3.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='portfolio-views']/div[3]/div")));
        WebDriverWait wait5 = new WebDriverWait(driver, 30);
        wait5.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='portfolio-views']/div[1]/div")));
    }

    @Test(priority = 15)
    public void AssertPortfolioFromAdmDeleted() throws Exception {
        goToPagePortfolio();
        assertEquals(driver.findElement(By.xpath("//*[@id='portfolio-views']/article/div/p/strong/span")).getText(), "Får du vist frem din kompetanse på en god nok måte gjennom en vanlig CV? ");
    }


}