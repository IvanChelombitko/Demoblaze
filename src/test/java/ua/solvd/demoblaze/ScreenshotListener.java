package ua.solvd.demoblaze;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ua.solvd.demoblaze.util.DriverPool;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotListener implements ITestListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(ScreenshotListener.class);

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = DriverPool.getDriver();
        if (driver != null) {
            TakesScreenshot screenshotTaker = (TakesScreenshot) driver;
            File screenshotFile = screenshotTaker.getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String testName = result.getMethod().getMethodName();
            String destinationPath = "target/screenshots/" + testName + "_" + timestamp + ".png";
            File destinationFile = new File(destinationPath);
            File parentDir = destinationFile.getParentFile();
            if (!parentDir.exists() && !parentDir.mkdirs()) {
                LOGGER.warn("Failed to create screenshot directories at: '{}'.", parentDir.getAbsolutePath());
            }
            try {
                FileHandler.copy(screenshotFile, destinationFile);
                LOGGER.info("Screenshot saved successfully to: '{}'.", destinationPath);
            } catch (IOException e) {
                LOGGER.error("Failed to save screenshot for test: '{}'.", testName, e);
            }
        }
    }
}