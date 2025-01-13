package reports;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import testBase.Base;

public class AllureListener extends Base implements ITestListener {
    private static String getTestMethodName(ITestResult testResult) {
        return testResult.getMethod().getMethodName();
    }

    @Attachment
    public static byte[] saveFailedScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Starting test" + context.getName());
        //context.setAttribute("WebDriver", Base.driver);
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Finishing test" + context.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Starting test" + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test passed" + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test failed" + result.getName());
        saveFailedScreenshot(driver);
        saveTextLog(result.getName() + "failed and screenshot taken");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Skipped test" + result.getName());
    }
}
