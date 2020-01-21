package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    WebDriver driver;
    protected LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}
