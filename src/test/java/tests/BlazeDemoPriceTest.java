package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BlazeDemoFlightsPage;
import pages.BlazeDemoHomepage;
import utilities.Configuration;
import utilities.TestBase;

import java.util.List;


public class BlazeDemoPriceTest extends TestBase{
    // This test will veriofy that all flight prices are below $1000
    BlazeDemoHomepage blazeDemoHomepage = new BlazeDemoHomepage();
    BlazeDemoFlightsPage blazeDemoFlightsPage = new BlazeDemoFlightsPage();
    @Test
    public void priceTest(){
        driver.get(Configuration.getProperty("BlazeDemoURL"));
       // driver.findElement(By.xpath("//input[@type='submit']")).click();
        blazeDemoHomepage.findFlightsButton.click();
        //List<WebElement> prices = driver.findElements(By.xpath("//table[@class='table']//td[6]"));
        List<WebElement> prices = blazeDemoFlightsPage.prices;
        for(WebElement price:prices){
            String strPrice = price.getText().substring(1);//
            //String 472.56 -> Double
            double doublePrice=Double.parseDouble(strPrice);
            Assert.assertTrue(doublePrice<1000);
            System.out.println(doublePrice);
        }

    }
    // verify that test result having only two virgin america flights
    //  verify that flight text having right city names like Flight from san diego to NEw York

}
