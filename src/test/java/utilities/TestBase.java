package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
 protected WebDriver driver;
    @BeforeMethod
    public void setUp() {
//        WebDriverManager.chromedriver().setup();
//        driver=new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver = Driver.getDriver();
    }

        @AfterMethod

        public void tearDown () throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();

        }


}
