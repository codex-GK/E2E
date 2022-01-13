package Academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners extends Base implements ITestListener
{
	ExtentTest genreports;
	//er is the return type here so we need to keep in er variable type
	ExtentReports er=ExtentreportsNG.testCaseReports();
	//if we write inside the on test start it gives error at flush for on finish()
	
	public void onTestStart(ITestResult result)
	{
		
		
	//FOr every test case we generate reports so we dont hardcode in every test case instead we write here
	//we shouldnot hardcode the report name. report name should be method name for standards
		genreports	=er.createTest(result.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult result)
	{
		genreports.log(Status.PASS, "TestPass");
	}

	public void onTestFailure(ITestResult result)
	{
		//this will give the logs of failed test case in the generated report
		genreports.fail(result.getThrowable());
//step1: we need to write screenshot method for failed test case
//step2: we write screenshot method in base class
//step3: we need to link base class here so use inheritence to acccess the screenshot methods
//Step4: we need to know which test case failed, result variable has the details
		WebDriver driver=null;
		String failedmethname= result.getMethod().getMethodName();
		
		
 try {
	 driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
} catch (Exception e) {
	
}          
		
		try {
		//to capture the screenshot in the generated report
			genreports.addScreenCaptureFromPath(screenshotmethod(failedmethname,driver),result.getMethod().getMethodName());
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void onTestSkipped(ITestResult result)
	{
			
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
		
	}

	public void onTestFailedWithTimeout(ITestResult result)
	{
		
	}

	public void onStart(ITestContext context) 
	{
		
	}

	public void onFinish(ITestContext context)
	{
		er.flush();
		
	}

}
