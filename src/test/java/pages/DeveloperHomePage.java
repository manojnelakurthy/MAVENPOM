package pages;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import constants.ExcelData;
import constants.Webdriver;

public class DeveloperHomePage extends Webdriver{
	ExcelData data=new ExcelData();
	HashMap<String, List<String>> mapData1 =null;

public void clicklogout() throws Exception{
	Thread.sleep(2000);
	mapData1=data.read1();
	if(mapData1.get("logout").get(0).equalsIgnoreCase("id")){
		driver.findElement(By.id(mapData1.get("logout").get(1))).click();;
	}else if(mapData1.get("logout").get(0).equalsIgnoreCase("linkText")){
		driver.findElement(By.linkText(mapData1.get("logout").get(1))).click();;
	}
}
public WebElement checklogin() throws Exception{
	mapData1=data.read1();
	return driver.findElement(By.linkText(mapData1.get("logout").get(1)));
	
}
}