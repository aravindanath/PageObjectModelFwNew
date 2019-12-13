package testScripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageRepo.BasePage;
import utils.JavaUtils;

public class BaseTest {

	protected WebDriver driver;
	protected ExtentHtmlReporter htmlReporter;
	protected ExtentReports extent;
	protected ExtentTest test;

	@BeforeTest
	public void setExtent() {
		htmlReporter = new ExtentHtmlReporter("./test-output/myReport.html");
		htmlReporter.config().setDocumentTitle("Automation Report for Regression Suite"); // Title of the report
		htmlReporter.config().setReportName("Functional Report for Amazon"); // name of the report
		htmlReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();

		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Hostname", "LocalHost");
		extent.setSystemInfo("os", "macOS Mojave");
		extent.setSystemInfo("Tester Name", "ARAVINDA");
		extent.setSystemInfo("Browser", "Chrome");
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName()); // to add name in extent report
			test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // to add error/exception in extent
																					// report
			String screenshotPath = BasePage.getScreenshot(driver, result.getName());
			test.addScreenCaptureFromPath(screenshotPath);// adding screen shot
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
		}

	}

	@AfterTest
	public void endReport() {
		extent.flush();
	}

	@BeforeClass

	public void launchBrowser() throws IOException {

		if (JavaUtils.getPropertyOf("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (JavaUtils.getPropertyOf("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.firefoxdriver().setup();

			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}

		driver.get(JavaUtils.getPropertyOf("url"));
	}

	// @AfterSuite
	@AfterClass

	public void closeBroswer() throws IOException {

		driver.quit();

	}

}
