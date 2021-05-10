package pages;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;

import constants.ExcelData;
import constants.Webdriver;

public class LoginPage extends Webdriver{
	ExcelData data=new ExcelData();
	HashMap<String, List<String>> mapData1 =null;
public void login(String username,String password) throws Exception{
	Thread.sleep(1000);
	mapData1=data.read1();
	try{
	if(mapData1.get("username").get(0).equalsIgnoreCase("id")){
		driver.findElement(By.id(mapData1.get("username").get(1))).sendKeys(username);
	}else if(mapData1.get("username").get(0).equalsIgnoreCase("linkText")){
		driver.findElement(By.linkText(mapData1.get("username").get(1))).sendKeys(username);
	}
	
	if(mapData1.get("password").get(0).equalsIgnoreCase("id")){
		driver.findElement(By.id(mapData1.get("password").get(1))).sendKeys(password);
	}else if(mapData1.get("password").get(0).equalsIgnoreCase("name")){
		driver.findElement(By.name(mapData1.get("password").get(1))).sendKeys(password);
	}else if(mapData1.get("password").get(0).equalsIgnoreCase("linkText")){
		driver.findElement(By.linkText(mapData1.get("password").get(1))).sendKeys(password);
	}
	
	if(mapData1.get("login").get(0).equalsIgnoreCase("id")){
		driver.findElement(By.id(mapData1.get("login").get(1))).click();
	}else if(mapData1.get("login").get(0).equalsIgnoreCase("name")){
		driver.findElement(By.name(mapData1.get("login").get(1))).click();
	}else if(mapData1.get("login").get(0).equalsIgnoreCase("linkText")){
		driver.findElement(By.linkText(mapData1.get("login").get(1))).click();;
	}
	}catch(Exception e){
		
	}
	try{
	driver.switchTo().alert().accept();
	}catch(NoAlertPresentException e){
}
}
public WebElement checklogout() throws Exception{
	mapData1=data.read1();
	return driver.findElement(By.name(mapData1.get("login").get(1)));
}
}