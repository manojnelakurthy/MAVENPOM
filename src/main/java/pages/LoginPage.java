package pages;

import org.openqa.selenium.WebElement;

public class LoginPage extends PageElements1{
public void checklogin(String username,String password) throws Exception{
	Thread.sleep(1000);
	uname.sendKeys(username);
	pword.sendKeys(password);
	login.click();
}
public WebElement checklogout(){
return login;
		
	}
	
}

