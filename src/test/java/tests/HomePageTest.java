package tests;

import com.opencsv.CSVWriter;
import io.qameta.allure.*;
import org.testng.Assert;

import java.io.FileReader;

import com.opencsv.CSVReader;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import reports.AllureListener;
import testBase.Base;
import pageobjects.HomePage;

import java.io.FileWriter;
import java.io.IOException;

@Listeners({AllureListener.class})
public class HomePageTest extends Base {

    @Test(description = "Verification of URL launch and Logo Check")
    @Description("Verify Logo Persence on HomePage")
    @Epic("E40566")
    @Feature("GetAccountDetails")
    @Story("Saving Account ID")
    @Step("Logo Check")
    @Severity(SeverityLevel.MINOR)

    public void homePage() throws IOException, InterruptedException {
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        logger.info("Url launched successfully");
        HomePage hp = new HomePage(driver);
        System.out.println("Logo of home page is :: " + hp.getLogo());
        //Assert.assertTrue(false);
        hp.setQuantity(5);
        hp.addToCart();
        hp.proceedToCheckout();
    }

    @Test
    public void readFunction() throws Exception {
        //Below code reads a row from the csv file. Return type of this method is array of String.
        CSVReader csvReader = new CSVReader(new FileReader("credentials.csv"));
        String[] cols;
        while ((cols = csvReader.readNext()) != null) {
            String uname = cols[0];
            String pwd = cols[1];
            System.out.println(uname + " " + pwd);
        }
        csvReader.close();
    }

    @Test
    public void writeFunction() throws Exception {
        //Below code writes a header row to the csv file. Return type of this method is array of String.
        CSVReader csvReader = new CSVReader(new FileReader("credentials.csv"));
        CSVWriter csvWriter = new CSVWriter(new FileWriter("results.csv"));
        String[] cols;
        while ((cols = csvReader.readNext()) != null) {
            String uname = cols[0];
            String pwd = cols[1];
            String success[] = {uname, pwd, "Login successful"};
            csvWriter.writeNext(success);
        }
        csvReader.close();
        csvWriter.close();
    }
}
