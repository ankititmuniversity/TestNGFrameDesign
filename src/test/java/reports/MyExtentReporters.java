package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import testBase.Base;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyExtentReporters extends Base implements ITestListener {

    ExtentSparkReporter sparkReporter;
    ExtentReports reporter;
    ExtentTest test;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-ddHH-mm-ss");
    String timeStamp = sdf.format(new Date());
    String path = System.getProperty("user.dir") + "\\report\\" + timeStamp + "index.html";

    @Override
    public void onStart(ITestContext context) {
        sparkReporter = new ExtentSparkReporter(path);
        reporter = new ExtentReports();
        reporter.attachReporter(sparkReporter);

        sparkReporter.config().setDocumentTitle("MyExtentReportDocument");
        sparkReporter.config().setReportName("MyExtentReport");
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setEncoding("UTF-8");

        reporter.setSystemInfo("OS Name", System.getProperty("os.name"));
        reporter.setSystemInfo("OS Version", System.getProperty("os.version"));
        reporter.setSystemInfo("OS Architecture", System.getProperty("os.arch"));
        reporter.setSystemInfo("Root Directory", System.getProperty("user.dir"));
        reporter.setSystemInfo("Java Version", System.getProperty("java.version"));
        reporter.setSystemInfo("Role", "Test Lead");
        reporter.setSystemInfo("Environment", "Test Environment");
    }

    @Override
    public void onFinish(ITestContext context) {
        reporter.flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = reporter.createTest(result.getMethod().getMethodName());
        System.out.println("Started Test Name is :: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        errorScreenShot(System.getProperty("user.dir") + "\\screenshots\\" + timeStamp + result.getName() + ".png");
        System.out.println("Failed Test Name is :: " + result.getName());
        test.fail("Test failed: " + result.getThrowable());
        test.log(Status.FAIL, "FAILED");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Skipped Test Name is :: " + result.getName());
        test.log(Status.SKIP, "SKIPPED");
    }
}