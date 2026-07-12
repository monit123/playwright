package Utils;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.microsoft.playwright.Page;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicInteger;

public class ReportUtils {
	
	private final Page page;
    private static final AtomicInteger screenshotCounter = new AtomicInteger(0);
    public ReportUtils(Page page) {
        this.page = page;
    }

    public void logStep(String stepDescription, Status status) {
        try {
            String fileName = "step_" + screenshotCounter.incrementAndGet() + "_" + System.currentTimeMillis() + ".png";
            String screenshotPath = "test-output/screenshots/" + fileName;

            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(screenshotPath)));

            // Convert to absolute path before attaching
            String absolutePath = Paths.get(screenshotPath).toAbsolutePath().toString();

            ExtentManager.getTest().log(status, stepDescription,
                    MediaEntityBuilder.createScreenCaptureFromPath(absolutePath).build());

        } catch (Exception e) {
            ExtentManager.getTest().log(Status.WARNING, "Could not capture screenshot for step: " + stepDescription);
        }
    }
    }