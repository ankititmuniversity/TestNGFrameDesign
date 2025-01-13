package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

//@Listeners(ListenersTestNG.class)
public class ParameterizationDemo {
    WebDriver driver;

    @BeforeClass
    @Parameters({"browser"})
    public void beforeClass(@Optional("chrome") String browser) {
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                driver = null;
        }
        if (driver != null) {
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(Duration.of(5, ChronoUnit.SECONDS));
        } else {
            System.out.println("Browser is null");
        }
    }

    @Test
    public void test1() {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.getTitle();
        System.out.println("/");
        System.out.println("./");
        System.out.println("../");
    }

    @Test
    public void test2() {
        //  driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        String expected = "Practice Page";
        String actual = driver.getTitle();
        Assert.assertEquals(actual, expected);
    }

    @Test(enabled = false)
    public void test3() {
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        String expected = "Practice Page";
        String actual = driver.getTitle();
        Assert.assertEquals(actual, expected);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
