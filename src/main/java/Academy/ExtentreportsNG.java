package Academy;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentreportsNG
{
	static ExtentReports er;
	 public static ExtentReports testCaseReports()
	{
		String path=System.getProperty("C:\\Users\\MG\\eclipse-workspace\\E2Eproject")+"reports\\index.html";
		ExtentSparkReporter esk=new ExtentSparkReporter(path);
		esk.config().setReportName("Automation Testing Result Report");
		esk.config().setDocumentTitle("Automation");
		
		er=new ExtentReports();
		er.attachReporter(esk);
		er.setSystemInfo("Tester","GK");
		return er;
	}

}
