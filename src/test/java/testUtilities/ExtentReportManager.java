package testUtilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import pageObjects.BasePage;

public class ExtentReportManager implements ITestListener {
	
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;

	String repName;
	
	@Override
	public void onTestStart(ITestResult result) {
		test =extent.createTest(result.getTestClass().getName());
		//test.log(Status., "Test case Passed is: " + result.getName());
		extent.getStats();
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		test =extent.createTest(result.getTestClass().getName());
		test.log(Status.PASS, "Test case Passed is: " + result.getName());
		test.log(Status.PASS,result.getName()+" got successfully executed");
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		test =extent.createTest(result.getTestClass().getName());
		test.log(Status.FAIL, "Test case FAILED is: "  + result.getName());
		test.log(Status.FAIL,result.getName()+" got failed");
		test.log(Status.INFO,result.getThrowable().getMessage());
		
		/* try { */
			String imgpath = new CaptureScreenshots().getScreenshots(result.getName());
			test.addScreenCaptureFromPath(imgpath);
			
		/*}catch(IOException e1){
			e1.printStrackTrace();
		}*/
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test =extent.createTest(result.getName());
		test.log(Status.SKIP, "Test case SKIPPED is: " + result.getName());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		repName = "test-Report-"+ timeStamp + ".html";
		sparkReporter=new ExtentSparkReporter(".\\reports\\" + repName);
		
		sparkReporter.config().setDocumentTitle("ArtVault Automation Report");
		sparkReporter.config().setReportName("ArtVault Functional Testing");
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		
		extent.setSystemInfo("Application", "ArtVault");
		extent.setSystemInfo("user Name", System.getProperty("user.name"));
		extent.setSystemInfo("Environment", "QA");
		
		String os = context.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("Operating System", os);
		
		String browser =context.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browser);
		
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		
	}

}
