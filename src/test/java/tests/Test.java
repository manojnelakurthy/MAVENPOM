package tests;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.LogStatus;

import constants.ExcelData;
import constants.Webdriver;
import pages.DeveloperHomePage;
import pages.LoginPage;

public class Test extends Webdriver{
	
	ExcelData data=new ExcelData();
    ReportClass report=new ReportClass();
	LoginPage lp;
	DeveloperHomePage dh;
	HashMap<String, String> mapData =null;
	public  String uname,pword,browser,url;
	
	@BeforeTest
	public void launch() throws IOException{
		mapData =data.read();
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
		lp=PageFactory.initElements(driver, LoginPage.class);
		lp.checklogin(uname, pword);
		report.test.log(LogStatus.PASS,"pass" );
		
        report.endTest();
		
	}
	
	@org.testng.annotations.Test
	public void B_checklogout() throws Exception{
		 report.startTest();
		dh=PageFactory.initElements(driver, DeveloperHomePage.class);
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