package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	private static ExtentReports extent;
	private static ThreadLocal<ExtentTest> test= new ThreadLocal<>();
	
	public static ExtentReports getInstance() {
		if(extent==null) {
			ExtentSparkReporter reporter=new ExtentSparkReporter("test-output/ExtentReport.html");
			reporter.config().setDocumentTitle("Automation Test Report");
			reporter.config().setReportName("AutomationExcercise Report");
			extent=new ExtentReports();
			extent.attachReporter(reporter);
		}
		return extent;
	}
	
	public static void setTest(ExtentTest currentTest) {
		test.set(currentTest);
	}
	
	public static ExtentTest getTest() {
		return test.get();
	}
}
