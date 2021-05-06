package tests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.LogStatus;

import constants.ExcelData;
import constants.Webdriver;
import pages.DeveloperHomePage;
import pages.LoginPage;

public class Test extends Webdriver{
	
	ExcelData data=new ExcelData();
    ReportClass report=new ReportClass();
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
	public void A_login() throws Exception{
	  report.startTest();
		lp.login(uname, pword);
		report.test.log(LogStatus.PASS,"pass" );
		WebElement ele=dh.checklogin();
		Assert.assertTrue(ele.isDisplayed());
		if(ele.isDisplayed()){
		report.test.log(LogStatus.PASS,"pass" );
		TakesScreenshot ss=(TakesScreenshot) driver;
		File src=ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(".\\XLDATA\\screenshot.png"));
		}else{
        report.test.log(LogStatus.FAIL, "fail");
		}
        report.endTest();
		
	}
	
	@org.testng.annotations.Test
	public void B_checklogout() throws Exception{
		 report.startTest();
	
		dh.clicklogout();
		 lp=PageFactory.initElements(driver, LoginPage.class);
		WebElement ele=lp.checklogout();
		Assert.assertTrue(ele.isDisplayed());
		if(ele.isDisplayed()){
		report.test.log(LogStatus.PASS,"pass" );
		}else{
        report.test.log(LogStatus.FAIL, "fail");
		}
        report.endTest();
}
}