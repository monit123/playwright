package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    private static ThreadLocal<ExtentReports> extent = new ThreadLocal<>();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public static void createReport(String testCaseName) {
        String filePath = "test-output/" + testCaseName + "_Report.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(filePath);
        reporter.config().setDocumentTitle("Test Report - " + testCaseName);
        reporter.config().setReportName(testCaseName);

        ExtentReports report = new ExtentReports();
        report.attachReporter(reporter);
        extent.set(report);
    }

    public static ExtentReports getInstance() {
        return extent.get();
    }

    public static void setTest(ExtentTest currentTest) {
        test.set(currentTest);
    }

    public static ExtentTest getTest() {
        return test.get();
    }

    public static void flushReport() {
        extent.get().flush();
    }
}