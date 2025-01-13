package utilities;

import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import testBase.Base;

public class XMLReadDemo extends Base {


    @Test
    public void f() throws Exception {
        File file = new File(".//demo1.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(file);
        NodeList nodes = doc.getElementsByTagName("test");
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            String data = node.getTextContent();
            String[] lines = data.split("\n");
            String username = lines[1].trim();
            String password = lines[2].trim();
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
            //  d.findElement(By.xpath("body_txtUserID")).clear();
            driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
            driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            if (driver.getCurrentUrl().equals("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login")) {
                System.out.println("Login unsuccesful");
            } else {
                System.out.println("Login successful");
                driver.findElement(By.cssSelector("i[class*='oxd-userdropdown']")).click();
                driver.findElement(By.linkText("Logout")).click();
            }
        }
    }
}

