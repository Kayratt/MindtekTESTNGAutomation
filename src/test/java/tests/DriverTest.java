package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import utilities.Configuration;

public class DriverTest {
    @Test
    public void edgeTest() {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.get("https://blazedemo.com/index.php");
    }

    @Test
    public void testProperties() {
        System.out.println(Configuration.getProperty("browser")); //chrome
        System.out.println(Configuration.getProperty("username"));
    }
}

