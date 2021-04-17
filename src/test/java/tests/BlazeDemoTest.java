package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BlazeDemoHomepage;
import utilities.Configuration;
import utilities.TestBase;




public class BlazeDemoTest extends TestBase {


    @Test(groups = {"regression"})
    public void test(){
        BlazeDemoHomepage blazeDemoHomepage = new BlazeDemoHomepage();
        driver.get(Configuration.getProperty("BlazeDemoURL"));
       // driver.findElement(By.xpath("//input[@type='submit']")).click();
        blazeDemoHomepage.findFlightsButton.click();
        String expectedTitle="BlazeDemo - reserve";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
    }

}
