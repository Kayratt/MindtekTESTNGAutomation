package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.SaucedemoHomePage;
import pages.SaucedemoLoginPage;
import utilities.BrowserUtils;
import utilities.Configuration;
import utilities.TestBase;

import java.util.List;

public class SaucedemoAppTest extends TestBase {
    @Test
    public void filterTest(){
    driver.get(Configuration.getProperty("SaucedemoURL"));
    String expectedTitle="Swag Labs";
    String actualTitle=driver.getTitle();
        SoftAssert softAssert = new SoftAssert();
        Assert.assertEquals(actualTitle,expectedTitle);
        SaucedemoLoginPage saucedemoLoginPage = new SaucedemoLoginPage();
        saucedemoLoginPage.username.sendKeys(Configuration.getProperty("SaucedemoUsername"));
        saucedemoLoginPage.password.sendKeys(Configuration.getProperty("SaucedemoPassword"));
        saucedemoLoginPage.loginButton.click();
        SaucedemoHomePage SaucedemoHomePage= new SaucedemoHomePage();
        BrowserUtils.selectByValue(SaucedemoHomePage.filterDropdown,"lohi");
        List<WebElement> prices =SaucedemoHomePage.prices;
        // $7.99, $15.99
        for(int i=0; i< prices.size()-1; i++){
            double price1=Double.parseDouble(prices.get(i).getText().substring(1));
            double price2=Double.parseDouble(prices.get(i+1).getText().substring(1));
            Assert.assertTrue(price1<=price2);



        }

    }
}
