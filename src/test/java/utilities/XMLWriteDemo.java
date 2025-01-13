package utilities;

import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import testBase.Base;

public class XMLWriteDemo extends Base {
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
            Element resElement = doc.createElement("result");
            if (driver.getCurrentUrl().equals("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login")) {
                Text invalidLogin = doc.createTextNode("Login unsuccessful_" + username + ":" + password);
                resElement.appendChild(invalidLogin);
            } else {
                Text validLogin = doc.createTextNode("Login successful_" + username + ":" + password);
                resElement.appendChild(validLogin);
                driver.findElement(By.cssSelector("i[class*='oxd-userdropdown']")).click();
                driver.findElement(By.linkText("Logout")).click();
            }
            Element root = doc.getDocumentElement();
            root.appendChild(resElement);
            TransformerFactory tff = TransformerFactory.newInstance();
            Transformer tf = tff.newTransformer();
            DOMSource domSource = new DOMSource(doc);
            StreamResult result = new StreamResult(file);
            tf.transform(domSource, result);
        }
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }
}
