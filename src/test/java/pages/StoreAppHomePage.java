package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class StoreAppHomePage {
    public StoreAppHomePage(){
        WebDriver driver= Driver.getDriver();
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath ="//a[@class='login']")
    public WebElement signInButton;

    @FindBy(xpath = "//li[@class='youtube']")
    public WebElement youtubeButton;

    @FindBy(xpath = "//li[@class='facebook']")
    public WebElement facebookButton;

    @FindBy(xpath ="(//a[@href='http://automationpractice.com/index.php?id_category=3&controller=category'])[1]")
    public WebElement womenButton;

}
