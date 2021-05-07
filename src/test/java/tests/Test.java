package tests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import constants.ExcelData;
import constants.Webdriver;
import pages.DeveloperHomePage;
import pages.LoginPage;

public class Test extends Webdriver{
	public  ExtentReports report=new ExtentReports("report.html");
	public ExtentTest test;
	ExcelData data=new ExcelData();
    
	LoginPage lp=new LoginPage();
	DeveloperHomePage dh=new DeveloperHomePage();
	HashMap<String, String> mapData =null;
	HashMap<String, List<String>> mapData1 =null;
	
	public  String uname,pword,browser,url;

	@BeforeTest
	public void launch() throws IOException{
		
		mapData =data.read();
		mapData1=data.read1();
		uname=mapData.get("username");
		pword=mapData.get("password");
		browser=mapData.get("browser");
		url=mapData.get("url");
		
	  launch(browser);	
	  driver.get(url);
	}
	
	@org.testng.annotations.Test
	public void A_login(){
		
		try{
			test=report.startTest("Login Test");
		lp.login(uname, pword);
		
		WebElement ele=dh.checklogin();
		
		Assert.assertTrue(ele.isDisplayed());
		if(ele.isDisplayed()){
		test.log(LogStatus.PASS, "Pass");
		
		screenShot();
		}else{
        test.log(LogStatus.FAIL, "Fail");
        screenShot();
		}

		}
		catch(Exception e){
			screenShot();
		}
		
	}
	
	public void screenShot(){
		Random rand = new Random();
		int random = rand.nextInt(100);
		
		TakesScreenshot ss=(TakesScreenshot) driver;
		File src=ss.getScreenshotAs(OutputType.FILE);
		try {
			File dest=new File(".\\XLDATA\\screenshot"+random+".png");
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String file =test.addScreenCapture(".\\XLDATA\\screenshot"+random+".png");
		test.log(LogStatus.INFO, file);
	}
	
	@org.testng.annotations.Test
	public void B_logout() throws Exception{
		test=report.startTest("Logout Test");
		dh.logout();
		 
		WebElement ele=lp.checklogout();
		
		Assert.assertTrue(ele.isDisplayed());
		if(ele.isDisplayed()){
		test.log(LogStatus.PASS,"Pass" );
		}else{
        test.log(LogStatus.FAIL, "Fail");
		}
		
}
	@AfterTest
	public void close(){
		report.endTest(test);
		report.flush();
		driver.close();
	}
	
}