package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.StoreAppHomePage;
import utilities.Configuration;
import utilities.TestBase;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class StoreProject extends TestBase {
    int actualResultForCompare;

    StoreAppHomePage storeAppHomePage = new StoreAppHomePage();


    @DataProvider(name = "checkTitles")
    public static Object[][] testData() {
        StoreAppHomePage storeAppHomePage = new StoreAppHomePage();
        WebElement youtubeBtn = storeAppHomePage.youtubeButton;
        WebElement facebookBtn = storeAppHomePage.facebookButton;
        return new Object[][]{
                {youtubeBtn, "Selenium Framework - YouTube"},
                {facebookBtn, "Selenium Framework"}
        };
    }

    @Test(dataProvider = "checkTitles", priority = 0)
    public void youtubeButton(WebElement buttonToClick, String expectedTitle) throws InterruptedException {
        driver.get(Configuration.getProperty("ProjectURL"));
        String currentWindowID = driver.getWindowHandle();
        buttonToClick.click();
        Set<String> windowIDs = driver.getWindowHandles();
        for (String id : windowIDs) {
            if (!id.equals(currentWindowID)) {
                driver.switchTo().window(id);
            }
        }
        String actualResult = driver.getTitle();
        Assert.assertEquals(actualResult, expectedTitle, "Expected result for this test is " + expectedTitle + "" +
                " ,and Actual result is " + actualResult);
    }

    @Test
    public void facebookButton() {
        driver.get(Configuration.getProperty("StoreURL"));
        String currentWindowID = driver.getWindowHandle();
        storeAppHomePage.facebookButton.click();
        Set<String> windowIDs = driver.getWindowHandles();
        for (String id : windowIDs) {
            if (!id.equals(currentWindowID)) {
                driver.switchTo().window(id);
            }
        }
        String actualResult = driver.getTitle();
        String expectedResult = "Selenium Framework | Facebook";
        Assert.assertEquals(actualResult, expectedResult, "Expected result for this test is " + expectedResult + "" +
                " ,and Actual result is " + actualResult);
    }

    @Test(priority = 2)

    public void checkCompareButton() throws InterruptedException {

        driver.get(Configuration.getProperty("StoreURL"));
        storeAppHomePage.womenButton.click();
        Actions actions = new Actions(driver);
        WebElement element2 = driver.findElement(By.xpath("(//img[@class='replace-2x img-responsive'])[3]"));
        actions.moveToElement(element2).build().perform();
        WebElement addToCompare2 = driver.findElement(By.xpath("(//a[@class='add_to_compare'])[2]"));
        addToCompare2.click();
        Thread.sleep(3000);
        WebElement element1 = driver.findElement(By.xpath("(//img[@class='replace-2x img-responsive'])[2]"));
        actions.moveToElement(element1).build().perform();
        WebElement addToCompare1 = driver.findElement(By.xpath("(//a[@class='add_to_compare'])[1]"));
        addToCompare1.click();
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
        WebElement inTheBox1 = driver.findElement(By.xpath("//td[@class='ajax_block_product comparison_infos product-block product-1']"));
        WebElement inTheBox2 = driver.findElement(By.xpath("//td[@class='ajax_block_product comparison_infos product-block product-2']"));
        WebElement result[] = {inTheBox1, inTheBox2};
        int expectedResult = 2;

        for (int i = 0; i < result.length; i++) {
            actualResultForCompare++;
        }
        Assert.assertEquals(actualResultForCompare, expectedResult);

    }
    @Test(priority = 3)
    public void checkCompareButton2() throws InterruptedException {
        driver.get(Configuration.getProperty("StoreURL"));
        storeAppHomePage.womenButton.click();
        Actions actions = new Actions(driver);
        Thread.sleep(3000);
        WebElement element4 = driver.findElement(By.xpath("(//img[@class='replace-2x img-responsive'])[5]"));
        actions.moveToElement(element4).build().perform();
        WebElement addToCompare4 = driver.findElement(By.xpath("(//a[@class='add_to_compare'])[4]"));
        addToCompare4.click();
        Thread.sleep(3000);
        WebElement element3 = driver.findElement(By.xpath("(//img[@class='replace-2x img-responsive'])[4]"));
        actions.moveToElement(element3).build().perform();
        WebElement addToCompare3 = driver.findElement(By.xpath("(//a[@class='add_to_compare'])[3]"));
        addToCompare3.click();
        WebElement element2 = driver.findElement(By.xpath("(//img[@class='replace-2x img-responsive'])[3]"));
        actions.moveToElement(element2).build().perform();
        WebElement addToCompare2 = driver.findElement(By.xpath("(//a[@class='add_to_compare'])[2]"));
        addToCompare2.click();
        Thread.sleep(3000);
        WebElement element1 = driver.findElement(By.xpath("(//img[@class='replace-2x img-responsive'])[2]"));
        actions.moveToElement(element1).build().perform();
        WebElement addToCompare1 = driver.findElement(By.xpath("(//a[@class='add_to_compare'])[1]"));
        addToCompare1.click();
        String actualError = driver.findElement(By.xpath("//p[@class='fancybox-error']")).getText();
        String expectedError = "You cannot add more than 3 product(s) to the product comparison";
        Assert.assertEquals(actualError, expectedError);


    }
}