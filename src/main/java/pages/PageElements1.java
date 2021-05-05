package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageElements1 {

	//Login Page
	@FindBy(id="username") WebElement uname; 
	@FindBy(id="password") WebElement pword;
	@FindBy(id="Login") WebElement login;
	
	//HomePage
	@FindBy(id="userNav") WebElement menu;
	@FindBy(linkText="Logout") WebElement logout;
}
