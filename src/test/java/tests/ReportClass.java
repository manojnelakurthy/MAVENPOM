package tests;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ReportClass {

	static ExtentReports report;
	static ExtentTest test;
	
	public void startTest(){
		report=new ExtentReports("report.html");
		test=report.startTest("Test");
	}
	
	public void endTest(){
		report.endTest(test);
		report.flush();
	}
}
