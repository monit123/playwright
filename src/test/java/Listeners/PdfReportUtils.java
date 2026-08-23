package Listeners;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.nio.file.Paths;

public class PdfReportUtils {

    public static void convertHtmlToPdf(String testCaseName) {
        String htmlPath = Paths.get("test-output/" + testCaseName + "_Report.html").toAbsolutePath().toString();
        String pdfPath = "test-output/pdf/" + testCaseName + "_Report.pdf";

        try (Playwright pdfPlaywright = Playwright.create()) {
            Browser pdfBrowser = pdfPlaywright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(true));

            Page pdfPage = pdfBrowser.newPage();
            pdfPage.navigate("file:///" + htmlPath.replace("\\", "/"));

            pdfPage.pdf(new Page.PdfOptions()
                    .setPath(Paths.get(pdfPath))
                    .setFormat("A4")
                    .setPrintBackground(true));

            pdfBrowser.close();
            System.out.println("PDF report generated: " + pdfPath);

        } catch (Exception e) {
            System.out.println("Could not generate PDF report: " + e.getMessage());
        }
    }
}