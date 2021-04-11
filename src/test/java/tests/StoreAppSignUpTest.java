package tests;

import org.apache.commons.io.input.BrokenInputStream;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.StoreAppHomePage;
import pages.StoreAppRegisterPage;
import pages.StoreAppSignInPage;
import utilities.BrowserUtils;
import utilities.Configuration;
import utilities.DataUtils;
import utilities.TestBase;


public class StoreAppSignUpTest extends TestBase {

    @DataProvider(name="signUpTestData")
    public static Object[][] testData(){
        return new Object[][]{
                {"John","Doe","12345678","1","1","2000","123 Washington ave.","Chicago","13","12345","1234567890"},
                {"John","Mr.Doe","1232222","1","1","2020","33 Dee Rd.","New York","32","54321","989838182"}


        };
    }
    @Test(dataProvider="signUpTestData")
    public void signUpTest(String firstName,String lastName,String password, String Day, String month, String year,
                           String address, String city, String state, String postcode, String mobileNumber){
        StoreAppHomePage storeAppHomePage= new StoreAppHomePage();
        StoreAppSignInPage storeAppSignInPage = new StoreAppSignInPage();
        StoreAppRegisterPage storeAppRegisterPage = new StoreAppRegisterPage();
        driver.get(Configuration.getProperty("StoreURL"));
        storeAppHomePage.signInButton.click();
        storeAppSignInPage.emailInputBox.sendKeys(DataUtils.getRandomEmail());
        storeAppSignInPage.createAccountButton.click();
        storeAppRegisterPage.firstName.sendKeys(firstName);
        storeAppRegisterPage.lastName.sendKeys(lastName);
        storeAppRegisterPage.address1.sendKeys(address);
        storeAppRegisterPage.password.sendKeys(password);
        storeAppRegisterPage.mobile.sendKeys(mobileNumber);
        BrowserUtils.selectByValue(storeAppRegisterPage.days,Day);
        BrowserUtils.selectByValue(storeAppRegisterPage.months,month);
        BrowserUtils.selectByValue(storeAppRegisterPage.years,year);
        storeAppRegisterPage.cities.sendKeys(city);
        BrowserUtils.selectByValue(storeAppRegisterPage.states,state);
        storeAppRegisterPage.postcode.sendKeys(postcode);
        storeAppRegisterPage.registerButton.click();
        String expectedTitle = "My account - My Store";
        String actualTitle =driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle,"Actual Title "+actualTitle+
                " didn't match with expected title"+expectedTitle);
    }

}
