package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;
import testBase.Base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

public class TakeScreenShot extends Base {
    //element level screen shot
    @Test
    public void captureScreenShot() throws IOException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        //  d.findElement(By.xpath("body_txtUserID")).clear();
       // driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
        byte [] src = driver.findElement(By.xpath("//input[@name='username']")).getScreenshotAs(OutputType.BYTES);
        FileOutputStream fos = new FileOutputStream("./screenshots/mySS.jpg");
        fos.write(src);
        fos.close();

    }
    @Test
    public void captureScreenSho1t() throws IOException {

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        String base64code = driver.findElement(By.xpath("//input[@name='username']")).getScreenshotAs(OutputType.BASE64);
        byte [] src = Base64.getDecoder().decode(base64code);
        FileOutputStream fos = new FileOutputStream("./screenshots/img.jpg");
        fos.write(src);
        fos.close();

    }
}
