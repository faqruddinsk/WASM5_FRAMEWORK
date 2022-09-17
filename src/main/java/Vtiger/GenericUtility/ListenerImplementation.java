package Vtiger.GenericUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class acts like implementation class to override all methods present in 
 * ITest listener Interface 
 * @author shaik
 *
 */
public class ListenerImplementation implements ITestListener {
	ExtentReports report;
	ExtentTest test;
	public void onTestStart(ITestResult result) {
		
		// TODO Auto-generated method stub
		String methodname = result.getMethod().getMethodName();
		
		test=report.createTest(methodname);//test is created which will initialize the individual test
		
		Reporter.log(methodname +" => test script execution started ", true);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname = result.getMethod().getMethodName();
		
		test.log(Status.PASS, methodname+"----> is pass ");
		Reporter.log(methodname+" => is passed ",true);
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		WebDriverUtility wLib=new WebDriverUtility();
		JavaUtility jLib=new JavaUtility();
		
		//this will capture the exception occur
		//String msg = result.getThrowable().toString();
		
		//this will capture the current test method name 
	String methodname = result.getMethod().getMethodName();
	
	//This will append the method name with date for screen shoot 
	String screenShotName=methodname+"-"+jLib.getSystemDateInFormat();
	
	//This will log in report in console
	test.log(Status.FAIL, methodname+"--> is failed");
	test.log(Status.FAIL, result.getThrowable());
	//Reporter.log(methodname +"=> is failed because of => "+msg,true);
	
	//This will capture the screen shoot and provide the screen shoot name with date and time 
	//then save it in folder
	try {
		String path = wLib.takeScreenShot(BaseClass.sDriver, screenShotName);
		
		test.addScreenCaptureFromPath(path);  //navigate to screenshot path and attach it to the report
	}
	catch (Throwable e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		//String msg = result.getThrowable().toString();
		
		String methodname = result.getMethod().getMethodName();
		
		test.log(Status.SKIP, methodname+"--> skipped");
		test.log(Status.SKIP, result.getThrowable());
		
		//Reporter.log(methodname+" => is skipped becuse of =>"+msg,true);
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	
	public void onStart(ITestContext context) {
		//Start of suite execution 
		
		                                                  //inside ExtentReport -Report-07 sep 2022 10-12-25.html
	ExtentSparkReporter htmlReport=new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getSystemDateInFormat()+".html");  
	htmlReport.config().setDocumentTitle("WASM-5-Vtiger Execution Report");
	htmlReport.config().setTheme(Theme.DARK);
	htmlReport.config().setReportName("Vitiger Execution Report");
	
	 report=new ExtentReports();
	report.attachReporter(htmlReport);
	report.setSystemInfo("Base-Browser", "chrome");
	report.setSystemInfo("Base-platform", "windows");
	report.setSystemInfo("Base-URL", "https://localhost:8888");
	report.setSystemInfo("Reporter Name", "shaik");
	
	}

	public void onFinish(ITestContext context) {
		//End of suite execution 
		report.flush();
		  //consolidate all the test script execution and dump the status into report
	}
	

}
