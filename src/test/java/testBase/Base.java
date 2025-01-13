package testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class Base {
    public static WebDriver driver;
    public Logger logger;

    @BeforeClass
    @Parameters({"browser"})
    public void beforeClass(@Optional("chrome") String browser) throws IOException {
        logger = LogManager.getLogger(this.getClass());
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

    //full page Screenshot
    public static void errorScreenShot(String path) {
        TakesScreenshot scrShot = (TakesScreenshot) driver;
        File src = scrShot.getScreenshotAs(OutputType.FILE);
        File des = new File(path);
        //FileUtils.copyFile(des,src);
        src.renameTo(des);

        //Specific element Screenshot
//        WebElement specEle = driver.findElement(By.xpath(""));
//        File srcFile = specEle.getScreenshotAs(OutputType.FILE);
//        File desFile =new File(  System.getProperty("user.dir"));
//        srcFile.renameTo(desFile);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
