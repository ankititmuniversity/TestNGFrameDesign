package commontoselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import testBase.Base;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class SeleniumBasic extends Base {

    @Test
    public void radioButton() {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        WebElement radio1 = driver.findElement(By.xpath("//input[@value='radio1']"));
        if (radio1.isEnabled()) {
            if (!radio1.isSelected()) {
                radio1.click();
            }
        }
    }
    @Test
    public void suggestedDropDown() {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        WebElement enterValue = driver.findElement(By.xpath("//input[@placeholder='Type to Select Countries']"));
        enterValue.sendKeys("IND");
        List<WebElement> listOfCountry = driver.findElements(By.xpath("//ul[@id='ui-id-1']/li"));
        for (WebElement country : listOfCountry) {
            if (country.getText()=="India"){
                country.click();
            }
        }
    }
    @Test
    public void selectDropDown() {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        WebElement dropdown = driver.findElement(By.cssSelector("select[id*='class']"));
        Select dd = new Select(dropdown);
       // dd.selectByIndex(1);
        dd.selectByValue("option2");
        //dd.selectByVisibleText("Option3");
    }
    @Test
    public void checkBox() throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//        WebElement checkbox = driver.findElement(By.id("checkBoxOption1"));
//        checkbox.click();
        List<WebElement> myCheckBox =driver.findElements(By.xpath("//div[@id='checkbox-example']/descendant::input"));
        for (WebElement checkBox : myCheckBox) {
            if (!checkBox.isSelected()) {
                checkBox.click();
              //  System.out.println("checkbox clicked");
               // Thread.sleep(4000);
            }
        }
    }
    @Test
    public void switchWindow() {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        String originalWindow = driver.getWindowHandle();
        driver.findElement(By.id("openwindow")).click();
        Set<String> windowHandles = driver.getWindowHandles();
        // Switch to the new window
        for (String handle : windowHandles) {
            if (!handle.equals(originalWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        // Perform actions in the new window
        System.out.println("New window title: " + driver.getTitle());
        driver.close();
        driver.switchTo().window(originalWindow);
        // Perform actions in the original window
        System.out.println("Original window title: " + driver.getTitle());
    }
    @Test
    public void switchTab(){
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        // Get the current tab handle
        String originalTab = driver.getWindowHandle();
        // Open a new tab by clicking a link
        driver.findElement(By.id("opentab")).click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.numberOfWindowsToBe(2));

        // Wait for the new tab to open and get all tab handles
        Set<String> allTabs = driver.getWindowHandles();
        // Switch to the new tab
        for (String tab : allTabs) {
            if (!tab.equals(originalTab)) {
                driver.switchTo().window(tab);
                break;
            }
        }
        // Perform actions in the new tab
        System.out.println("New tab title: " + driver.getTitle());

        // Close the new tab and switch back to the original tab
        driver.close();
        driver.switchTo().window(originalTab);
    }
    @Test
    public void popUp(){
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.id("name")).sendKeys("Ankit");
        driver.findElement(By.id("alertbtn")).click();
        String alertMsg = driver.switchTo().alert().getText();
        System.out.println(alertMsg);
        driver.switchTo().alert().accept();
        //driver.switchTo().alert().dismiss();

        driver.findElement(By.id("name")).sendKeys("Rahul");
        driver.findElement(By.id("confirmbtn")).click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.alertIsPresent());
        String confirmMsg = driver.switchTo().alert().getText();
        System.out.println(confirmMsg);
        //driver.switchTo().alert().accept();
        driver.switchTo().alert().dismiss();

    }
    @Test
    public void webTable(){
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
       WebElement productTable = driver.findElement(By.tagName("table"));
       List<WebElement> theader = productTable.findElements(By.tagName("th"));
        for (WebElement header : theader) {
            System.out.print("| "+header.getText()+" | ");
        }

       List<WebElement> rows = productTable.findElements(By.tagName("tr"));
       for (WebElement row : rows) {
           List<WebElement> data =row.findElements(By.tagName("td"));
           for (WebElement cell : data) {
               System.out.print("| "+cell.getText()+" | ");
           }
           System.out.println();
       }
    }
    @Test
    public void fixedHeaderTable(){
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        WebElement fixedHeaderTable = driver.findElement(By.xpath("//table[@id='product']/parent::div[@class='tableFixHead']"));
        List<WebElement> theader = fixedHeaderTable.findElements(By.tagName("th"));
            for (WebElement header : theader) {
                System.out.print("| "+header.getText()+" | ");
            }

        List<WebElement> rows = fixedHeaderTable.findElements(By.tagName("tr"));
        for (WebElement row : rows) {
            List<WebElement> data =row.findElements(By.tagName("td"));
            for (WebElement cell : data) {
                System.out.print("| "+cell.getText()+" | ");
            }
            System.out.println();
        }

    }
    @Test
    public void pageScroll() throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,800)");
        Thread.sleep(2000);
        WebElement ele = driver.findElement(By.xpath("//table[@id='product']/parent::div[@class='tableFixHead']/descendant::tr[10]"));
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", ele);
        Thread.sleep(2000);
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

    }
    @Test
    public void mouseAction(){
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        WebElement ele = driver.findElement(By.id("mousehover"));
        Actions action = new Actions(driver);
        action.moveToElement(ele).perform();
        driver.findElement(By.linkText("Top")).click();
    }
    @Test
    public void iframeTest(){
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        WebElement iframe = driver.findElement(By.id("courses-iframe"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.linkText("Practice")).click();
        driver.switchTo().defaultContent();
    }
    @Test
    public void linkCount(){
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        List<WebElement> links =driver.findElements(By.xpath("//div[@id='gf-BIG']/descendant::ul/li"));
        for (WebElement link : links) {
            System.out.println(link.getText());
        }
    }
}